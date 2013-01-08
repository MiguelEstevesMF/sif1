<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : 28/Jun/2009, 22:21:37
    Author     : Miguel
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <ice:outputStyle href="./resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="./xmlhttp/css/xp/xp.css" id="outputStyle2"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style=" height: 766px; left: 0px; top: 0px; position: absolute; width: 1078px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Gestor"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 573px; left: 192px; top: 168px; position: absolute; width: 861px; -rave-layout: grid">
                            <ice:panelLayout id="gerir_panelLayout" layout="flow"
                                style="height: 549px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 837px; -rave-layout: grid" visible="true">
                                <ice:panelTabSet id="panelTabSet1" selectedIndex="1" style="left: 0px; top: 0px; position: absolute" tabPlacement="Top">
                                    <ice:panelTab id="campeonato_panelTab1" label="Campeonato">
                                        <ice:panelLayout id="panelLayout1" layout="flow" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="panelLayout5" layout="flow" style="background-color: rgb(237, 234, 234); font-size: 11px; height: 476px; position: absolute; width: 119px; -rave-layout: grid">
                                                <hr style="left: 0px; top: -7px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink1_action}" id="commandLink1"
                                                    style="left: 9px; top: 6px; position: absolute" value="Criar Campeonato"/>
                                                <ice:commandLink action="#{Gestor.commandLink3_action}" id="commandLink3"
                                                    style="left: 9px; top: 29px; position: absolute" value="Editar Campeonato"/>
                                                <ice:commandLink action="#{Gestor.commandLink2_action}" id="commandLink2"
                                                    style="left: 9px; top: 49px; position: absolute" value="Remover Campeonato"/>
                                                <hr style="left: 0px; top: 110px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink4_action}" id="commandLink4"
                                                    style="left: 9px; top: 134px; position: absolute" value="Adicionar Evento"/>
                                                <ice:commandLink action="#{Gestor.commandLink5_action}" id="commandLink5"
                                                    style="left: 9px; top: 154px; position: absolute" value="Editar Evento"/>
                                                <ice:commandLink action="#{Gestor.commandLink6_action}" id="commandLink6"
                                                    style="left: 9px; top: 174px; position: absolute" value="Remover Evento"/>
                                                <hr style="left: 0px; top: 354px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink65_action}" binding="#{Gestor.commandLink65}" id="commandLink65"
                                                    style="left: 9px; top: 379px; position: absolute" value="Mostrar Treinos"/>
                                                <ice:commandLink action="#{Gestor.commandLink7_action}" id="commandLink7"
                                                    style="left: 9px; top: 399px; position: absolute" value="Adicionar Treino"/>
                                                <ice:commandLink action="#{Gestor.commandLink8_action}" id="commandLink8"
                                                    style="left: 9px; top: 419px; position: absolute" value="Editar Treino"/>
                                                <ice:commandLink action="#{Gestor.commandLink9_action}" id="commandLink9"
                                                    style="left: 9px; top: 439px; position: absolute" value="Remover Treino"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout6" layout="flow" style="height: 95px; left: 133px; top: 6px; position: absolute; width: 317px; -rave-layout: grid">
                                                <ice:selectOneMenu binding="#{Gestor.campeonatosSelectOneMenu1}" id="campeonatosDropDown" partialSubmit="true"
                                                    style="left: -1px; top: 1px; position: absolute"
                                                    value="#{Gestor.campeonatosSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Gestor.campeonatosSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Gestor.campeonatosSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputText id="outputText1" style="left: 0px; top: 48px; position: absolute" value="Designação:"/>
                                                <ice:inputText binding="#{Gestor.campDesigna}" id="campDesigna" style="left: 144px; top: 46px; position: absolute; width: 150px"/>
                                                <ice:outputText id="outputText2" style="left: 0px; top: 72px; position: absolute" value="Ano de início:"/>
                                                <ice:inputText binding="#{Gestor.campAnoInic}" id="campAnoInic" style="left: 144px; top: 70px; position: absolute; width: 150px"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout7" layout="flow" style="height: 219px; left: 133px; top: 138px; position: absolute; width: 320px; -rave-layout: grid">
                                                <ice:selectOneMenu id="selectOneMenu2" partialSubmit="true" style="left: -1px; top: 1px; position: absolute"
                                                    value="#{Gestor.eventosSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Gestor.eventosSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Gestor.eventosSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:panelLayout id="evento_panelLayout1" layout="flow"
                                                    style="left: 0px; top: 48px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                    <ice:outputText id="designacao_outputText1" style="left: 0px; top: 0px; position: absolute" value="Designação:"/>
                                                    <ice:inputText binding="#{Gestor.designacao_inputText1}" id="designacao_inputText1" style="left: 144px; top: 0px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="data_outputText1" style="left: 0px; top: 25px; position: absolute" value="Data:"/>
                                                    <ice:selectInputDate binding="#{Gestor.eventoDate1}" id="eventoDate1" popupDateFormat="dd/MM/yyyy"
                                                        renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                                        style="font-size: 10px; left: 144px; top: 25px; position: absolute" visible="true">
                                                        <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                                    </ice:selectInputDate>
                                                    <ice:outputText id="numerovoltas_outputText1" style="left: 0px; top: 50px; position: absolute" value="Número de voltas:"/>
                                                    <ice:inputText binding="#{Gestor.numerovoltas_inputText1}" id="numerovoltas_inputText1" style="left: 144px; top: 50px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="dtotal_outputText1" style="left: 0px; top: 75px; position: absolute" value="Distância total (Km):"/>
                                                    <ice:inputText binding="#{Gestor.dtotal_inputText1}" id="dtotal_inputText1" style="left: 144px; top: 75px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="circuitoEv_outputText1" style="left: 0px; top: 100px; position: absolute" value="Circuito:"/>
                                                    <ice:selectOneMenu binding="#{Gestor.circuitoEvSelectOneMenu1}" id="circuitoEvSelectOneMenu1"
                                                        partialSubmit="true" style="left: 144px; top: 100px; position: absolute" value="#{Gestor.circuitoEvSelectOneMenu1Bean.selectedItem}">
                                                        <f:selectItems id="circuitoEvSelectOneMenu1selectItems1" value="#{Gestor.circuitoEvSelectOneMenu1DefaultItems}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText id="data_outputText3" style="left: 0px; top: 125px; position: absolute" value="Corrida (data):"/>
                                                    <ice:selectInputDate binding="#{Gestor.date3_corrida}" id="date3_corrida" popupDateFormat="dd/MM/yyyy HH:mm"
                                                        renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                                        style="font-size: 10px; left: 144px; top: 125px; position: absolute" visible="true">
                                                        <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                                    </ice:selectInputDate>
                                                    <ice:outputText id="data_outputText4" style="left: 0px; top: 150px; position: absolute" value="Qualificação (data):"/>
                                                    <ice:selectInputDate binding="#{Gestor.date3_qualificacao}" id="date3_qualificacao"
                                                        popupDateFormat="dd/MM/yyyy HH:mm" renderAsPopup="true" renderMonthAsDropdown="true"
                                                        renderYearAsDropdown="true" style="font-size: 10px; left: 144px; top: 150px; position: absolute" visible="true">
                                                        <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                                    </ice:selectInputDate>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout11" layout="flow" style="height: 219px; left: 123px; top: 395px; position: absolute; width: 320px; -rave-layout: grid">
                                                <ice:panelLayout id="treino_panelLayout3" layout="flow"
                                                    style="left: 0px; top: 0px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                    <ice:dataTable binding="#{Gestor.dataTable1}" id="dataTable1" rowClasses="oddRow, evenRow"
                                                        style="cursor:default; position: absolute" value="#{GestorSessionBean.listaTreinos}" var="currentRow">
                                                        <ice:column id="column1" style="#{currentRow.activestyle}">
                                                            <ice:commandLink id="l1" actionListener="#{Gestor.selectorT_processAction}" title="#{currentRow.treino}">
                                                                <ice:outputText id="outputText3" value="#{currentRow.treino}"/>
                                                            </ice:commandLink>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText4" value="Treino"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column2" style="#{currentRow.activestyle}">
                                                            <ice:selectInputDate id="d1" popupDateFormat="dd/MM/yyyy HH:mm" renderAsPopup="true"
                                                                renderMonthAsDropdown="true" renderYearAsDropdown="true" style="font-size: 10px;;"
                                                                value="#{currentRow.data}" visible="true">
                                                                <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                                            </ice:selectInputDate>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText6" value="Data"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                    <ice:panelTab id="circuito_panelTab2" label="Circuito">
                                        <ice:panelLayout id="panelLayout2" layout="flow" style="height: 453px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="panelLayout8" layout="flow" style="background-color: rgb(237, 234, 234); font-size: 11px; height: 476px; position: absolute; width: 119px; -rave-layout: grid">
                                                <hr style="left: 0px; top: -7px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink10_action}" id="commandLink10"
                                                    style="left: 9px; top: 6px; position: absolute" value="Criar Cricuito"/>
                                                <ice:commandLink action="#{Gestor.commandLink11_action}" id="commandLink11"
                                                    style="left: 9px; top: 29px; position: absolute" value="Editar Cricuito"/>
                                                <ice:commandLink action="#{Gestor.commandLink12_action}" id="commandLink12"
                                                    style="left: 9px; top: 49px; position: absolute" value="Remover Cricuito"/>
                                                <hr style="left: 0px; top: 355px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink125_action}" binding="#{Gestor.commandLink125}" id="commandLink125"
                                                    style="left: 9px; top: 368px; position: absolute" value="Mostrar Loops"/>
                                                <ice:commandLink action="#{Gestor.commandLink13_action}" id="commandLink13"
                                                    style="left: 9px; top: 388px; position: absolute" value="Adicionar Loop"/>
                                                <ice:commandLink action="#{Gestor.commandLink14_action}" id="commandLink14"
                                                    style="left: 9px; top: 408px; position: absolute" value="Editar Loop"/>
                                                <ice:commandLink action="#{Gestor.commandLink15_action}" id="commandLink15"
                                                    style="left: 9px; top: 428px; position: absolute" value="Remover Loop"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout9" layout="flow" style="height: 219px; left: 133px; top: 6px; position: absolute; width: 320px; -rave-layout: grid">
                                                <ice:selectOneMenu binding="#{Gestor.circuitosSelectOneMenu1}" id="selectOneMenu3" partialSubmit="true"
                                                    style="left: -1px; top: 1px; position: absolute" value="#{Gestor.circuitosSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Gestor.circuitosSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{Gestor.circuitosSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:panelLayout id="circuito_panelLayout3" layout="flow"
                                                    style="left: 0px; top: 48px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                    <ice:outputText id="nome_outputText3" style="left: 0px; top: 0px; position: absolute" value="Nome:"/>
                                                    <ice:inputText binding="#{Gestor.nome_inputText3}" id="nome_inputText3" style="left: 144px; top: 0px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="cidade_outputText3" style="left: 0px; top: 25px; position: absolute" value="País:"/>
                                                    <ice:inputText binding="#{Gestor.cidade_inputText3}" id="cidade_inputText3" style="left: 144px; top: 25px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="pais_outputText3" style="left: 0px; top: 50px; position: absolute" value="Cidade:"/>
                                                    <ice:inputText binding="#{Gestor.pais_inputText3}" id="pais_inputText3" style="left: 144px; top: 50px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="comprimento_outputText3" style="left: 0px; top: 75px; position: absolute" value="Comprimento (Km):"/>
                                                    <ice:inputText binding="#{Gestor.comprimento_inputText3}" id="comprimento_inputText3" style="left: 144px; top: 75px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="largura_outputText3" style="left: 0px; top: 100px; position: absolute" value="Largura (m):"/>
                                                    <ice:inputText binding="#{Gestor.largura_inputText3}" id="largura_inputText3" style="left: 144px; top: 100px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="GMT_outputText3" style="left: 0px; top: 125px; position: absolute" value="GMT:"/>
                                                    <ice:inputText binding="#{Gestor.GMT_inputText3}" id="GMT_inputText3" style="left: 144px; top: 125px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="homepage_outputText3" style="left: 0px; top: 150px; position: absolute" value="Homepage:"/>
                                                    <ice:inputText binding="#{Gestor.homepage_inputText3}" id="homepage_inputText3" style="left: 144px; top: 150px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="descricao_outputText3" style="left: 0px; top: 175px; position: absolute" value="Descrição:"/>
                                                    <ice:inputTextarea binding="#{Gestor.descricao_inputText3}" id="descricao_inputText3" style="left: 144px; top: 175px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="imagemCi_outputText" style="left: 0px; top: 240px; position: absolute" value="Imagem:"/>
                                                    <ice:inputFile binding="#{Gestor.inputFileCi}" id="inputFileCi" style="left: 144px; top: 240px; position: absolute; "/>
                                                    <ice:graphicImage binding="#{Gestor.graphicImageCi}" id="graphicImageCi" value="/resources/blank.bmp"
                                                    style="left: 0px; top: 270px; position: absolute; width: 25px; height: 25px"/>

                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout10" layout="flow" style="height: 219px; left: 133px; top: 398px; position: absolute; width: 320px; -rave-layout: grid">
                                                <ice:panelLayout id="loop_panelLayout2" layout="flow"
                                                    style="left: 0px; top: 48px; position: absolute; visibility: visible; width: 359px; -rave-layout: grid" visible="true"/>
                                                <ice:dataTable binding="#{Gestor.dataTable2}" id="dataTable2" rowClasses="oddRow, evenRow"
                                                    style="cursor:default; position: absolute" value="#{GestorSessionBean.listaLoops}" var="currentRow">
                                                    <ice:column id="column3">
                                                        <ice:rowSelector id="rowSelector1" selectionListener="#{Gestor.rowSelector1_processAction}" value="#{currentRow.selected}"/>
                                                        <ice:inputText disabled="#{currentRow.disabled}" style="width: 150px" value="#{currentRow.descricao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="ref_outputText2" value="Referência"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:inputText disabled="#{currentRow.disabled}" style="width: 150px" value="#{currentRow.posicao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="outputText7" value="Posição (Km)"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                    <ice:panelTab id="equipas_panelTab3" label="Equipas">
                                        <ice:panelLayout id="panelLayout3" style="height: 453px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="panelLayout13" layout="flow" style="background-color: rgb(237, 234, 234); font-size: 11px; height: 476px; position: absolute; width: 119px; -rave-layout: grid">
                                                <hr style="left: 0px; top: -7px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink16_action}" id="commandLink16"
                                                    style="left: 9px; top: 6px; position: absolute" value="Criar Equipa"/>
                                                <ice:commandLink action="#{Gestor.commandLink17_action}" id="commandLink17"
                                                    style="left: 9px; top: 29px; position: absolute" value="Editar Equipa"/>
                                                <ice:commandLink action="#{Gestor.commandLink18_action}" id="commandLink18"
                                                    style="left: 9px; top: 49px; position: absolute" value="Remover Equipa"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout12" layout="flow" style="height: 219px; left: 133px; top: 6px; position: absolute; width: 320px; -rave-layout: grid">
                                                <ice:selectOneMenu binding="#{Gestor.equipasSelectOneMenu1}" id="selectOneMenu6" partialSubmit="true"
                                                    style="left: -1px; top: 1px; position: absolute" value="#{Gestor.equipasSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Gestor.equipasSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems5" value="#{Gestor.equipasPiSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:panelLayout id="equipa_panelLayout1" layout="flow"
                                                    style="left: 0px; top: 48px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                    <ice:outputText id="nomeEq_outputText1" style="left: 0px; top: 0px; position: absolute" value="Nome:"/>
                                                    <ice:inputText binding="#{Gestor.nomeEq_inputText1}" id="nomeEq_inputText1" style="left: 144px; top: 0px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="motor_outputText1" style="left: 0px; top: 25px; position: absolute" value="Motor:"/>
                                                    <ice:inputText binding="#{Gestor.motor_inputText1}" id="motor_inputText1" style="left: 144px; top: 25px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="chassi_outputText1" style="left: 0px; top: 50px; position: absolute" value="Chassi:"/>
                                                    <ice:inputText binding="#{Gestor.chassi_inputText1}" id="chassi_inputText1" style="left: 144px; top: 50px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="peneus_outputText1" style="left: 0px; top: 75px; position: absolute" value="Peneus:"/>
                                                    <ice:inputText binding="#{Gestor.peneus_inputText1}" id="peneus_inputText1" style="left: 144px; top: 75px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="director_outputText1" style="left: 0px; top: 100px; position: absolute" value="Director:"/>
                                                    <ice:inputText binding="#{Gestor.director_inputText1}" id="director_inputText1" style="left: 144px; top: 100px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="sede_outputText1" style="left: 0px; top: 125px; position: absolute" value="Sede:"/>
                                                    <ice:inputText binding="#{Gestor.sede_inputText1}" id="sede_inputText1" style="left: 144px; top: 125px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="descricao_outputText1" style="left: 0px; top: 150px; position: absolute" value="Descrição:"/>
                                                    <ice:inputTextarea binding="#{Gestor.descricao_inputText1}" id="descricao_inputText1" style="left: 144px; top: 150px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="campeonatoAc_outputText1" style="left: 0px; top: 230px; position: absolute;" value="Inscrito em:"/>
                                                    <ice:selectBooleanCheckbox binding="#{Gestor.selectBooleanCheckbox1}" id="selectBooleanCheckbox1"
                                                        partialSubmit="true" style="left: 144px; top: 233px; position: absolute;"
                                                        value="#{Gestor.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Gestor.selectBooleanCheckbox1_processValueChange}"/>
                                                    <ice:selectOneMenu binding="#{Gestor.campeonatoEqSelectOneMenu1}" id="pilotos_selectOneMenu6"
                                                        partialSubmit="true" style="left: 163px; top: 230px; position: absolute"
                                                        value="#{Gestor.campeonatoEqSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Gestor.campeonatoEqSelectOneMenu1_processValueChange}">
                                                        <f:selectItems id="pilotos_selectOneMenu1selectItems5" value="#{Gestor.campeonatoEqSelectOneMenu1DefaultItems}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText id="imagemEq_outputText" style="left: 0px; top: 270px; position: absolute" value="Imagem:"/>
                                                    <ice:inputFile binding="#{Gestor.inputFileEq}" id="inputFileEq" style="left: 144px; top: 270px; position: absolute; "/>
                                                    <ice:graphicImage binding="#{Gestor.graphicImageEq}" id="graphicImageEq" value="/resources/blank.bmp"
                                                    style="left: 0px; top: 300px; position: absolute; width: 25px; height: 25px"/>

                                                    <ice:dataTable id="dataTable3" rowClasses="oddRow, evenRow"
                                                        style="left: 0px; top: 380px; position: absolute" value="#{GestorSessionBean.listaPilotos}" var="currentRow">
                                                        <ice:column id="column5">
                                                            <ice:outputText value="#{currentRow}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText value="Pilotos"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                    <ice:panelTab id="pilotos_panelTab4" label="Pilotos">
                                        <ice:panelLayout id="panelLayout4" style="height: 453px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="panelLayout14" layout="flow" style="background-color: rgb(237, 234, 234); font-size: 11px; height: 476px; position: absolute; width: 119px; -rave-layout: grid">
                                                <hr style="left: 0px; top: -7px; position: relative; color: silver"/>
                                                <ice:commandLink action="#{Gestor.commandLink19_action}" id="commandLink19"
                                                    style="left: 9px; top: 6px; position: absolute" value="Criar Piloto"/>
                                                <ice:commandLink action="#{Gestor.commandLink20_action}" id="commandLink20"
                                                    style="left: 9px; top: 29px; position: absolute" value="Editar Piloto"/>
                                                <ice:commandLink action="#{Gestor.commandLink21_action}" id="commandLink21"
                                                    style="left: 9px; top: 49px; position: absolute" value="Remover Piloto"/>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="panelLayout15" layout="flow" style="height: 219px; left: 133px; top: 6px; position: absolute; width: 320px; -rave-layout: grid">
                                                <ice:selectOneMenu binding="#{Gestor.pilotosSelectOneMenu1}" id="pilotos_selectOneMenu7" partialSubmit="true"
                                                    style="left: -1px; top: 1px; position: absolute" value="#{Gestor.pilotosSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Gestor.pilotosSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="pilotos_selectOneMenu1selectItems6" value="#{Gestor.pilotosSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:panelLayout id="piloto_panelLayout2" layout="flow"
                                                    style="left: 0px; top: 48px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                    <ice:outputText id="nomePi_outputText2" style="left: 0px; top: 0px; position: absolute" value="Nome:"/>
                                                    <ice:inputText binding="#{Gestor.nomePi_inputText2}" id="nomePi_inputText2" style="left: 144px; top: 0px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="datanasc" style="left: 0px; top: 25px; position: absolute" value="Data de nascimento:"/>
                                                    <ice:selectInputDate binding="#{Gestor.date_dataNascPi}" id="date_dataNascPi" popupDateFormat="dd/MM/yyyy"
                                                        renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                                        style="font-size: 10px; left: 144px; top: 25px; position: absolute" visible="true">
                                                        <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                                    </ice:selectInputDate>
                                                    <ice:outputText id="nacionalidadePi_outputText2" style="left: 0px; top: 50px; position: absolute" value="Nacionalidade:"/>
                                                    <ice:inputText binding="#{Gestor.nacionalidadePi_inputText2}" id="nacionalidadePi_inputText2" style="left: 144px; top: 50px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="transponder_outputText2" style="left: 0px; top: 75px; position: absolute" value="Transponder:"/>
                                                    <ice:inputText binding="#{Gestor.transponder_inputText2}" id="transponder_inputText2" style="left: 144px; top: 75px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="descricaoPi_outputText2" style="left: 0px; top: 100px; position: absolute" value="Descrição:"/>
                                                    <ice:inputTextarea binding="#{Gestor.descricaoPi_inputText2}" id="descricaoPi_inputText2" style="left: 144px; top: 100px; position: absolute; width: 150px"/>
                                                    <ice:outputText id="equipas_outputText2" style="left: 0px; top: 185px; position: absolute" value="Equipa:"/>
                                                    <ice:selectOneMenu binding="#{Gestor.equipasPiSelectOneMenu1}" id="equipas_selectOneMenu1"
                                                        partialSubmit="true" style="left: 144px; top: 185px; position: absolute" value="#{Gestor.equipasPiSelectOneMenu1Bean.selectedItem}">
                                                        <f:selectItems id="equipas_selectOneMenu1selectItems1" value="#{Gestor.equipasPiSelectOneMenu1DefaultItems}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputText id="imagemPi_outputText" style="left: 0px; top: 220px; position: absolute" value="Imagem:"/>
                                                    <ice:inputFile binding="#{Gestor.inputFilePi}" id="inputFilePi" style="left: 144px; top: 220px; position: absolute; "/>
                                                    <ice:graphicImage binding="#{Gestor.graphicImagePi}" id="graphicImagePi" value="/resources/blank.bmp"
                                                    style="left: 0px; top: 250px; position: absolute; width: 25px; height: 25px"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                </ice:panelTabSet>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
