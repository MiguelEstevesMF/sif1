package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Registro;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import org.jgroups.ChannelClosedException;
import org.jgroups.ChannelException;
import org.jgroups.ChannelNotConnectedException;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import bl.psmJEEHibernate.entities.Corrida;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Qualificacao;
import bl.psmJEEHibernate.entities.ResultadoQualificacao;
import bl.psmJEEHibernate.entities.Treino;
import java.util.HashMap;
import org.jgroups.util.Util;


// notas tetes
// implementar os metodos em RS
// mudar os Beans ou os LS para passar pelo RS

// falta o get / set State



public class NodeSYNC extends ReceiverAdapter{

    private JChannel chn;
    private RunningSessions rs;

    public enum Accao{ ADD,REM,INIT,STOP,NEXTQ };

    @EJB
    private EntityManager em;

    public NodeSYNC(RunningSessions rs){
        try{
            this.rs = rs;
            chn = new JChannel();
            chn.connect("SIF1_SYNC");
            chn.setReceiver(this);
            //chn.getState(null,30000);
        }
        catch(ChannelException e){
            System.out.println("Erro ao criar NodeSYNC");;
            System.out.println(e.getMessage());
        }
    }

    public synchronized void broadCast(Registro r) throws ChannelNotConnectedException, ChannelClosedException{
        chn.send(null,null,r);
    }

    public void broadCast(LiveSession ls,Accao a) throws ChannelNotConnectedException, ChannelClosedException{
        /* Format => Class|id|Accao */
        chn.send(null,null,ls.getSessao().getClass().getName()+"\254"+ls.getSessao().getID()+"\254"+a.name());
    }

    @Override
    public synchronized void receive(Message m){
        if(!m.getSrc().equals(chn.getLocalAddress())){
            Object obj = m.getObject();
            if(obj instanceof Registro){
System.out.println("novo registro");
                RunningSessions.getInstance().registarNoRep((Registro)obj);
            }
            if(obj instanceof String){
                String[] str = ((String)obj).split("\254");
                System.out.println("ParseTokensN:: "+str.length);
                for(String s:str){
                    System.out.println("Token= "+s);
                }
                if(str.length == 3){
                    try {
                        Class c = Class.forName(str[0]);
                        int id = Integer.valueOf(str[1]);
                        Accao a = Accao.valueOf(str[2]);

                        LiveSession ls = null ;

                        if(a.equals(a.ADD)){
System.out.println("passou no ADD1");

                            if(c.equals(Treino.class)){
                                Treino t = (Treino) em.createQuery("SELECT DISTINCT Object(t) FROM Treino t LEFT JOIN FETCH t.resultados r LEFT JOIN FETCH r.melhorsTemposPorSector WHERE t.ID="+id).getSingleResult();
                                List<Loop> loop_list = em.createQuery("SELECT DISTINCT Object(l) FROM Evento e JOIN e.circuito c JOIN c.loops l JOIN e.treinos t WHERE t.ID="+id).getResultList();
                                ls = new bl.psmJEEHibernate.TempoReal.Treino(t, loop_list);
                            }
                            if(c.equals(Qualificacao.class)){
                                Qualificacao q = (Qualificacao) em.createQuery("SELECT DISTINCT Object(q) FROM Qualificacao q LEFT JOIN FETCH q.resultados r LEFT JOIN FETCH r.melhorsTemposPorSector LEFT JOIN FETCH r.qualificativas WHERE q.ID="+id).getSingleResult();
                                List<Loop> loop_list = em.createQuery("SELECT DISTINCT Object(l) FROM Evento e JOIN e.circuito c JOIN c.loops l WHERE e.qualificacao.ID="+id).getResultList();
                                ls = new bl.psmJEEHibernate.TempoReal.Qualificacao(q,loop_list);
                            }
                            if(c.equals(Corrida.class)){
System.out.println("passou na corrida");
                                List<Loop> loop_list = em.createQuery("SELECT DISTINCT Object(l) FROM Evento e JOIN e.circuito c JOIN c.loops l WHERE e.corrida.ID="+id).getResultList();

                                List<ResultadoQualificacao> resultados = (List<ResultadoQualificacao>) em.createQuery("SELECT DISTINCT Object(rq) FROM Evento e JOIN e.qualificacao q JOIN q.resultados rq JOIN FETCH rq.piloto WHERE e.corrida.ID="+id).getResultList();

                                HashMap<Piloto,Integer> grelha = new HashMap<Piloto,Integer>();
                                for(ResultadoQualificacao rq : resultados){
                                    grelha.put(rq.getPiloto(),rq.getPosicao());
                                }

                                Corrida crd = (Corrida) em.createQuery("SELECT DISTINCT Object(c) FROM Corrida c LEFT JOIN FETCH c.resultados r LEFT JOIN FETCH r.melhorsTemposPorSector WHERE c.ID="+id).getSingleResult();


                                ls = new bl.psmJEEHibernate.TempoReal.Corrida(crd, loop_list, grelha);
                                }

                                RunningSessions.getInstance().addNoRep(ls);
                        }
                        else{
                            if(c.equals(Treino.class)){
                                Treino t = new Treino();
                                t.setID(id);
                                ls = new bl.psmJEEHibernate.TempoReal.Treino(t);
                            }
                            if(c.equals(Qualificacao.class)){
                                Qualificacao q = new Qualificacao();
                                q.setID(id);
                                ls = new bl.psmJEEHibernate.TempoReal.Qualificacao(q);
                            }
                            if(c.equals(Corrida.class)){
                                Corrida crd = new Corrida();
                                crd.setID(id);
                                ls = new bl.psmJEEHibernate.TempoReal.Corrida(crd);
                            }
                            if(a.equals(Accao.REM)&&ls!=null){
                                RunningSessions.getInstance().removeNoRep(ls);
                            }
                            if(a.equals(Accao.INIT)&&ls!=null){
                                RunningSessions.getInstance().initNoRep(ls);
                            }
                            if(a.equals(Accao.STOP)&&ls!=null){
                                RunningSessions.getInstance().stopNoRep(ls);
                            }
                            if(a.equals(Accao.NEXTQ)&&ls!=null){
                                RunningSessions.getInstance().nextQNoRep(ls);
                            }
                        }
                    }
                    catch (Exception ex) {
                        System.out.println("erro de parsing de ::"+obj);
                        System.out.println("erro de parsing de ::"+ex.getMessage());
                    }


                }
                else{
                    System.out.println("Erro ao fazer parsing");
                }
            }

        }
        else{
            System.out.println("mensagem enviada pelo proprio");
            ;;;;;;;
            // se foi enviada por este nodo <ignorar>
        }

    }

    @Override
    public synchronized byte[] getState() {
        byte[] state=null;
        try {
            //modo lavajao ON ??? desconheco como afecta os observers
            state = Util.objectToByteBuffer(rs.getLoop_evento());
        } catch (Exception ex) {
            System.out.println("Erro ao coordenar estados :: GET");
            System.out.println(ex.getMessage());
        }
        return state;
    }

    @Override
    public synchronized void setState(byte[] state) {
        try {
            rs.setLoop_evento((Map<Loop, LiveSession>) Util.objectFromByteBuffer(state));
        } catch (Exception ex) {
            System.out.println("Erro ao coordenar estados :: SET");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected synchronized void finalize() throws Throwable {
        chn.close();
    }





}