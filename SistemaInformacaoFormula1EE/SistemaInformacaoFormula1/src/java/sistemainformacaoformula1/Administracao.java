/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.GerirEquipaLocal;
import bl.psmJEEHibernate.GerirUtilizadorLocal;
import bl.psmJEEHibernate.NotificaEmailLocal;
import bl.psmJEEHibernate.entities.Admin;
import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.SBTR;
import bl.psmJEEHibernate.entities.Utilizador;
import com.icesoft.faces.async.render.GroupAsyncRenderer;
import com.icesoft.faces.async.render.OnDemandRenderer;
import com.icesoft.faces.async.render.SessionRenderer;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectManyCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import sistemainformacaoformula1.MenuUtilizador;
import sistemainformacaoformula1.*;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.security.auth.RefreshFailedException;
import sistemainformacaoformula1.datatables.AdministracaoSessionBean;
import sistemainformacaoformula1.datatables.TabelaUtilizadores;
import sistemainformacaoformula1.datatables.UtilizadorRow;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Administracao extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private HtmlInputText nome_inputText = new HtmlInputText();

    public HtmlInputText getNome_inputText() {
        return nome_inputText;
    }

    public void setNome_inputText(HtmlInputText hit) {
        this.nome_inputText = hit;
    }
    private HtmlInputText email_inputText = new HtmlInputText();

    public HtmlInputText getEmail_inputText() {
        return email_inputText;
    }

    public void setEmail_inputText(HtmlInputText hit) {
        this.email_inputText = hit;
    }

    private SelectInputDate date1 = new SelectInputDate();

    public SelectInputDate getDate1() {
        return date1;
    }
    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public void setDate1(SelectInputDate sid) {
        this.date1 = sid;
    }

    private Date data1 = new GregorianCalendar(1975,1,1).getTime();
    
    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    private HtmlInputText username_inputText = new HtmlInputText();

    public HtmlInputText getUsername_inputText() {
        return username_inputText;
    }

    public void setUsername_inputText(HtmlInputText hit) {
        this.username_inputText = hit;
    }
    private DefaultSelectedData selectManyCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectManyCheckbox1Bean() {
        return selectManyCheckbox1Bean;
    }

    public void setSelectManyCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectManyCheckbox1Bean = dsd;
    }
    private DefaultSelectionItems selectManyCheckbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectManyCheckbox1DefaultItems() {
        return selectManyCheckbox1DefaultItems;
    }

    public void setSelectManyCheckbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectManyCheckbox1DefaultItems = dsi;
    }
    private HtmlSelectManyCheckbox selectManyCheckbox1 = new HtmlSelectManyCheckbox();

    public HtmlSelectManyCheckbox getSelectManyCheckbox1() {
        return selectManyCheckbox1;
    }

    public void setSelectManyCheckbox1(HtmlSelectManyCheckbox hsmc) {
        this.selectManyCheckbox1 = hsmc;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckbox1 = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckbox1() {
        return selectBooleanCheckbox1;
    }

    public void setSelectBooleanCheckbox1(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckbox1 = hsbc;
    }
    private HtmlOutputText outputText7 = new HtmlOutputText();

    public HtmlOutputText getOutputText7() {
        return outputText7;
    }

    public void setOutputText7(HtmlOutputText hot) {
        this.outputText7 = hot;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu selectOneMenu1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1() {
        return selectOneMenu1;
    }

    public void setSelectOneMenu1(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1 = hsom;
    }
    private HtmlCommandLink dataTable1HeaderFirstButton = new HtmlCommandLink();

    public HtmlCommandLink getDataTable1HeaderFirstButton() {
        return dataTable1HeaderFirstButton;
    }

    public void setDataTable1HeaderFirstButton(HtmlCommandLink hcl) {
        this.dataTable1HeaderFirstButton = hcl;
    }
    private HtmlCommandLink dataTable1HeaderPreviousButton = new HtmlCommandLink();

    public HtmlCommandLink getDataTable1HeaderPreviousButton() {
        return dataTable1HeaderPreviousButton;
    }

    public void setDataTable1HeaderPreviousButton(HtmlCommandLink hcl) {
        this.dataTable1HeaderPreviousButton = hcl;
    }
    private HtmlCommandLink dataTable1HeaderNextButton = new HtmlCommandLink();

    public HtmlCommandLink getDataTable1HeaderNextButton() {
        return dataTable1HeaderNextButton;
    }

    public void setDataTable1HeaderNextButton(HtmlCommandLink hcl) {
        this.dataTable1HeaderNextButton = hcl;
    }
    private HtmlCommandLink dataTable1HeaderLastButton = new HtmlCommandLink();

    public HtmlCommandLink getDataTable1HeaderLastButton() {
        return dataTable1HeaderLastButton;
    }

    public void setDataTable1HeaderLastButton(HtmlCommandLink hcl) {
        this.dataTable1HeaderLastButton = hcl;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Administracao() {
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

        outputText7.setValue("");
                
        selectManyCheckbox1DefaultItems.clear();
        for(Credencial c: gur.findAllCredenciais())
            selectManyCheckbox1DefaultItems.add(new SelectItem(c.getNome(), c.getNome()));

        selectOneMenu1DefaultItems.clear();
        selectOneMenu1DefaultItems.add(new SelectItem("------", "------"));
        for(Equipa e: ger.getEquipas())
            selectOneMenu1DefaultItems.add(new SelectItem(e.getNome(), e.getNome()));
        //SessionRenderer.addCurrentSession("admin");
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
    protected AdministracaoSessionBean getAdministracaoSessionBean() { return (AdministracaoSessionBean) getBean("AdministracaoSessionBean"); }

    int i=0;

    @EJB
    private GerirUtilizadorLocal gur;

    @EJB
    private GerirEquipaLocal ger;

    @EJB
    private NotificaEmailLocal ner;

    public String button1_action() {
        return null;
    }

    private UtilizadorRow u = new UtilizadorRow();
    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
  
        ArrayList<UtilizadorRow> a = getAdministracaoSessionBean().getUtilizadores();

        u = a.get(selectedRowIndex);
        nome_inputText.changeText(u.getNome());
        email_inputText.changeText(u.getEmail());
        username_inputText.changeText(u.getUser());
        data1 = u.getDataNascimento();
        date1.resetValue();
        selectManyCheckbox1Bean.setSelectedItems(u.getCredenciais2());
        selectManyCheckbox1.resetValue();
        selectBooleanCheckbox1Bean.setSelectedBoolean(u.getActivo());
        selectBooleanCheckbox1.resetValue();

        Equipa equipa = gur.getEquipa(u.getUser());

        if(equipa==null) 
            selectOneMenu1Bean.setSelectedObject("------");
        else
            selectOneMenu1Bean.setSelectedObject(equipa.getNome());
        selectOneMenu1.resetValue();

    }

    public String submeter_registo_button_action() {

        try{

            Utilizador utilizador = gur.getUtilizador(username_inputText.getValue().toString());

            utilizador.setUser(username_inputText.getValue().toString());
            utilizador.setNome(nome_inputText.getValue().toString());
            utilizador.setEmail(email_inputText.getValue().toString());
            utilizador.setDataNascimento(data1);

            HashSet<Credencial> cs = new HashSet<Credencial>();
            for(String s:selectManyCheckbox1Bean.getSelectedItems()){
                if (s.equals("Admin")){
                    Credencial c = new Admin();
                    c.setNome(s);
                    cs.add(c);
                }
                if (s.equals("Crono")){
                    Credencial c = new bl.psmJEEHibernate.entities.Crono();
                    c.setNome(s);
                    cs.add(c);
                }
                if (s.equals("Gestor")){
                    Credencial c = new bl.psmJEEHibernate.entities.Gestor();
                    c.setNome(s);
                    cs.add(c);
                }
                if (s.equals("Juiz")){
                    Credencial c = new bl.psmJEEHibernate.entities.Juiz();
                    c.setNome(s);
                    cs.add(c);
                }
                if (s.equals("SBTR")){
                    Credencial c = new SBTR();
                    c.setNome(s);
                    cs.add(c);
                }
            }

            utilizador.setCredenciais(cs);
            boolean oldActivo =utilizador.getActivo();
            utilizador.setActivo(selectBooleanCheckbox1Bean.isSelectedBoolean());

            gur.setUtilizador(utilizador);
            
            if(oldActivo!=utilizador.getActivo()){
                try {
                    String m = "";
                    m = "\nA sua conta foi "+(utilizador.getActivo()?"activada":"desactivada")+" pela administração do Sistema de Informação de Fórmula 1.\n\n";
                    m += "\n\nEquipa do SIF1";
                    ner.enviarEmail("Notificação SIF1", m, utilizador.getEmail());
                } catch (Exception ex) {
                }
            }

            String dropEq = (String) selectOneMenu1Bean.getSelectedObject();

            if(!dropEq.equals("------")) {
                Equipa newEq = ger.getEquipa(dropEq);

                

                if(newEq.getUtilizador()!=null) {
                    if(newEq.getUtilizador().getUser().equals(utilizador.getUser())) return null;
                    throw new Exception("A equipa "+newEq.getNome()+" já tem uma conta de utilizador.");

                } else {

                    Equipa oldEq = gur.getEquipa(utilizador.getUser());

                    if(oldEq!=null) {

                        Utilizador uu = null;
                        Equipa ee = null;
                        oldEq.setUtilizador(uu);
                        utilizador.setEquipa(ee);

                        gur.setUtilizador(utilizador);
                        ger.save(oldEq);

                    }
                    
                    utilizador.setEquipa(newEq);
                    newEq.setUtilizador(utilizador);

                    gur.setUtilizador(utilizador);
                    ger.save(newEq);

                }

            } else {

                Equipa oldEq = gur.getEquipa(utilizador.getUser());

                Utilizador uu = null;
                Equipa ee = null;
                oldEq.setUtilizador(uu);
                utilizador.setEquipa(ee);

                gur.setUtilizador(utilizador);
                ger.save(oldEq);
            }


            

            outputText7.setValue("");
        } catch(Exception ex) {
            outputText7.setValue(ex.getMessage());
        }

        return null;
    }

    public String dataTable1_firstPageAction() {
        getAdministracaoSessionBean().setOffset(1);
        renderPaginator();
        return null;
    }

    public String dataTable1_previousPageAction() {
        int offset =getAdministracaoSessionBean().getOffset();
        int limit = getAdministracaoSessionBean().getLimit();

        offset = offset-1>0?offset-1:1;
        getAdministracaoSessionBean().setOffset(offset);

        renderPaginator();
        return null;
    }

    public String dataTable1_nextPageAction() {
        int offset =getAdministracaoSessionBean().getOffset();
        int limit = getAdministracaoSessionBean().getLimit();
        int total = getAdministracaoSessionBean().getTotal();

        offset = offset*limit>total?offset:offset+1;
        getAdministracaoSessionBean().setOffset(offset);

        renderPaginator();
        return null;
    }

    public String dataTable1_lastPageAction() {
        int total = getAdministracaoSessionBean().getTotal();
        int limit = getAdministracaoSessionBean().getLimit();
        getAdministracaoSessionBean().setOffset( ((int) (total / limit))+1 );
        renderPaginator();

        return null;
    }


   private void renderPaginator(){
        int offset =getAdministracaoSessionBean().getOffset();
        int limit = getAdministracaoSessionBean().getLimit();
        int total = getAdministracaoSessionBean().getTotal();
        total = ((int) (total / limit))+1;

        if(offset>1 && offset<total) {
            dataTable1HeaderFirstButton.setVisible(true);
            dataTable1HeaderPreviousButton.setVisible(true);
            dataTable1HeaderNextButton.setVisible(true);
            dataTable1HeaderLastButton.setVisible(true);
        } else {
            if(offset==1 && offset<total) {
                dataTable1HeaderFirstButton.setVisible(false);
                dataTable1HeaderPreviousButton.setVisible(false);
                dataTable1HeaderNextButton.setVisible(true);
                dataTable1HeaderLastButton.setVisible(true);
            }
            if(offset>1 && offset==total) {
                dataTable1HeaderFirstButton.setVisible(true);
                dataTable1HeaderPreviousButton.setVisible(true);
                dataTable1HeaderNextButton.setVisible(false);
                dataTable1HeaderLastButton.setVisible(false);
            }
            if(offset==1 && offset==total) {
                dataTable1HeaderFirstButton.setVisible(false);
                dataTable1HeaderPreviousButton.setVisible(false);
                dataTable1HeaderNextButton.setVisible(false);
                dataTable1HeaderLastButton.setVisible(false);
            }
        }

    }


}

