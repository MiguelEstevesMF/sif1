package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.TempoReal.NodeSYNC.Accao;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Registro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jgroups.ChannelClosedException;
import org.jgroups.ChannelNotConnectedException;


public class RunningSessions {

    private static RunningSessions instance;

    private Set<LiveSession> running = Collections.synchronizedSet(new HashSet<LiveSession>());

    private Map<Loop,LiveSession> loop_evento = Collections.synchronizedMap(new HashMap<Loop,LiveSession>());

    private NodeSYNC nodesync = new NodeSYNC(this);


    private RunningSessions(){};


    public static RunningSessions getInstance(){
        if(instance == null){
            instance = new RunningSessions();
        }
        return instance;
    }


    public Set<LiveSession> getRunning() {
        return running;
    }










    public synchronized void setLoop_evento( Map<Loop,LiveSession> loop_evento){
	    this.loop_evento.putAll(loop_evento);
    }

    public synchronized Map<Loop,LiveSession> getLoop_evento(){
	    return loop_evento;
    }





    public synchronized void registar(Registro r){
        this.registarNoRep(r);
//        try {
//            nodesync.broadCast(r);
//        } catch (ChannelNotConnectedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ r);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        } catch (ChannelClosedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ r);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        }
    }



    public synchronized void registarNoRep(Registro r){

        if(loop_evento.containsKey(r.getLoop())){

            LiveSession ls = loop_evento.get(r.getLoop());

            synchronized(ls){
                ls.registar(r);
            }
        }

    }



    public synchronized void add(LiveSession s){

       this.addNoRep(s);
//       try {
//            nodesync.broadCast(s,Accao.ADD);
//        } catch (ChannelNotConnectedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        } catch (ChannelClosedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        }
       

    }

    public synchronized void addNoRep(LiveSession ls){

        this.running.add(ls);
        ls.iniciar();


        for(Loop l : ls.getLoops()){
            loop_evento.put(l,ls);
        }
    }


    public synchronized void remove(LiveSession s){

       this.removeNoRep(s);
//       try {
//            nodesync.broadCast(s,Accao.REM);
//        } catch (ChannelNotConnectedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        } catch (ChannelClosedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        }
       

    }

    public synchronized void removeNoRep(LiveSession s){
        running.remove(s);
        ArrayList<Loop> loopsRemover = new ArrayList<Loop>();
        for(Entry<Loop,LiveSession> e : loop_evento.entrySet()){
            if (e.getValue().equals(s)){
                loopsRemover.add(e.getKey());

            }
        }
        for(Loop l: loopsRemover)
            loop_evento.remove(l);
    }


    public synchronized void init(LiveSession s){

       this.initNoRep(s);
//       try {
//            nodesync.broadCast(s,Accao.INIT);
//        } catch (ChannelNotConnectedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        } catch (ChannelClosedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        }

    }

    public synchronized void initNoRep(LiveSession ls){
        ls.iniciar();
    }


    public synchronized void stop(LiveSession s){

       this.stopNoRep(s);
//       try {
//            nodesync.broadCast(s,Accao.STOP);
//        } catch (ChannelNotConnectedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        } catch (ChannelClosedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        }

    }

    public synchronized void stopNoRep(LiveSession ls){
        ls.parar();
    }



    public synchronized void nextQ(LiveSession s){

       this.nextQNoRep(s);
//       try {
//            nodesync.broadCast(s,Accao.NEXTQ);
//        } catch (ChannelNotConnectedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        } catch (ChannelClosedException ex) {
//            System.out.println("Erro ao Enviar o Registro ::"+ s);
//            System.out.println("Erro ao Enviar o Registro ::"+ ex.getMessage());
//        }

    }

    public synchronized void nextQNoRep(LiveSession ls){
        ls.avancarQ();
    }











}