package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.MelhorTempo_Sector;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.ResultadoTreino;
import bl.psmJEEHibernate.entities.Sessao;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;



public class Treino implements LiveSession, Serializable{

    private bl.psmJEEHibernate.entities.Treino treino;

    private CronometragemTreino crono;

    private TreeSet<Loop> loops ; /* loops meta = 0Km total distance = circuito.lenth */

    private Observable_ obs ;


    private String campeonato;
    private String evento;
    private String tsessao;

    Treino(bl.psmJEEHibernate.entities.Treino t) {
        this.treino = t;
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

    


    private class Observable_ extends Observable implements Serializable{
        @Override
        public void setChanged(){
            super.setChanged();
        }
    }

    
    public Treino(bl.psmJEEHibernate.entities.Treino t, List<Loop> loops){

        this.treino = t;

        this.loops = new TreeSet<Loop>(new Comparator<Loop>(){

            public int compare(Loop l1, Loop l2) {
                return (int)((l1.getPosicaoKm()-l2.getPosicaoKm())*1000.0);
            }

        });

        this.loops.addAll(loops);

        TreeSet ts = new TreeSet(this.loops);

        this.crono = new CronometragemTreino(ts);

        this.obs = new Observable_();

    }


    public void iniciar(){

        crono.start();

    }

    public void parar(){

     crono.stop();

    }

    public boolean gerarResultadoFinal(){

        if(!crono.activo){

            Set<ResultadoTreino> trstr = treino.getResultados();
            trstr.clear();

            for(ScoreBoardRTRegistro sbr : crono.sb){

                Set<MelhorTempo_Sector> mts = new HashSet<MelhorTempo_Sector>();

                for(Entry<Integer,Long> e : sbr.getTempos_sectors_melhor().entrySet()){
                    MelhorTempo_Sector mts_ = new MelhorTempo_Sector();
                    mts_.setSector(e.getKey());
                    mts_.setTempo(e.getValue());
                    mts.add(mts_);
                }
                ResultadoTreino rstr = new ResultadoTreino();
                rstr.setPosicao(sbr.getPosicao());
                rstr.setTempo(sbr.getTempo_melhor_Volta().get(1));
                rstr.setVoltas(sbr.getVolta());
                rstr.setPiloto(sbr.getPiloto());
                rstr.setEquipa(sbr.getPiloto().getEquipa_actual());
                rstr.setMelhorsTemposPorSector(mts);

                trstr.add(rstr);
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
        return treino;
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
        if(o instanceof Treino){
            return ((Treino) o).treino.getID() == treino.getID();
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.treino != null ? this.treino.hashCode() : 0);
        hash = 83 * hash + (this.crono != null ? this.crono.hashCode() : 0);
        hash = 83 * hash + (this.loops != null ? this.loops.hashCode() : 0);
        hash = 83 * hash + (this.obs != null ? this.obs.hashCode() : 0);
        return hash;
    }


}
