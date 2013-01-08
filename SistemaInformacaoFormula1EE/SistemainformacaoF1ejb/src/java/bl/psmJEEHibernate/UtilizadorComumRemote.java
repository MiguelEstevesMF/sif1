/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.ResultadoPiloto;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Tiago
 */
@Remote
public interface UtilizadorComumRemote {

    public ArrayList<ResultadoPiloto> getResEquipasCamp(String nome_camp);
    
}
