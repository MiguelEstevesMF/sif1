package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Transponder;
import java.util.Set;
import javax.ejb.Local;


@Local
public interface GeradorPassagensLocal {

    public void startSimulation(Set<Loop> loops, Set<Transponder> transponders, int meanTime, int delta);

    public void stopSimulation();

    public void setMeanTime(int meanTime);

    public void setDelta(int delta) ;

    public void setSpeed(int speed) ;

    public void simKill(bl.psmJEEHibernate.entities.Transponder t);
    
}
