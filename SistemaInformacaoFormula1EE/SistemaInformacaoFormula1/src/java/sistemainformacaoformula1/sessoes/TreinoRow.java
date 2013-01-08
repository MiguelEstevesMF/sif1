/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemainformacaoformula1.sessoes;

import bl.psmJEEHibernate.entities.Treino;
import java.util.Date;

/**
 *
 * @author Miguel
 */
public class TreinoRow {

    Treino t;
    private String treino;
    private boolean selected;
    private String activeStyle;


    public TreinoRow(String treino, Treino t) {
        this.t = t;
        this.treino = treino;
    }

    public TreinoRow(String treino, Date d) {
        t = new Treino();
        t.setData(d);
        this.treino = treino;
    }

    public String getActivestyle() {
        if(selected) return "background-color: #9999ff;";
        return "";
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Date getData() {
        return t.getData();
    }

    public void setData(Date data) {
        t.setData(data);
    }

    public String getTreino() {
        return treino;
    }

    public void setTreino(String treino) {
        this.treino = treino;
    }

    public Treino getT() {
        return t;
    }

    public void setT(Treino t) {
        this.t = t;
    }


}
