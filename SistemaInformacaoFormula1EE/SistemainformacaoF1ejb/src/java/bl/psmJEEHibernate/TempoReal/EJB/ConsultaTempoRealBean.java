package bl.psmJEEHibernate.TempoReal.EJB;

import bl.psmJEEHibernate.TempoReal.LiveSession;
import bl.psmJEEHibernate.TempoReal.ScoreBoardRTRegistro;
import bl.psmJEEHibernate.TempoReal.RunningSessions;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.SortedSet;
import javax.ejb.Stateful;


@Stateful
public class ConsultaTempoRealBean implements ConsultaTempoRealRemote, ConsultaTempoRealLocal {

    private LiveSession ls ;
    
    public List<LiveSession> getLiveSessions(){
        return new ArrayList<LiveSession>(RunningSessions.getInstance().getRunning());
    }

    public SortedSet<ScoreBoardRTRegistro> getScoreBoard(){
        try {
            return ls.getScoreBoard();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void registraObserver(Observer ob){
        ls.setObserver(ob);
    }

    public void libertaObserver(Observer ob){
        ls.releaseObserver(ob);
    }


    public LiveSession getLs() {
        return ls;
    }


    public void setLs(LiveSession ls) {
        this.ls = ls;
    }

    public int ultimoPilotoRegistrado() {
        return ls.getScoreBoardCrono().first().getNumPiloto();
    }

    public int nSectores() {
        return ls.getLoops().size();
    }
 
}
