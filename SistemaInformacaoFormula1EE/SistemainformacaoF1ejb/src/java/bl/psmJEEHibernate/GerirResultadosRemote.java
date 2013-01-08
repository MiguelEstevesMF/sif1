/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate;

import POJOs.ResCampEquipa;
import POJOs.ResCampEquipas;
import POJOs.ResCampEventoCorr;
import POJOs.ResCampPiloto;
import POJOs.ResCampPilotos;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Tiago
 */
@Remote
public interface GerirResultadosRemote {

    public void persist(Object object);

    public void edit(Object object);

    public void remove(Object object);

    public ArrayList<ResCampEquipa> getResCampEquipa(String camp, String nomeEquip);

    public ArrayList<ResCampEquipas> getResCampEquipas(String camp);

    public ArrayList<ResCampPiloto> getResCampPiloto(String camp, String nomePiloto);

    public ArrayList<ResCampPilotos> getResCampPilotos(String camp);

    public ArrayList<ResCampEventoCorr> getResCampEventoCorr(String camp, String evt);

    public java.util.ArrayList<POJOs.ResCampEventos> getResCampEventos(java.lang.String camp);

    public java.util.ArrayList<POJOs.ResCampEventoQual> getResCampEventoQual(java.lang.String camp, java.lang.String evt);

    public java.util.ArrayList<java.util.ArrayList<POJOs.ResCampEventoTreinos>> getResCampEventoTreinos(java.lang.String camp, java.lang.String evt);

}
