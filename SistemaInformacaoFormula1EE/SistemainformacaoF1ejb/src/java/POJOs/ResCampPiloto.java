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
public class ResCampPiloto {

    private String evento;
    private Date data;
    private String equipa;
    private int grelhaPartida;
    private int posicaoFinal;
    private int pontos;
    private boolean selected;
    
    public ResCampPiloto(String evento, Date data, String equipa, int grelhaPartida, int posicaoFinal, int pontos) {
        this.evento = evento;
        this.data = data;
        this.equipa = equipa;
        this.grelhaPartida = grelhaPartida;
        this.posicaoFinal = posicaoFinal;
        this.pontos = pontos;
        this.selected = false;
    }
 
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getData2() {
        return new SimpleDateFormat("dd/MM/yyyy").format(getData());
    }

    public String getEquipa() {
        return equipa;
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public int getGrelhaPartida() {
        return grelhaPartida;
    }

    public void setGrelhaPartida(int grelhaPartida) {
        this.grelhaPartida = grelhaPartida;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(int posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }




}
