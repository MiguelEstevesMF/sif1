/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

/**
 *
 * @author Tiago
 */
public class ResCampPilotos {

    private int posicao;
    private String piloto;
    private String nacionalidade;
    private String equipa;
    private int pontos;
    private boolean selected;


    public ResCampPilotos(String piloto, String nacionalidade, String equipa, int pontos) {
        this.posicao = 0;
        this.piloto = piloto;
        this.nacionalidade = nacionalidade;
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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
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
