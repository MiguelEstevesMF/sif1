package POJOs;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class ResCampEquipa {

    private String evento;
    private Date data;
    private int pontos;
    private boolean selected;


    public ResCampEquipa(String evento, Date data, int pontos) {
        this.evento = evento;
        this.data = data;
        this.pontos = pontos;
        this.selected = false;
    }

    public Date getData() {
        return data;
    }

    public String getData2() {
        return new SimpleDateFormat("dd/MM/yyyy").format(getData());
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
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
