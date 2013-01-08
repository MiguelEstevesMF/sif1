package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Equipa_Piloto;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Transponder;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class GerirPilotoBean implements GerirPilotoRemote, GerirPilotoLocal {

    @PersistenceContext
    EntityManager em;


    public List<Piloto> getPilotos(){
        return em.createQuery("SELECT Object(p) FROM Piloto AS p ORDER by p.nome asc").getResultList();
    }

    public Piloto getPiloto(String nome){
        return (Piloto) em.createQuery("SELECT Object(p) FROM Piloto AS p LEFT JOIN FETCH p.equipa_actual JOIN FETCH p.transponder WHERE p.nome='"+nome+"'").getSingleResult();
    }

    public List<Equipa> getEquipas(){
        return em.createQuery("SELECT Object(e) FROM Equipa AS e").getResultList();
    }
    
    public boolean hasTransponderAssoc(String ref, Piloto piloto){
        Piloto p = null;
        try{
            p = (Piloto) em.createQuery("SELECT Object(p) FROM Piloto AS p LEFT JOIN FETCH p.transponder t WHERE t.ref='"+ref+"'").getSingleResult();
        } catch(Exception e){}
        if (p==null) return false;
        else if (p.getID()!=piloto.getID()) return true;
        else return false;
    }

    public boolean availableTransponder(String ref) {
        Piloto p = null;
        try{
            p = (Piloto) em.createQuery("SELECT Object(p) FROM Piloto AS p LEFT JOIN FETCH p.transponder t WHERE t.ref='"+ref+"'").getSingleResult();
        } catch(Exception e){}
        
        if (p==null) return true;
        return false;
    }

    public Transponder getTransponder(String ref) {
        Transponder t=null;
        try{
            t = (Transponder) em.createQuery("SELECT Object(t) FROM Transponder as t WHERE t.ref='"+ref+"'").getSingleResult();
        } catch(Exception e){}

        if (t==null) return t;
        return t;
    }

    public void addPiloto(Piloto p){
        Equipa_Piloto ep = new Equipa_Piloto();
        ep.setDataEntrada(new GregorianCalendar().getTime());
        ep.setEquipa(p.getEquipa_actual());
        ep.setPiloto(p);
        em.merge(ep);
    }

    public void remPiloto(Piloto p){
        ArrayList<Equipa_Piloto> eps = (ArrayList<Equipa_Piloto>) em.createQuery("SELECT Object(ep) FROM Equipa_Piloto AS ep LEFT JOIN FETCH ep.equipa LEFT JOIN FETCH ep.piloto WHERE ep.piloto.ID = "+p.getID()).getResultList();
        for(Equipa_Piloto ep:eps)
            em.remove(em.merge(ep));
        em.remove(em.merge(p));
    }

    public void editPiloto(Piloto novoPiloto) throws Exception{
        Piloto p = (Piloto) em.createQuery("SELECT Object(p) FROM Piloto AS p LEFT JOIN FETCH p.equipa_actual LEFT JOIN FETCH p.transponder WHERE p.ID = "+novoPiloto.getID()).getSingleResult();

        if (novoPiloto.getTransponder()!=null && this.hasTransponderAssoc(novoPiloto.getTransponder().getRef(),novoPiloto)) throw new Exception("Este transponder já tem um piloto associado.");
        else {
            if (p.getEquipa_actual()==null && novoPiloto.getEquipa_actual()!=null){
                Equipa_Piloto ep = (Equipa_Piloto) em.createQuery("SELECT Object(ep) FROM Equipa_Piloto AS ep LEFT JOIN FETCH ep.equipa LEFT JOIN FETCH ep.piloto WHERE ep.piloto.ID = "+novoPiloto.getID()).getSingleResult();
                em.remove(em.merge(ep));
                Equipa_Piloto novoEP = new Equipa_Piloto();
                novoEP.setDataEntrada(new GregorianCalendar().getTime());
                novoEP.setEquipa(novoPiloto.getEquipa_actual());
                novoEP.setPiloto(novoPiloto);
                em.merge(novoEP);
            } else if (p.getEquipa_actual()!=null && novoPiloto.getEquipa_actual()==null){
                Equipa_Piloto ep = (Equipa_Piloto) em.createQuery("SELECT Object(ep) FROM Equipa_Piloto AS ep LEFT JOIN FETCH ep.equipa LEFT JOIN FETCH ep.piloto WHERE ep.piloto.ID = "+novoPiloto.getID()).getSingleResult();
                ep.setDataSaida(new GregorianCalendar().getTime());
                em.merge(ep);
            } else if(p.getEquipa_actual()==null && novoPiloto.getEquipa_actual()==null) {
                em.merge(novoPiloto);
            } else if (p.getEquipa_actual().getID()!=novoPiloto.getEquipa_actual().getID()) {
                Equipa_Piloto ep = (Equipa_Piloto) em.createQuery("SELECT Object(ep) FROM Equipa_Piloto AS ep LEFT JOIN FETCH ep.equipa LEFT JOIN FETCH ep.piloto WHERE ep.piloto.ID = "+p.getID()+" AND ep.equipa.ID = "+p.getEquipa_actual().getID()).getSingleResult();
                ep.setDataSaida(new GregorianCalendar().getTime());
                em.merge(ep);
                Equipa_Piloto novoEP = new Equipa_Piloto();
                novoEP.setDataEntrada(new GregorianCalendar().getTime());
                novoEP.setEquipa(novoPiloto.getEquipa_actual());
                novoEP.setPiloto(novoPiloto);
                em.merge(novoEP);
            }
            em.merge(novoPiloto);
        }
        
    }


    public ArrayList<Piloto> findAllOrdenado(String campo, String ordem, int limit, int offset){
        ArrayList<Piloto> pils = new ArrayList<Piloto>();
        pils = (ArrayList<Piloto>) em.createQuery("select distinct object(o) from Piloto o ORDER BY o."+campo+" "+ordem).setFirstResult(limit * (offset-1)).setMaxResults(limit).getResultList();
        return pils;
    }

    public int countPilotos(){
        return new Integer(em.createQuery("select count(*) from Piloto as o").getSingleResult().toString());
    }


    public byte[] getImagem(Piloto p) {
        try {
            Piloto p2 = (Piloto) em.createQuery("Select object(p) from Piloto p left join fetch p.imagem i where p.id ="+p.getID()).getSingleResult();
            return p2.getImagem().getImagem();
        } catch (Exception ex) {}
        return null;
    }



}
