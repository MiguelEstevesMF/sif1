/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tiago
 */
public class ResCampEventoCorr {

    private int posicao;
    private int numero;
    private String piloto;
    private String equipa;
    private int voltas;
    private long tempo;
    private int grelha;
    private int pontos;
    private boolean selected;

    public ResCampEventoCorr(int numero, String piloto, String equipa, int voltas, long tempo, int grelha, int pontos) {
        this.posicao = 0;
        this.numero = numero;
        this.piloto = piloto;
        this.equipa = equipa;
        this.voltas = voltas;
        this.tempo = tempo;
        this.grelha = grelha;
        this.pontos = pontos;
        this.selected = false;
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getGrelha() {
        return grelha;
    }

    public void setGrelha(int grelha) {
        this.grelha = grelha;
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }

    public String getTempo2() {
        return new Tempo(this.tempo).toString();
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
