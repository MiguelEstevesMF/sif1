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
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style=" height: 574px; left: 0px; top: 0px; position: absolute; width: 862px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Resultados"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 381px; left: 192px; top: 168px; position: absolute; width: 645px; -rave-layout: grid">
                            <ice:panelLayout id="resultados_panelLayout" layout="flow"
                                style="height: 549px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 837px; -rave-layout: grid" visible="true">
                                <ice:panelTabSet id="panelTabSet1" selectedIndex="0" style="left: 0px; top: 0px; position: absolute" tabPlacement="Top">
                                    <ice:panelTab id="campeonato_panelTab1" label="Campeonato">
                                        <ice:panelLayout id="panelLayout1" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="SelectsCa_panelLayout5" layout="flow" style="position: absolute; -rave-layout: grid">
                                                <ice:selectOneMenu id="campeonatoCa_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.campeonatoCaSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.campeonatoCaSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="campeonatoCa_selectOneMenu1selectItems1" value="#{Resultados.campeonatoCaSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu id="eventoCa_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.eventoCaSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.eventoCaSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="eventoCa_selectOneMenu1selectItems1" value="#{Resultados.eventoCaSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu id="sessaoCa_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.sessaoCaSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.sessaoCaSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="sessaoCa_selectOneMenu1selectItems1" value="#{Resultados.sessaoCaSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="tabelaResultadosCa_panelLayout3" layout="flow"
                                                style="left: 0px; top: 60px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                <ice:dataTable binding="#{Resultados.dataTable1_CaAllEv}" id="dataTable1_CaAllEv" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaCaAllEv}" var="currentRow">
                                                    <ice:column id="column1">
                                                        <ice:outputText id="o1" value="#{currentRow.evento}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o2" value="Evento"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText id="o3" value="#{currentRow.data2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o4" value="Data"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText id="o5" value="#{currentRow.pilotoVenc}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o6" value="Piloto Vencedor"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText id="o7" value="#{currentRow.voltas}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o8" value="Voltas"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="o9" value="#{currentRow.tempo2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o10" value="Tempo"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>

                                                <ice:dataTable binding="#{Resultados.dataTable1_CaOneEvCorr}" id="dataTable1_CaOneEvCorr" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaCaOneEvCorr}" var="currentRow">

                                                    <ice:column id="column1">
                                                        <ice:outputText id="o11" value="#{currentRow.posicao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o12" value="Posição"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText id="o13" value="#{currentRow.numero}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o14" value="Número"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText id="o15" value="#{currentRow.piloto}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o16" value="Piloto"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText id="o17" value="#{currentRow.equipa}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o18" value="Equipa"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="o19" value="#{currentRow.voltas}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o20" value="Voltas"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText id="o21" value="#{currentRow.tempo2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o22" value="Tempo"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column7">
                                                        <ice:outputText id="o23" value="#{currentRow.grelha}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o24" value="Grelha"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column8">
                                                        <ice:outputText id="o25" value="#{currentRow.pontos}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o26" value="Pontos"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>

                                                <ice:dataTable binding="#{Resultados.dataTable1_CaOneEvQual}" id="dataTable1_CaOneEvQual" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaCaOneEvQual}" var="currentRow">

                                                    <ice:column id="column1">
                                                        <ice:outputText id="o27" value="#{currentRow.posicao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o28" value="Posição"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText id="o29" value="#{currentRow.numero}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o30" value="Número"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText id="o31" value="#{currentRow.piloto}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o32" value="Piloto"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText id="o33" value="#{currentRow.equipa}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o34" value="Equipa"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="o35" value="#{currentRow.q1}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o36" value="Q1"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText id="o37" value="#{currentRow.q2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o38" value="Q2"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column7">
                                                        <ice:outputText id="o39" value="#{currentRow.q3}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o40" value="Q3"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column8">
                                                        <ice:outputText id="o41" value="#{currentRow.voltas}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o42" value="Voltas"/>
                                                        </f:facet>
                                                    </ice:column>

                                                </ice:dataTable>

                                                <ice:dataTable binding="#{Resultados.dataTable1_CaOneEvTreinos}" id="dataTable1_CaOneEvTreinos" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaCaOneEvTreinos}" var="currentRow">

                                                    <ice:column id="column1">
                                                        <ice:outputText id="o43" value="#{currentRow.posicao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o44" value="Posição"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText id="o45" value="#{currentRow.numero}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o46" value="Número"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText id="o47" value="#{currentRow.piloto}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o48" value="Piloto"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText id="o49" value="#{currentRow.equipa}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o50" value="Equipa"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText id="o51" value="#{currentRow.tempo2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o52" value="Tempo da Melhor Volta"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText id="o53" value="#{currentRow.voltas}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText id="o54" value="Voltas"/>
                                                        </f:facet>
                                                    </ice:column>

                                                </ice:dataTable>

                                            </ice:panelLayout>
                                        </ice:panelLayout>

                                    </ice:panelTab>
                                    <ice:panelTab id="equipa_panelTab1" label="Equipa">
                                        <ice:panelLayout id="panelLayout2" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="SelectsEq_panelLayout5" layout="flow" style="position: absolute; -rave-layout: grid">
                                                <ice:selectOneMenu id="campeonatoEq_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.campeonatoEqSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.campeonatoEqSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="campeonatoEq_selectOneMenu1selectItems1" value="#{Resultados.campeonatoEqSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu id="equipaEq_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.equipaEqSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.equipaEqSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="equipaEq_selectOneMenu1selectItems1" value="#{Resultados.equipaEqSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="tabelaResultadosEq_panelLayout3" layout="flow"
                                                style="left: 0px; top: 60px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                <ice:dataTable binding="#{Resultados.dataTable1_EqAll}" id="dataTable1_EqAll" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaEqAll}" var="currentRow">
                                                    <ice:column id="column1">
                                                        <ice:outputText value="#{currentRow.posicao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Posição"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText value="#{currentRow.equipa}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Equipa"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText value="#{currentRow.pontos}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Pontos"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                                <ice:dataTable binding="#{Resultados.dataTable1_EqOne}" id="dataTable1_EqOne" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaEqOne}" var="currentRow">
                                                    <ice:column id="column1">
                                                        <ice:outputText value="#{currentRow.evento}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Evento"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText value="#{currentRow.data2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Data"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText value="#{currentRow.pontos}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Pontos"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                            </ice:panelLayout>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                    <ice:panelTab id="piloto_panelTab1" label="Piloto">
                                        <ice:panelLayout id="panelLayout3" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <ice:panelLayout id="SelectsPi_panelLayout5" layout="flow" style="position: absolute; -rave-layout: grid">
                                                <ice:selectOneMenu id="campeonatoPi_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.campeonatoPiSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.campeonatoPiSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="campeonatoPi_selectOneMenu1selectItems1" value="#{Resultados.campeonatoPiSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu id="pilotoPi_selectOneMenu2" partialSubmit="true"
                                                    value="#{Resultados.pilotoPiSelectOneMenu1Bean.selectedItem}" valueChangeListener="#{Resultados.pilotoPiSelectOneMenu1_processValueChange}">
                                                    <f:selectItems id="pilotoPi_selectOneMenu1selectItems1" value="#{Resultados.pilotoPiSelectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="tabelaResultadosPi_panelLayout3" layout="flow"
                                                style="left: 0px; top: 60px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                <ice:dataTable binding="#{Resultados.dataTable1_PiAll}" id="dataTable1_PiAll" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaPiAll}" var="currentRow">
                                                    <ice:column id="column1">
                                                        <ice:outputText value="#{currentRow.posicao}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Posição"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText value="#{currentRow.piloto}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Piloto"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText value="#{currentRow.nacionalidade}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Nacionalidade"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText value="#{currentRow.equipa}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Equipa"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText value="#{currentRow.pontos}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Pontos"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
                                                <ice:dataTable binding="#{Resultados.dataTable1_PiOne}" id="dataTable1_PiOne" rowClasses="oddRow, evenRow"
                                                    style="cursor:default" value="#{Resultados.listaPiOne}" var="currentRow">
                                                    <ice:column id="column1">
                                                        <ice:outputText value="#{currentRow.evento}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Evento"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column2">
                                                        <ice:outputText value="#{currentRow.data2}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Data"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column3">
                                                        <ice:outputText value="#{currentRow.equipa}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Equipa"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column4">
                                                        <ice:outputText value="#{currentRow.grelhaPartida}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Grelha de Partida"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column5">
                                                        <ice:outputText value="#{currentRow.posicaoFinal}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Posição Final"/>
                                                        </f:facet>
                                                    </ice:column>
                                                    <ice:column id="column6">
                                                        <ice:outputText value="#{currentRow.pontos}"/>
                                                        <f:facet name="header">
                                                            <ice:outputText value="Pontos"/>
                                                        </f:facet>
                                                    </ice:column>
                                                </ice:dataTable>
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
