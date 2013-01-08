package bl.psmJEEHibernate.TempoReal.EJB;

import bl.psmJEEHibernate.TempoReal.CronometragemRegistro;
import bl.psmJEEHibernate.TempoReal.GeradorPassagensLocal;
import bl.psmJEEHibernate.TempoReal.LiveSession;
import bl.psmJEEHibernate.TempoReal.RunningSessions;
import bl.psmJEEHibernate.TempoReal.ScoreBoardRTRegistro;
import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Corrida;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Qualificacao;
import bl.psmJEEHibernate.entities.ResultadoQualificacao;
import bl.psmJEEHibernate.entities.Sessao;
import bl.psmJEEHibernate.entities.Transponder;
import bl.psmJEEHibernate.entities.Treino;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateful
public class CronometragemBean implements CronometragemRemote, CronometragemLocal, Serializable {

    @PersistenceContext
    EntityManager em;

    @EJB
    GeradorPassagensLocal gpl;

    private LiveSession ls;

    public List<Campeonato> getCampeonatos(){
        int current = new GregorianCalendar().get(GregorianCalendar.YEAR);
        return em.createQuery("SELECT DISTINCT Object(c) FROM Campeonato AS c WHERE c.anoFim >= "+current+"AND c.anoInicio <= "+current).getResultList();
    }


    public List<Evento> getEventos(String camp){
        return em.createQuery("SELECT DISTINCT Object(e) FROM Evento AS e WHERE e.campeonato.designacao='"+camp+"' ").getResultList();
    }


    public List<Sessao> getSessoes(String evento){
        return em.createQuery("Select DISTINCT Object(s) FROM Evento AS e, Sessao AS s WHERE (e.designacao='"+evento+"') AND (e.id=(e.corrida=s.ID OR e.qualificacao=s.ID OR s.ID IN (e.treinos))) ").getResultList();
    }

    public void initCronoSystem(Sessao s){

        if(s instanceof Treino){
            Treino t = (Treino) em.createQuery("SELECT DISTINCT Object(t) FROM Treino t LEFT JOIN FETCH t.resultados r LEFT JOIN FETCH r.melhorsTemposPorSector WHERE t.ID="+s.getID()).getSingleResult();
            List<Loop> loop_list = em.createQuery("SELECT DISTINCT Object(l) FROM Evento e JOIN e.circuito c JOIN c.loops l JOIN e.treinos t WHERE t.ID="+s.getID()).getResultList();
            setLs(new bl.psmJEEHibernate.TempoReal.Treino(t, loop_list));
        }
        if(s instanceof Qualificacao){
            Qualificacao q = (Qualificacao) em.createQuery("SELECT DISTINCT Object(q) FROM Qualificacao q LEFT JOIN FETCH q.resultados r LEFT JOIN FETCH r.melhorsTemposPorSector LEFT JOIN FETCH r.qualificativas WHERE q.ID="+s.getID()).getSingleResult();
            List<Loop> loop_list = em.createQuery("SELECT DISTINCT Object(l) FROM Evento e JOIN e.circuito c JOIN c.loops l WHERE e.qualificacao.ID="+s.getID()).getResultList();
            setLs(new bl.psmJEEHibernate.TempoReal.Qualificacao(q,loop_list));
        }
        if(s instanceof Corrida){
            List<Loop> loop_list = em.createQuery("SELECT DISTINCT Object(l) FROM Evento e JOIN e.circuito c JOIN c.loops l WHERE e.corrida.ID="+s.getID()).getResultList();

            List<ResultadoQualificacao> resultados = (List<ResultadoQualificacao>) em.createQuery("SELECT DISTINCT Object(rq) FROM Evento e JOIN e.qualificacao q JOIN q.resultados rq JOIN FETCH rq.piloto WHERE e.corrida.ID="+s.getID()).getResultList();

            HashMap<Piloto,Integer> grelha = new HashMap<Piloto,Integer>();
            for(ResultadoQualificacao rq : resultados){
                grelha.put(rq.getPiloto(),rq.getPosicao());
            }

            Corrida c = (Corrida) em.createQuery("SELECT DISTINCT Object(c) FROM Corrida c LEFT JOIN FETCH c.resultados r LEFT JOIN FETCH r.melhorsTemposPorSector WHERE c.ID="+s.getID()).getSingleResult();


            setLs(new bl.psmJEEHibernate.TempoReal.Corrida(c, loop_list, grelha));
        }

        RunningSessions.getInstance().add(getLs());

    }


    public List<LiveSession> getLiveSession(){
        return new ArrayList(RunningSessions.getInstance().getRunning());
    }


    public void iniciar(){
        //ls.iniciar();
	 RunningSessions.getInstance().init(ls);
    }


    public void iniciar_ComSimulacao(){
        RunningSessions.getInstance().init(ls);
        Sessao s = ls.getSessao();
        List<Transponder> transponders = em.createQuery("Select DISTINCT Object(tp) FROM Campeonato cp JOIN cp.eventos ev LEFT JOIN ev.treinos tr JOIN cp.equipas eq JOIN eq.pilotos pl JOIN pl.transponder tp WHERE ev.corrida.ID="+s.getID()+" OR ev.qualificacao.ID="+s.getID()+" OR tr.ID="+s.getID()).getResultList();

        gpl.startSimulation(ls.getLoops(), new HashSet(transponders),20,20);


    }


    public void finalizar(){
        RunningSessions.getInstance().stop(ls);
        //RunningSessions.getInstance().remove(ls);
    }

    public void finalizar_comSimulacao(){
        RunningSessions.getInstance().stop(ls);
        gpl.stopSimulation();
        //RunningSessions.getInstance().remove(ls);
    }

    public boolean gravar(){
        boolean b = ls.gerarResultadoFinal();
        if(b){
		em.merge(ls.getSessao());
		RunningSessions.getInstance().remove(ls);
	}
        return b;
    }


    public LiveSession getLs() {
        return ls;
    }


    public void setLs(LiveSession ls) {
        this.ls = ls;
    }


    public SortedSet<CronometragemRegistro> getScoreBoard(){
        try {
            SortedSet<CronometragemRegistro> rs = new TreeSet<CronometragemRegistro>(ls.getScoreBoardCrono().comparator());
            Iterator<CronometragemRegistro> sbi = ls.getScoreBoardCrono().iterator();
            for(int i = 0; i<100 && sbi.hasNext(); i++){
                rs.add(sbi.next());
            }
            return rs;
        } catch(Exception ex) {
        //    System.out.println(ex.getMessage());
        }
        return null;
    }

    public void registraObserver(Observer ob){
        ls.setObserver(ob);
    }

    public void libertaObserver(Observer ob){
        ls.releaseObserver(ob);
    }


    public void avancarQ() {
        RunningSessions.getInstance().nextQ(ls);
    }

    public void avancarQ_comSimulacao() {
        Iterator<ScoreBoardRTRegistro> sbi = (new TreeSet(ls.getScoreBoard())).descendingIterator();
        for(int i=0; i<5 && sbi.hasNext(); i++){
            gpl.simKill(sbi.next().getPiloto().getTransponder());
        }
        RunningSessions.getInstance().nextQ(ls);
    }

    public int getCurrentQ() {
        return ls.getCurrentQ();
    }

}
