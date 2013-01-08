package bl.psmJEEHibernate.TempoReal;

import javax.ejb.Local;


@Local
public interface InputBridgeLocal {

    public void regista(long currentTimeMillis, int potenciaSinal, int hits, int loopID, int transponderID);
    
}
