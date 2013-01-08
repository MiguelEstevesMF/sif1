package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Transponder;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import java.util.SortedSet;


public class PilotoSim extends Thread implements Serializable {

    private Transponder transponder;

    private Loop[] loops;

    private int meanTime; //mili-segundos

    private int delta; // mili-segundos

    private int speed;

    private InputBridgeLocal ibl;

    public PilotoSim(Transponder transponder, SortedSet<Loop> loops, int meanTime, int delta, InputBridgeLocal ibl) {
        this.transponder = transponder;
        this.loops = new Loop[loops.size()];
        this.loops = loops.toArray(this.loops);
        this.meanTime = meanTime*1000;
        this.delta = delta*1000;
        this.speed = 1;
        this.ibl = ibl;
    }


    public void run() {

        Random rnd = new Random(System.nanoTime()) ;

        try{

            int index = 1;
            int maxIndex = loops.length;

            float probBox = 0.1f ;

            synchronized (ibl) { ibl.regista(Calendar.getInstance().getTimeInMillis(),Math.abs(rnd.nextInt())%73+27,Math.abs(rnd.nextInt())%93+7,loops[index].getID(),transponder.getID()); }

            while(!Thread.currentThread().isInterrupted()){

                for(index = 2; index<maxIndex; index++){
                    long sleepTime = (long)((1.0*meanTime)/(1.0*speed)+(rnd.nextFloat()*delta/(1.0*speed))) ;
                    Thread.sleep(sleepTime);
                    synchronized (ibl) { ibl.regista(Calendar.getInstance().getTimeInMillis(),Math.abs(rnd.nextInt())%73+27,Math.abs(rnd.nextInt())%93+7,loops[index].getID(),transponder.getID()); }


                }

                index = rnd.nextFloat()>probBox?1:0;

                long sleepTime = (long)(((1.0*meanTime)/(1.0*speed))+((rnd.nextFloat()*delta/(1.0*speed)))) ;
                Thread.sleep(sleepTime);
                synchronized (ibl) { ibl.regista(Calendar.getInstance().getTimeInMillis(),Math.abs(rnd.nextInt())%73+27,Math.abs(rnd.nextInt())%93+7,loops[index].getID(),transponder.getID()); }
            }
        }
        catch (InterruptedException ex) {
            ;;;
        }

    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }




}