package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.Transponder;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class InputBridgeBean implements InputBridgeRemote, InputBridgeLocal {

    @PersistenceContext
    private EntityManager em;

    private RunningSessions rs ;

    public InputBridgeBean() {
        rs = RunningSessions.getInstance();
    }


    public void regista(long currentTimeMillis, int potenciaSinal, int hits, int loopID, int transponderID) {

        Loop loop = (Loop) em.createQuery("SELECT DISTINCT Object(l) FROM Loop AS l WHERE l.ID="+loopID).getSingleResult();
        Transponder trp = (Transponder) em.createQuery("SELECT DISTINCT Object(t) FROM Transponder AS t LEFT JOIN FETCH t.piloto p LEFT JOIN FETCH p.equipa_actual WHERE t.ID="+transponderID).getSingleResult();

        Registro rg = new Registro();
        rg.setTempoTransponder(new Date(currentTimeMillis));
        rg.setPotenciaSinal(potenciaSinal);
        rg.setHits(hits);
        rg.setLoop(loop);
        rg.setTransponder(trp);

        em.merge(rg);

        rs.registar(rg);
    }


}