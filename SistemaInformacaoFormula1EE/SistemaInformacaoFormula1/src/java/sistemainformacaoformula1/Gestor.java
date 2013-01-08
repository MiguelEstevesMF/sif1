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
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.io.File;
import java.io.FileInputStream;
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
public class Gestor extends AbstractPageBean {

    @EJB
    private GerirCampeonatoLocal gcr;

    @EJB
    private GerirCircuitoLocal gcirr;

    @EJB
    private GerirEquipaLocal ger;

    @EJB
    private GerirPilotoLocal gpr;

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    private void _init() throws Exception {
    }


    private ArrayList<SelectItem> campeonatosDropDownDBItems = new ArrayList<SelectItem>();
    private HtmlSelectOneMenu campeonatosDropDown = new HtmlSelectOneMenu();
    private DefaultSelectedData campeonatoDropDownSelec = new DefaultSelectedData();

    public DefaultSelectedData getCampeonatoDropDownSelec() {
        return campeonatoDropDownSelec;
    }

    public void setCampeonatoDropDownSelec(DefaultSelectedData campeonatoDropDownSelec) {
        this.campeonatoDropDownSelec = campeonatoDropDownSelec;
    }

    public HtmlSelectOneMenu getCampeonatosDropDown() {
        return campeonatosDropDown;
    }

    public void setCampeonatosDropDown(HtmlSelectOneMenu campeonatosDropDown) {
        this.campeonatosDropDown = campeonatosDropDown;
    }

    public ArrayList<SelectItem> getCampeonatosDropDownDBItems() {
        return campeonatosDropDownDBItems;
    }

    public void setCampeonatosDropDownDBItems(ArrayList<SelectItem> campeonatosDropDownDBItems) {
        this.campeonatosDropDownDBItems = campeonatosDropDownDBItems;
    }


//////////////////////////////////////////////////////////////////////////


    private DefaultSelectedData campeonatosSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems campeonatosSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu campeonatosSelectOneMenu1 = new HtmlSelectOneMenu();
    private DefaultSelectedData eventosSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems eventosSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu eventosSelectOneMenu1 = new HtmlSelectOneMenu(); //nao uso

    private DefaultSelectedData circuitoEvSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems circuitoEvSelectOneMenu1DefaultItems = new DefaultSelectionItems();

    private HtmlInputText campDesigna = new HtmlInputText();
    private HtmlInputText campAnoInic = new HtmlInputText();



    public HtmlInputText getCampAnoInic() {
        return campAnoInic;
    }

    public void setCampAnoInic(HtmlInputText campAnoInic) {
        this.campAnoInic = campAnoInic;
    }

    public HtmlInputText getCampDesigna() {
        return campDesigna;
    }

    public void setCampDesigna(HtmlInputText campDesigna) {
        this.campDesigna = campDesigna;
    }


    public HtmlSelectOneMenu getCampeonatosSelectOneMenu1() {
        return campeonatosSelectOneMenu1;
    }

    public void setCampeonatosSelectOneMenu1(HtmlSelectOneMenu campeonatosSelectOneMenu1) {
        this.campeonatosSelectOneMenu1 = campeonatosSelectOneMenu1;
    }

    public DefaultSelectedData getCampeonatosSelectOneMenu1Bean() {
        return campeonatosSelectOneMenu1Bean;
    }

    public void setCampeonatosSelectOneMenu1Bean(DefaultSelectedData campeonatosSelectOneMenu1Bean) {
        this.campeonatosSelectOneMenu1Bean = campeonatosSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCampeonatosSelectOneMenu1DefaultItems() {
        return campeonatosSelectOneMenu1DefaultItems;
    }

    public void setCampeonatosSelectOneMenu1DefaultItems(DefaultSelectionItems campeonatosSelectOneMenu1DefaultItems) {
        this.campeonatosSelectOneMenu1DefaultItems = campeonatosSelectOneMenu1DefaultItems;
    }


    public HtmlSelectOneMenu getEventosSelectOneMenu1() {
        return eventosSelectOneMenu1;
    }

    public void setEventosSelectOneMenu1(HtmlSelectOneMenu eventosSelectOneMenu1) {
        this.eventosSelectOneMenu1 = eventosSelectOneMenu1;
    }

    public DefaultSelectedData getEventosSelectOneMenu1Bean() {
        return eventosSelectOneMenu1Bean;
    }

    public void setEventosSelectOneMenu1Bean(DefaultSelectedData eventosSelectOneMenu1Bean) {
        this.eventosSelectOneMenu1Bean = eventosSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getEventosSelectOneMenu1DefaultItems() {
        return eventosSelectOneMenu1DefaultItems;
    }

    public void setEventosSelectOneMenu1DefaultItems(DefaultSelectionItems eventosSelectOneMenu1DefaultItems) {
        this.eventosSelectOneMenu1DefaultItems = eventosSelectOneMenu1DefaultItems;
    }

    public DefaultSelectedData getCircuitoEvSelectOneMenu1Bean() {
        return circuitoEvSelectOneMenu1Bean;
    }

    public void setCircuitoEvSelectOneMenu1Bean(DefaultSelectedData circuitoEvSelectOneMenu1Bean) {
        this.circuitoEvSelectOneMenu1Bean = circuitoEvSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCircuitoEvSelectOneMenu1DefaultItems() {
        return circuitoEvSelectOneMenu1DefaultItems;
    }

    public void setCircuitoEvSelectOneMenu1DefaultItems(DefaultSelectionItems circuitoEvSelectOneMenu1DefaultItems) {
        this.circuitoEvSelectOneMenu1DefaultItems = circuitoEvSelectOneMenu1DefaultItems;
    }
    private HtmlInputText designacao_inputText1 = new HtmlInputText();

    public HtmlInputText getDesignacao_inputText1() {
        return designacao_inputText1;
    }

    public void setDesignacao_inputText1(HtmlInputText hit) {
        this.designacao_inputText1 = hit;
    }
    private SelectInputDate eventoDate1 = new SelectInputDate();

    public SelectInputDate getEventoDate1() {
        return eventoDate1;
    }

    public void setEventoDate1(SelectInputDate sid) {
        this.eventoDate1 = sid;
    }
    
    private HtmlInputText numerovoltas_inputText1 = new HtmlInputText();

    public HtmlInputText getNumerovoltas_inputText1() {
        return numerovoltas_inputText1;
    }

    public void setNumerovoltas_inputText1(HtmlInputText hit) {
        this.numerovoltas_inputText1 = hit;
    }
    private HtmlInputText dtotal_inputText1 = new HtmlInputText();

    public HtmlInputText getDtotal_inputText1() {
        return dtotal_inputText1;
    }

    public void setDtotal_inputText1(HtmlInputText hit) {
        this.dtotal_inputText1 = hit;
    }
    private SelectInputDate date3_corrida = new SelectInputDate();

    public SelectInputDate getDate3_corrida() {
        return date3_corrida;
    }

    public void setDate3_corrida(SelectInputDate sid) {
        this.date3_corrida = sid;
    }
    private SelectInputDate date3_qualificacao = new SelectInputDate();

    public SelectInputDate getDate3_qualificacao() {
        return date3_qualificacao;
    }

    public void setDate3_qualificacao(SelectInputDate sid) {
        this.date3_qualificacao = sid;
    }
    private HtmlSelectOneMenu circuitoEvSelectOneMenu1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCircuitoEvSelectOneMenu1() {
        return circuitoEvSelectOneMenu1;
    }

    public void setCircuitoEvSelectOneMenu1(HtmlSelectOneMenu hsom) {
        this.circuitoEvSelectOneMenu1 = hsom;
    }
    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }


    /////////////////////////////////////////////////////////////////////////////////////

    private DefaultSelectedData circuitosSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems circuitosSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu circuitosSelectOneMenu1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCircuitosSelectOneMenu1() {
        return circuitosSelectOneMenu1;
    }

    public void setCircuitosSelectOneMenu1(HtmlSelectOneMenu circuitosSelectOneMenu1) {
        this.circuitosSelectOneMenu1 = circuitosSelectOneMenu1;
    }

    public DefaultSelectedData getCircuitosSelectOneMenu1Bean() {
        return circuitosSelectOneMenu1Bean;
    }

    public void setCircuitosSelectOneMenu1Bean(DefaultSelectedData circuitosSelectOneMenu1Bean) {
        this.circuitosSelectOneMenu1Bean = circuitosSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getCircuitosSelectOneMenu1DefaultItems() {
        return circuitosSelectOneMenu1DefaultItems;
    }

    public void setCircuitosSelectOneMenu1DefaultItems(DefaultSelectionItems circuitosSelectOneMenu1DefaultItems) {
        this.circuitosSelectOneMenu1DefaultItems = circuitosSelectOneMenu1DefaultItems;
    }
    private HtmlInputText nome_inputText3 = new HtmlInputText();

    public HtmlInputText getNome_inputText3() {
        return nome_inputText3;
    }

    public void setNome_inputText3(HtmlInputText hit) {
        this.nome_inputText3 = hit;
    }
    private HtmlInputText cidade_inputText3 = new HtmlInputText();

    public HtmlInputText getCidade_inputText3() {
        return cidade_inputText3;
    }

    public void setCidade_inputText3(HtmlInputText hit) {
        this.cidade_inputText3 = hit;
    }
    private HtmlInputText pais_inputText3 = new HtmlInputText();

    public HtmlInputText getPais_inputText3() {
        return pais_inputText3;
    }

    public void setPais_inputText3(HtmlInputText hit) {
        this.pais_inputText3 = hit;
    }


    private HtmlInputText comprimento_inputText3 = new HtmlInputText();

    public HtmlInputText getComprimento_inputText3() {
        return comprimento_inputText3;
    }

    public void setComprimento_inputText3(HtmlInputText hit) {
        this.comprimento_inputText3 = hit;
    }
    private HtmlInputText largura_inputText3 = new HtmlInputText();

    public HtmlInputText getLargura_inputText3() {
        return largura_inputText3;
    }

    public void setLargura_inputText3(HtmlInputText hit) {
        this.largura_inputText3 = hit;
    }
    private HtmlInputText GMT_inputText3 = new HtmlInputText();

    public HtmlInputText getGMT_inputText3() {
        return GMT_inputText3;
    }

    public void setGMT_inputText3(HtmlInputText hit) {
        this.GMT_inputText3 = hit;
    }
    private HtmlInputText homepage_inputText3 = new HtmlInputText();

    public HtmlInputText getHomepage_inputText3() {
        return homepage_inputText3;
    }

    public void setHomepage_inputText3(HtmlInputText hit) {
        this.homepage_inputText3 = hit;
    }
    private HtmlInputTextarea descricao_inputText3 = new HtmlInputTextarea();

    public HtmlInputTextarea getDescricao_inputText3() {
        return descricao_inputText3;
    }

    public void setDescricao_inputText3(HtmlInputTextarea hit) {
        this.descricao_inputText3 = hit;
    }
    private HtmlDataTable dataTable2 = new HtmlDataTable();

    public HtmlDataTable getDataTable2() {
        return dataTable2;
    }

    public void setDataTable2(HtmlDataTable hdt) {
        this.dataTable2 = hdt;
    }

    private InputFile inputFileCi = new InputFile();

    public InputFile getInputFileCi() {
        return inputFileCi;
    }

    public void setInputFileCi(InputFile if0) {
        this.inputFileCi = if0;
    }

    private byte[] imagemCi = null;

    public byte[] getImagemCi() {
        return imagemCi;
    }

    public void setImagemCi(byte[] imagemCi) {
        this.imagemCi = imagemCi;
    }

    private HtmlGraphicImage graphicImageCi = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImageCi() {
        return graphicImageCi;
    }

    public void setGraphicImageCi(HtmlGraphicImage hgi) {
        this.graphicImageCi = hgi;
    }



    /////////////////////////////////////////////////////////////////////////////////////


    private DefaultSelectedData equipasSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems equipasSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu equipasSelectOneMenu1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getEquipasSelectOneMenu1() {
        return equipasSelectOneMenu1;
    }

    public void setEquipasSelectOneMenu1(HtmlSelectOneMenu equipasSelectOneMenu1) {
        this.equipasSelectOneMenu1 = equipasSelectOneMenu1;
    }

    public DefaultSelectedData getEquipasSelectOneMenu1Bean() {
        return equipasSelectOneMenu1Bean;
    }

    public void setEquipasSelectOneMenu1Bean(DefaultSelectedData equipasSelectOneMenu1Bean) {
        this.equipasSelectOneMenu1Bean = equipasSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getEquipasSelectOneMenu1DefaultItems() {
        return equipasSelectOneMenu1DefaultItems;
    }

    public void setEquipasSelectOneMenu1DefaultItems(DefaultSelectionItems equipasSelectOneMenu1DefaultItems) {
        this.equipasSelectOneMenu1DefaultItems = equipasSelectOneMenu1DefaultItems;
    }


    private HtmlInputText nomeEq_inputText1 = new HtmlInputText();

    public HtmlInputText getNomeEq_inputText1() {
        return nomeEq_inputText1;
    }

    public void setNomeEq_inputText1(HtmlInputText hit) {
        this.nomeEq_inputText1 = hit;
    }
    private HtmlInputText motor_inputText1 = new HtmlInputText();

    public HtmlInputText getMotor_inputText1() {
        return motor_inputText1;
    }

    public void setMotor_inputText1(HtmlInputText hit) {
        this.motor_inputText1 = hit;
    }
    private HtmlInputText chassi_inputText1 = new HtmlInputText();

    public HtmlInputText getChassi_inputText1() {
        return chassi_inputText1;
    }

    public void setChassi_inputText1(HtmlInputText hit) {
        this.chassi_inputText1 = hit;
    }
    private HtmlInputText peneus_inputText1 = new HtmlInputText();

    public HtmlInputText getPeneus_inputText1() {
        return peneus_inputText1;
    }

    public void setPeneus_inputText1(HtmlInputText hit) {
        this.peneus_inputText1 = hit;
    }
    private HtmlInputText director_inputText1 = new HtmlInputText();

    public HtmlInputText getDirector_inputText1() {
        return director_inputText1;
    }

    public void setDirector_inputText1(HtmlInputText hit) {
        this.director_inputText1 = hit;
    }
    private HtmlInputText sede_inputText1 = new HtmlInputText();

    public HtmlInputText getSede_inputText1() {
        return sede_inputText1;
    }

    public void setSede_inputText1(HtmlInputText hit) {
        this.sede_inputText1 = hit;
    }
    private HtmlInputTextarea descricao_inputText1 = new HtmlInputTextarea();

    public HtmlInputTextarea getDescricao_inputText1() {
        return descricao_inputText1;
    }

    public void setDescricao_inputText1(HtmlInputTextarea hit) {
        this.descricao_inputText1 = hit;
    }



    private DefaultSelectedData campeonatoEqSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems campeonatoEqSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu campeonatoEqSelectOneMenu1 = new HtmlSelectOneMenu();

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


    private InputFile inputFileEq = new InputFile();
    private byte[] imagemEq = null;
    private HtmlGraphicImage graphicImageEq = new HtmlGraphicImage();

    public byte[] getImagemEq() {
        return imagemEq;
    }

    public void setImagemEq(byte[] imagemEq) {
        this.imagemEq = imagemEq;
    }

    public InputFile getInputFileEq() {
        return inputFileEq;
    }

    public void setInputFileEq(InputFile inputFileEq) {
        this.inputFileEq = inputFileEq;
    }

    public HtmlGraphicImage getGraphicImageEq() {
        return graphicImageEq;
    }

    public void setGraphicImageEq(HtmlGraphicImage graphicImageEq) {
        this.graphicImageEq = graphicImageEq;
    }









     /////////////////////////////////////////////////////////////////////////////////////

    private DefaultSelectedData pilotosSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems pilotosSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu pilotosSelectOneMenu1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getPilotosSelectOneMenu1() {
        return pilotosSelectOneMenu1;
    }

    public void setPilotosSelectOneMenu1(HtmlSelectOneMenu pilotosSelectOneMenu1) {
        this.pilotosSelectOneMenu1 = pilotosSelectOneMenu1;
    }

    public DefaultSelectedData getPilotosSelectOneMenu1Bean() {
        return pilotosSelectOneMenu1Bean;
    }

    public void setPilotosSelectOneMenu1Bean(DefaultSelectedData pilotosSelectOneMenu1Bean) {
        this.pilotosSelectOneMenu1Bean = pilotosSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getPilotosSelectOneMenu1DefaultItems() {
        return pilotosSelectOneMenu1DefaultItems;
    }

    public void setPilotosSelectOneMenu1DefaultItems(DefaultSelectionItems pilotosSelectOneMenu1DefaultItems) {
        this.pilotosSelectOneMenu1DefaultItems = pilotosSelectOneMenu1DefaultItems;
    }
    private HtmlInputText nomePi_inputText2 = new HtmlInputText();

    public HtmlInputText getNomePi_inputText2() {
        return nomePi_inputText2;
    }

    public void setNomePi_inputText2(HtmlInputText hit) {
        this.nomePi_inputText2 = hit;
    }
    private SelectInputDate date_dataNascPi = new SelectInputDate();

    public SelectInputDate getDate_dataNascPi() {
        return date_dataNascPi;
    }

    public void setDate_dataNascPi(SelectInputDate sid) {
        this.date_dataNascPi = sid;
    }
    private HtmlInputText nacionalidadePi_inputText2 = new HtmlInputText();

    public HtmlInputText getNacionalidadePi_inputText2() {
        return nacionalidadePi_inputText2;
    }

    public void setNacionalidadePi_inputText2(HtmlInputText hit) {
        this.nacionalidadePi_inputText2 = hit;
    }
    private HtmlInputText transponder_inputText2 = new HtmlInputText();

    public HtmlInputText getTransponder_inputText2() {
        return transponder_inputText2;
    }

    public void setTransponder_inputText2(HtmlInputText hit) {
        this.transponder_inputText2 = hit;
    }
    private HtmlInputTextarea descricaoPi_inputText2 = new HtmlInputTextarea();

    public HtmlInputTextarea getDescricaoPi_inputText2() {
        return descricaoPi_inputText2;
    }

    public void setDescricaoPi_inputText2(HtmlInputTextarea hit) {
        this.descricaoPi_inputText2 = hit;
    }

    private DefaultSelectedData equipasPiSelectOneMenu1Bean = new DefaultSelectedData();
    private DefaultSelectionItems equipasPiSelectOneMenu1DefaultItems = new DefaultSelectionItems();
    private HtmlSelectOneMenu equipasPiSelectOneMenu1 = new HtmlSelectOneMenu();

    public DefaultSelectedData getEquipasPiSelectOneMenu1Bean() {
        return equipasPiSelectOneMenu1Bean;
    }

    public void setEquipasPiSelectOneMenu1Bean(DefaultSelectedData equipasPiSelectOneMenu1Bean) {
        this.equipasPiSelectOneMenu1Bean = equipasPiSelectOneMenu1Bean;
    }

    public DefaultSelectionItems getEquipasPiSelectOneMenu1DefaultItems() {
        return equipasPiSelectOneMenu1DefaultItems;
    }

    public void setEquipasPiSelectOneMenu1DefaultItems(DefaultSelectionItems equipasPiSelectOneMenu1DefaultItems) {
        this.equipasPiSelectOneMenu1DefaultItems = equipasPiSelectOneMenu1DefaultItems;
    }

    public HtmlSelectOneMenu getEquipasPiSelectOneMenu1() {
        return equipasPiSelectOneMenu1;
    }

    public void setEquipasPiSelectOneMenu1(HtmlSelectOneMenu equipasPiSelectOneMenu1) {
        this.equipasPiSelectOneMenu1 = equipasPiSelectOneMenu1;
    }
    private HtmlCommandLink commandLink65 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink65() {
        return commandLink65;
    }

    public void setCommandLink65(HtmlCommandLink hcl) {
        this.commandLink65 = hcl;
    }
    private HtmlCommandLink commandLink125 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink125() {
        return commandLink125;
    }

    public void setCommandLink125(HtmlCommandLink hcl) {
        this.commandLink125 = hcl;
    }
    private HtmlCommandLink commandLink7 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink7() {
        return commandLink7;
    }

    public void setCommandLink7(HtmlCommandLink hcl) {
        this.commandLink7 = hcl;
    }
    private HtmlCommandLink commandLink8 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink8() {
        return commandLink8;
    }

    public void setCommandLink8(HtmlCommandLink hcl) {
        this.commandLink8 = hcl;
    }
    private HtmlCommandLink commandLink9 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink9() {
        return commandLink9;
    }

    public void setCommandLink9(HtmlCommandLink hcl) {
        this.commandLink9 = hcl;
    }
    private HtmlCommandLink commandLink13 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink13() {
        return commandLink13;
    }

    public void setCommandLink13(HtmlCommandLink hcl) {
        this.commandLink13 = hcl;
    }
    private HtmlCommandLink commandLink14 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink14() {
        return commandLink14;
    }

    public void setCommandLink14(HtmlCommandLink hcl) {
        this.commandLink14 = hcl;
    }
    private HtmlCommandLink commandLink15 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink15() {
        return commandLink15;
    }

    public void setCommandLink15(HtmlCommandLink hcl) {
        this.commandLink15 = hcl;
    }

    private InputFile inputFilePi = new InputFile();
    private byte[] imagemPi = null;
    private HtmlGraphicImage graphicImagePi = new HtmlGraphicImage();

    public HtmlGraphicImage getGraphicImagePi() {
        return graphicImagePi;
    }

    public void setGraphicImagePi(HtmlGraphicImage graphicImagePi) {
        this.graphicImagePi = graphicImagePi;
    }

    public byte[] getImagemPi() {
        return imagemPi;
    }

    public void setImagemPi(byte[] imagemPi) {
        this.imagemPi = imagemPi;
    }

    public InputFile getInputFilePi() {
        return inputFilePi;
    }

    public void setInputFilePi(InputFile inputFilePi) {
        this.inputFilePi = inputFilePi;
    }




    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Gestor() {
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


        circuitoEvSelectOneMenu1DefaultItems.clear();
        eventosSelectOneMenu1DefaultItems.clear();
        refreshCampsDropDowns();
        
        refreshCircuitosDropDown();
        
        refreshEquipasDropDown();
        refreshCampsEqDropDowns();

        refreshPilotosDropDown();
        refreshEquipasPiDropDown();
        dataTable1.setStyle("visibility: hidden");
        dataTable2.setStyle("visibility: hidden");
        commandLink65.setDisabled(true);
        commandLink125.setDisabled(true);
        campeonatoEqSelectOneMenu1.setDisabled(true);
        selectBooleanCheckbox1.setDisabled(true);
        equipasPiSelectOneMenu1.setDisabled(true);
        commandLink7.setDisabled(true);
        commandLink8.setDisabled(true);
        commandLink9.setDisabled(true);
        commandLink13.setDisabled(true);
        commandLink14.setDisabled(true);
        commandLink15.setDisabled(true);


    }


    public void refreshCampsDropDowns(){
        campeonatosSelectOneMenu1DefaultItems.clear();
        campeonatosSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        campeonatosSelectOneMenu1DefaultItems.add(new SelectItem("*novo...","*novo..."));
        for(Campeonato c : gcr.getCampeonatos())
            campeonatosSelectOneMenu1DefaultItems.add(new SelectItem(c.getDesignacao(),c.getDesignacao()));

        circuitoEvSelectOneMenu1DefaultItems.clear();
        circuitoEvSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        for(Circuito cir : gcr.getCircuitos())
            circuitoEvSelectOneMenu1DefaultItems.add(new SelectItem(cir.getNome(),cir.getNome()));
        dataTable1.setStyle("visibility: hidden");
    }

    public void refreshEventosDropDown(){
        if(campeonatoSeleccionado==null) return;
        eventosSelectOneMenu1DefaultItems.clear();
        eventosSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        eventosSelectOneMenu1DefaultItems.add(new SelectItem("*novo...","*novo..."));
        for(Evento e : gcr.getEventos(campeonatoSeleccionado.getDesignacao()))
            eventosSelectOneMenu1DefaultItems.add(new SelectItem(e.getDesignacao(),e.getDesignacao()));
        dataTable1.setStyle("visibility: hidden");
    }

    public void refreshCircuitosDropDown(){
        circuitosSelectOneMenu1DefaultItems.clear();
        circuitosSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        circuitosSelectOneMenu1DefaultItems.add(new SelectItem("*novo...","*novo..."));
        for(Circuito c : gcirr.getCircuitos())
            circuitosSelectOneMenu1DefaultItems.add(new SelectItem(c.getNome(),c.getNome()));
        dataTable2.setStyle("visibility: hidden");
    }
    
    public void refreshEquipasDropDown(){
        equipasSelectOneMenu1DefaultItems.clear();
        equipasSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        equipasSelectOneMenu1DefaultItems.add(new SelectItem("*novo...","*novo..."));
        for(Equipa e : ger.getEquipas())
            equipasPiSelectOneMenu1DefaultItems.add(new SelectItem(e.getNome(),e.getNome()));
    }

    public void refreshCampsEqDropDowns(){
        campeonatoEqSelectOneMenu1DefaultItems.clear();
        campeonatoEqSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        for(Campeonato c : ger.getCampeonatos())
            campeonatoEqSelectOneMenu1DefaultItems.add(new SelectItem(c.getDesignacao(),c.getDesignacao()));
    }

    public void refreshPilotosDropDown(){
        pilotosSelectOneMenu1DefaultItems.clear();
        pilotosSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        pilotosSelectOneMenu1DefaultItems.add(new SelectItem("*novo...","*novo..."));
        for(Piloto p : gpr.getPilotos())
            pilotosSelectOneMenu1DefaultItems.add(new SelectItem(p.getNome(),p.getNome()));
    }

    public void refreshEquipasPiDropDown(){
        equipasPiSelectOneMenu1DefaultItems.clear();
        equipasPiSelectOneMenu1DefaultItems.add(new SelectItem("",""));
        for(Equipa e : gpr.getEquipas())
            equipasPiSelectOneMenu1DefaultItems.add(new SelectItem(e.getNome(),e.getNome()));
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
    protected GestorSessionBean getGestorSessionBean() { return (GestorSessionBean) getBean("GestorSessionBean"); }


    /////////////////GERIR CAMPEONATOS//////////////////////////////////////////

    private Campeonato campeonatoSeleccionado = null;

    //Criar Campeonato
    public void commandLink1_action() {
        try {
            campeonatoSeleccionado = new Campeonato();
            campeonatoSeleccionado.setDesignacao((String) campDesigna.getText());
            campeonatoSeleccionado.setAnoInicio(new Integer((String) campAnoInic.getText()));
            gcr.save(campeonatoSeleccionado);
            cleanEventos();
            cleanCampeonatos();
            refreshCampsDropDowns();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //Editar Campeonato
    public void commandLink3_action() {
        try {
            campeonatoSeleccionado.setDesignacao((String) campDesigna.getValue());
            campeonatoSeleccionado.setAnoInicio(new Integer((String) campAnoInic.getValue()));
            gcr.save(campeonatoSeleccionado);
            refreshCampsDropDowns();
        } catch(Exception ex){}
    }

    //Remover Campeonato
    public void commandLink2_action() {
        try {
            gcr.remove(campeonatoSeleccionado);
            cleanEventos();
            cleanCampeonatos();
            refreshCampsDropDowns();
        } catch(Exception ex){}
    }


    private Evento eventoSeleccionado = null;

    //Criar Evento
    public void commandLink4_action() {
        try {
            eventoSeleccionado = new Evento();
            eventoSeleccionado.setDesignacao(designacao_inputText1.getText());
            eventoSeleccionado.setData((Date) eventoDate1.getValue());
            //eventoSeleccionado.setNumeroVoltas(new Integer((String) numerovoltas_inputText1.getValue()));
            eventoSeleccionado.setDistanciaTotalKm(new Float((String) dtotal_inputText1.getValue()));
            eventoSeleccionado.setCircuito( gcr.getCircuito(circuitoEvSelectOneMenu1Bean.getSelectedItem()) );
            eventoSeleccionado.setCorrida(new Corrida());
            eventoSeleccionado.getCorrida().setData((Date) date3_corrida.getValue());
            eventoSeleccionado.setQualificacao(new Qualificacao());
            eventoSeleccionado.getQualificacao().setData((Date) date3_qualificacao.getValue());
            eventoSeleccionado.setCampeonato(campeonatoSeleccionado);

            gcr.save(eventoSeleccionado);
            cleanEventos();
            refreshEventosDropDown();
            
            Evento ev = gcr.getEventoDeep(designacao_inputText1.getText());
            ev.setNumeroVoltas(new Integer((String) numerovoltas_inputText1.getValue()));
            gcr.save(ev);
        } catch(Exception ex){
        }
    }

    //Editar Evento
    public void commandLink5_action() {
        try {
            eventoSeleccionado.setDesignacao(designacao_inputText1.getText());
            eventoSeleccionado.setData((Date) eventoDate1.getValue());
            eventoSeleccionado.setNumeroVoltas(new Integer((String) numerovoltas_inputText1.getValue()));
            eventoSeleccionado.setDistanciaTotalKm(new Float((String) dtotal_inputText1.getValue()));
            eventoSeleccionado.setCircuito( gcr.getCircuito(circuitoEvSelectOneMenu1Bean.getSelectedItem()) );
            eventoSeleccionado.getCorrida().setData((Date) date3_corrida.getValue());
            eventoSeleccionado.getQualificacao().setData((Date) date3_qualificacao.getValue());
            eventoSeleccionado.setTreinos(treinosSeleccionado);
            gcr.save(eventoSeleccionado);
            refreshEventosDropDown();
        } catch(Exception ex){}
    }

    //Remover Evento
    public void commandLink6_action() {
        try {
            gcr.remove(gcr.getEventoDeep(eventoSeleccionado.getDesignacao()));
            cleanEventos();
            refreshEventosDropDown();
        } catch(Exception ex){}
    }



    private HashSet<Treino> treinosSeleccionado = null;

    //Adicionar Treino
    public void commandLink7_action() {
        try {
            getGestorSessionBean().addListaTreinos(new Treino());
            treinosSeleccionado.clear();
            for(TreinoRow t : getGestorSessionBean().getListaTreinos()) {
                treinosSeleccionado.add(t.getT());
            }

            commandLink5_action();
            dataTable1.setStyle("visibility: visible");
        } catch(Exception ex){}
    }

    //selector Treino
    public void selectorT_processAction(ActionEvent e){
        UICommand uic = (UICommand) e.getComponent();
        getGestorSessionBean().setSelectedT(Integer.parseInt((String) uic.getAttributes().get("title")) -1);
    }

    //Remover Treino
    public String commandLink9_action() {
        try {
            getGestorSessionBean().removeTreino();
            treinosSeleccionado.clear();
            for(TreinoRow t : getGestorSessionBean().getListaTreinos()) {
                treinosSeleccionado.add(t.getT());
            }
            commandLink5_action();
            dataTable1.setStyle("visibility: visible");
        } catch(Exception ex){}
        return null;
    }

    //Editar Treino
    public String commandLink8_action() {
        try {
            commandLink5_action();
            dataTable1.setStyle("visibility: visible");
        } catch(Exception ex){}
        return null;
    }

    //Mostrar Treinos
    public String commandLink65_action(){
        dataTable1.setStyle("visibility: visible");
        commandLink7.setDisabled(false);
        commandLink8.setDisabled(false);
        commandLink9.setDisabled(false);
        getGestorSessionBean().setListaTreinos(new ArrayList<TreinoRow>());
        for(Treino t : treinosSeleccionado) {
            getGestorSessionBean().addListaTreinos(t);
        }
        return null;
    }


    //Campeonato Dropdown
    public void campeonatosSelectOneMenu1_processValueChange(ValueChangeEvent vce) {

        if(vce.getNewValue() == null) {
            campDesigna.changeText("");
            campAnoInic.changeText("");
            cleanEventos();
            cleanCampeonatos();
            eventosSelectOneMenu1DefaultItems.clear();
            eventosSelectOneMenu1DefaultItems.add(new SelectItem("",""));
            return;
        }
        Campeonato c = gcr.getCampeonato((String) vce.getNewValue());
        if(c==null) return;
        campDesigna.changeText(c.getDesignacao());
        campAnoInic.changeText(""+c.getAnoInicio());
        cleanEventos();
        campeonatoSeleccionado = c;

        refreshEventosDropDown();
        
    }


    //Evento Dropdown
    public void eventosSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue() == null){
            cleanEventos();
            return;
        }
        try {
            Evento e = gcr.getEventoDeep((String) vce.getNewValue());
            if(e==null) return;
            designacao_inputText1.changeText(e.getDesignacao());

            eventoDate1.setValue(e.getData());
            numerovoltas_inputText1.changeText(e.getNumeroVoltas()+"");
            dtotal_inputText1.changeText(e.getDistanciaTotalKm()+"");

            circuitoEvSelectOneMenu1Bean.setSelectedItem(e.getCircuito().getNome());
            circuitoEvSelectOneMenu1.resetValue();

            date3_corrida.setValue(e.getCorrida().getData());
            date3_qualificacao.setValue(e.getQualificacao().getData());

            treinosSeleccionado = new HashSet<Treino>(e.getTreinos());

            eventoSeleccionado = e;
            dataTable1.setStyle("visibility: hidden");
            commandLink7.setDisabled(true);
            commandLink8.setDisabled(true);
            commandLink9.setDisabled(true);
            commandLink65.setDisabled(false);
        } catch (Exception ex) {}
        
    }

    public void cleanEventos(){
  /*      designacao_inputText1.resetValue();
        eventoDate1.resetValue();
        numerovoltas_inputText1.resetValue();
        dtotal_inputText1.resetValue();
        circuitoEvSelectOneMenu1Bean.setSelectedItem("");
        circuitoEvSelectOneMenu1.resetValue();
        date3_corrida.resetValue();
        date3_qualificacao.resetValue();
        dataTable1.setStyle("visibility: hidden");
        commandLink65.setDisabled(true);
        commandLink7.setDisabled(true);
        commandLink8.setDisabled(true);
        commandLink9.setDisabled(true);*/
    }

    public void cleanCampeonatos(){
        /*campDesigna.resetValue();
        campAnoInic.resetValue();
        eventosSelectOneMenu1DefaultItems.clear();
        eventosSelectOneMenu1DefaultItems.add(new SelectItem("",""));*/
    }







/////////////////GERIR CIRCUITOS////////////////////////////////////////////



    private Circuito circuitoSeleccionado = null;


    //Criar Circuito
    public String commandLink10_action() {
        try {
            circuitoSeleccionado = new Circuito();
            circuitoSeleccionado.setNome( nome_inputText3.getText() );
            circuitoSeleccionado.setCidade( cidade_inputText3.getText() );
            circuitoSeleccionado.setPais( pais_inputText3.getText() );
            circuitoSeleccionado.setComprimentoKm( new Float(comprimento_inputText3.getText()) );
            circuitoSeleccionado.setLarguraM( new Float(largura_inputText3.getText()) );
            circuitoSeleccionado.setGmt( new Integer(GMT_inputText3.getText()) );
            circuitoSeleccionado.setHomePage( homepage_inputText3.getText() );
            circuitoSeleccionado.setDescricao( (String) descricao_inputText3.getValue());
            circuitoSeleccionado.setLoops(loopsSeleccionado);

            File f = inputFileCi.getFile();
            if(f!=null) {
                imagemCi = new byte[(int) f.length()];
                FileInputStream fis = new FileInputStream(f);
                fis.read(imagemCi);
                circuitoSeleccionado.setImagem(imagemCi);
                graphicImageCi.setValue(imagemCi);
            }

            gcirr.save(circuitoSeleccionado);
            cleanCircuitos();
        refreshCircuitosDropDown();
        } catch(Exception ex){}
        return null;
    }

    //Editar Circuito
    public String commandLink11_action() {
        try {
            circuitoSeleccionado.setNome( nome_inputText3.getText() );
            circuitoSeleccionado.setCidade( cidade_inputText3.getText() );
            circuitoSeleccionado.setPais( pais_inputText3.getText() );
            circuitoSeleccionado.setComprimentoKm( new Float(comprimento_inputText3.getText()) );
            circuitoSeleccionado.setLarguraM( new Float(largura_inputText3.getText()) );
            circuitoSeleccionado.setGmt( new Integer(GMT_inputText3.getText()) );
            circuitoSeleccionado.setHomePage( homepage_inputText3.getText() );
            circuitoSeleccionado.setDescricao( (String) descricao_inputText3.getValue());
            circuitoSeleccionado.setLoops(loopsSeleccionado);

            File f = inputFileCi.getFile();
            if(f!=null) {
                imagemCi = new byte[(int) f.length()];
                FileInputStream fis = new FileInputStream(f);
                fis.read(imagemCi);
                circuitoSeleccionado.setImagem(imagemCi);
                graphicImageCi.setValue(imagemCi);
            }

            gcirr.save(circuitoSeleccionado);
        } catch(Exception ex){}
        return null;
    }

    //Remover Circuito
    public String commandLink12_action() {
        try {
            gcirr.remove(circuitoSeleccionado);
            cleanCircuitos();
            refreshCircuitosDropDown();

        } catch(Exception ex){}
        return null;
    }
    



    private HashSet<Loop> loopsSeleccionado = null;

    //Mostrar Loops
    public String commandLink125_action(){
        dataTable2.setStyle("visibility: visible");
        commandLink13.setDisabled(false);
        commandLink14.setDisabled(false);
        commandLink15.setDisabled(false);
        getGestorSessionBean().setListaLoops(new ArrayList<LoopRow>());
        for(Loop l : loopsSeleccionado) {
            getGestorSessionBean().addListaLoops(l);
        }
        return null;
    }

    //selector Loop
    public void rowSelector1_processAction(RowSelectorEvent rse){
        int selectedRowIndex = rse.getRow();
        getGestorSessionBean().setSelectedL(selectedRowIndex);
    }

    //Adicionar Loop
    public void commandLink13_action() {
        try {
            getGestorSessionBean().addListaLoops(new Loop());
            loopsSeleccionado.clear();
            for(LoopRow t : getGestorSessionBean().getListaLoops()) {
                loopsSeleccionado.add(t.getL());
            }
            commandLink11_action();
        } catch(Exception ex){}
    }

    //Remover Loop
    public void commandLink15_action() {
        try {
            getGestorSessionBean().removeLoop();
            loopsSeleccionado.clear();
            for(LoopRow t : getGestorSessionBean().getListaLoops()) {
                loopsSeleccionado.add(t.getL());
            }
            commandLink11_action();
        } catch(Exception ex){}
    }

    //Editar Loop
    public void commandLink14_action() {
        try {
            commandLink11_action();
        } catch(Exception ex){}
    }



    public void circuitosSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue() == null){
            cleanCircuitos();
            return;
        }
        try {
            Circuito c = gcirr.getCircuito((String) vce.getNewValue());
            if(c==null) return;
            nome_inputText3.changeText( c.getNome() );
            cidade_inputText3.changeText( c.getCidade() );
            pais_inputText3.changeText( c.getPais() );
            comprimento_inputText3.changeText( Float.toString(c.getComprimentoKm()) );
            largura_inputText3.changeText( Float.toString(c.getLarguraM()) );
            GMT_inputText3.changeText( Integer.toString(c.getGmt()) );
            homepage_inputText3.changeText( c.getHomePage() );
            descricao_inputText3.setValue( c.getDescricao() );
            commandLink125.setDisabled(false);
            circuitoSeleccionado = c;

            if(gcirr.getImagem(circuitoSeleccionado)!=null)
                graphicImageCi.setValue(gcirr.getImagem(circuitoSeleccionado));
            else graphicImageCi.setValue("/resources/blank.bmp");

            loopsSeleccionado = new HashSet<Loop>(c.getLoops());

            refreshCircuitosDropDown();

            commandLink13.setDisabled(true);
            commandLink14.setDisabled(true);
            commandLink15.setDisabled(true);
        } catch(Exception ex) {}
    }

    public void cleanCircuitos(){
        /*nome_inputText3.resetValue();
        cidade_inputText3.resetValue();
        pais_inputText3.resetValue();
        comprimento_inputText3.resetValue();
        largura_inputText3.resetValue();
        GMT_inputText3.resetValue();
        homepage_inputText3.resetValue();
        descricao_inputText3.resetValue();
        loopsSeleccionado = new HashSet<Loop>();
        commandLink125.setDisabled(true);
        dataTable2.setStyle("visibility: hidden");
        graphicImageCi.setValue("/resources/blank.bmp");
        commandLink13.setDisabled(true);
        commandLink14.setDisabled(true);
        commandLink15.setDisabled(true);*/
    }



   /////////////////GERIR EQUIPAS//////////////////////////////////////////////

    private Equipa equipaSeleccionado = null;

    //Criar Equipa
    public String commandLink16_action() {
        try {
            equipaSeleccionado = new Equipa();
            equipaSeleccionado.setNome(nomeEq_inputText1.getText());
            equipaSeleccionado.setMotor(motor_inputText1.getText());
            equipaSeleccionado.setChassi(chassi_inputText1.getText());
            equipaSeleccionado.setPneus(peneus_inputText1.getText());
            equipaSeleccionado.setDirector(director_inputText1.getText());
            equipaSeleccionado.setSede(sede_inputText1.getText());
            equipaSeleccionado.setDescricao((String) descricao_inputText1.getValue());

            File f = inputFileEq.getFile();
            if(f!=null) {
                imagemEq = new byte[(int) f.length()];
                FileInputStream fis = new FileInputStream(f);
                fis.read(imagemEq);
                equipaSeleccionado.setImagem(imagemEq);
                graphicImageEq.setValue(imagemEq);
            }

            ger.save(equipaSeleccionado);
            cleanEquipas();
            refreshEquipasDropDown();
            refreshEquipasPiDropDown();
            refreshCampsEqDropDowns();
        } catch(Exception ex){}
        return null;
    }

    //Editar Equipa
    public String commandLink17_action() {
        try {
            equipaSeleccionado.setNome(nomeEq_inputText1.getText());
            equipaSeleccionado.setMotor(motor_inputText1.getText());
            equipaSeleccionado.setChassi(chassi_inputText1.getText());
            equipaSeleccionado.setPneus(peneus_inputText1.getText());
            equipaSeleccionado.setDirector(director_inputText1.getText());
            equipaSeleccionado.setSede(sede_inputText1.getText());
            equipaSeleccionado.setDescricao((String) descricao_inputText1.getValue());

            File f = inputFileEq.getFile();
            if(f!=null) {
                imagemEq = new byte[(int) f.length()];
                FileInputStream fis = new FileInputStream(f);
                fis.read(imagemEq);
                equipaSeleccionado.setImagem(imagemEq);
                graphicImageEq.setValue(imagemEq);
            }

            ger.save(equipaSeleccionado);

            refreshEquipasDropDown();
            refreshEquipasPiDropDown();
            refreshCampsEqDropDowns();
        } catch(Exception ex){}
        return null;
    }

    //Remover Equipa
    public String commandLink18_action() {
        try {
            ger.remove(equipaSeleccionado);
            cleanEquipas();
            refreshEquipasDropDown();
            refreshEquipasPiDropDown();
            refreshCampsEqDropDowns();
        } catch(Exception ex){}
        return null;
    }


    public void equipasSelectOneMenu1_processValueChange(ValueChangeEvent vce) {

        if(vce.getNewValue() == null){
            cleanEquipas();
            return;
        }
        try {
            Equipa e = ger.getEquipaDeep((String) vce.getNewValue());

            nomeEq_inputText1.changeText(e.getNome());
            motor_inputText1.changeText(e.getMotor());
            chassi_inputText1.changeText(e.getChassi());
            peneus_inputText1.changeText(e.getPneus());
            director_inputText1.changeText(e.getDirector());
            sede_inputText1.changeText(e.getSede());
            descricao_inputText1.setValue(e.getDescricao());

            ArrayList<String> Lpilotos = new ArrayList<String>();
            for(Piloto p : e.getPilotos())
                Lpilotos.add(p.getNome());
            getGestorSessionBean().setListaPilotos(Lpilotos);
            campeonatoEqSelectOneMenu1.setDisabled(false);
            equipaSeleccionado = e;

            if(ger.getImagem(equipaSeleccionado)!=null)
                graphicImageEq.setValue(ger.getImagem(equipaSeleccionado));
            else graphicImageEq.setValue("/resources/blank.bmp");

        } catch(Exception ex) {}
        //refreshEquipasDropDown();
        //refreshEquipasPiDropDown();
    }

    public void campeonatoEqSelectOneMenu1_processValueChange(ValueChangeEvent vce) {

        if(vce.getNewValue() == null){
            selectBooleanCheckbox1Bean.setSelectedBoolean(false);
            selectBooleanCheckbox1.resetValue();
            selectBooleanCheckbox1.setDisabled(true);
            return;
        }

        for(Campeonato c : equipaSeleccionado.getCampeonatos()) {
            if(c.getDesignacao().equals((String) vce.getNewValue())) {
                selectBooleanCheckbox1Bean.setSelectedBoolean(true);
                selectBooleanCheckbox1.resetValue();
                selectBooleanCheckbox1.setDisabled(false);
                return;
            }
        }

        selectBooleanCheckbox1Bean.setSelectedBoolean(false);
        selectBooleanCheckbox1.resetValue();

    }


    public void selectBooleanCheckbox1_processValueChange(ValueChangeEvent vce) {
        Campeonato camp = ger.getCampeonato((String) campeonatoEqSelectOneMenu1Bean.getSelectedItem());

        HashSet<Equipa> equipas = new HashSet<Equipa>(camp.getEquipas());

        if( (Boolean) vce.getNewValue() ) {
            equipas.add(equipaSeleccionado);
        }
        else {
            Equipa e_rem = null;
            for(Equipa e : equipas)
                if(e.getNome().equals(equipaSeleccionado.getNome()))
                    e_rem = e;
            if(e_rem!=null) equipas.remove(e_rem);
        }

        camp.setEquipas(equipas);
        gcr.save(camp);

        equipaSeleccionado = ger.getEquipaDeep(equipaSeleccionado.getNome());

        refreshCampsEqDropDowns();
    }


    public void cleanEquipas(){
      /*  nomeEq_inputText1.resetValue();
        motor_inputText1.resetValue();
        chassi_inputText1.resetValue();
        peneus_inputText1.resetValue();
        director_inputText1.resetValue();
        sede_inputText1.resetValue();
        descricao_inputText1.resetValue();
        campeonatoEqSelectOneMenu1Bean.setSelectedItem("");
        campeonatoEqSelectOneMenu1.resetValue();
        campeonatoEqSelectOneMenu1.setDisabled(true);
        selectBooleanCheckbox1Bean.setSelectedBoolean(false);
        selectBooleanCheckbox1.resetValue();
        selectBooleanCheckbox1.setDisabled(true);
        graphicImageEq.setValue("/resources/blank.bmp");
        ArrayList<String> Lpilotos = new ArrayList<String>();
        getGestorSessionBean().setListaPilotos(Lpilotos);*/
    }



   /////////////////GERIR PILOTOS//////////////////////////////////////////////



    private Piloto pilotoSeleccionado = null;


    //Criar Piloto
    public String commandLink19_action() {
        try{
            pilotoSeleccionado = new Piloto();
            pilotoSeleccionado.setNome(nomePi_inputText2.getText());
            pilotoSeleccionado.setDataNascimento((Date) date_dataNascPi.getValue());
            pilotoSeleccionado.setNacionalidade(nacionalidadePi_inputText2.getText());

            if(!gpr.availableTransponder(transponder_inputText2.getText())) return null;

            Transponder trans = gpr.getTransponder(transponder_inputText2.getText());

            if(trans==null) {
                trans = new Transponder();
                trans.setRef(transponder_inputText2.getText());
            }

            pilotoSeleccionado.setTransponder(trans);

            pilotoSeleccionado.setDescricao((String) descricaoPi_inputText2.getValue());

            Equipa e = ger.getEquipa(equipasPiSelectOneMenu1Bean.getSelectedItem());
            pilotoSeleccionado.setEquipa_actual(e);

            File f = inputFilePi.getFile();
            if(f!=null) {
                imagemPi = new byte[(int) f.length()];
                FileInputStream fis = new FileInputStream(f);
                fis.read(imagemPi);
                pilotoSeleccionado.setImagem(imagemPi);
                graphicImagePi.setValue(imagemPi);
            }

            gpr.addPiloto(pilotoSeleccionado);
            cleanPilotos();
            refreshPilotosDropDown();
        } catch(Exception ex) {}
        return null;
    }

    //Editar Piloto
    public String commandLink20_action() {
        try {
            pilotoSeleccionado.setNome(nomePi_inputText2.getText());
            pilotoSeleccionado.setDataNascimento((Date) date_dataNascPi.getValue());
            pilotoSeleccionado.setNacionalidade(nacionalidadePi_inputText2.getText());
            Transponder trans = new Transponder();
            trans.setRef(transponder_inputText2.getText());
            pilotoSeleccionado.setTransponder(trans);

            pilotoSeleccionado.setDescricao((String) descricaoPi_inputText2.getValue());

            Equipa e = ger.getEquipa(equipasPiSelectOneMenu1Bean.getSelectedItem());
            pilotoSeleccionado.setEquipa_actual(e);

            File f = inputFilePi.getFile();
            if(f!=null) {
                imagemPi = new byte[(int) f.length()];
                FileInputStream fis = new FileInputStream(f);
                fis.read(imagemPi);
                pilotoSeleccionado.setImagem(imagemPi);
                graphicImagePi.setValue(imagemPi);
            }

            gpr.editPiloto(pilotoSeleccionado);
            refreshPilotosDropDown();
        } catch(Exception ex) {}
        return null;
    }

    //Remover Piloto
    public String commandLink21_action() {
        try {
            gpr.remPiloto(pilotoSeleccionado);
            cleanPilotos();
            refreshPilotosDropDown();
        } catch(Exception ex) {}
        return null;
    }


    public void pilotosSelectOneMenu1_processValueChange(ValueChangeEvent vce) {
        if(vce.getNewValue() == null){
            cleanPilotos();
            return;
        }
        try {
        Piloto p = gpr.getPiloto((String) vce.getNewValue());
        if(p==null) return;

        nomePi_inputText2.changeText(p.getNome());
        date_dataNascPi.setValue(p.getDataNascimento());
        nacionalidadePi_inputText2.changeText(p.getNacionalidade());
        if(p.getTransponder()!=null) transponder_inputText2.changeText(p.getTransponder().getRef());
        descricaoPi_inputText2.setValue(p.getDescricao());
        Equipa e = p.getEquipa_actual();
        if(e==null) return;
        equipasPiSelectOneMenu1Bean.setSelectedItem(e.getNome());
        equipasPiSelectOneMenu1.resetValue();
        equipasPiSelectOneMenu1.setDisabled(false);
        pilotoSeleccionado = p;

        if(gpr.getImagem(pilotoSeleccionado)!=null)
            graphicImagePi.setValue(gpr.getImagem(pilotoSeleccionado));
        else graphicImagePi.setValue("/resources/blank.bmp");

        refreshPilotosDropDown();
        } catch(Exception ex) {}
    }

    public void cleanPilotos(){
    /*    nomePi_inputText2.resetValue();
        date_dataNascPi.resetValue();
        nacionalidadePi_inputText2.resetValue();
        transponder_inputText2.resetValue();
        descricaoPi_inputText2.resetValue();
        equipasPiSelectOneMenu1Bean.setSelectedItem("");
        equipasPiSelectOneMenu1.resetValue();
        pilotosSelectOneMenu1Bean.setSelectedItem("");
        pilotosSelectOneMenu1.resetValue();
        graphicImagePi.setValue("/resources/blank.bmp");
        equipasPiSelectOneMenu1.setDisabled(true);*/
    }

}

