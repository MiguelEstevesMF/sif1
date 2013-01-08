package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Circuito;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Piloto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class GerirCampeonatoBean implements GerirCampeonatoRemote, GerirCampeonatoLocal {

    @PersistenceContext
    EntityManager em;

    public Campeonato getCampeonato (String designacao) {
        Campeonato c = null;
        try {
            c = (Campeonato) em.createQuery("select object(o) from Campeonato o left join fetch o.eventos e where o.designacao='"+designacao+"' order by e.data DESC").getSingleResult();
        } catch(NoResultException ex){
            c=null;
        }
        return c;
    }

    public List<Campeonato> getCampeonatos(){
        return em.createQuery("SELECT Object(c) From Campeonato as c order by c.anoInicio DESC").getResultList();
    }

    public List<Evento> getEventos(Campeonato camp){
        return em.createQuery("SELECT distinct Object(e) From Evento AS e left JOIN Campeonato AS c WHERE c.id = "+camp.getID()).getResultList();
    }

    public List<Evento> getEventos(String designacaoCamp){
        return em.createQuery("select distinct Object ( e ) FROM Evento AS e WHERE e.campeonato.designacao = '"+designacaoCamp+"' order by e.data DESC").getResultList();
    }

    public Evento getEventoDeep(Evento evt){
        return (Evento) em.createQuery("SELECT Object(e) FROM Evento AS e " +
                "left JOIN FETCH e.circuito " +
                "left JOIN FETCH e.corrida " +
                "left JOIN FETCH e.qualificacao " +
                "left JOIN FETCH e.treinos WHERE e.ID = "+evt.getID()).getSingleResult();
    }

    public Evento getEventoDeep(String designacao) {
        return (Evento) em.createQuery("SELECT Object(e) FROM Evento AS e " +
                "left join FETCH e.circuito " +
                "left join FETCH e.corrida " +
                "left join FETCH e.qualificacao " +
                "left join FETCH e.treinos " +
                "WHERE e.designacao = '"+designacao+"'").getSingleResult();
    }

    public List<Circuito> getCircuitos(){
        return em.createQuery("SELECT distinct Object(c) From Circuito AS c ").getResultList();
    }

    public Circuito getCircuito(String nome){
        return (Circuito) em.createQuery("SELECT Object(c) FROM Circuito AS c WHERE c.nome = '"+nome+"'").getSingleResult();
    }

    public ArrayList<Equipa> getEquipas(String camp){
         ArrayList<Equipa> equipas = new ArrayList<Equipa>(((Campeonato) (em.createQuery("SELECT Object(c) FROM Campeonato AS c LEFT JOIN FETCH c.equipas WHERE c.designacao='"+camp+"'").getSingleResult())).getEquipas());

        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                Equipa u1 = (Equipa) o1;
                Equipa u2 = (Equipa) o2;
                return u1.getNome().compareTo(u2.getNome());
            }
        };
        Collections.sort(equipas, comparator);
        
        return equipas;
    }

    public ArrayList<Piloto> getPilotos(String camp){
        ArrayList<Equipa> equipas = new ArrayList<Equipa>();

        for(Equipa e:getEquipas(camp))
            equipas.add((Equipa) em.createQuery("SELECT Object(e) FROM Equipa AS e LEFT JOIN FETCH e.pilotos WHERE e.ID="+e.getID()).getSingleResult());

        ArrayList<Piloto> pilotos = new ArrayList<Piloto>();
        for(Equipa e:equipas)
            pilotos.addAll(new ArrayList<Piloto>(e.getPilotos()));

        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                Piloto u1 = (Piloto) o1;
                Piloto u2 = (Piloto) o2;
                return u1.getNome().compareTo(u2.getNome());
            }
        };
        Collections.sort(pilotos, comparator);
        
        return pilotos;
    }

    public void setCampeonatos(ArrayList<Campeonato> cs) {
        for(Campeonato c:cs)
            em.merge(c);
    }

    public void save(Campeonato camp){
        em.merge(camp);
        em.flush();
    }

    public void save(Object o) {
        em.merge(o);
        em.flush();
    }

    public void remove(Object o) {
        em.remove(em.merge(o));
    }

}
