/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate.TempoReal.EJB;

import javax.ejb.Local;

/**
 *
 * @author di
 */
@Local
public interface ConsultaTempoRealLocal {

    public java.util.List<bl.psmJEEHibernate.TempoReal.LiveSession> getLiveSessions();

    public java.util.SortedSet<bl.psmJEEHibernate.TempoReal.ScoreBoardRTRegistro> getScoreBoard();

    public void registraObserver(java.util.Observer ob);

    public void libertaObserver(java.util.Observer ob);

    public bl.psmJEEHibernate.TempoReal.LiveSession getLs();

    public void setLs(bl.psmJEEHibernate.TempoReal.LiveSession ls);

    public int ultimoPilotoRegistrado();

    public int nSectores();
   
    
}
