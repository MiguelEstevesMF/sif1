/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import POJOs.ResCampEquipa;
import POJOs.ResCampEquipas;
import POJOs.ResCampEventoCorr;
import POJOs.ResCampEventoQual;
import POJOs.ResCampEventoTreinos;
import POJOs.ResCampEventos;
import POJOs.ResCampPiloto;
import POJOs.ResCampPilotos;
import bl.psmJEEHibernate.GerirCampeonatoLocal;
import bl.psmJEEHibernate.GerirResultadosLocal;
import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Treino;
import sistemainformacaoformula1.MenuUtilizador;
import sistemainformacaoformula1.*;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.ArrayList;
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
public class Resultados extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    @EJB
    private GerirCampeonatoLocal gcr;

    @EJB
    private GerirResultadosLocal grr;


    ///////////////////////////////Campeonato/////////////////////////////////////////

    ArrayList<ResCampEventos> listaCaAllEv = new ArrayList<ResCampEventos>();
    ArrayList<ResCampEventoCorr> listaCaOneEvCorr = new ArrayList<ResCampEventoCorr>();
    ArrayList<ResCampEventoQual> listaCaOneEvQual = new ArrayList<ResCampEventoQual>();
    ArrayList<ResCampEventoTreinos> listaCaOneEvTreinos = new ArrayList<ResCampEventoTreinos>();

    public ArrayList<ResCampEventos> getListaCaAllEv() {
        return listaCaAllEv;
    }

    public void setListaCaAllEv(ArrayList<ResCampEventos> listaCaAllEv) {
        this.listaCaAllEv = listaCaAllEv;
    }

    public ArrayList<ResCampEventoCorr> getListaCaOneEvCorr() {
        return listaCaOneEvCorr;
    }

    public void setListaCaOneEvCorr(ArrayList<ResCampEventoCorr> listaCaOneEvCorr) {
        this.listaCaOneEvCorr = listaCaOneEvCorr;
    }

    public ArrayList<ResCampEventoQual> getListaCaOneEvQual() {
        return listaCaOneEvQual;
    }

    public void setListaCaOneEvQual(ArrayList<ResCampEventoQual> listaCaOneEvQual) {
        this.listaCaOneEvQual = listaCaOneEvQual;
    }

    public ArrayList<ResCampEventoTreinos> getListaCaOneEvTreinos() {
        return listaCaOneEvTreinos;
    }

    public void setListaCaOneEvTreinos(ArrayList<ResCampEventoTreinos> listaCaOneEvTreinos) {
        this.listaCaOneEvTreinos = listaCaOneEvTreinos;
    }




    private DefaultSelectedData campeonatoCaSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems campeonatoCaSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu campeonatoCaSelectOneMenu1 = new HtmlSelectOneMenu();

    private DefaultSelectedData eventoCaSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems eventoCaSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu eventoCaSelectOneMenu1 = new HtmlSelectOneMenu();

    private DefaultSelectedData sessaoCaSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems sessaoCaSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu sessaoCaSelectOneMenu1 = new HtmlSelectOneMenu();

    private HtmlDataTable dataTable1_CaAllEv = new HtmlDataTable();
    private HtmlDataTable dataTable1_CaOneEvCorr = new HtmlDataTable();
    private HtmlDataTable dataTable1_CaOneEvQual = new HtmlDataTable();
    private HtmlDataTable dataTable1_CaOneEvTreinos = new HtmlDataTable();

    public HtmlSelectOneMenu getCampeonatoCaSelectOneMenu1() {
        return campeonatoCaSelectOneMenu1;
    }

    public void setCampeonatoCaSelectOneMenu1(HtmlSelectOneMenu campeonatoCaSelectOneMenu1) {
        this.campeonatoCaSelectOneMenu1 = campeonatoCaSelectOneMenu1;
    }

    public DefaultSelectedData getCampeonatoCaSelectOneMenu1Bean() {
        return campeonatoCaSelectOneMenu1Bean;
    }

    public void setCampeonatoCaSelectOneMenu1Bean(DefaultSelectedData campeonatoCaSelectOneMenu1Bean) {
        this.campeonatoCaSelectOneMenu1Bean = campeonatoCaSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCampeonatoCaSelectOneMenu1DefaultItems() {
        return campeonatoCaSelectOneMenu1DefaultItems;
    }

    public void setCampeonatoCaSelectOneMenu1DefaultItems(DefaultSelectionItems campeonatoCaSelectOneMenu1DefaultItems) {
        this.campeonatoCaSelectOneMenu1DefaultItems = campeonatoCaSelectOneMenu1DefaultItems;
    }

    public HtmlDataTable getDataTable1_CaAllEv() {
        return dataTable1_CaAllEv;
    }

    public void setDataTable1_CaAllEv(HtmlDataTable dataTable1_CaAllEv) {
        this.dataTable1_CaAllEv = dataTable1_CaAllEv;
    }

    public HtmlDataTable getDataTable1_CaOneEvCorr() {
        return dataTable1_CaOneEvCorr;
    }

    public void setDataTable1_CaOneEvCorr(HtmlDataTable dataTable1_CaOneEvCorr) {
        this.dataTable1_CaOneEvCorr = dataTable1_CaOneEvCorr;
    }

    public HtmlSelectOneMenu getEventoCaSelectOneMenu1() {
        return eventoCaSelectOneMenu1;
    }

    public void setEventoCaSelectOneMenu1(HtmlSelectOneMenu eventoCaSelectOneMenu1) {
        this.eventoCaSelectOneMenu1 = eventoCaSelectOneMenu1;
    }

    public DefaultSelectedData getEventoCaSelectOneMenu1Bean() {
        return eventoCaSelectOneMenu1Bean;
    }

    public void setEventoCaSelectOneMenu1Bean(DefaultSelectedData eventoCaSelectOneMenu1Bean) {
        this.eventoCaSelectOneMenu1Bean = eventoCaSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getEventoCaSelectOneMenu1DefaultItems() {
        return eventoCaSelectOneMenu1DefaultItems;
    }

    public void setEventoCaSelectOneMenu1DefaultItems(DefaultSelectionItems eventoCaSelectOneMenu1DefaultItems) {
        this.eventoCaSelectOneMenu1DefaultItems = eventoCaSelectOneMenu1DefaultItems;
    }

    public HtmlSelectOneMenu getSessaoCaSelectOneMenu1() {
        return sessaoCaSelectOneMenu1;
    }

    public void setSessaoCaSelectOneMenu1(HtmlSelectOneMenu sessaoCaSelectOneMenu1) {
        this.sessaoCaSelectOneMenu1 = sessaoCaSelectOneMenu1;
    }

    public DefaultSelectedData getSessaoCaSelectOneMenu1Bean() {
        return sessaoCaSelectOneMenu1Bean;
    }

    public void setSessaoCaSelectOneMenu1Bean(DefaultSelectedData sessaoCaSelectOneMenu1Bean) {
        this.sessaoCaSelectOneMenu1Bean = sessaoCaSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getSessaoCaSelectOneMenu1DefaultItems() {
        return sessaoCaSelectOneMenu1DefaultItems;
    }

    public void setSessaoCaSelectOneMenu1DefaultItems(DefaultSelectionItems sessaoCaSelectOneMenu1DefaultItems) {
        this.sessaoCaSelectOneMenu1DefaultItems = sessaoCaSelectOneMenu1DefaultItems;
    }

    public HtmlDataTable getDataTable1_CaOneEvQual() {
        return dataTable1_CaOneEvQual;
    }

    public void setDataTable1_CaOneEvQual(HtmlDataTable dataTable1_CaOneEvQual) {
        this.dataTable1_CaOneEvQual = dataTable1_CaOneEvQual;
    }

    public HtmlDataTable getDataTable1_CaOneEvTreinos() {
        return dataTable1_CaOneEvTreinos;
    }

    public void setDataTable1_CaOneEvTreinos(HtmlDataTable dataTable1_CaOneEvTreinos) {
        this.dataTable1_CaOneEvTreinos = dataTable1_CaOneEvTreinos;
    }







    ///////////////////////////////EQUIPA/////////////////////////////////////////

    ArrayList<ResCampEquipas> listaEqAll = new ArrayList<ResCampEquipas>();
    ArrayList<ResCampEquipa> listaEqOne = new ArrayList<ResCampEquipa>();

    public ArrayList<ResCampEquipas> getListaEqAll() {
        return listaEqAll;
    }

    public void setListaEqAll(ArrayList<ResCampEquipas> listaEqAll) {
        this.listaEqAll = listaEqAll;
    }

    public ArrayList<ResCampEquipa> getListaEqOne() {
        return listaEqOne;
    }

    public void setListaEqOne(ArrayList<ResCampEquipa> listaEqOne) {
        this.listaEqOne = listaEqOne;
    }


    private DefaultSelectedData campeonatoEqSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems campeonatoEqSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu campeonatoEqSelectOneMenu1 = new HtmlSelectOneMenu();

    private DefaultSelectedData equipaEqSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems equipaEqSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu equipaEqSelectOneMenu1 = new HtmlSelectOneMenu();

    private HtmlDataTable dataTable1_EqAll = new HtmlDataTable();
    private HtmlDataTable dataTable1_EqOne = new HtmlDataTable();

    public HtmlDataTable getDataTable1_EqAll() {
        return dataTable1_EqAll;
    }

    public void setDataTable1_EqAll(HtmlDataTable dataTable1_EqAll) {
        this.dataTable1_EqAll = dataTable1_EqAll;
    }

    public HtmlDataTable getDataTable1_EqOne() {
        return dataTable1_EqOne;
    }

    public void setDataTable1_EqOne(HtmlDataTable dataTable1_EqOne) {
        this.dataTable1_EqOne = dataTable1_EqOne;
    }



    public HtmlSelectOneMenu getCampeonatoEqSelectOneMenu1() {
        return campeonatoEqSelectOneMenu1;
    }

    public void setCampeonatoEqSelectOneMenu1(HtmlSelectOneMenu campeonatoEqSelectOneMenu1) {
        this.campeonatoEqSelectOneMenu1 = campeonatoEqSelectOneMenu1;
    }

    public DefaultSelectedData getCampeonatoEqSelectOneMenu1Bean() {
        return campeonatoEqSelectOneMenu1Bean;
    }

    public void setCampeonatoEqSelectOneMenu1Bean(DefaultSelectedData campeonatoEqSelectOneMenu1Bean) {
        this.campeonatoEqSelectOneMenu1Bean = campeonatoEqSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCampeonatoEqSelectOneMenu1DefaultItems() {
        return campeonatoEqSelectOneMenu1DefaultItems;
    }

    public void setCampeonatoEqSelectOneMenu1DefaultItems(DefaultSelectionItems campeonatoEqSelectOneMenu1DefaultItems) {
        this.campeonatoEqSelectOneMenu1DefaultItems = campeonatoEqSelectOneMenu1DefaultItems;
    }

    public HtmlSelectOneMenu getEquipaEqSelectOneMenu1() {
        return equipaEqSelectOneMenu1;
    }

    public void setEquipaEqSelectOneMenu1(HtmlSelectOneMenu equipaEqSelectOneMenu1) {
        this.equipaEqSelectOneMenu1 = equipaEqSelectOneMenu1;
    }

    public DefaultSelectedData getEquipaEqSelectOneMenu1Bean() {
        return equipaEqSelectOneMenu1Bean;
    }

    public void setEquipaEqSelectOneMenu1Bean(DefaultSelectedData equipaEqSelectOneMenu1Bean) {
        this.equipaEqSelectOneMenu1Bean = equipaEqSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getEquipaEqSelectOneMenu1DefaultItems() {
        return equipaEqSelectOneMenu1DefaultItems;
    }

    public void setEquipaEqSelectOneMenu1DefaultItems(DefaultSelectionItems equipaEqSelectOneMenu1DefaultItems) {
        this.equipaEqSelectOneMenu1DefaultItems = equipaEqSelectOneMenu1DefaultItems;
    }


    ///////////////////////////////PILOTO/////////////////////////////////////////

    ArrayList<ResCampPilotos> listaPiAll = new ArrayList<ResCampPilotos>();
    ArrayList<ResCampPiloto> listaPiOne = new ArrayList<ResCampPiloto>();

    public ArrayList<ResCampPilotos> getListaPiAll() {
        return listaPiAll;
    }

    public void setListaPiAll(ArrayList<ResCampPilotos> listaPiAll) {
        this.listaPiAll = listaPiAll;
    }

    public ArrayList<ResCampPiloto> getListaPiOne() {
        return listaPiOne;
    }

    public void setListaPiOne(ArrayList<ResCampPiloto> listaPiOne) {
        this.listaPiOne = listaPiOne;
    }




    private DefaultSelectedData campeonatoPiSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems campeonatoPiSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu campeonatoPiSelectOneMenu1 = new HtmlSelectOneMenu();

    private DefaultSelectedData pilotoPiSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems pilotoPiSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu pilotoPiSelectOneMenu1 = new HtmlSelectOneMenu();

    private HtmlDataTable dataTable1_PiAll = new HtmlDataTable();
    private HtmlDataTable dataTable1_PiOne = new HtmlDataTable();

    public HtmlSelectOneMenu getCampeonatoPiSelectOneMenu1() {
        return campeonatoPiSelectOneMenu1;
    }

    public void setCampeonatoPiSelectOneMenu1(HtmlSelectOneMenu campeonatoPiSelectOneMenu1) {
        this.campeonatoPiSelectOneMenu1 = campeonatoPiSelectOneMenu1;
    }

    public DefaultSelectedData getCampeonatoPiSelectOneMenu1Bean() {
        return campeonatoPiSelectOneMenu1Bean;
    }

    public void setCampeonatoPiSelectOneMenu1Bean(DefaultSelectedData campeonatoPiSelectOneMenu1Bean) {
        this.campeonatoPiSelectOneMenu1Bean = campeonatoPiSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCampeonatoPiSelectOneMenu1DefaultItems() {
        return campeonatoPiSelectOneMenu1DefaultItems;
    }

    public void setCampeonatoPiSelectOneMenu1DefaultItems(DefaultSelectionItems campeonatoPiSelectOneMenu1DefaultItems) {
        this.campeonatoPiSelectOneMenu1DefaultItems = campeonatoPiSelectOneMenu1DefaultItems;
    }

    public HtmlDataTable getDataTable1_PiAll() {
        return dataTable1_PiAll;
    }

    public void setDataTable1_PiAll(HtmlDataTable dataTable1_PiAll) {
        this.dataTable1_PiAll = dataTable1_PiAll;
    }

    public HtmlDataTable getDataTable1_PiOne() {
        return dataTable1_PiOne;
    }

    public void setDataTable1_PiOne(HtmlDataTable dataTable1_PiOne) {
        this.dataTable1_PiOne = dataTable1_PiOne;
    }

    public HtmlSelectOneMenu getPilotoPiSelectOneMenu1() {
        return pilotoPiSelectOneMenu1;
    }

    public void setPilotoPiSelectOneMenu1(HtmlSelectOneMenu pilotoPiSelectOneMenu1) {
        this.pilotoPiSelectOneMenu1 = pilotoPiSelectOneMenu1;
    }

    public DefaultSelectedData getPilotoPiSelectOneMenu1Bean() {
        return pilotoPiSelectOneMenu1Bean;
    }

    public void setPilotoPiSelectOneMenu1Bean(DefaultSelectedData pilotoPiSelectOneMenu1Bean) {
        this.pilotoPiSelectOneMenu1Bean = pilotoPiSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getPilotoPiSelectOneMenu1DefaultItems() {
        return pilotoPiSelectOneMenu1DefaultItems;
    }

    public void setPilotoPiSelectOneMenu1DefaultItems(DefaultSelectionItems pilotoPiSelectOneMenu1DefaultItems) {
        this.pilotoPiSelectOneMenu1DefaultItems = pilotoPiSelectOneMenu1DefaultItems;
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
    public Resultados() {
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


        refreshCampsEqDropDown();
        dataTable1_EqOne.setRendered(false);
        dataTable1_EqAll.setRendered(false);

        refreshCampsPiDropDown();
        dataTable1_PiOne.setRendered(false);
        dataTable1_PiAll.setRendered(false);

        refreshCampsCaDropDown();
        dataTable1_CaOneEvTreinos.setRendered(false);
        dataTable1_CaOneEvQual.setRendered(false);
        dataTable1_CaOneEvCorr.setRendered(false);
        dataTable1_CaAllEv.setRendered(false);

    }


    //////////////////////////CAMPEONATO/////////////////////////////////////////

    public void refreshCampsCaDropDown() {
        campeonatoCaSelectOneMenu1DefaultItems.clear();
        for(Campeonato c : gcr.getCampeonatos())
            campeonatoCaSelectOneMenu1DefaultItems.add(new SelectItem(c.getDesignacao(),c.getDesignacao()));

        eventoCaSelectOneMenu1DefaultItems.clear();
        sessaoCaSelectOneMenu1DefaultItems.clear();
    }

    public void refreshEventosCaDropDown() {
        eventoCaSelectOneMenu1DefaultItems.clear();
        eventoCaSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        eventoCaSelectOneMenu1DefaultItems.add(new SelectItem("Todos os Eventos","Todos os Eventos"));
        for(Evento e : gcr.getEventos(campeonatoCaSelectOneMenu1Bean.getSelectedItem()))
            eventoCaSelectOneMenu1DefaultItems.add(new SelectItem(e.getDesignacao(),e.getDesignacao()));

        sessaoCaSelectOneMenu1DefaultItems.clear();
    }

    public void refreshSessaoCaDropDown() {
        sessaoCaSelectOneMenu1DefaultItems.clear();
        sessaoCaSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        sessaoCaSelectOneMenu1DefaultItems.add(new SelectItem("Corrida","Corrida"));
        sessaoCaSelectOneMenu1DefaultItems.add(new SelectItem("Qualificação","Qualificação"));
        int i = 1;
        for(Treino t : gcr.getEventoDeep(eventoCaSelectOneMenu1Bean.getSelectedItem()).getTreinos())
            sessaoCaSelectOneMenu1DefaultItems.add(new SelectItem("Treino "+i,"Treino "+(i++)));
    }


    //////////////////////////EQUIPA/////////////////////////////////////////////

    public void refreshCampsEqDropDown() {
        campeonatoEqSelectOneMenu1DefaultItems.clear();
        for(Campeonato c : gcr.getCampeonatos())
            campeonatoEqSelectOneMenu1DefaultItems.add(new SelectItem(c.getDesignacao(),c.getDesignacao()));

        equipaEqSelectOneMenu1DefaultItems.clear();
        
    }
    
    public void refreshEquipasEqDropDown() {
        equipaEqSelectOneMenu1DefaultItems.clear();
        equipaEqSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        equipaEqSelectOneMenu1DefaultItems.add(new SelectItem("Todas as Equipas","Todas as Equipas"));
        for(Equipa e : gcr.getEquipas(campeonatoEqSelectOneMenu1Bean.getSelectedItem()))
            equipaEqSelectOneMenu1DefaultItems.add(new SelectItem(e.getNome(),e.getNome()));
    }

    //////////////////////////PILOTO/////////////////////////////////////////////

    public void refreshCampsPiDropDown() {
        campeonatoPiSelectOneMenu1DefaultItems.clear();
        for(Campeonato c : gcr.getCampeonatos())
            campeonatoPiSelectOneMenu1DefaultItems.add(new SelectItem(c.getDesignacao(),c.getDesignacao()));

        pilotoPiSelectOneMenu1DefaultItems.clear();

    }

    public void refreshPilotosPiqDropDown() {
        pilotoPiSelectOneMenu1DefaultItems.clear();
        pilotoPiSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        pilotoPiSelectOneMenu1DefaultItems.add(new SelectItem("Todos os Pilotos","Todos os Pilotos"));
        for(Piloto p : gcr.getPilotos(campeonatoPiSelectOneMenu1Bean.getSelectedItem()))
            pilotoPiSelectOneMenu1DefaultItems.add(new SelectItem(p.getNome(),p.getNome()));
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





    /////////////////////////////CAMPEONATO////////////////////////////////////////

    public void campeonatoCaSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) return;

        campeonatoCaSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());
        refreshEventosCaDropDown();

        dataTable1_CaOneEvTreinos.setRendered(false);
        dataTable1_CaOneEvQual.setRendered(false);
        dataTable1_CaOneEvCorr.setRendered(false);
        dataTable1_CaAllEv.setRendered(false);


        String evSelected = eventoCaSelectOneMenu1Bean.getSelectedItem();

        if(evSelected==null || evSelected.equals("")) return;

        if(evSelected.equals("Todos os Eventos")) {
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(true);
            listaCaAllEv = grr.getResCampEventos(campeonatoCaSelectOneMenu1Bean.getSelectedItem());
        } else {
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaAllEv.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(true);
            listaCaOneEvCorr = grr.getResCampEventoCorr(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), evSelected);
        }

    }


    public void eventoCaSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) {
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(false);
            return;
        }

        eventoCaSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());

        String selected = eventoCaSelectOneMenu1Bean.getSelectedItem();

        if(selected==null || selected.equals("")) return;
        
        if(selected.equals("Todos os Eventos")) {
            sessaoCaSelectOneMenu1DefaultItems.clear();
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(true);
            listaCaAllEv = grr.getResCampEventos(campeonatoCaSelectOneMenu1Bean.getSelectedItem());
        } else {

            String selectedSe = sessaoCaSelectOneMenu1Bean.getSelectedItem();
            refreshSessaoCaDropDown();

            if(selectedSe==null || selectedSe.equals("Corrida")) {
                sessaoCaSelectOneMenu1Bean.setSelectedItem("Corrida");
                dataTable1_CaOneEvTreinos.setRendered(false);
                dataTable1_CaOneEvQual.setRendered(false);
                dataTable1_CaOneEvCorr.setRendered(true);
                dataTable1_CaAllEv.setRendered(false);
                listaCaOneEvCorr = grr.getResCampEventoCorr(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), selected);
                return;
            }
            if(selectedSe.equals("Qualificação")) {
                dataTable1_CaOneEvTreinos.setRendered(false);
                dataTable1_CaOneEvQual.setRendered(true);
                dataTable1_CaOneEvCorr.setRendered(false);
                dataTable1_CaAllEv.setRendered(false);
                listaCaOneEvQual = grr.getResCampEventoQual(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), selected);
                return;
            }
            if(selectedSe.startsWith("Treino")) {
                dataTable1_CaOneEvTreinos.setRendered(true);
                dataTable1_CaOneEvQual.setRendered(false);
                dataTable1_CaOneEvCorr.setRendered(false);
                dataTable1_CaAllEv.setRendered(false);
                int idx = Integer.parseInt(selectedSe.substring( selectedSe.lastIndexOf(" ") +1 )) -1;
                listaCaOneEvTreinos = grr.getResCampEventoTreinos(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), selected).get(idx);
                return;
            }

        }

    }


    public void sessaoCaSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) {
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(false);
            return;
        }

        sessaoCaSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());

        String selected = sessaoCaSelectOneMenu1Bean.getSelectedItem();

        String selectedEv = eventoCaSelectOneMenu1Bean.getSelectedItem();

        if(selectedEv==null || selectedEv.equals("") || selectedEv.equals("Todos os Eventos")) return;

        if(selected.equals("Corrida")) {
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(true);
            dataTable1_CaAllEv.setRendered(false);
            listaCaOneEvCorr = grr.getResCampEventoCorr(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), selectedEv);
            return;
        }
        if(selected.equals("Qualificação")) {
            dataTable1_CaOneEvTreinos.setRendered(false);
            dataTable1_CaOneEvQual.setRendered(true);
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(false);
            listaCaOneEvQual = grr.getResCampEventoQual(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), selectedEv);
            return;
        }
        if(selected.startsWith("Treino")) {
            dataTable1_CaOneEvTreinos.setRendered(true);
            dataTable1_CaOneEvQual.setRendered(false);
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(false);
            int idx = Integer.parseInt(selected.substring( selected.lastIndexOf(" ") +1 )) -1;
            listaCaOneEvTreinos = grr.getResCampEventoTreinos(campeonatoCaSelectOneMenu1Bean.getSelectedItem(), selectedEv).get(idx);
            return;
        }

    }


    /////////////////////////////EQUIPA////////////////////////////////////////

    public void campeonatoEqSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) return;
        
        campeonatoEqSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());
        refreshEquipasEqDropDown();

        
        dataTable1_EqOne.setRendered(false);
        dataTable1_EqAll.setRendered(false);

        String eqSelected = equipaEqSelectOneMenu1Bean.getSelectedItem();

        if(eqSelected==null) return;

        if(eqSelected.equals("Todas as Equipas")) {
            dataTable1_EqOne.setRendered(false);
            dataTable1_EqAll.setRendered(true);
            listaEqAll = grr.getResCampEquipas(campeonatoEqSelectOneMenu1Bean.getSelectedItem());
        } else {
            dataTable1_EqAll.setRendered(false);
            dataTable1_EqOne.setRendered(true);
            listaEqOne = grr.getResCampEquipa(campeonatoEqSelectOneMenu1Bean.getSelectedItem(), eqSelected);
        }

    }


    public void equipaEqSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) { 
            dataTable1_CaOneEvCorr.setRendered(false);
            dataTable1_CaAllEv.setRendered(false);
            return;
        }

        String selected = (String) vce.getNewValue();
        if(selected.equals("Todas as Equipas")) {
            dataTable1_EqOne.setRendered(false);
            dataTable1_EqAll.setRendered(true);
            listaEqAll = grr.getResCampEquipas(campeonatoEqSelectOneMenu1Bean.getSelectedItem());
        } else {
            dataTable1_EqAll.setRendered(false);
            dataTable1_EqOne.setRendered(true);
            listaEqOne = grr.getResCampEquipa(campeonatoEqSelectOneMenu1Bean.getSelectedItem(), selected);
        }

    }


    /////////////////////////////PILOTO////////////////////////////////////////

    public void campeonatoPiSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) return;

        campeonatoPiSelectOneMenu1Bean.setSelectedItem((String) vce.getNewValue());
        refreshPilotosPiqDropDown();

        dataTable1_PiOne.setRendered(false);
        dataTable1_PiAll.setRendered(false);

        String pilSelected = pilotoPiSelectOneMenu1Bean.getSelectedItem();

        if(pilSelected==null) return;

        if(pilSelected.equals("Todos os Pilotos")) {
            dataTable1_PiOne.setRendered(false);
            dataTable1_PiAll.setRendered(true);
            listaPiAll = grr.getResCampPilotos(campeonatoPiSelectOneMenu1Bean.getSelectedItem());
        } else {
            dataTable1_PiAll.setRendered(false);
            dataTable1_PiOne.setRendered(true);
            listaPiOne = grr.getResCampPiloto(campeonatoPiSelectOneMenu1Bean.getSelectedItem(), pilSelected);
        }


    }


    public void pilotoPiSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue()==null ) {
            dataTable1_PiOne.setRendered(false);
            dataTable1_PiAll.setRendered(false);
            return;
        }

        String selected = (String) vce.getNewValue();

        if(selected.equals("Todos os Pilotos")) {
            dataTable1_PiOne.setRendered(false);
            dataTable1_PiAll.setRendered(true);
            listaPiAll = grr.getResCampPilotos(campeonatoPiSelectOneMenu1Bean.getSelectedItem());
        } else {
            dataTable1_PiAll.setRendered(false);
            dataTable1_PiOne.setRendered(true);
            listaPiOne = grr.getResCampPiloto(campeonatoPiSelectOneMenu1Bean.getSelectedItem(), selected);
        }

    }


}

