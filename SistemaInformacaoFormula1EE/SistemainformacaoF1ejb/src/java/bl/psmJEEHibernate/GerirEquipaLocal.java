
package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Equipa;
import java.util.List;
import javax.ejb.Local;


@Local
public interface GerirEquipaLocal {

    public List<Equipa> getEquipas();

    public List<Campeonato> getCampeonatos();

    public void save(Equipa equ);

    public Equipa getEquipa(String nome);

    public bl.psmJEEHibernate.entities.Equipa getEquipaP(java.lang.String nome);

    public bl.psmJEEHibernate.entities.Equipa getEquipaC(java.lang.String nome);

    public void remove(bl.psmJEEHibernate.entities.Equipa equ);

    public bl.psmJEEHibernate.entities.Campeonato getCampeonato(java.lang.String designacao);

    public bl.psmJEEHibernate.entities.Equipa getEquipaDeep(java.lang.String nome);

    public java.util.ArrayList<bl.psmJEEHibernate.entities.Equipa> findAllOrdenado(java.lang.String campo, java.lang.String ordem, int limit, int offset);

    public int countEquipas();

    public byte[] getImagem(bl.psmJEEHibernate.entities.Equipa e);
    
}
