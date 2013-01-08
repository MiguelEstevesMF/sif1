/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemainformacaoformula1.datatables;

import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Utilizador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Miguel
 */
public class UtilizadorRow extends Utilizador {


    boolean selected;

    public UtilizadorRow() {
        super();
    }

    
    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    String activestyle;
    public String getActivestyle() {
        if(super.getActivo()) return "";
        return "color: #cccccc;";
    }

    public String[] getCredenciais2() {
        String[] res = new String[10]; int i=0;
        for(Credencial c : super.getCredenciais())
            res[i++] = c.getNome();
        return res;
    }

    public String getDatanasc2() {
        return new SimpleDateFormat("dd/MM/yyyy").format(super.getDataNascimento());
    }


}
