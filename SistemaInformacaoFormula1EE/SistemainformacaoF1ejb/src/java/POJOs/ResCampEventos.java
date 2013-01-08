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
public class ResCampEventos {

    private String evento;
    private Date data;
    private String pilotoVenc;
    private String equipa;
    private int voltas;
    private long tempo;
    private boolean selected;

    public ResCampEventos(String evento, Date data, String pilotoVenc, String equipa, int voltas, long tempo) {
        this.evento = evento;
        this.data = data;
        this.pilotoVenc = pilotoVenc;
        this.equipa = equipa;
        this.voltas = voltas;
        this.tempo = tempo;
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

    public String getPilotoVenc() {
        return pilotoVenc;
    }

    public void setPilotoVenc(String pilotoVenc) {
        this.pilotoVenc = pilotoVenc;
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



}
