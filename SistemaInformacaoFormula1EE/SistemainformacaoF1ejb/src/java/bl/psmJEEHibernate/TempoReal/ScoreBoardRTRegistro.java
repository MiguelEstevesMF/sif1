package bl.psmJEEHibernate.TempoReal;

import POJOs.Tempo;
import bl.psmJEEHibernate.entities.Piloto;
import java.io.Serializable;
import java.util.TreeMap;


public class ScoreBoardRTRegistro implements Serializable {

    private int posicao = 0;

    private Piloto piloto;

    private int volta = 1;

    private long tempo_acumulado;

    private long tempo_ultima_volta;

    private long diff_u_primeiro;

    private long diff_u_frente;

    private TreeMap<Integer,Long> tempo_melhor_Volta = new TreeMap<Integer,Long>();

    private int melhor_volta;

    private long diff_gap_primeiro;

    private long diff_gap_frente;



    private TreeMap<Integer,Long> tempos_sectors_ultimo = new TreeMap<Integer,Long>();

    private TreeMap<Integer,Long> tempos_sectors_melhor = new TreeMap<Integer,Long>();

    private boolean pit;

    private int pitCount;

    private int sector;


    public ScoreBoardRTRegistro(Piloto piloto, boolean pit) {
        this.piloto = piloto;
        this.pit = pit;

    }

    /**
     * @return the posicao
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    /**
     * @return the numero
     */
    public int getNumeroPiloto() {
        return piloto.getNumero();
    }

    /**
     * @return the equipa
     */
    public String getNomeEquipa() {
        return piloto.getEquipa_actual().getNome();
    }

    /**
     * @return the piloto
     */
    public String getNomePiloto() {
        return piloto.getNome();
    }

    /**
     * @return the volta
     */
    public int getVolta() {
        return volta;
    }

    /**
     * @param volta the volta to set
     */
    public void setVolta(int volta) {
        this.volta = volta;
    }

    /**
     * @return the tempo_ultima_volta
     */
    public long getTempo_ultima_volta() {
        return tempo_ultima_volta;
    }

    public String getTempo_ultima_volta2() {
        return new Tempo(tempo_ultima_volta).toStringQ();
    }

    /**
     * @param tempo_ultima_volta the tempo_ultima_volta to set
     */
    public void setTempo_ultima_volta(long tempo_ultima_volta) {
        this.tempo_acumulado += tempo_ultima_volta;
        this.tempo_ultima_volta = tempo_ultima_volta;
    }

    /**
     * @return the diff_u_primeiro
     */
    public long getDiff_u_primeiro() {
        return diff_u_primeiro;
    }

    public String getDiff_u_primeiro2() {
        return new Tempo(diff_u_primeiro).toStringQ();
    }

    /**
     * @param diff_u_primeiro the diff_u_primeiro to set
     */
    public void setDiff_u_primeiro(long diff_u_primeiro) {
        this.diff_u_primeiro = diff_u_primeiro;
    }

    /**
     * @return the diff_u_frente
     */
    public long getDiff_u_frente() {
        return diff_u_frente;
    }

    public String getDiff_u_frente2() {
        return new Tempo(diff_u_frente).toStringQ();
    }
    /**
     * @param diff_u_frente the diff_u_frente to set
     */
    public void setDiff_u_frente(long diff_u_frente) {
        this.diff_u_frente = diff_u_frente;
    }

    /**
     * @return the tempo_melhor_Volta
     */
    public TreeMap<Integer,Long> getTempo_melhor_Volta() {
        return tempo_melhor_Volta;
    }

    public String getTempo_melhor_Volta2() {
        if(tempo_melhor_Volta.containsKey(1))
            return new Tempo(tempo_melhor_Volta.get(1)).toStringQ();
        else return "---";
    }

    /**
     * @param tempo_melhor_Volta the tempo_melhor_Volta to set
     */
    public void setTempo_melhor_Volta(TreeMap<Integer,Long> tempo_melhor_Volta) {
        this.tempo_melhor_Volta = tempo_melhor_Volta;
    }

    /**
     * @return the diff_m_primeiro
     */
    public long getDiff_gap_primeiro() {
        return diff_gap_primeiro;
    }

    public String getGapCorrida() {
        if(diff_gap_primeiro==0) return new Tempo(tempo_acumulado).toString();
        if(diff_gap_primeiro<0) return "" + Math.abs(diff_gap_primeiro) + " VA";
        return new Tempo(diff_gap_primeiro).toStringQ();

    }

    public String getIntervaloCorrida() {
        if(diff_gap_frente==0) return "volta: " + volta;
        if(diff_gap_frente<0) return "" + Math.abs(diff_gap_primeiro) + " VA";
        return new Tempo(diff_gap_frente).toStringQ();

    }

    /**
     * @param diff_m_primeiro the diff_m_primeiro to set
     */
    public void setDiff_gap_primeiro(long diff_m_primeiro) {
        this.diff_gap_primeiro = diff_m_primeiro;
    }

    /**
     * @return the diff_m_frente
     */
    public long getDiff_gap_frente() {
        return diff_gap_frente;
    }

    /**
     * @param diff_m_frente the diff_m_frente to set
     */
    public void setDiff_gap_frente(long diff_m_frente) {
        this.diff_gap_frente = diff_m_frente;
    }

    /**
     * @return the tempos_sectors_ultimo
     */
    public TreeMap<Integer,Long> getTempos_sectors_ultimo() {
        return tempos_sectors_ultimo;
    }

    public String getS1() {
        if(tempos_sectors_ultimo.containsKey(1))
            return new Tempo(tempos_sectors_ultimo.get(1)).toStringQ();
        return "--";
    }

    public String getS2() {
        if(tempos_sectors_ultimo.containsKey(2))
            return new Tempo(tempos_sectors_ultimo.get(2)).toStringQ();
        return "--";
    }

    public String getS3() {
        if(tempos_sectors_ultimo.containsKey(3))
            return new Tempo(tempos_sectors_ultimo.get(3)).toStringQ();
        return "--";
    }

    public String getS4() {
        if(tempos_sectors_ultimo.containsKey(4))
            return new Tempo(tempos_sectors_ultimo.get(4)).toStringQ();
        return "--";
    }

    public String getS5() {
        if(tempos_sectors_ultimo.containsKey(5))
            return new Tempo(tempos_sectors_ultimo.get(5)).toStringQ();
        return "--";
    }

    public String getS6() {
        if(tempos_sectors_ultimo.containsKey(6))
            return new Tempo(tempos_sectors_ultimo.get(6)).toStringQ();
        return "--";
    }

    public String getS7() {
        if(tempos_sectors_ultimo.containsKey(7))
            return new Tempo(tempos_sectors_ultimo.get(7)).toStringQ();
        return "--";
    }

    public String getS8() {
        if(tempos_sectors_ultimo.containsKey(8))
            return new Tempo(tempos_sectors_ultimo.get(8)).toStringQ();
        return "--";
    }

    public String getS9() {
        if(tempos_sectors_ultimo.containsKey(9))
            return new Tempo(tempos_sectors_ultimo.get(9)).toStringQ();
        return "--";
    }

    public String getS10() {
        if(tempos_sectors_ultimo.containsKey(10))
            return new Tempo(tempos_sectors_ultimo.get(10)).toStringQ();
        return "--";
    }

    /**
     * @param tempos_sectors_ultimo the tempos_sectors_ultimo to set
     */
    public void setTempos_sectors_ultimo(TreeMap<Integer,Long> tempos_sectors_ultimo) {
        this.tempos_sectors_ultimo = tempos_sectors_ultimo;
    }

    /**
     * @return the tempos_sectors_melhor
     */
    public TreeMap<Integer,Long> getTempos_sectors_melhor() {
        return tempos_sectors_melhor;
    }

    /**
     * @param tempos_sectors_melhor the tempos_sectors_melhor to set
     */
    public void setTempos_sectors_melhor(TreeMap<Integer,Long> tempos_sectors_melhor) {
        this.tempos_sectors_melhor = tempos_sectors_melhor;
    }

    /**
     * @return the pit
     */
    public boolean isPit() {
        return pit;
    }

    /**
     * @param pit the pit to set
     */
    public void setPit(boolean pit) {
        this.pit = pit;
    }

    /**
     * @return the pitCount
     */
    public int getPitCount() {
        return pitCount;
    }

    /**
     * @param pitCount the pitCount to set
     */
    public void setPitCount(int pitCount) {
        this.pitCount = pitCount;
    }

    public Piloto getPiloto(){
        return piloto;
    }



    public long getTempo_acumulado() {
        return tempo_acumulado;
    }

    /**
     * @return the melhor_volta
     */
    public int getMelhor_volta() {
        return melhor_volta;
    }

    /**
     * @param melhor_volta the melhor_volta to set
     */
    public void setMelhor_volta(int melhor_volta) {
        this.melhor_volta = melhor_volta;
    }



    public String getQ1() {
        if(tempo_melhor_Volta.containsKey(1))
            return new Tempo(tempo_melhor_Volta.get(1)).toStringQ();
        else return "---";
    }

    public String getQ2() {
        if(tempo_melhor_Volta.containsKey(2))
            return new Tempo(tempo_melhor_Volta.get(2)).toStringQ();
        else return "---";
    }

    public String getQ3() {
        if(tempo_melhor_Volta.containsKey(3))
            return new Tempo(tempo_melhor_Volta.get(3)).toStringQ();
        else return "---";
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }





}
