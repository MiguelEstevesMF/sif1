package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Circuito;
import bl.psmJEEHibernate.entities.Loop;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GerirCircuitoBean implements GerirCircuitoRemote, GerirCircuitoLocal {

    @PersistenceContext
    EntityManager em;


    public List<Circuito> getCircuitos(){
        return em.createQuery("SELECT distinct Object(c) FROM Circuito AS c LEFT JOIN FETCH c.loops ORDER BY c.nome").getResultList();
    }

    public Circuito getCircuito(String nome){
        return (Circuito) em.createQuery("SELECT Object(c) FROM Circuito AS c LEFT JOIN FETCH c.loops WHERE c.nome='"+nome+"'").getSingleResult();
    }

    public void addCircuito(Circuito c){
        Loop fl = new Loop();
        fl.setRef("fl");
        fl.setPosicaoKm(0);
        Loop box = new Loop();
        box.setRef("box");
        box.setPosicaoKm(-1);
        c.addLoop(fl);
        c.addLoop(box);
        em.merge(c);
    }

    public void remCircuito(Circuito c){
        em.flush();
        for(Loop l : c.getLoops())
            em.remove(em.merge(l));
        em.remove(em.merge(c));
    }

    public void editCircuito(Circuito c){
        Circuito circ = new Circuito();
        circ = (Circuito) em.createQuery("SELECT Object(c) FROM Circuito AS c LEFT JOIN FETCH c.loops WHERE c.ID="+c.getID()).getSingleResult();
        em.remove(em.merge(circ));
        em.flush();
        em.merge(c);
    }

    
    public ArrayList<Circuito> findAllOrdenado(String campo, String ordem, int limit, int offset){
        ArrayList<Circuito> cirs = new ArrayList<Circuito>();
        cirs = (ArrayList<Circuito>) em.createQuery("select distinct object(o) from Circuito o LEFT JOIN FETCH o.loops ORDER BY o."+campo+" "+ordem).setFirstResult(limit * (offset-1)).setMaxResults(limit).getResultList();
        return cirs;
    }

    public int countCircuitos(){
        return new Integer(em.createQuery("select count(*) from Circuito as o").getSingleResult().toString());
    }
    
    public byte[] getImagem(Circuito c) {
        try {
            Circuito c2 = (Circuito) em.createQuery("Select object(c) from Circuito c left join fetch c.imagem i where c.nome ='"+c.getNome()+"'").getSingleResult();
            return c2.getImagem().getImagem();
        } catch (Exception ex) {}
        return null;
    }


    public void save(Object o) {
        em.merge(o);
    }

    public void remove(Object o) {
        em.remove(em.merge(o));
    }
}
