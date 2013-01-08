/*
 * Login.java
 *
 * Created on 28/Jun/2009, 22:21:38
 * Copyright Miguel
 */
package sistemainformacaoformula1;

import bl.psmJEEHibernate.GerirCampeonatoLocal;
import bl.psmJEEHibernate.GerirCircuitoLocal;
import bl.psmJEEHibernate.GerirEquipaLocal;
import bl.psmJEEHibernate.GerirPilotoLocal;
import bl.psmJEEHibernate.entities.Campeonato;
import bl.psmJEEHibernate.entities.Circuito;
import bl.psmJEEHibernate.entities.Corrida;
import bl.psmJEEHibernate.entities.Equipa;
import bl.psmJEEHibernate.entities.Evento;
import bl.psmJEEHibernate.entities.Loop;
import bl.psmJEEHibernate.entities.Piloto;
import bl.psmJEEHibernate.entities.Qualificacao;
import bl.psmJEEHibernate.entities.Transponder;
import bl.psmJEEHibernate.entities.Treino;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLink;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.xml.crypto.Data;
import sistemainformacaoformula1.sessoes.GestorSessionBean;
import sistemainformacaoformula1.sessoes.LoopRow;
import sistemainformacaoformula1.sessoes.TreinoRow;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Galeria extends AbstractPageBean {

    @EJB
    private GerirCampeonatoLocal gcr;

    @EJB
    private GerirCircuitoLocal gcirr;

    @EJB
    private GerirEquipaLocal ger;

    @EJB
    private GerirPilotoLocal gpr;

    private final static int limit = 15;
    private int pagEq=1;
    private int totalEq;

    public int getTotalEq() {
        return ger.countEquipas();
    }

    private int pagCi=1;
    private int totalCi;

    public int getTotalCi() {
        return gcirr.countCircuitos();
    }

    private int pagPi=1;
    private int totalPi;

    public int getTotalPi() {
        return gpr.countPilotos();
    }


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    private void _init() throws Exception {
    }

    private ArrayList<Circuito> circuitos = new ArrayList<Circuito>();

    public ArrayList<Circuito> getCircuitos() {
        return (ArrayList<Circuito>) gcirr.findAllOrdenado("nome", "asc",limit,pagCi);
    }

    private HtmlGraphicImage graphicImageCi = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImageCi() {
        return graphicImageCi;
    }

    public void setGraphicImageCi(HtmlGraphicImage graphicImageCi) {
        this.graphicImageCi = graphicImageCi;
    }


    private HtmlOutputText nome1_outputText = new HtmlOutputText();

    public HtmlOutputText getNome1_outputText() {
        return nome1_outputText;
    }

    public void setNome1_outputText(HtmlOutputText hot) {
        this.nome1_outputText = hot;
    }
    private HtmlOutputText ComprimentoKm1_outputText = new HtmlOutputText();

    public HtmlOutputText getComprimentoKm1_outputText() {
        return ComprimentoKm1_outputText;
    }

    public void setComprimentoKm1_outputText(HtmlOutputText ComprimentoKm1_outputText) {
        this.ComprimentoKm1_outputText = ComprimentoKm1_outputText;
    }

    


    private HtmlOutputText LarguraM1_outputText = new HtmlOutputText();

    public HtmlOutputText getLarguraM1_outputText() {
        return LarguraM1_outputText;
    }

    public void setLarguraM1_outputText(HtmlOutputText hot) {
        this.LarguraM1_outputText = hot;
    }
    private HtmlOutputText Cidade1_outputText = new HtmlOutputText();

    public HtmlOutputText getCidade1_outputText() {
        return Cidade1_outputText;
    }

    public void setCidade1_outputText(HtmlOutputText hot) {
        this.Cidade1_outputText = hot;
    }
    private HtmlOutputText Pais1_outputText = new HtmlOutputText();

    public HtmlOutputText getPais1_outputText() {
        return Pais1_outputText;
    }

    public void setPais1_outputText(HtmlOutputText hot) {
        this.Pais1_outputText = hot;
    }
    private HtmlOutputText Gmt1_outputText = new HtmlOutputText();

    public HtmlOutputText getGmt1_outputText() {
        return Gmt1_outputText;
    }

    public void setGmt1_outputText(HtmlOutputText hot) {
        this.Gmt1_outputText = hot;
    }
    private HtmlOutputLink HomePage1_outputLink1 = new HtmlOutputLink();

    public HtmlOutputLink getHomePage1_outputLink1() {
        return HomePage1_outputLink1;
    }

    public void setHomePage1_outputLink1(HtmlOutputLink hol) {
        this.HomePage1_outputLink1 = hol;
    }
    private HtmlOutputText HomePage1_outputText = new HtmlOutputText();

    public HtmlOutputText getHomePage1_outputText() {
        return HomePage1_outputText;
    }

    public void setHomePage1_outputText(HtmlOutputText hot) {
        this.HomePage1_outputText = hot;
    }
    private HtmlOutputText TempoVoltaRecord1_outputText = new HtmlOutputText();

    public HtmlOutputText getTempoVoltaRecord1_outputText() {
        return TempoVoltaRecord1_outputText;
    }

    public void setTempoVoltaRecord1_outputText(HtmlOutputText hot) {
        this.TempoVoltaRecord1_outputText = hot;
    }
    private HtmlOutputText pilotoVoltaRecord1_outputText = new HtmlOutputText();

    public HtmlOutputText getPilotoVoltaRecord1_outputText() {
        return pilotoVoltaRecord1_outputText;
    }

    public void setPilotoVoltaRecord1_outputText(HtmlOutputText hot) {
        this.pilotoVoltaRecord1_outputText = hot;
    }
    private HtmlOutputText TempoMelhorVoltaPossivel1_outputText = new HtmlOutputText();

    public HtmlOutputText getTempoMelhorVoltaPossivel1_outputText() {
        return TempoMelhorVoltaPossivel1_outputText;
    }

    public void setTempoMelhorVoltaPossivel1_outputText(HtmlOutputText hot) {
        this.TempoMelhorVoltaPossivel1_outputText = hot;
    }
    private HtmlOutputText Descricao1_outputText = new HtmlOutputText();

    public HtmlOutputText getDescricao1_outputText() {
        return Descricao1_outputText;
    }

    public void setDescricao1_outputText(HtmlOutputText hot) {
        this.Descricao1_outputText = hot;
    }

    private HtmlInputTextarea sectores1_outputText = new HtmlInputTextarea();

    public HtmlInputTextarea getSectores1_outputText() {
        return sectores1_outputText;
    }

    public void setSectores1_outputText(HtmlInputTextarea sectores1_outputText) {
        this.sectores1_outputText = sectores1_outputText;
    }


    private HtmlCommandLink dataTable1HeaderFirstButtonCi = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderPreviousButtonCi = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderNextButtonCi = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderLastButtonCi = new HtmlCommandLink();
    private String paginacaoCi = "";

    public HtmlCommandLink getDataTable1HeaderFirstButtonCi() {
        return dataTable1HeaderFirstButtonCi;
    }

    public void setDataTable1HeaderFirstButtonCi(HtmlCommandLink dataTable1HeaderFirstButtonCi) {
        this.dataTable1HeaderFirstButtonCi = dataTable1HeaderFirstButtonCi;
    }

    public HtmlCommandLink getDataTable1HeaderLastButtonCi() {
        return dataTable1HeaderLastButtonCi;
    }

    public void setDataTable1HeaderLastButtonCi(HtmlCommandLink dataTable1HeaderLastButtonCi) {
        this.dataTable1HeaderLastButtonCi = dataTable1HeaderLastButtonCi;
    }

    public HtmlCommandLink getDataTable1HeaderNextButtonCi() {
        return dataTable1HeaderNextButtonCi;
    }

    public void setDataTable1HeaderNextButtonCi(HtmlCommandLink dataTable1HeaderNextButtonCi) {
        this.dataTable1HeaderNextButtonCi = dataTable1HeaderNextButtonCi;
    }

    public HtmlCommandLink getDataTable1HeaderPreviousButtonCi() {
        return dataTable1HeaderPreviousButtonCi;
    }

    public void setDataTable1HeaderPreviousButtonCi(HtmlCommandLink dataTable1HeaderPreviousButtonCi) {
        this.dataTable1HeaderPreviousButtonCi = dataTable1HeaderPreviousButtonCi;
    }


    public String getPaginacaoCi() {
        int total = getTotalCi();
        return 1+((pagCi-1)*limit) + "-"+ ((pagCi*limit>total)?total:(pagCi*limit)) +" de "+total;
    }




///////////////////////////////////////////////////////////////////////

    private ArrayList<Equipa> equipas = new ArrayList<Equipa>();

    public ArrayList<Equipa> getEquipas() {
        return (ArrayList<Equipa>) ger.findAllOrdenado("nome", "asc",limit,pagEq);
    }

    private HtmlGraphicImage graphicImageEq = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImageEq() {
        return graphicImageEq;
    }

    public void setGraphicImageEq(HtmlGraphicImage graphicImageEq) {
        this.graphicImageEq = graphicImageEq;
    }




    private HtmlOutputText nomeEq1_outputText = new HtmlOutputText();
    private HtmlOutputText motorEq1_outputText = new HtmlOutputText();
    private HtmlOutputText chassiEq1_outputText = new HtmlOutputText();
    private HtmlOutputText peneusEq1_outputText = new HtmlOutputText();
    private HtmlOutputText anoEntradaEq1_outputText = new HtmlOutputText();
    private HtmlOutputText melhorPosicaoEq1_outputText = new HtmlOutputText();
    private HtmlOutputText numeroVezesMPEq1_outputText = new HtmlOutputText();
    private HtmlOutputText polepositionsEq1_outputText = new HtmlOutputText();
    private HtmlOutputText directorEq1_outputText = new HtmlOutputText();
    private HtmlOutputText sedeEq1_outputText = new HtmlOutputText();
    private HtmlOutputText descricaoEq1_outputText = new HtmlOutputText();
    private HtmlInputTextarea pilotosEq1_outputText = new HtmlInputTextarea();


    public HtmlOutputText getAnoEntradaEq1_outputText() {
        return anoEntradaEq1_outputText;
    }

    public void setAnoEntradaEq1_outputText(HtmlOutputText anoEntradaEq1_outputText) {
        this.anoEntradaEq1_outputText = anoEntradaEq1_outputText;
    }

    public HtmlOutputText getChassiEq1_outputText() {
        return chassiEq1_outputText;
    }

    public void setChassiEq1_outputText(HtmlOutputText chassiEq1_outputText) {
        this.chassiEq1_outputText = chassiEq1_outputText;
    }

    public HtmlOutputText getDescricaoEq1_outputText() {
        return descricaoEq1_outputText;
    }

    public void setDescricaoEq1_outputText(HtmlOutputText descricaoEq1_outputText) {
        this.descricaoEq1_outputText = descricaoEq1_outputText;
    }

    public HtmlOutputText getDirectorEq1_outputText() {
        return directorEq1_outputText;
    }

    public void setDirectorEq1_outputText(HtmlOutputText directorEq1_outputText) {
        this.directorEq1_outputText = directorEq1_outputText;
    }

    public HtmlOutputText getMelhorPosicaoEq1_outputText() {
        return melhorPosicaoEq1_outputText;
    }

    public void setMelhorPosicaoEq1_outputText(HtmlOutputText melhorPosicaoEq1_outputText) {
        this.melhorPosicaoEq1_outputText = melhorPosicaoEq1_outputText;
    }

    public HtmlOutputText getMotorEq1_outputText() {
        return motorEq1_outputText;
    }

    public void setMotorEq1_outputText(HtmlOutputText motorEq1_outputText) {
        this.motorEq1_outputText = motorEq1_outputText;
    }

    public HtmlOutputText getNomeEq1_outputText() {
        return nomeEq1_outputText;
    }

    public void setNomeEq1_outputText(HtmlOutputText nomeEq1_outputText) {
        this.nomeEq1_outputText = nomeEq1_outputText;
    }

    public HtmlOutputText getNumeroVezesMPEq1_outputText() {
        return numeroVezesMPEq1_outputText;
    }

    public void setNumeroVezesMPEq1_outputText(HtmlOutputText numeroVezesMPEq1_outputText) {
        this.numeroVezesMPEq1_outputText = numeroVezesMPEq1_outputText;
    }

    public HtmlOutputText getPeneusEq1_outputText() {
        return peneusEq1_outputText;
    }

    public void setPeneusEq1_outputText(HtmlOutputText peneusEq1_outputText) {
        this.peneusEq1_outputText = peneusEq1_outputText;
    }

    public HtmlOutputText getPolepositionsEq1_outputText() {
        return polepositionsEq1_outputText;
    }

    public void setPolepositionsEq1_outputText(HtmlOutputText polepositionsEq1_outputText) {
        this.polepositionsEq1_outputText = polepositionsEq1_outputText;
    }

    public HtmlOutputText getSedeEq1_outputText() {
        return sedeEq1_outputText;
    }

    public void setSedeEq1_outputText(HtmlOutputText sedeEq1_outputText) {
        this.sedeEq1_outputText = sedeEq1_outputText;
    }

    public HtmlInputTextarea getPilotosEq1_outputText() {
        return pilotosEq1_outputText;
    }

    public void setPilotosEq1_outputText(HtmlInputTextarea pilotosEq1_outputText) {
        this.pilotosEq1_outputText = pilotosEq1_outputText;
    }


    private HtmlCommandLink dataTable1HeaderFirstButtonEq = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderPreviousButtonEq = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderNextButtonEq = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderLastButtonEq = new HtmlCommandLink();
    private String paginacaoEq = "";

    public HtmlCommandLink getDataTable1HeaderFirstButtonEq() {
        return dataTable1HeaderFirstButtonEq;
    }

    public void setDataTable1HeaderFirstButtonEq(HtmlCommandLink dataTable1HeaderFirstButtonEq) {
        this.dataTable1HeaderFirstButtonEq = dataTable1HeaderFirstButtonEq;
    }

    public HtmlCommandLink getDataTable1HeaderLastButtonEq() {
        return dataTable1HeaderLastButtonEq;
    }

    public void setDataTable1HeaderLastButtonEq(HtmlCommandLink dataTable1HeaderLastButtonEq) {
        this.dataTable1HeaderLastButtonEq = dataTable1HeaderLastButtonEq;
    }

    public HtmlCommandLink getDataTable1HeaderNextButtonEq() {
        return dataTable1HeaderNextButtonEq;
    }

    public void setDataTable1HeaderNextButtonEq(HtmlCommandLink dataTable1HeaderNextButtonEq) {
        this.dataTable1HeaderNextButtonEq = dataTable1HeaderNextButtonEq;
    }

    public HtmlCommandLink getDataTable1HeaderPreviousButtonEq() {
        return dataTable1HeaderPreviousButtonEq;
    }

    public void setDataTable1HeaderPreviousButtonEq(HtmlCommandLink dataTable1HeaderPreviousButtonEq) {
        this.dataTable1HeaderPreviousButtonEq = dataTable1HeaderPreviousButtonEq;
    }

    public String getPaginacaoEq() {
        int total = getTotalEq();
        return 1+((pagEq-1)*limit) + "-"+ ((pagEq*limit>total)?total:(pagEq*limit)) +" de "+total;
    }






    ///////////////////////////////////////////////////////////////////////

    private ArrayList<Piloto> pilotos = new ArrayList<Piloto>();

    public ArrayList<Piloto> getPilotos() {
        return (ArrayList<Piloto>) gpr.findAllOrdenado("nome", "asc",limit,pagPi);
    }

    public void setPilotos(ArrayList<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    private HtmlGraphicImage graphicImagePi = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImagePi() {
        return graphicImagePi;
    }

    public void setGraphicImagePi(HtmlGraphicImage graphicImagePi) {
        this.graphicImagePi = graphicImagePi;
    }



    private HtmlOutputText numeroPi1_outputText = new HtmlOutputText();
    private HtmlOutputText nomePi1_outputText = new HtmlOutputText();
    private HtmlOutputText dataNascimentoPi1_outputText = new HtmlOutputText();
    private HtmlOutputText nacionalidadePi1_outputText = new HtmlOutputText();
    private HtmlOutputText melhorPosicaoPi1_outputText = new HtmlOutputText();
    private HtmlOutputText numeroVezesMPPi1_outputText = new HtmlOutputText();
    private HtmlOutputText polePositionsPi1_outputText = new HtmlOutputText();
    private HtmlOutputText descricaoPi1_outputText = new HtmlOutputText();
    private HtmlOutputText equipa_actualPi1_outputText = new HtmlOutputText();

    public HtmlOutputText getDataNascimentoPi1_outputText() {
        return dataNascimentoPi1_outputText;
    }

    public void setDataNascimentoPi1_outputText(HtmlOutputText dataNascimentoPi1_outputText) {
        this.dataNascimentoPi1_outputText = dataNascimentoPi1_outputText;
    }

    public HtmlOutputText getDescricaoPi1_outputText() {
        return descricaoPi1_outputText;
    }

    public void setDescricaoPi1_outputText(HtmlOutputText descricaoPi1_outputText) {
        this.descricaoPi1_outputText = descricaoPi1_outputText;
    }

    public HtmlOutputText getEquipa_actualPi1_outputText() {
        return equipa_actualPi1_outputText;
    }

    public void setEquipa_actualPi1_outputText(HtmlOutputText equipa_actualPi1_outputText) {
        this.equipa_actualPi1_outputText = equipa_actualPi1_outputText;
    }

    public HtmlOutputText getMelhorPosicaoPi1_outputText() {
        return melhorPosicaoPi1_outputText;
    }

    public void setMelhorPosicaoPi1_outputText(HtmlOutputText melhorPosicaoPi1_outputText) {
        this.melhorPosicaoPi1_outputText = melhorPosicaoPi1_outputText;
    }

    public HtmlOutputText getNacionalidadePi1_outputText() {
        return nacionalidadePi1_outputText;
    }

    public void setNacionalidadePi1_outputText(HtmlOutputText nacionalidadePi1_outputText) {
        this.nacionalidadePi1_outputText = nacionalidadePi1_outputText;
    }

    public HtmlOutputText getNomePi1_outputText() {
        return nomePi1_outputText;
    }

    public void setNomePi1_outputText(HtmlOutputText nomePi1_outputText) {
        this.nomePi1_outputText = nomePi1_outputText;
    }

    public HtmlOutputText getNumeroPi1_outputText() {
        return numeroPi1_outputText;
    }

    public void setNumeroPi1_outputText(HtmlOutputText numeroPi1_outputText) {
        this.numeroPi1_outputText = numeroPi1_outputText;
    }

    public HtmlOutputText getNumeroVezesMPPi1_outputText() {
        return numeroVezesMPPi1_outputText;
    }

    public void setNumeroVezesMPPi1_outputText(HtmlOutputText numeroVezesMPPi1_outputText) {
        this.numeroVezesMPPi1_outputText = numeroVezesMPPi1_outputText;
    }

    public HtmlOutputText getPolePositionsPi1_outputText() {
        return polePositionsPi1_outputText;
    }

    public void setPolePositionsPi1_outputText(HtmlOutputText polePositionsPi1_outputText) {
        this.polePositionsPi1_outputText = polePositionsPi1_outputText;
    }

    private HtmlCommandLink dataTable1HeaderFirstButtonPi = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderPreviousButtonPi = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderNextButtonPi = new HtmlCommandLink();
    private HtmlCommandLink dataTable1HeaderLastButtonPi = new HtmlCommandLink();
    private String paginacaoPi = "";

    public HtmlCommandLink getDataTable1HeaderFirstButtonPi() {
        return dataTable1HeaderFirstButtonPi;
    }

    public void setDataTable1HeaderFirstButtonPi(HtmlCommandLink dataTable1HeaderFirstButtonPi) {
        this.dataTable1HeaderFirstButtonPi = dataTable1HeaderFirstButtonPi;
    }

    public HtmlCommandLink getDataTable1HeaderLastButtonPi() {
        return dataTable1HeaderLastButtonPi;
    }

    public void setDataTable1HeaderLastButtonPi(HtmlCommandLink dataTable1HeaderLastButtonPi) {
        this.dataTable1HeaderLastButtonPi = dataTable1HeaderLastButtonPi;
    }

    public HtmlCommandLink getDataTable1HeaderNextButtonPi() {
        return dataTable1HeaderNextButtonPi;
    }

    public void setDataTable1HeaderNextButtonPi(HtmlCommandLink dataTable1HeaderNextButtonPi) {
        this.dataTable1HeaderNextButtonPi = dataTable1HeaderNextButtonPi;
    }

    public HtmlCommandLink getDataTable1HeaderPreviousButtonPi() {
        return dataTable1HeaderPreviousButtonPi;
    }

    public void setDataTable1HeaderPreviousButtonPi(HtmlCommandLink dataTable1HeaderPreviousButtonPi) {
        this.dataTable1HeaderPreviousButtonPi = dataTable1HeaderPreviousButtonPi;
    }



    public String getPaginacaoPi() {
        int total = getTotalPi();
        return 1+((pagPi-1)*limit) + "-"+ ((pagPi*limit>total)?total:(pagPi*limit)) +" de "+total;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Galeria() {
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
    


    /////////////////CIRCUITOS//////////////////////////////////////////


    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();

        circuitos = new ArrayList<Circuito>(gcirr.findAllOrdenado("nome", "asc",limit,pagCi));
        
        Circuito c = circuitos.get(selectedRowIndex);

        if(gcirr.getImagem(c)!=null)
            graphicImageCi.setValue(gcirr.getImagem(c));
        else graphicImageCi.setValue("/resources/blank.bmp");

        nome1_outputText.setValue(c.getNome());
        Cidade1_outputText.setValue(c.getCidade());
        ComprimentoKm1_outputText.setValue(c.getComprimentoKm());
        Descricao1_outputText.setValue(c.getDescricao());
        Gmt1_outputText.setValue(c.getGmt());
        LarguraM1_outputText.setValue(c.getLarguraM());
        Pais1_outputText.setValue(c.getPais());
        HomePage1_outputLink1.setValue(c.getHomePage());
        HomePage1_outputText.setValue(c.getHomePage());
        TempoMelhorVoltaPossivel1_outputText.setValue(
                new SimpleDateFormat("hh:mm:ss,SSS").format(new Date(c.getTempoMelhorVoltaPossivel()))
                );

        TempoVoltaRecord1_outputText.setValue(
                new SimpleDateFormat("hh:mm:ss,SSS").format(new Date(c.getTempoVoltaRecord()))
                );
        
        String str ="";
        for(Loop l : c.getLoops())
            str += l.getRef()+" - "+l.getPosicaoKm()+" Km\n";


        sectores1_outputText.setValue(str);
        

    }


        /////////////////EQUIPAS//////////////////////////////////////////


    public void rowSelector2_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();

        equipas = new ArrayList<Equipa>(ger.findAllOrdenado("nome", "asc",limit,pagEq));

        Equipa e = equipas.get(selectedRowIndex);

        if(ger.getImagem(e)!=null)
            graphicImageEq.setValue(ger.getImagem(e));
        else graphicImageEq.setValue("/resources/blank.bmp");

        nomeEq1_outputText.setValue(e.getNome());
        anoEntradaEq1_outputText.setValue(e.getAnoEntrada());
        chassiEq1_outputText.setValue(e.getChassi());
        descricaoEq1_outputText.setValue(e.getDescricao());
        directorEq1_outputText.setValue(e.getDirector());
        melhorPosicaoEq1_outputText.setValue(e.getMelhorPosicao());
        motorEq1_outputText.setValue(e.getMotor());
        polepositionsEq1_outputText.setValue(e.getPolepositions());
        peneusEq1_outputText.setValue(e.getPneus());
        sedeEq1_outputText.setValue(e.getSede());
        numeroVezesMPEq1_outputText.setValue(e.getNumeroVezesMP());
        
        String str ="";
        for(Piloto p : ger.getEquipaP(e.getNome()).getPilotos())
            str += p.getNome() + "\n";

        pilotosEq1_outputText.setValue(str);

    }


    /////////////////PILOTOS//////////////////////////////////////////

    public void rowSelector3_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();

        pilotos = new ArrayList<Piloto>(gpr.findAllOrdenado("nome", "asc",limit,pagPi));

        Piloto p = pilotos.get(selectedRowIndex);

        if(gpr.getImagem(p)!=null)
            graphicImagePi.setValue(gpr.getImagem(p));
        else graphicImagePi.setValue("/resources/blank.bmp");

        numeroPi1_outputText.setValue(p.getNumero());
        nomePi1_outputText.setValue(p.getNome());
        dataNascimentoPi1_outputText.setValue(p.getDataNascimento());
        nacionalidadePi1_outputText.setValue(p.getNacionalidade());
        melhorPosicaoPi1_outputText.setValue(p.getMelhorPosicao());
        numeroVezesMPPi1_outputText.setValue(p.getNumeroVezesMP());
        polePositionsPi1_outputText.setValue(p.getPolePositions());
        descricaoPi1_outputText.setValue(p.getDescricao());
        equipa_actualPi1_outputText.setValue(gpr.getPiloto(p.getNome()).getEquipa_actual().getNome());


    }






    ////////////////////////////PAGINATORS//////////////////////////////////


    ////////////////////////////Ci//////////////////////////////////
    public String dataTable1_firstPageActionCi() {
        this.pagCi = 1;
        renderPaginatorCi();
        return null;
    }

    public String dataTable1_previousPageActionCi() {
        int offset = pagCi;

        offset = offset-1>0?offset-1:1;
        pagCi = offset;

        renderPaginatorCi();
        return null;
    }

    public String dataTable1_nextPageActionCi() {
        int offset = pagCi;
        int total = getTotalCi();

        offset = offset*limit>total?offset:offset+1;
        pagCi = offset;

        renderPaginatorCi();
        return null;
    }

    public String dataTable1_lastPageActionCi() {
        int total = getTotalCi();
        pagCi =  ((int) (total / limit))+1 ;
        renderPaginatorCi();

        return null;
    }


   private void renderPaginatorCi(){
        int offset = pagCi;
        int total = getTotalCi();
        total = ((int) (total / limit))+1;

        if(offset>1 && offset<total) {
            dataTable1HeaderFirstButtonCi.setVisible(true);
            dataTable1HeaderPreviousButtonCi.setVisible(true);
            dataTable1HeaderNextButtonCi.setVisible(true);
            dataTable1HeaderLastButtonCi.setVisible(true);
        } else {
            if(offset==1 && offset<total) {
                dataTable1HeaderFirstButtonCi.setVisible(false);
                dataTable1HeaderPreviousButtonCi.setVisible(false);
                dataTable1HeaderNextButtonCi.setVisible(true);
                dataTable1HeaderLastButtonCi.setVisible(true);
            }
            if(offset>1 && offset==total) {
                dataTable1HeaderFirstButtonCi.setVisible(true);
                dataTable1HeaderPreviousButtonCi.setVisible(true);
                dataTable1HeaderNextButtonCi.setVisible(false);
                dataTable1HeaderLastButtonCi.setVisible(false);
            }
            if(offset==1 && offset==total) {
                dataTable1HeaderFirstButtonCi.setVisible(false);
                dataTable1HeaderPreviousButtonCi.setVisible(false);
                dataTable1HeaderNextButtonCi.setVisible(false);
                dataTable1HeaderLastButtonCi.setVisible(false);
            }
        }

    }



    ////////////////////////////Eq//////////////////////////////////
    public String dataTable1_firstPageActionEq() {
        this.pagEq = 1;
        renderPaginatorEq();
        return null;
    }

    public String dataTable1_previousPageActionEq() {
        int offset = pagEq;

        offset = offset-1>0?offset-1:1;
        pagEq = offset;

        renderPaginatorEq();
        return null;
    }

    public String dataTable1_nextPageActionEq() {
        int offset = pagEq;
        int total = getTotalEq();

        offset = offset*limit>total?offset:offset+1;
        pagEq = offset;

        renderPaginatorEq();
        return null;
    }

    public String dataTable1_lastPageActionEq() {
        int total = getTotalEq();
        pagEq =  ((int) (total / limit))+1 ;
        renderPaginatorEq();

        return null;
    }


   private void renderPaginatorEq(){
        int offset = pagEq;
        int total = getTotalEq();
        total = ((int) (total / limit))+1;

        if(offset>1 && offset<total) {
            dataTable1HeaderFirstButtonEq.setVisible(true);
            dataTable1HeaderPreviousButtonEq.setVisible(true);
            dataTable1HeaderNextButtonEq.setVisible(true);
            dataTable1HeaderLastButtonEq.setVisible(true);
        } else {
            if(offset==1 && offset<total) {
                dataTable1HeaderFirstButtonEq.setVisible(false);
                dataTable1HeaderPreviousButtonEq.setVisible(false);
                dataTable1HeaderNextButtonEq.setVisible(true);
                dataTable1HeaderLastButtonEq.setVisible(true);
            }
            if(offset>1 && offset==total) {
                dataTable1HeaderFirstButtonEq.setVisible(true);
                dataTable1HeaderPreviousButtonEq.setVisible(true);
                dataTable1HeaderNextButtonEq.setVisible(false);
                dataTable1HeaderLastButtonEq.setVisible(false);
            }
            if(offset==1 && offset==total) {
                dataTable1HeaderFirstButtonEq.setVisible(false);
                dataTable1HeaderPreviousButtonEq.setVisible(false);
                dataTable1HeaderNextButtonEq.setVisible(false);
                dataTable1HeaderLastButtonEq.setVisible(false);
            }
        }

    }


////////////////////////////Pi//////////////////////////////////
    public String dataTable1_firstPageActionPi() {
        this.pagPi = 1;
        renderPaginatorPi();
        return null;
    }

    public String dataTable1_previousPageActionPi() {
        int offset = pagPi;

        offset = offset-1>0?offset-1:1;
        pagPi = offset;

        renderPaginatorPi();
        return null;
    }

    public String dataTable1_nextPageActionPi() {
        int offset = pagPi;
        int total = getTotalPi();

        offset = offset*limit>total?offset:offset+1;
        pagPi = offset;

        renderPaginatorPi();
        return null;
    }

    public String dataTable1_lastPageActionPi() {
        int total = getTotalPi();
        pagPi =  ((int) (total / limit))+1 ;
        renderPaginatorPi();

        return null;
    }


   private void renderPaginatorPi(){
        int offset = pagPi;
        int total = getTotalPi();
        total = ((int) (total / limit))+1;

        if(offset>1 && offset<total) {
            dataTable1HeaderFirstButtonPi.setVisible(true);
            dataTable1HeaderPreviousButtonPi.setVisible(true);
            dataTable1HeaderNextButtonPi.setVisible(true);
            dataTable1HeaderLastButtonPi.setVisible(true);
        } else {
            if(offset==1 && offset<total) {
                dataTable1HeaderFirstButtonPi.setVisible(false);
                dataTable1HeaderPreviousButtonPi.setVisible(false);
                dataTable1HeaderNextButtonPi.setVisible(true);
                dataTable1HeaderLastButtonPi.setVisible(true);
            }
            if(offset>1 && offset==total) {
                dataTable1HeaderFirstButtonPi.setVisible(true);
                dataTable1HeaderPreviousButtonPi.setVisible(true);
                dataTable1HeaderNextButtonPi.setVisible(false);
                dataTable1HeaderLastButtonPi.setVisible(false);
            }
            if(offset==1 && offset==total) {
                dataTable1HeaderFirstButtonPi.setVisible(false);
                dataTable1HeaderPreviousButtonPi.setVisible(false);
                dataTable1HeaderNextButtonPi.setVisible(false);
                dataTable1HeaderLastButtonPi.setVisible(false);
            }
        }

    }






}

