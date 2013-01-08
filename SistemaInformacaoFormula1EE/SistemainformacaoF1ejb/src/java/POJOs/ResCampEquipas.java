/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

/**
 *
 * @author Tiago
 */
public class ResCampEquipas {

    private int posicao;
    private String equipa;
    private int pontos;
    private boolean selected;


    public ResCampEquipas(String equipa, int pontos) {
        this.posicao = 0;
        this.equipa = equipa;
        this.pontos = pontos;
        this.selected = false;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}
