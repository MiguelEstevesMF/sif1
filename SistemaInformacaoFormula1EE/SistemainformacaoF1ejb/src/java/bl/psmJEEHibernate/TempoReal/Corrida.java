package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.MelhorTempo_Sector;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.ResultadoCorrida;
import bl.psmJEEHibernate.entities.Sessao;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Corrida implements LiveSession, Serializable{

    private bl.psmJEEHibernate.entities.Corrida corrida;

    private CronometragemCorrida crono;

    private TreeSet<Loop> loops ; /* loops meta = 0Km total distance = circuito.lenth */

    private Observable_ obs ;

    private Map<Piloto,Integer> grelha;



        private String campeonato;
    private String evento;
    private String tsessao;

    Corrida(bl.psmJEEHibernate.entities.Corrida crd) {
        this.corrida = crd;
    }

    /**
     * @return the campeonato
     */
    public String getCampeonato() {
        return campeonato;
    }

    /**
     * @param campeonato the campeonato to set
     */
    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    /**
     * @return the evento
     */
    public String getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * @return the tsessao
     */
    public String getTsessao() {
        return tsessao;
    }

    /**
     * @param tsessao the tsessao to set
     */
    public void setTsessao(String tsessao) {
        this.tsessao = tsessao;
    }

    



    //private float comprimento;


    private class Observable_ extends Observable implements Serializable{
        public void setChanged(){
            super.setChanged();
        }
    }

    
    public Corrida(bl.psmJEEHibernate.entities.Corrida c, List<Loop> loops, Map<Piloto,Integer> grelha){

        this.corrida = c;

        this.loops = new TreeSet<Loop>(new Comparator<Loop>(){

            public int compare(Loop l1, Loop l2) {
                return (int)((l1.getPosicaoKm()-l2.getPosicaoKm())*1000.0);
            }

        });

        this.loops.addAll(loops);

        TreeSet ts = new TreeSet(this.loops);

        this.crono = new CronometragemCorrida(ts,c.getNumeroVoltas());

        this.obs = new Observable_();

        this.grelha = grelha ;


    }


    public void iniciar(){

        crono.start();

    }

    public void parar(){

     crono.stop();

    }


    private int pontos(int lugar){
        int res = 0;
        switch(lugar){
            case 1: res = 10; break;
            case 2: res =  8; break;
            case 3: res =  6; break;
            case 4: res =  5; break;
            case 5: res =  4; break;
            case 6: res =  3; break;
            case 7: res =  2; break;
            case 8: res =  1; break;
            default:  res = 0;
        }
        return res;
    }

    public boolean gerarResultadoFinal(){

        if(!crono.activo){

            Set<ResultadoCorrida> srsc = corrida.getResultados();
            //srsc.clear();

            for(ScoreBoardRTRegistro sbr : crono.sb){

                Set<MelhorTempo_Sector> mts = new HashSet<MelhorTempo_Sector>();
                for(Entry<Integer,Long> e : sbr.getTempos_sectors_melhor().entrySet()){
                    MelhorTempo_Sector mts_ = new MelhorTempo_Sector();
                    mts_.setSector(e.getKey());
                    mts_.setTempo(e.getValue());
                    mts.add(mts_);
                }

                ResultadoCorrida rstc = new ResultadoCorrida();
                rstc.setPosicao(sbr.getPosicao());
                rstc.setTempo(sbr.getTempo_acumulado());
                rstc.setVoltas(sbr.getVolta());
                rstc.setPiloto(sbr.getPiloto());
                rstc.setEquipa(sbr.getPiloto().getEquipa_actual());
                rstc.setMelhorsTemposPorSector(mts);

                rstc.setPontos(pontos(sbr.getPosicao()));
                rstc.setPosicaoGrelha(grelha.get(sbr.getPiloto()));
                rstc.setTempoMelhorVolta(sbr.getTempo_melhor_Volta().get(1)==null?0:sbr.getTempo_melhor_Volta().get(1));
                rstc.setVoltaMelhorTempo(sbr.getMelhor_volta());

                srsc.add(rstc);
            }

        }


        return !crono.activo;

    }


    public void registar(Registro r){

        crono.processaRegistro(r);

        obs.setChanged();

        obs.notifyObservers();
        
    }

    public TreeSet<Loop> getLoops() {
        return loops;
    }


    public Sessao getSessao() {
        return corrida;
    }




    public SortedSet<ScoreBoardRTRegistro> getScoreBoard() {
        return crono.sb;
    }

    public SortedSet<CronometragemRegistro> getScoreBoardCrono() {
        return crono.registros;
    }

    public void setObserver(Observer ob) {
        obs.addObserver(ob);
    }

    public void releaseObserver(Observer ob) {
        obs.deleteObserver(ob);
    }


    

    public void avancarQ() {
    }

    public int getCurrentQ() {
        return 0;
    }







    @Override
    public boolean equals(Object o){
        if(o instanceof Corrida){
            return ((Corrida) o).corrida.getID() == corrida.getID();
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.corrida != null ? this.corrida.hashCode() : 0);
        hash = 83 * hash + (this.crono != null ? this.crono.hashCode() : 0);
        hash = 83 * hash + (this.loops != null ? this.loops.hashCode() : 0);
        hash = 83 * hash + (this.obs != null ? this.obs.hashCode() : 0);
        return hash;
    }


}
