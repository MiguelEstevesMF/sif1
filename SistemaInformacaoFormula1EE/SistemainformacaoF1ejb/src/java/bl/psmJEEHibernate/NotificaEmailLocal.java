/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import javax.ejb.Local;

/**
 *
 * @author Tiago
 */
@Local
public interface NotificaEmailLocal {
    public void enviarEmail(String assunto, String texto, String destino) throws Exception;
}
