package bl.psmJEEHibernate;


import bl.psmJEEHibernate.entities.Admin;
import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Crono;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Gestor;
import bl.psmJEEHibernate.entities.Juiz;
import bl.psmJEEHibernate.entities.SBTR;
import bl.psmJEEHibernate.entities.Utilizador;
import java.util.ArrayList;
import java.util.HashSet;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateful
public class GerirUtilizadorBean implements GerirUtilizadorLocal, GerirUtilizadorRemote{

    @PersistenceContext
    private EntityManager em;
    private static Boolean created=false;

    public void create(Utilizador utilizador) {
        em.persist(utilizador);
    }

    public void edit(Utilizador utilizador) {
        em.merge(utilizador);
    }

    public void remove(Utilizador utilizador) {
        em.remove(em.merge(utilizador));
    }

    public boolean hasUser(String username){
        if (em.find(Utilizador.class, username)!=null) return true;
        else return false;
    }

    public boolean hasEmail(String email){
        if (em.createQuery("select object(o) from Utilizador as o where email='"+email+"'").getResultList().size()>0) return true;
        else return false;
    }

    public Equipa getEquipa (String user) {
        Equipa eq = null;
        try {
            eq = ((Utilizador) em.createQuery("select object(o) from Utilizador o left join fetch o.equipa c where username='"+user+"'").getSingleResult()).getEquipa();
        } catch(NoResultException ex){

        }
        return eq;
    }


    public int countUtilizadores(){
        return new Integer(em.createQuery("select count(*) from Utilizador as o").getSingleResult().toString());
    }

    public HashSet<Credencial> findAllCredenciais(){
        return new HashSet<Credencial>(em.createQuery("select object(c) from Credencial as c").getResultList());
    }

    public HashSet<Credencial> getCredenciaisUtilizador(String user){
        ArrayList<Utilizador> utils = new ArrayList<Utilizador>();
        utils = this.getUtilizadores();
        for(Utilizador u:utils)
            if (u.getUser().equals(user)) return new HashSet<Credencial>(u.getCredenciais());
        return null;
    }

    public Utilizador getUtilizador (String user) throws Exception {
        Utilizador us = null;
        try {
            us = (Utilizador) em.createQuery("select object(o) from Utilizador o left join fetch o.credenciais c where username='"+user+"'").getSingleResult();
        } catch(NoResultException ex){
            throw new Exception("Utilizador não existente.");
        }
        return us;
    }

    public ArrayList<Utilizador> getUtilizadores(){
        ArrayList<Utilizador> us = new ArrayList<Utilizador>();
        us = (ArrayList<Utilizador>) em.createQuery("select distinct object(o) from Utilizador o left join fetch o.credenciais c").getResultList();
        return us;
    }

    public void setUtilizador(Utilizador u){
        em.merge(u);
    }

    public void setUtilizadores(ArrayList<Utilizador> us){
        for(Utilizador u:us)
            em.merge(u);
    }

    public Utilizador loginValido (String user, String pass) throws Exception {
        Utilizador us;

        try {
            us = (Utilizador) em.createQuery("select object(o) from Utilizador as o left join fetch o.credenciais c where o.user='"+user+"'").getSingleResult();
            //em.refresh(us);
        } catch(NoResultException ex){
            throw new Exception("Utilizador não existe.");
        }

        if (us!=null) {
            System.out.println(us.getEstado());

            if (!us.getActivo())
                throw new Exception("Utilizador inactivo.");
            else if (us.getEstado().equals("online")){
                us = null;
                throw new Exception("Utilizador já está online.");
            }
            else if(!us.getPass().equals(pass))
                throw new Exception("Password inválida.");
            else return us;
        }
        return null;
    }

    public ArrayList<Utilizador> findAllOrdenado(String campo, String ordem, int limit, int offset){
        ArrayList<Utilizador> utils = new ArrayList<Utilizador>();
        utils = (ArrayList<Utilizador>) em.createQuery("select distinct object(o) from Utilizador o left join fetch o.credenciais c ORDER BY o."+campo+" "+ordem).setFirstResult(limit * (offset-1)).setMaxResults(limit).getResultList();
        return utils;
    }

    public void initCredenciais(){

        Credencial c = new Admin();
        c.setNome("Admin");
        em.merge(c);
        c = new Crono();
        c.setNome("Crono");
        em.merge(c);
        c = new Gestor();
        c.setNome("Gestor");
        em.merge(c);
        c = new Juiz();
        c.setNome("Juiz");
        em.merge(c);
        c = new SBTR();
        c.setNome("SBTR");
        em.merge(c);

    }

}
