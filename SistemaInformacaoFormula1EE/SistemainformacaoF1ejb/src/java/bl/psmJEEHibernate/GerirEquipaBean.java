package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Equipa;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class GerirEquipaBean implements GerirEquipaRemote, GerirEquipaLocal {

    @PersistenceContext
    EntityManager em;


    public List<Equipa> getEquipas(){
        return em.createQuery("SELECT Object(e) FROM Equipa AS e ORDER BY e.nome asc").getResultList();
    }

    public Equipa getEquipa(String nome){
        return (Equipa) em.createQuery("SELECT Object(e) FROM Equipa AS e left join fetch e.utilizador where e.nome='"+nome+"'").getSingleResult();
    }

    public Equipa getEquipaP(String nome){
        return (Equipa) em.createQuery("SELECT Object(e) FROM Equipa AS e left join fetch e.pilotos where e.nome='"+nome+"'").getSingleResult();
    }

    public Equipa getEquipaC(String nome){
        return (Equipa) em.createQuery("SELECT Object(e) FROM Equipa AS e left join fetch e.campeonatos where e.nome='"+nome+"'").getSingleResult();
    }

    public Equipa getEquipaDeep(String nome){
        return (Equipa) em.createQuery("SELECT Object(e) FROM Equipa AS e left JOIN FETCH e.pilotos left JOIN FETCH e.campeonatos where e.nome='"+nome+"'").getSingleResult();
    }

    public List<Campeonato> getCampeonatos(){
        int current = new GregorianCalendar().get(GregorianCalendar.YEAR);
        return em.createQuery("SELECT Object(c) FROM Campeonato AS c WHERE c.anoFim > "+current+"AND c.anoInicio >= "+current).getResultList();
    }

    public Campeonato getCampeonato (String designacao) {
        Campeonato c = null;
        try {
            c = (Campeonato) em.createQuery("select object(o) from Campeonato o LEFT JOIN FETCH o.equipas where o.designacao='"+designacao+"'").getSingleResult();
        } catch(NoResultException ex){
            c=null;
        }
        return c;
    }

    public ArrayList<Equipa> findAllOrdenado(String campo, String ordem, int limit, int offset){
        ArrayList<Equipa> eqs = new ArrayList<Equipa>();
        eqs = (ArrayList<Equipa>) em.createQuery("select distinct object(o) from Equipa o ORDER BY o."+campo+" "+ordem).setFirstResult(limit * (offset-1)).setMaxResults(limit).getResultList();
        return eqs;
    }

    public int countEquipas(){
        return new Integer(em.createQuery("select count(*) from Equipa as o").getSingleResult().toString());
    }

    public byte[] getImagem(Equipa e) {
        try {
            Equipa e2 = (Equipa) em.createQuery("Select object(e) from Equipa e left join fetch e.imagem i where e.id ="+e.getID()).getSingleResult();
            return e2.getImagem().getImagem();
        } catch (Exception ex) {}
        return null;
    }


    public void save(Equipa equ){
        em.merge(equ);
    }

    public void remove(Equipa equ){
        em.remove(em.merge(equ));
    }
}
