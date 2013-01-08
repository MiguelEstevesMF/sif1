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
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style=" height: 502px; left: 0px; top: 0px; position: absolute; width: 694px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Crono"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 260px; left: 192px; top: 168px; position: absolute; width: 645px; -rave-layout: grid">
                            <ice:panelLayout id="crono_panelLayout" layout="flow"
                                style="height: 118px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 837px; -rave-layout: grid" visible="true">
                                <ice:panelLayout id="panelLayout1" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                    <ice:panelLayout id="Selects_panelLayout5" layout="flow" style="position: absolute; -rave-layout: grid">
                                        <ice:selectOneMenu id="campeonato_selectOneMenu2" partialSubmit="true"
                                            value="#{Crono.campeonatoSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Crono.campeonatoSelectOneMenu1_processValueChange}">
                                            <f:selectItems id="campeonato_selectOneMenu1selectItems1" value="#{Crono.campeonatoSelectOneMenu1DefaultItems}"/>
                                        </ice:selectOneMenu>
                                        <ice:selectOneMenu id="evento_selectOneMenu2" partialSubmit="true"
                                            value="#{Crono.eventoSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Crono.eventoSelectOneMenu1_processValueChange}">
                                            <f:selectItems id="evento_selectOneMenu1selectItems1" value="#{Crono.eventoSelectOneMenu1DefaultItems}"/>
                                        </ice:selectOneMenu>
                                        <ice:selectOneMenu id="sessao_selectOneMenu2" partialSubmit="true"
                                            value="#{Crono.sessaoSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Crono.sessaoSelectOneMenu1_processValueChange}">
                                            <f:selectItems id="sessao_selectOneMenu1selectItems1" value="#{Crono.sessaoSelectOneMenu1DefaultItems}"/>
                                        </ice:selectOneMenu>
                                        <br/>
                                        <ice:commandButton action="#{Crono.start_button1_action}" binding="#{Crono.start_button1}" id="start_button1" value="start"/>
                                        <ice:commandButton action="#{Crono.stop_button2_action}" binding="#{Crono.stop_button2}" id="stop_button2" value="stop"/>
                                        <ice:commandButton action="#{Crono.avancarQ_button3_action}" binding="#{Crono.avancarQ_button3}" id="avancarQ_button3" value="avançar para Q2"/>
                                        <ice:commandButton action="#{Crono.gravar_button4_action}" id="gravar_button2" value="gravar"/>
                                    </ice:panelLayout>
                                    <ice:panelLayout id="tabelaCrono_panelLayout3" layout="flow"
                                        style="left: 0px; top: 60px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                        <ice:dataTable binding="#{Crono.dataTable1_crono}" id="dataTable1_Crono" rowClasses="oddRow, evenRow"
                                            style="cursor:default" value="#{Crono.cronometragemSet}" var="currentRow">
                                            <ice:column id="column1">
                                                <ice:outputText id="o1" value="#{currentRow.regNum}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o2" value="#"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2">
                                                <ice:outputText id="o3" value="#{currentRow.numPiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o4" value="Nº"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3">
                                                <ice:outputText id="o5" style="width:150px;" value="#{currentRow.nomePiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o6" value="Piloto"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4">
                                                <ice:outputText id="o7" style="width:150px;" value="#{currentRow.equipa}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o8" value="Equipa"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5">
                                                <ice:outputText id="o9" value="#{currentRow.transponder_ref}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o10" value="Transponder"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column6">
                                                <ice:outputText id="o11" value="#{currentRow.sector}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o12" value="Sector"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7">
                                                <ice:outputText id="o13" value="#{currentRow.loop_ref}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o14" value="Loop"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8">
                                                <ice:outputText id="o15" value="#{currentRow.tempo2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o16" value="Tempo do Sector"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9">
                                                <ice:outputText id="o17" value="#{currentRow.tempoProva2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o18" value="Tempo total"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10">
                                                <ice:outputText id="o19" style="width:180px;" value="#{currentRow.tempoMedicao2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o20" value="Tempo de Medição"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11">
                                                <ice:outputText id="o21" value="#{currentRow.potenciaSinal}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o22" value="Sinal"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12">
                                                <ice:outputText id="o23" value="#{currentRow.hits}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o24" value="Hits"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column13">
                                                <ice:outputText id="o25" value="#{currentRow.volta}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o26" value="Volta"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column14">
                                                <ice:outputText id="o27" value="#{currentRow.pit}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o28" value="Pit"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
