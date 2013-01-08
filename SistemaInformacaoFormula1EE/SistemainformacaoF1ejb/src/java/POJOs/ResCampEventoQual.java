/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

/**
 *
 * @author Tiago
 */
public class ResCampEventoQual {

    private int posicao;
    private int numero;
    private String piloto;
    private String equipa;
    private long qual_1;
    private long qual_2;
    private long qual_3;
    private int voltas;
    private boolean selected;


    public ResCampEventoQual(int numero, String piloto, String equipa, long qual_1, long qual_2, long qual_3, int voltas) {
        this.posicao = 0;
        this.numero = numero;
        this.piloto = piloto;
        this.equipa = equipa;
        this.qual_1 = qual_1;
        this.qual_2 = qual_2;
        this.qual_3 = qual_3;
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

    public long getQual_1() {
        return qual_1;
    }

    public void setQual_1(long qual_1) {
        this.qual_1 = qual_1;
    }

    public long getQual_2() {
        return qual_2;
    }

    public void setQual_2(long qual_2) {
        this.qual_2 = qual_2;
    }

    public long getQual_3() {
        return qual_3;
    }

    public void setQual_3(long qual_3) {
        this.qual_3 = qual_3;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }

    public String getQ1() {
        return new Tempo(qual_1).toStringQ();
    }
    public String getQ2() {
        return new Tempo(qual_2).toStringQ();
    }
    public String getQ3() {
        return new Tempo(qual_3).toStringQ();
    }
    
}
