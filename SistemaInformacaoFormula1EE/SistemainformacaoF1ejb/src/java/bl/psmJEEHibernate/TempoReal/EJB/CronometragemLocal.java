/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.psmJEEHibernate.TempoReal.EJB;

import javax.ejb.Local;

/**
 *
 * @author di
 */
@Local
public interface CronometragemLocal {
    public java.util.List<bl.psmJEEHibernate.entities.Campeonato> getCampeonatos();

    public java.util.List<bl.psmJEEHibernate.entities.Evento> getEventos(java.lang.String camp);

    public java.util.List<bl.psmJEEHibernate.entities.Sessao> getSessoes(java.lang.String evento);

    public void initCronoSystem(bl.psmJEEHibernate.entities.Sessao s);

    public java.util.List<bl.psmJEEHibernate.TempoReal.LiveSession> getLiveSession();

    public void iniciar();

    public void iniciar_ComSimulacao();

    public void finalizar();

    public void finalizar_comSimulacao();

    public boolean gravar();

    public bl.psmJEEHibernate.TempoReal.LiveSession getLs();

    public void setLs(bl.psmJEEHibernate.TempoReal.LiveSession ls);

    public java.util.SortedSet<bl.psmJEEHibernate.TempoReal.CronometragemRegistro> getScoreBoard();

    public void registraObserver(java.util.Observer ob);

    public void libertaObserver(java.util.Observer ob);

    public void avancarQ();

    public int getCurrentQ();

    public void avancarQ_comSimulacao();

}