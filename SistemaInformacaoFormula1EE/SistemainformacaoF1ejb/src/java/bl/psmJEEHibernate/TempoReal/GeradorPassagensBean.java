package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Transponder;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.ejb.Stateful;


@Stateful
public class GeradorPassagensBean implements GeradorPassagensRemote, GeradorPassagensLocal{

    private SortedSet<Loop> loops;

    private Map<Transponder,PilotoSim> sims;

    private int meanTime = 20; //segundos
    private int delta = 20; // segundos


    @EJB
    InputBridgeLocal ibl;


    public GeradorPassagensBean() {
        Comparator<Loop> cmp = new Comparator<Loop>() {

            public int compare(Loop l1, Loop l2) {
                return (int)((l1.getPosicaoKm()-l2.getPosicaoKm())*1000.0);
            }
        } ;

        loops = new TreeSet<Loop>(cmp);
        sims = new HashMap<Transponder, PilotoSim>();
    }


    public void startSimulation(Set<Loop> loops, Set<Transponder> transponders, int meanTime, int delta){

        this.loops.addAll(loops);
        this.meanTime = meanTime;
        this.delta = delta;

        for(Transponder trp : transponders){
            PilotoSim ps = new PilotoSim(trp, this.loops, meanTime, delta, ibl);
            ps.start();
            sims.put(trp,ps);
        }
    }


    public void stopSimulation(){

        for(PilotoSim ps : sims.values()){
            ps.interrupt();
        }

    }


    public void setMeanTime(int meanTime) {
        this.meanTime = meanTime;
    }


    public void setDelta(int delta) {
        this.delta = delta;
    }


    public void setSpeed(int speed) {
        if(speed != 0){
            for(PilotoSim ps : sims.values()){
                ps.setSpeed(speed);
            }
        }
    }

    public void simKill(Transponder t){
        if(sims.containsKey(t)){
            sims.get(t).interrupt();
            sims.remove(t);
        }
        else{
            System.out.println("TransponderT "+t.getID()+t.getRef()+"not fount");
        }

    }

}