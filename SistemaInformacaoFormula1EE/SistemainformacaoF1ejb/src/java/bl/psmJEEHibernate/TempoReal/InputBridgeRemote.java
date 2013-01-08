package bl.psmJEEHibernate.TempoReal;

import javax.ejb.Remote;

@Remote
public interface InputBridgeRemote {

    public void regista(long currentTimeMillis, int potenciaSinal, int hits, int loopID, int transponderID);
    
}
