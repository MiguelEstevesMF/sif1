/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.TempoReal.Corrida;
import bl.psmJEEHibernate.TempoReal.EJB.ConsultaTempoRealLocal;
import bl.psmJEEHibernate.TempoReal.LiveSession;
import bl.psmJEEHibernate.TempoReal.Qualificacao;
import bl.psmJEEHibernate.TempoReal.ScoreBoardRTRegistro;
import com.icesoft.faces.async.render.SessionRenderer;
import java.util.Observable;
import sistemainformacaoformula1.MenuUtilizador;
import sistemainformacaoformula1.*;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.UIColumn;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.List;
import java.util.Observer;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Scoreboard extends AbstractPageBean implements Observer {

    @EJB
    ConsultaTempoRealLocal ctr;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    private HtmlDataTable dataTable1_sbtrCorrida = new HtmlDataTable();

    public HtmlDataTable getDataTable1_sbtrCorrida() {
        return dataTable1_sbtrCorrida;
    }

    public void setDataTable1_sbtrCorrida(HtmlDataTable dataTable1_sbtrCorrida) {
        this.dataTable1_sbtrCorrida = dataTable1_sbtrCorrida;
    }


    private HtmlDataTable dataTable1_sbtrQualificacao = new HtmlDataTable();

    public HtmlDataTable getDataTable1_sbtrQualificacao() {
        return dataTable1_sbtrQualificacao;
    }

    public void setDataTable1_sbtrQualificacao(HtmlDataTable dataTable1_sbtrQualificacao) {
        this.dataTable1_sbtrQualificacao = dataTable1_sbtrQualificacao;
    }

    private HtmlDataTable dataTable1_sbtrTreino = new HtmlDataTable();

    public HtmlDataTable getDataTable1_sbtrTreino() {
        return dataTable1_sbtrTreino;
    }

    public void setDataTable1_sbtrTreino(HtmlDataTable dataTable1_sbtrTreino) {
        this.dataTable1_sbtrTreino = dataTable1_sbtrTreino;
    }



    public SortedSet<ScoreBoardRTRegistro> getSbtrSet() {
        try {
            return ctr.getScoreBoard();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new TreeSet<ScoreBoardRTRegistro>();
    }

    public SortedSet<ScoreBoardRTRegistro> getSbtrCorridaSet() {
        return getSbtrSet();
    }

    public SortedSet<ScoreBoardRTRegistro> getSbtrQualificacaoSet() {
        return getSbtrSet();
    }

    public SortedSet<ScoreBoardRTRegistro> getSbtrTreinoSet() {
        return getSbtrSet();
    }


    public int getUltimoPilotoRegistro() {
        try {
            return ctr.ultimoPilotoRegistrado();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1;

    }


    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Scoreboard() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
            
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        dataTable1_sbtrCorrida.setRendered(false);
        dataTable1_sbtrQualificacao.setRendered(false);
        dataTable1_sbtrTreino.setRendered(false);


        SessionRenderer.addCurrentSession("sbtr");

        try {
            ctr.setLs(ctr.getLiveSessions().get(0));
            ctr.registraObserver(this);

            LiveSession ls = ctr.getLiveSessions().get(0);

            if(ls.getSessao() instanceof bl.psmJEEHibernate.entities.Corrida)
                dataTable1_sbtrCorrida.setRendered(true);
            else if(ls.getSessao() instanceof bl.psmJEEHibernate.entities.Qualificacao)
                dataTable1_sbtrQualificacao.setRendered(true);
            else if(ls.getSessao() instanceof bl.psmJEEHibernate.entities.Treino)
                dataTable1_sbtrTreino.setRendered(true);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        
      
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }

    protected RequestBean1 getRequestBean1() { return (RequestBean1) getBean("RequestBean1"); }
    protected SessionBean1 getSessionBean1() { return (SessionBean1) getBean("SessionBean1"); }
    protected ApplicationBean1 getApplicationBean1() { return (ApplicationBean1) getBean("ApplicationBean1"); }
    protected MenuUtilizador getMenuUtilizador() { return (MenuUtilizador) getBean("MenuUtilizador"); }



    public void update(Observable o, Object arg) {
        apagaColunasSectores();
        SessionRenderer.render("sbtr");
    }

    

    boolean bool = false;
    public void apagaColunasSectores() {
        if(bool) return;
        try {

            int ns = ctr.nSectores();
            System.out.println("ns="+ns);

            LiveSession ls = ctr.getLiveSessions().get(0);
            List<UIComponent> cols;
            if(ls.getSessao() instanceof bl.psmJEEHibernate.entities.Corrida)
                cols = dataTable1_sbtrCorrida.getChildren();
            else if(ls.getSessao() instanceof bl.psmJEEHibernate.entities.Qualificacao)
                cols = dataTable1_sbtrQualificacao.getChildren();
            else
                cols = dataTable1_sbtrTreino.getChildren();

            for(int i=1;i<12-ns;i++)
                cols.remove(cols.size()-3);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        bool=true;
    }


    public String getTitulos() {
        try {
        LiveSession ls = ctr.getLiveSessions().get(0);
        return ls.getCampeonato()+" - "+ ls.getEvento()+" - "+ls.getTsessao();
        } catch(Exception ex) {}
        return "";
    }

}

