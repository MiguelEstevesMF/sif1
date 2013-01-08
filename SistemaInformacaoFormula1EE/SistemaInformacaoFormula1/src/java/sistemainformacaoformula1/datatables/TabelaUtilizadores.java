/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemainformacaoformula1.datatables;

import bl.psmJEEHibernate.GerirUtilizadorLocal;
import bl.psmJEEHibernate.entities.Utilizador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Miguel
 */
public class TabelaUtilizadores extends SortableList {

    private ArrayList<UtilizadorRow> utilizadores;

    private static final String usernameColumnName = "username";
    private static final String nomeColumnName = "nome";
    private static final String datanascColumnName = "datanasc";
    private static final String estadoColumnName = "estado";

    public String getUsernameColumnName() { return usernameColumnName; }
    public String getNomeColumnName() { return nomeColumnName; }
    public String getDatanascColumnName() { return datanascColumnName; }
    public String getEstadoColumnName() { return estadoColumnName; }


    public TabelaUtilizadores() {
        super(usernameColumnName);
        this.utilizadores = new ArrayList<UtilizadorRow>();
    }

    @EJB
    private GerirUtilizadorLocal gur;

    public List<UtilizadorRow> getUtilizadores() {
        if (!oldSort.equals(sortColumnName) ||
             oldAscending != ascending){

             utilizadores = new ArrayList<UtilizadorRow>();

             try{
                for( Utilizador u : gur.getUtilizadores() ) {
                    
                    //utilizadores.add((UtilizadorRow) u);
                }
             } catch (Exception e){
                 System.out.println("erro");
             }
             //sort();
             oldSort = sortColumnName;
             oldAscending = ascending;
        }
        return utilizadores;
    }

    public void setUtilizadores(ArrayList<UtilizadorRow> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public void add(UtilizadorRow u){
        this.utilizadores.add(u);
    }

    protected boolean isDefaultAscending(String sortColumn) {
        return true;
    }


    protected void sort() {
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                UtilizadorRow u1 = (UtilizadorRow) o1;
                UtilizadorRow u2 = (UtilizadorRow) o2;
                if (sortColumnName == null) {
                    return 0;
                }
                if (sortColumnName.equals(nomeColumnName)) {
                    return ascending ?
                        u1.getNome().compareTo(u2.getNome()) :
                        u2.getNome().compareTo(u1.getNome());
                } else if (sortColumnName.equals(usernameColumnName)) {
                    return ascending ?
                            u1.getUser().compareTo(u2.getUser()) :
                            u2.getUser().compareTo(u1.getUser());
                } else if (sortColumnName.equals(datanascColumnName)) {
                    GregorianCalendar d1 = new GregorianCalendar();
                    GregorianCalendar d2 = new GregorianCalendar();
                    d1.setTime(u1.getDataNascimento());
                    d2.setTime(u2.getDataNascimento());
                    return ascending ?
                            d1.compareTo(d2) :
                            d2.compareTo(d1);
                } else if (sortColumnName.equals(estadoColumnName)) {
                    return ascending ?
                        u1.getEstado().compareTo(u2.getEstado()) :
                        u2.getEstado().compareTo(u1.getEstado());
                } else return 0;
            }
        };
        Collections.sort(utilizadores, comparator);
    }



}
