/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Circuito;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Piloto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author di
 */
@Remote
public interface GerirCampeonatoRemote {

    public Campeonato getCampeonato (String designacao);
    
    public List<Campeonato> getCampeonatos();

    public List<Evento> getEventos(Campeonato camp);

    public Evento getEventoDeep(Evento evt);

    public List<Circuito> getCircuitos();

    public Circuito getCircuito(String designacao);

    public ArrayList<Equipa> getEquipas(String camp);

    public ArrayList<Piloto> getPilotos(String camp);

    public void setCampeonatos(ArrayList<Campeonato> cs);

    public void save(Campeonato camp);

    public void save(Object camp);

    public bl.psmJEEHibernate.entities.Evento getEventoDeep(java.lang.String designacao);

    public java.util.List<bl.psmJEEHibernate.entities.Evento> getEventos(java.lang.String designacaoCamp);

    public void remove(Object o);
    
}
