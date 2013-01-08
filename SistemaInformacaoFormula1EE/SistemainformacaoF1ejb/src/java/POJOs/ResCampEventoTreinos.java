/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

/**
 *
 * @author Tiago
 */
public class ResCampEventoTreinos {

    private int posicao;
    private int numero;
    private String piloto;
    private String equipa;
    private long tempo;
    private int voltas;
    private boolean selected;

    public ResCampEventoTreinos(int numero, String piloto, String equipa, long tempo, int voltas) {
        this.posicao = 0;
        this.numero = numero;
        this.piloto = piloto;
        this.equipa = equipa;
        this.tempo = tempo;
        this.voltas = voltas;
        this.selected = false;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public long getTempo() {
        return tempo;
    }

    public String getTempo2() {
        return new Tempo(tempo).toString();
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }




}
