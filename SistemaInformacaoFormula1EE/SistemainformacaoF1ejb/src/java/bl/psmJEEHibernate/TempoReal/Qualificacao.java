package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.MelhorTempo_Sector;
import bl.psmJEEHibernate.entities.Qualificativa;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.ResultadoQualificacao;
import bl.psmJEEHibernate.entities.Sessao;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Qualificacao implements LiveSession, Serializable {

    private bl.psmJEEHibernate.entities.Qualificacao qualificacao;

    private CronometragemQualificacao crono;

    private TreeSet<Loop> loops ; /* loops meta = 0Km total distance = circuito.lenth */

    private Observable_ obs ;

    private String campeonato;
    private String evento;
    private String tsessao;

    Qualificacao(bl.psmJEEHibernate.entities.Qualificacao q) {
        this.qualificacao = q;
    }

    /**
     * @return the campeonato
     */
    public String getCampeonato() {
        return campeonato;
    }

    /**
     * @param campeonato the campeonato to set
     */
    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    /**
     * @return the evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * @return the tsessao
     */
    public String getTsessao() {
        return tsessao;
    }

    /**
     * @param tsessao the tsessao to set
     */
    public void setTsessao(String tsessao) {
        this.tsessao = tsessao;
    }

    
    


    private class Observable_ extends Observable implements Serializable{
        public void setChanged(){
            super.setChanged();
        }
    }

    
    public Qualificacao(bl.psmJEEHibernate.entities.Qualificacao q, List<Loop> loops){

        this.qualificacao = q;

        this.loops = new TreeSet<Loop>(new Comparator<Loop>(){

            public int compare(Loop l1, Loop l2) {
                return (int)((l1.getPosicaoKm()-l2.getPosicaoKm())*1000.0);
            }

        });

        this.loops.addAll(loops);

        TreeSet ts = new TreeSet(this.loops);

        this.crono = new CronometragemQualificacao(ts);

        this.obs = new Observable_();

    }


    public void iniciar(){

        crono.start();

    }

    public void parar(){

     crono.stop();

    }

    public boolean gerarResultadoFinal(){
System.out.println("ola1");
        if(!crono.activo){
System.out.println("ola2");
            Set<ResultadoQualificacao> srsq = qualificacao.getResultados();
            srsq.clear();
System.out.println("ola3");
            for(ScoreBoardRTRegistro sbr : crono.sb){
System.out.println("ola4");
                Set<MelhorTempo_Sector> mts = new HashSet<MelhorTempo_Sector>();
                for(Entry<Integer,Long> e : sbr.getTempos_sectors_melhor().entrySet()){
                    MelhorTempo_Sector mts_ = new MelhorTempo_Sector();
                    mts_.setSector(e.getKey());
                    mts_.setTempo(e.getValue());
                    mts.add(mts_);
                }
System.out.println("ola5");
                Set<Qualificativa> sq = new HashSet<Qualificativa>();
                for(Entry<Integer,Long> e : sbr.getTempo_melhor_Volta().entrySet()){
System.out.println("ola6");
                    Qualificativa q = new Qualificativa();
                    q.setSessao(e.getKey());
                    q.setTempo(e.getValue());
                    sq.add(q);
                }
System.out.println("ola7");
                ResultadoQualificacao rq = new ResultadoQualificacao();
                rq.setPosicao(sbr.getPosicao());
                rq.setTempo(sbr.getTempo_acumulado());
                rq.setVoltas(sbr.getVolta());
                rq.setPiloto(sbr.getPiloto());
                rq.setEquipa(sbr.getPiloto().getEquipa_actual());
                rq.setMelhorsTemposPorSector(mts);
                rq.setQualificativas(sq);
System.out.println("ola8");
                srsq.add(rq);
            }

        }
System.out.println("ola9");
        return !crono.activo;

    }


    public void registar(Registro r){

        crono.processaRegistro(r);

        obs.setChanged();

        obs.notifyObservers();
        
    }

    public TreeSet<Loop> getLoops() {
        return loops;
    }


    public Sessao getSessao() {
        return qualificacao;
    }




    public SortedSet<ScoreBoardRTRegistro> getScoreBoard() {
        return crono.sb;
    }

    public SortedSet<CronometragemRegistro> getScoreBoardCrono() {
        return crono.registros;
    }

    public void setObserver(Observer ob) {
        obs.addObserver(ob);
    }

    public void releaseObserver(Observer ob) {
        obs.deleteObserver(ob);
    }

    public void avancarQ() {
        crono.nextQ();
    }

    public int getCurrentQ() {
        return crono.getCurrentQ();
    }








    @Override
    public boolean equals(Object o){
        if(o instanceof Qualificacao){
            return ((Qualificacao) o).qualificacao.getID() == qualificacao.getID();
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.qualificacao != null ? this.qualificacao.hashCode() : 0);
        hash = 83 * hash + (this.crono != null ? this.crono.hashCode() : 0);
        hash = 83 * hash + (this.loops != null ? this.loops.hashCode() : 0);
        hash = 83 * hash + (this.obs != null ? this.obs.hashCode() : 0);
        return hash;
    }


}
