/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.GerirUtilizadorLocal;
import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Utilizador;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlOutputText;
import sistemainformacaoformula1.*;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.ejb.EJB;
import javax.faces.FacesException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class MeuPerfil extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

        @EJB
    private GerirUtilizadorLocal gur;

    Utilizador u = null;
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
    private HtmlOutputText erro_text = new HtmlOutputText();

    public HtmlOutputText getErro_text() {
        return erro_text;
    }

    public void setErro_text(HtmlOutputText hot) {
        this.erro_text = hot;
    }
    private HtmlOutputText nome_text = new HtmlOutputText();

    public HtmlOutputText getNome_text() {
        return nome_text;
    }

    public void setNome_text(HtmlOutputText hot) {
        this.nome_text = hot;
    }
    private HtmlOutputText email_text = new HtmlOutputText();

    public HtmlOutputText getEmail_text() {
        return email_text;
    }

    public void setEmail_text(HtmlOutputText hot) {
        this.email_text = hot;
    }
    private HtmlOutputText data_nasc_text = new HtmlOutputText();

    public HtmlOutputText getData_nasc_text() {
        return data_nasc_text;
    }

    public void setData_nasc_text(HtmlOutputText hot) {
        this.data_nasc_text = hot;
    }
    private HtmlOutputText username_text = new HtmlOutputText();

    public HtmlOutputText getUsername_text() {
        return username_text;
    }

    public void setUsername_text(HtmlOutputText hot) {
        this.username_text = hot;
    }
    private HtmlOutputText credenciais_text = new HtmlOutputText();

    public HtmlOutputText getCredenciais_text() {
        return credenciais_text;
    }

    public void setCredenciais_text(HtmlOutputText hot) {
        this.credenciais_text = hot;
    }




    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlOutputText equipa_text = new HtmlOutputText();

    public HtmlOutputText getEquipa_text() {
        return equipa_text;
    }

    public void setEquipa_text(HtmlOutputText hot) {
        this.equipa_text = hot;
    }
    // </editor-fold>


    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public MeuPerfil() {
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
        u = getMenuUtilizador().getUtilizador();
        nome_text.setValue(u.getNome());
        username_text.setValue(u.getUser());
        email_text.setValue(u.getEmail());
        data_nasc_text.setValue(u.getDataNascimento().toString());
        String creds = "";
        if (u.getCredenciais().size()>0){
            for(Credencial c:u.getCredenciais())
                creds += c.getNome()+", ";
            creds = creds.substring(0, creds.length()-2);
        } else creds = "Não tem";
        credenciais_text.setValue(creds);
        Equipa eq = gur.getEquipa(u.getUser());
        if(eq!=null) equipa_text.setValue(eq.getNome());
        else equipa_text.setValue("");

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

    public String alterar_password_button1_action() {
        if (password_inputSecret1.getValue().toString().equals(confirm_password_inputSecret1.getValue().toString())){
            u.setPass(password_inputSecret1.getValue().toString());
            gur.setUtilizador(u);
            erro_text.setValue("");
        } else {
            erro_text.setValue("Confirmação da password errada.");
            confirm_password_inputSecret1.setValue("");
        }
        return null;
    }


}

