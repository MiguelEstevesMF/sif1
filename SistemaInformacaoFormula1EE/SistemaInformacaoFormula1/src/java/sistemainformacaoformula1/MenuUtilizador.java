/*
 * MenuUtilizador.java
 *
 * Created on 30/Jun/2009, 17:13:33
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.GerirUtilizadorLocal;
import bl.psmJEEHibernate.entities.Credencial;
import bl.psmJEEHibernate.entities.Utilizador;
import sistemainformacaoformula1.*;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import java.util.HashSet;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class MenuUtilizador extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private Utilizador utilizador = null;

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private HtmlCommandLink administracao_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getAdministracao_commandLink() {
        return administracao_commandLink;
    }

    public void setAdministracao_commandLink(HtmlCommandLink hcl) {
        this.administracao_commandLink = hcl;
    }
    private HtmlCommandLink crono_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getCrono_commandLink() {
        return crono_commandLink;
    }

    public void setCrono_commandLink(HtmlCommandLink hcl) {
        this.crono_commandLink = hcl;
    }
    private HtmlCommandLink o_meu_perfil_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getO_meu_perfil_commandLink() {
        return o_meu_perfil_commandLink;
    }

    public void setO_meu_perfil_commandLink(HtmlCommandLink hcl) {
        this.o_meu_perfil_commandLink = hcl;
    }
    private HtmlCommandLink registar_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getRegistar_commandLink() {
        return registar_commandLink;
    }

    public void setRegistar_commandLink(HtmlCommandLink hcl) {
        this.registar_commandLink = hcl;
    }
    private HtmlCommandLink login_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getLogin_commandLink() {
        return login_commandLink;
    }

    public void setLogin_commandLink(HtmlCommandLink hcl) {
        this.login_commandLink = hcl;
    }
    private HtmlCommandLink logout_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getLogout_commandLink() {
        return logout_commandLink;
    }

    public void setLogout_commandLink(HtmlCommandLink hcl) {
        this.logout_commandLink = hcl;
    }
    private HtmlCommandLink inicio_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getInicio_commandLink() {
        return inicio_commandLink;
    }

    public void setInicio_commandLink(HtmlCommandLink hcl) {
        this.inicio_commandLink = hcl;
    }
    private HtmlCommandLink gestor_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getGestor_commandLink() {
        return gestor_commandLink;
    }

    public void setGestor_commandLink(HtmlCommandLink hcl) {
        this.gestor_commandLink = hcl;
    }
    private HtmlCommandLink scoreboard_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getScoreboard_commandLink() {
        return scoreboard_commandLink;
    }

    public void setScoreboard_commandLink(HtmlCommandLink hcl) {
        this.scoreboard_commandLink = hcl;
    }
    private HtmlCommandLink juiz_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getJuiz_commandLink() {
        return juiz_commandLink;
    }

    public void setJuiz_commandLink(HtmlCommandLink hcl) {
        this.juiz_commandLink = hcl;
    }

    private HtmlCommandLink galeria_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getGaleria_commandLink() {
        return galeria_commandLink;
    }

    public void setGaleria_commandLink(HtmlCommandLink galeria_commandLink) {
        this.galeria_commandLink = galeria_commandLink;
    }

    private HtmlCommandLink resultados_commandLink = new HtmlCommandLink();

    public HtmlCommandLink getResultados_commandLink() {
        return resultados_commandLink;
    }

    public void setResultados_commandLink(HtmlCommandLink resultados_commandLink) {
        this.resultados_commandLink = resultados_commandLink;
    }




    // </editor-fold>

    @EJB
    private GerirUtilizadorLocal gur;

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public MenuUtilizador() {
        this.hideMenus();
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
    @Override
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
            log("MenuUtilizador Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        getBean("InicializadorApplicationBean");
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
    @Override
    public void destroy() {
        try{
            utilizador.setEstado("offline");
            gur.setUtilizador(utilizador);
        } catch(Exception e) {}
    }

    public void onBeforeUnload()     {
        try{
            logout_commandLink_action();
            HttpSession sess =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            sess.invalidate();
        } catch(Exception e) {}
    }


    protected RequestBean1 getRequestBean1() { return (RequestBean1) getBean("RequestBean1"); }
    protected SessionBean1 getSessionBean1() { return (SessionBean1) getBean("SessionBean1"); }
    protected ApplicationBean1 getApplicationBean1() { return (ApplicationBean1) getBean("ApplicationBean1"); }

    public String o_meu_perfil_commandLink_action()     { return "caseMeuPerfil"; }
    public String registar_commandLink_action()         { return "caseRegistar"; }
    public String login_commandLink_action()            { return "caseLogin"; }
    public String logout_commandLink_action() {
        utilizador.setEstado("offline");
        gur.setUtilizador(utilizador);
        utilizador = null;
        this.hideMenus();
        loginlink(true);
        registarlink(true);
        return "caseInicio";
    }
    public String inicio_commandLink_action()           { return "caseInicio"; }
    public String administracao_commandLink_action()    { return "caseAdministracao"; }
    public String crono_commandLink_action()            { return "caseCrono"; }
    public String gestor_commandLink_action()           { return "caseGestor"; }
    public String scoreboard_commandLink_action()       { return "caseScoreboard"; }
    public String juiz_commandLink_action()             { return "caseJuiz"; }
    public String galeria_commandLink_action()             { return "caseGaleria"; }
    public String resultados_commandLink_action()             { return "caseResultados"; }

    public void o_meu_perfillink(boolean b) { o_meu_perfil_commandLink.setRendered(b); }
    public void registarlink(boolean b)     { registar_commandLink.setRendered(b); }
    public void loginlink(boolean b)        { login_commandLink.setRendered(b); }
    public void logoutlink(boolean b)       { logout_commandLink.setRendered(b); }
    public void iniciolink(boolean b)       { inicio_commandLink.setRendered(b); }
    public void administracaolink(boolean b){ administracao_commandLink.setRendered(b); }
    public void cronolink(boolean b)        { crono_commandLink.setRendered(b); }
    public void gestorlink(boolean b)       { gestor_commandLink.setRendered(b); }
    public void scoreboardlink(boolean b)   { scoreboard_commandLink.setRendered(b); }
    public void juizlink(boolean b)         { juiz_commandLink.setRendered(b); }
    public void galerialink(boolean b)         { galeria_commandLink.setRendered(b); }
    public void resultadoslink(boolean b)         { resultados_commandLink.setRendered(b); }


    public void showMenus(){
        HashSet<Credencial> creds = new HashSet<Credencial>();
        creds = new HashSet<Credencial>(utilizador.getCredenciais());
        o_meu_perfillink(true);
        logoutlink(true);
        loginlink(false);
        registarlink(false);
        for(Credencial c:creds){
            if (c.getNome().equals("Admin")) administracaolink(true);
            if (c.getNome().equals("Gestor")) gestorlink(true);
            if (c.getNome().equals("Crono")) cronolink(true);
            if (c.getNome().equals("Juiz")) juizlink(true);
            if (c.getNome().equals("SBTR")) scoreboardlink(true);
        }

    }

    public void hideMenus(){
        o_meu_perfillink(false);
        logoutlink(false);
        administracaolink(false);
        cronolink(false);
        gestorlink(false);
        scoreboardlink(false);
        juizlink(false);
    }

    public String fazerLogin(String user, String pass){
        String res = "";

        try {
            this.utilizador = gur.loginValido(user, pass);
        } catch (Exception ex) {
            res = ex.getMessage();
        }

        if (this.utilizador!=null) {
            this.utilizador.setEstado("online");
            gur.setUtilizador(utilizador);
            this.showMenus();
        }

        return res;
    }



}
