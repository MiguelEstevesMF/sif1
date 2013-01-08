/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Transponder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author di
 */
@Local
public interface GerirPilotoLocal {
    
    public List<Piloto> getPilotos();

    public List<Equipa> getEquipas();

    public void addPiloto(Piloto p);

    public void editPiloto(Piloto novoPiloto) throws Exception;

    public Piloto getPiloto(String nome);

    public void remPiloto(Piloto p);

    public boolean hasTransponderAssoc(String ref, Piloto p);

    public java.util.ArrayList<bl.psmJEEHibernate.entities.Piloto> findAllOrdenado(java.lang.String campo, java.lang.String ordem, int limit, int offset);

    public int countPilotos();

    public boolean availableTransponder(java.lang.String ref);

    public bl.psmJEEHibernate.entities.Transponder getTransponder(java.lang.String ref);

    public byte[] getImagem(bl.psmJEEHibernate.entities.Piloto p);

}
