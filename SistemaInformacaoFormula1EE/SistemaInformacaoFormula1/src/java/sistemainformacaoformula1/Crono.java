/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.GerirCampeonatoLocal;
import bl.psmJEEHibernate.GerirEquipaLocal;
import bl.psmJEEHibernate.TempoReal.CronometragemRegistro;
import bl.psmJEEHibernate.TempoReal.EJB.CronometragemLocal;
import bl.psmJEEHibernate.TempoReal.EJB.CronometragemLocal;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Treino;
import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Corrida;
import bl.psmJEEHibernate.entities.Qualificacao;
import com.icesoft.faces.async.render.SessionRenderer;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Crono extends AbstractPageBean implements Observer {

    @EJB
    private GerirCampeonatoLocal gcr;

    @EJB
    private GerirEquipaLocal ger;

    @EJB
    private CronometragemLocal crr;


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    private DefaultSelectedData campeonatoSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems campeonatoSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu campeonatoSelectOneMenu1 = new HtmlSelectOneMenu();

    private DefaultSelectedData eventoSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems eventoSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu eventoSelectOneMenu1 = new HtmlSelectOneMenu();

    private DefaultSelectedData sessaoSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems sessaoSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu sessaoSelectOneMenu1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCampeonatoSelectOneMenu1() {
        return campeonatoSelectOneMenu1;
    }

    public void setCampeonatoSelectOneMenu1(HtmlSelectOneMenu campeonatoSelectOneMenu1) {
        this.campeonatoSelectOneMenu1 = campeonatoSelectOneMenu1;
    }

    public DefaultSelectedData getCampeonatoSelectOneMenu1Bean() {
        return campeonatoSelectOneMenu1Bean;
    }

    public void setCampeonatoSelectOneMenu1Bean(DefaultSelectedData campeonatoSelectOneMenu1Bean) {
        this.campeonatoSelectOneMenu1Bean = campeonatoSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCampeonatoSelectOneMenu1DefaultItems() {
        return campeonatoSelectOneMenu1DefaultItems;
    }

    public void setCampeonatoSelectOneMenu1DefaultItems(DefaultSelectionItems campeonatoSelectOneMenu1DefaultItems) {
        this.campeonatoSelectOneMenu1DefaultItems = campeonatoSelectOneMenu1DefaultItems;
    }

    public HtmlSelectOneMenu getEventoSelectOneMenu1() {
        return eventoSelectOneMenu1;
    }

    public void setEventoSelectOneMenu1(HtmlSelectOneMenu eventoSelectOneMenu1) {
        this.eventoSelectOneMenu1 = eventoSelectOneMenu1;
    }

    public DefaultSelectedData getEventoSelectOneMenu1Bean() {
        return eventoSelectOneMenu1Bean;
    }

    public void setEventoSelectOneMenu1Bean(DefaultSelectedData eventoSelectOneMenu1Bean) {
        this.eventoSelectOneMenu1Bean = eventoSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getEventoSelectOneMenu1DefaultItems() {
        return eventoSelectOneMenu1DefaultItems;
    }

    public void setEventoSelectOneMenu1DefaultItems(DefaultSelectionItems eventoSelectOneMenu1DefaultItems) {
        this.eventoSelectOneMenu1DefaultItems = eventoSelectOneMenu1DefaultItems;
    }

    public HtmlSelectOneMenu getSessaoSelectOneMenu1() {
        return sessaoSelectOneMenu1;
    }

    public void setSessaoSelectOneMenu1(HtmlSelectOneMenu sessaoSelectOneMenu1) {
        this.sessaoSelectOneMenu1 = sessaoSelectOneMenu1;
    }

    public DefaultSelectedData getSessaoSelectOneMenu1Bean() {
        return sessaoSelectOneMenu1Bean;
    }

    public void setSessaoSelectOneMenu1Bean(DefaultSelectedData sessaoSelectOneMenu1Bean) {
        this.sessaoSelectOneMenu1Bean = sessaoSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getSessaoSelectOneMenu1DefaultItems() {
        return sessaoSelectOneMenu1DefaultItems;
    }

    public void setSessaoSelectOneMenu1DefaultItems(DefaultSelectionItems sessaoSelectOneMenu1DefaultItems) {
        this.sessaoSelectOneMenu1DefaultItems = sessaoSelectOneMenu1DefaultItems;
    }


    private HtmlDataTable dataTable1_crono = new HtmlDataTable();

    public HtmlDataTable getDataTable1_crono() {
        return dataTable1_crono;
    }

    public void setDataTable1_crono(HtmlDataTable dataTable1_crono) {
        this.dataTable1_crono = dataTable1_crono;
    }

    private TreeSet<CronometragemRegistro> cronometragemSet = null;

    public SortedSet<CronometragemRegistro> getCronometragemSet() {
        try {
            return crr.getScoreBoard();
            //return cronometragemSet;
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
        }
        return new TreeSet<CronometragemRegistro>();
        
    }






    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlCommandButton start_button1 = new HtmlCommandButton();

    public HtmlCommandButton getStart_button1() {
        return start_button1;
    }

    public void setStart_button1(HtmlCommandButton hcb) {
        this.start_button1 = hcb;
    }
    private HtmlCommandButton stop_button2 = new HtmlCommandButton();

    public HtmlCommandButton getStop_button2() {
        return stop_button2;
    }

    public void setStop_button2(HtmlCommandButton hcb) {
        this.stop_button2 = hcb;
    }

    private HtmlCommandButton avancarQ_button3 = new HtmlCommandButton();

    public HtmlCommandButton getAvancarQ_button3() {
        return avancarQ_button3;
    }

    public void setAvancarQ_button3(HtmlCommandButton avancarQ_button3) {
        this.avancarQ_button3 = avancarQ_button3;
    }


    
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Crono() {
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
        refreshCampsDropDown();
        start_button1.setDisabled(true);
        stop_button2.setDisabled(true);

        if(crr.getLiveSession().size()>0) {
            campeonatoSelectOneMenu1.setDisabled(true);
            eventoSelectOneMenu1.setDisabled(true);
            sessaoSelectOneMenu1.setDisabled(true);
            stop_button2.setDisabled(false);
            SessionRenderer.addCurrentSession("crono");
            crr.setLs(crr.getLiveSession().get(0));
            crr.registraObserver(this);
            campeonatoSelectOneMenu1Bean.setSelectedItem(crr.getLs().getCampeonato());
            refreshEventosDropDown();
            eventoSelectOneMenu1Bean.setSelectedItem(crr.getLs().getEvento());
            refreshSessaoDropDown();
            sessaoSelectOneMenu1Bean.setSelectedItem(crr.getLs().getTsessao());
        }

        
    }


    public void refreshCampsDropDown() {
        campeonatoSelectOneMenu1DefaultItems.clear();
        for(Campeonato c : ger.getCampeonatos())
            campeonatoSelectOneMenu1DefaultItems.add(new SelectItem(c.getDesignacao(),c.getDesignacao()));

        eventoSelectOneMenu1DefaultItems.clear();
        sessaoSelectOneMenu1DefaultItems.clear();
    }

    public void refreshEventosDropDown() {
        eventoSelectOneMenu1DefaultItems.clear();
        eventoSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        for(Evento e : gcr.getEventos(campeonatoSelectOneMenu1Bean.getSelectedItem()))
            eventoSelectOneMenu1DefaultItems.add(new SelectItem(e.getDesignacao(),e.getDesignacao()));

        sessaoSelectOneMenu1DefaultItems.clear();
    }

    public void refreshSessaoDropDown() {
        sessaoSelectOneMenu1DefaultItems.clear();
        sessaoSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        sessaoSelectOneMenu1DefaultItems.add(new SelectItem("Corrida","Corrida"));
        sessaoSelectOneMenu1DefaultItems.add(new SelectItem("Qualificação","Qualificação"));
        int i = 1;
        for(Treino t : gcr.getEventoDeep(eventoSelectOneMenu1Bean.getSelectedItem()).getTreinos())
            sessaoSelectOneMenu1DefaultItems.add(new SelectItem("Treino "+i,"Treino "+(i++)));
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


    public void campeonatoSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) return;

        campeonatoSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());
        refreshEventosDropDown();


        String evSelected = eventoSelectOneMenu1Bean.getSelectedItem();

        if(evSelected==null || evSelected.equals("")) return;


    }


    public void eventoSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) {
            return;
        }

        eventoSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());

        String selected = eventoSelectOneMenu1Bean.getSelectedItem();

        if(selected==null || selected.equals("")) return;

        String selectedSe = sessaoSelectOneMenu1Bean.getSelectedItem();
        refreshSessaoDropDown();

        if(selectedSe==null || selectedSe.equals("Corrida")) {

            return;
        }
        if(selectedSe.equals("Qualificação")) {
            return;
        }
        if(selectedSe.startsWith("Treino")) {

            return;
        }


    }


    public void sessaoSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) {

            return;
        }

        sessaoSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());

        String selected = sessaoSelectOneMenu1Bean.getSelectedItem();

        String selectedEv = eventoSelectOneMenu1Bean.getSelectedItem();

        if(selectedEv==null || selectedEv.equals("")) return;

        if(selected.equals("Corrida")) {
            start_button1.setDisabled(false);
            return;
        }
        if(selected.equals("Qualificação")) {
            start_button1.setDisabled(false);
            return;
        }
        if(selected.startsWith("Treino")) {
            start_button1.setDisabled(false);
            return;
        }

    }

    public String start_button1_action() {
        String evento = eventoSelectOneMenu1Bean.getSelectedItem();
        if(evento ==null) return null;

        String selected = sessaoSelectOneMenu1Bean.getSelectedItem();

        if(selected==null || selected.equals("")) return null;

        
        if(selected.equals("Corrida")) {
            Corrida c = (Corrida) gcr.getEventoDeep(evento).getCorrida();
            crr.initCronoSystem(c);
            crr.iniciar_ComSimulacao();

            SessionRenderer.addCurrentSession("crono");
            crr.registraObserver(this);
            setTitulos();

            start_button1.setDisabled(true);
            stop_button2.setDisabled(false);
            return null;
        }
        if(selected.equals("Qualificação")) {
            Qualificacao q = (Qualificacao) gcr.getEventoDeep(evento).getQualificacao();
            crr.initCronoSystem(q);
            crr.iniciar_ComSimulacao();

            SessionRenderer.addCurrentSession("crono");
            crr.registraObserver(this);

            setTitulos();
            start_button1.setDisabled(true);
            stop_button2.setDisabled(false);
            return null;
        }
        if(selected.startsWith("Treino")) {
            int idx = Integer.parseInt(selected.substring( selected.lastIndexOf(" ") +1 )) -1;
            Treino t = (Treino) gcr.getEventoDeep(evento).getTreinos().toArray()[idx];
            crr.initCronoSystem(t);
            crr.iniciar_ComSimulacao();

            SessionRenderer.addCurrentSession("crono");
            crr.registraObserver(this);

            setTitulos();
            start_button1.setDisabled(true);
            stop_button2.setDisabled(false);
            return null;
        }

        return null;
    }

    public String stop_button2_action() {
        crr.finalizar_comSimulacao();
        SessionRenderer.removeCurrentSession("crono");
        crr.libertaObserver(this);

        start_button1.setDisabled(false);
        stop_button2.setDisabled(true);
        campeonatoSelectOneMenu1.setDisabled(false);
        eventoSelectOneMenu1.setDisabled(false);
        sessaoSelectOneMenu1.setDisabled(false);
        return null;
    }

    public String avancarQ_button3_action() {
        int x = crr.getCurrentQ();
        if(x<3) {
            crr.avancarQ_comSimulacao();
            if(x+1<4)
                avancarQ_button3.setValue("avançar para Q"+(crr.getCurrentQ()+1));
            else
                avancarQ_button3.setValue("---------------");
        }
        return null;
    }

    public String gravar_button4_action() {
        crr.gravar();
        return null;
    }

    public void update(Observable o, Object arg) {
        SessionRenderer.render("crono");
    }


    public void setTitulos() {
        crr.getLs().setCampeonato(campeonatoSelectOneMenu1Bean.getSelectedItem());
        crr.getLs().setEvento(eventoSelectOneMenu1Bean.getSelectedItem());
        crr.getLs().setTsessao(sessaoSelectOneMenu1Bean.getSelectedItem());
    }



}

