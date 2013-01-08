/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemainformacaoformula1.sessoes;

import bl.psmJEEHibernate.entities.Loop;

/**
 *
 * @author Miguel
 */
public class LoopRow {

    Loop l;
    private boolean selected;
    private boolean disabled;

    public LoopRow(String descricao, float posicao) {
        l = new Loop();
        l.setRef(descricao);
        l.setPosicaoKm(posicao);
    }

    public LoopRow(Loop l) {
        this.l = l;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getDescricao() {
        return l.getRef();
    }

    public void setDescricao(String descricao) {
        l.setRef(descricao);
    }

    public float getPosicao() {
        return l.getPosicaoKm();
    }

    public void setPosicao(float posicao) {
        l.setPosicaoKm(posicao);
    }

    public Loop getL() {
        return l;
    }

    public void setL(Loop l) {
        this.l = l;
    }

    public boolean getDisabled() {
        if(l==null) return false;
        if (l.getRef()==null) return false;
        if(l.getRef().equals("fl") || l.getRef().equals("box"))
            return true;
        return false;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }




}
