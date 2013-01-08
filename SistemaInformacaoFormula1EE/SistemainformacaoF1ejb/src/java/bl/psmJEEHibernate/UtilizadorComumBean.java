/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.ResultadoPiloto;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashSet;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tiago
 */
@Stateful
public class UtilizadorComumBean implements UtilizadorComumRemote, UtilizadorComumLocal {
    @PersistenceContext
    private EntityManager em;

    public ArrayList<ResultadoPiloto> getResEquipasCamp(String nome_camp){
       /* ArrayList<ArrayList<String>> lista = new ArrayList<ArrayList<String>>();
        ArrayList<ResultadoPiloto> rps = (ArrayList<ResultadoPiloto>) em.createQuery("select object(rp) from RESULTADOPILOTO rp join fetch rp.equipa e").getResultList();
        ArrayList<ResultadoPiloto> rps_final = new ArrayList<ResultadoPiloto>();
        for(ResultadoPiloto rp:rps){
            HashSet<Campeonato> camp = new HashSet<Campeonato>();
            camp = (HashSet<Campeonato>) rp.getEquipa().getCampeonatos();
            for(Campeonato c:camp)
                if (c.getDesignacao().equals(nome_camp)) rps.add(rp);
        }*/
        ArrayList<ResultadoPiloto> res = (ArrayList<ResultadoPiloto>) em.createQuery("select object(r) from ResultadoPiloto r join fetch r.equipa e join fetch e.campeonatos").getResultList();
        
        //System.out.println(rp.getEquipa().getCampeonatos().getNome());
        //ArrayList<String> a = new ArrayList<String>();
        //a.add(rp);
        //lista.add(a);
        return res;
    }
    
    
    
}
