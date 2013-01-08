/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.GerirUtilizadorLocal;
import bl.psmJEEHibernate.NotificaEmailLocal;
import bl.psmJEEHibernate.entities.Admin;
import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.SBTR;
import bl.psmJEEHibernate.entities.Utilizador;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectManyCheckbox;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import javax.faces.event.ValueChangeEvent;
import sistemainformacaoformula1.*;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.model.SelectItem;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Registar extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;


    private Date data1 = new GregorianCalendar(1975,1,1).getTime();

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
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
    private HtmlInputSecret password_inputSecret1 = new HtmlInputSecret();

    public HtmlInputSecret getPassword_inputSecret1() {
        return password_inputSecret1;
    }

    public void setPassword_inputSecret1(HtmlInputSecret his) {
        this.password_inputSecret1 = his;
    }
    private HtmlInputSecret confirm_password_inputSecret1 = new HtmlInputSecret();

    public HtmlInputSecret getConfirm_password_inputSecret1() {
        return confirm_password_inputSecret1;
    }

    public void setConfirm_password_inputSecret1(HtmlInputSecret his) {
        this.confirm_password_inputSecret1 = his;
    }
    private HtmlInputText nome_inputText = new HtmlInputText();

    public HtmlInputText getNome_inputText() {
        return nome_inputText;
    }

    public void setNome_inputText(HtmlInputText hit) {
        this.nome_inputText = hit;
    }
    private PanelLayout credenciais_panelLayout = new PanelLayout();

    public PanelLayout getCredenciais_panelLayout() {
        return credenciais_panelLayout;
    }

    public void setCredenciais_panelLayout(PanelLayout pl) {
        this.credenciais_panelLayout = pl;
    }
    private HtmlSelectManyCheckbox selectManyCheckbox1 = new HtmlSelectManyCheckbox();

    public HtmlSelectManyCheckbox getSelectManyCheckbox1() {
        return selectManyCheckbox1;
    }

    public void setSelectManyCheckbox1(HtmlSelectManyCheckbox hsmc) {
        this.selectManyCheckbox1 = hsmc;
    }



    // </editor-fold>

    @EJB
    private GerirUtilizadorLocal gur;

    @EJB
    private NotificaEmailLocal ner;


    private HtmlOutputText outputText1 = new HtmlOutputText();

    public HtmlOutputText getOutputText1() {
        return outputText1;
    }

    public void setOutputText1(HtmlOutputText hot) {
        this.outputText1 = hot;
    }
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Registar() {
        limpaCampos();
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

        selectManyCheckbox1DefaultItems.clear();
        for(Credencial c: gur.findAllCredenciais())
            selectManyCheckbox1DefaultItems.add(new SelectItem(c.getNome(), c.getNome()));
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


    public void limpaCampos(){
        confirm_password_inputSecret1.setValue("");
        Date d = new Date(0);
        date1.setValue(d);
        email_inputText.setValue("");
        nome_inputText.setValue("");
        outputText1.setValue("");
        password_inputSecret1.setValue("");
        username_inputText.setValue("");
        selectManyCheckbox1Bean.setSelectedItems(new String[]{});
    }

    public String submeter_registo_button_action() {

        Utilizador utilizador = new Utilizador();

        utilizador.setUser(username_inputText.getValue().toString());
        utilizador.setPass(password_inputSecret1.getValue().toString());
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
        utilizador.setActivo(false);
        utilizador.setEstado("offline");

        if (!gur.hasUser(utilizador.getUser())){
            if (gur.hasEmail(utilizador.getEmail())){
                outputText1.setValue("Email já existe.");
            } else if (!utilizador.getEmail().matches(".+@.+")){
                outputText1.setValue("Email não é válido.");
            } else if (password_inputSecret1.getValue().toString().equals(confirm_password_inputSecret1.getValue().toString())){
                gur.setUtilizador(utilizador);
                limpaCampos();
                try {
                    String m = "";
                    m = "\nObrigado por se ter registado no Sistema de Informação de Fórmula 1.\n";
                    m += "Aguarde a activação da sua conta pela nossa equipa.\n\n";
                    m += "Não se esqueça dos seus dados de login no sistema:\n";
                    m += "username: "+utilizador.getUser()+"\npassword: "+utilizador.getPass()+"\n\nEquipa do SIF1";
                    ner.enviarEmail("Registo SIF1", m, utilizador.getEmail());
                } catch (Exception ex) {
                }
                return (new MenuUtilizador()).inicio_commandLink_action();
            }
            else outputText1.setValue("Confirmação da password errada.");
        }
        else outputText1.setValue("Utilizador existente.");


        return null;
    }
    
    
}

