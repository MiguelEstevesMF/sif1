package bl.psmJEEHibernate.TempoReal;

import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Registro;
import bl.psmJEEHibernate.entities.Sessao;
import java.util.Observer;
import java.util.SortedSet;
import java.util.TreeSet;


public interface LiveSession {

    public void parar();

    public TreeSet<Loop> getLoops();

    public Sessao getSessao();

    public boolean gerarResultadoFinal();

    public void iniciar();

    public void registar(Registro r);

    public SortedSet<ScoreBoardRTRegistro> getScoreBoard();

    public SortedSet<CronometragemRegistro> getScoreBoardCrono();

    public void setObserver(Observer ob);

    public void releaseObserver(Observer ob);

    public void avancarQ();

    public int getCurrentQ();

    public String getCampeonato();

    public void setCampeonato(String c);

    public String getEvento();

    public void setEvento(String c);

    public String getTsessao();
    
    public void setTsessao(String c);

}
