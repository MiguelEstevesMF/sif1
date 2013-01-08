/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import javax.ejb.Remote;

/**
 *
 * @author Tiago
 */
@Remote
public interface NotificaEmailRemote {
    public void enviarEmail(String assunto, String texto, String destino) throws Exception;
}
