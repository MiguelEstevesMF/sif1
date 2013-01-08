package bl.psmJEEHibernate.TempoReal;

import POJOs.Tempo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CronometragemRegistro implements Serializable {

    private int regNum;

    private int numPiloto;

    private String equipa;

    private String nomePiloto;

    private String transponder_ref;

    private int sector;

    private String loop_ref ;

    private long tempo ; /* desde o ultimo registro (tempo do sector)*/

    private long tempoProva ; /* tempo decorrido desde o inicio da prova */

    private Date tempoMedicao ; /* hora local quando foi registada a passagem */



    private int potenciaSinal ;

    private int hits ;

    private int volta ;

    private boolean pit;


    
    public CronometragemRegistro(int regNum, int numPiloto, String equipa, String nomePiloto, String transponder_ref, int sector, String loop_ref, long tempo, long tempoProva, Date tempoMedicao, int potenciaSinal, int hits, int volta, boolean pit) {
        this.regNum = regNum;
        this.numPiloto = numPiloto;
        this.equipa = equipa;
        this.nomePiloto = nomePiloto;
        this.transponder_ref = transponder_ref;
        this.sector = sector;
        this.loop_ref = loop_ref;
        this.tempo = tempo;
        this.tempoProva = tempoProva;
        this.tempoMedicao = tempoMedicao;
        this.potenciaSinal = potenciaSinal;
        this.hits = hits;
        this.volta = volta;
        this.pit = pit;
    }

    /**
     * @return the regNum
     */
    public int getRegNum() {
        return regNum;
    }

    /**
     * @return the numPiloto
     */
    public int getNumPiloto() {
        return numPiloto;
    }

    /**
     * @return the equipa
     */
    public String getEquipa() {
        return equipa;
    }

    /**
     * @return the nomePiloto
     */
    public String getNomePiloto() {
        return nomePiloto;
    }

    /**
     * @return the transponder_ref
     */
    public String getTransponder_ref() {
        return transponder_ref;
    }

    /**
     * @return the sector
     */
    public int getSector() {
        return sector;
    }

    /**
     * @return the loop_ref
     */
    public String getLoop_ref() {
        return loop_ref;
    }

    /**
     * @return the tempo
     */
    public long getTempo() {
        return tempo;
    }

    public String getTempo2(){
        return new Tempo(tempo).toStringQ();
    }

    /**
     * @return the tempoProva
     */
    public long getTempoProva() {
        return tempoProva;
    }

    public String getTempoProva2(){
        return new Tempo(tempoProva).toString();
    }

    /**
     * @return the tempoMedicao
     */
    public Date getTempoMedicao() {
        return tempoMedicao;
    }

    public String getTempoMedicao2() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss,SSS").format(tempoMedicao);
    }

    /**
     * @return the potenciaSinal
     */
    public int getPotenciaSinal() {
        return potenciaSinal;
    }

    /**
     * @return the hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * @return the volta
     */
    public int getVolta() {
        return volta;
    }

    /**
     * @return the pit
     */
    public boolean isPit() {
        return pit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CronometragemRegistro other = (CronometragemRegistro) obj;
        if (this.regNum != other.regNum) {
            return false;
        }
        if (this.numPiloto != other.numPiloto) {
            return false;
        }
        if ((this.equipa == null) ? (other.equipa != null) : !this.equipa.equals(other.equipa)) {
            return false;
        }
        if ((this.nomePiloto == null) ? (other.nomePiloto != null) : !this.nomePiloto.equals(other.nomePiloto)) {
            return false;
        }
        if ((this.transponder_ref == null) ? (other.transponder_ref != null) : !this.transponder_ref.equals(other.transponder_ref)) {
            return false;
        }
        if (this.sector != other.sector) {
            return false;
        }
        if ((this.loop_ref == null) ? (other.loop_ref != null) : !this.loop_ref.equals(other.loop_ref)) {
            return false;
        }
        if (this.tempo != other.tempo) {
            return false;
        }
        if (this.tempoProva != other.tempoProva) {
            return false;
        }
        if (this.tempoMedicao != other.tempoMedicao && (this.tempoMedicao == null || !this.tempoMedicao.equals(other.tempoMedicao))) {
            return false;
        }
        if (this.potenciaSinal != other.potenciaSinal) {
            return false;
        }
        if (this.hits != other.hits) {
            return false;
        }
        if (this.volta != other.volta) {
            return false;
        }
        if (this.pit != other.pit) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.regNum;
        hash = 29 * hash + this.numPiloto;
        hash = 29 * hash + (this.equipa != null ? this.equipa.hashCode() : 0);
        hash = 29 * hash + (this.nomePiloto != null ? this.nomePiloto.hashCode() : 0);
        hash = 29 * hash + (this.transponder_ref != null ? this.transponder_ref.hashCode() : 0);
        hash = 29 * hash + this.sector;
        hash = 29 * hash + (this.loop_ref != null ? this.loop_ref.hashCode() : 0);
        hash = 29 * hash + (int) (this.tempo ^ (this.tempo >>> 32));
        hash = 29 * hash + (int) (this.tempoProva ^ (this.tempoProva >>> 32));
        hash = 29 * hash + (this.tempoMedicao != null ? this.tempoMedicao.hashCode() : 0);
        hash = 29 * hash + this.potenciaSinal;
        hash = 29 * hash + this.hits;
        hash = 29 * hash + this.volta;
        hash = 29 * hash + (this.pit ? 1 : 0);
        return hash;
    }




}


