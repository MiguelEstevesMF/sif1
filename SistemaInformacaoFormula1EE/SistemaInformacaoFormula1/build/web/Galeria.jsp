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
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Galeria"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 573px; left: 192px; top: 168px; position: absolute; width: 861px; -rave-layout: grid">
                            <ice:panelLayout id="gerir_panelLayout" layout="flow"
                                style="height: 549px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 837px; -rave-layout: grid" visible="true">
                                <ice:panelTabSet id="panelTabSet1" style="left: 0px; top: 0px; position: absolute" tabPlacement="Top">
                                    <ice:panelTab id="circuitos_panelTab1" label="Circuitos">
                                        <ice:panelLayout id="panelLayout1" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <table>
                                                <tr>
                                                    <td valign="top">
                                                        <ice:dataTable id="dataTable1" rowClasses="oddRow, evenRow" style="cursor:default" value="#{Galeria.circuitos}" var="currentRow">
                                                            <ice:column id="column1">
                                                                <ice:rowSelector id="rowSelector1" selectionListener="#{Galeria.rowSelector1_processAction}" value="#{currentRow.selected}" />
                                                                <ice:outputText value="#{currentRow.nome}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText value="Nome do circuito"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <f:facet name="footer">
                                                                <ice:panelGroup id="panelGroupCiFooter" style="display: block; text-align:center">
                                                                    <ice:commandLink action="#{Galeria.dataTable1_firstPageActionCi}"
                                                                        binding="#{Galeria.dataTable1HeaderFirstButtonCi}" id="dataTable1HeaderFirstButtonCi"
                                                                        immediate="true" style="background-color: #ccccff" value="|&lt;"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_previousPageActionCi}"
                                                                        binding="#{Galeria.dataTable1HeaderPreviousButtonCi}" id="dataTable1HeaderPreviousButtonCi"
                                                                        immediate="true" style="background-color: #ccccff" value="&lt;-"/>
                                                                    <ice:commandLink style="font-size:10px" value="#{Galeria.paginacaoCi}"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_nextPageActionCi}"
                                                                        binding="#{Galeria.dataTable1HeaderNextButtonCi}" id="dataTable1HeaderNextButtonCi"
                                                                        immediate="true" style="background-color: #ccccff" value="-&gt;"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_lastPageActionCi}"
                                                                        binding="#{Galeria.dataTable1HeaderLastButtonCi}" id="dataTable1HeaderLastButtonCi"
                                                                        immediate="true" style="background-color: #ccccff" value="&gt;|"/>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:dataTable>
                                                    </td>
                                                    <td valign="top">
                                                        <ice:panelLayout id="circuito_panelLayout01" layout="absolute"
                                                            style="position: relative; visibility: visible; width: 409px; left: 24px; top: 24px; -rave-layout: grid" visible="true">
                                                            <table>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="nome_outputText" style="color: silver" value="Nome:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.nome1_outputText}" id="nome1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="ComprimentoKm_outputText" style="color: silver" value="Comprimento (Km):"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.comprimentoKm1_outputText}" id="ComprimentoKm1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="LarguraM_outputText" style="color: silver" value="Largura (m):"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.larguraM1_outputText}" id="LarguraM1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Cidade_outputText" style="color: silver" value="Cidade:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.cidade1_outputText}" id="Cidade1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Pais_outputText" style="color: silver" value="Pais:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.pais1_outputText}" id="Pais1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Gmt_outputText" style="color: silver" value="GMT:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.gmt1_outputText}" id="Gmt1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="HomePage_outputText" style="color: silver" value="HomePage:"/>
                                                                </td><td>
                                                                <ice:outputLink binding="#{Galeria.homePage1_outputLink1}" id="HomePage1_outputLink1">
                                                                    <ice:outputText binding="#{Galeria.homePage1_outputText}" id="HomePage1_outputText"/>
                                                                </ice:outputLink>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="TempoVoltaRecord_outputText" style="color: silver" value="Tempo da Volta Record:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.tempoVoltaRecord1_outputText}" id="TempoVoltaRecord1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="pilotoVoltaRecord_outputText" style="color: silver" value="Piloto da Volta Record:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.pilotoVoltaRecord1_outputText}" id="pilotoVoltaRecord1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="TempoMelhorVoltaPossivel_outputText" style="color: silver" value="Tempo de Melhor Volta Possivel:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.tempoMelhorVoltaPossivel1_outputText}" id="TempoMelhorVoltaPossivel1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Descricao_outputText" style="color: silver" value="Descrição:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.descricao1_outputText}" id="Descricao1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Sectores_outputText" style="color: silver" value="Sectores:"/>
                                                                </td><td>
                                                                <ice:inputTextarea id="Sectores1_outputText" binding="#{Galeria.sectores1_outputText}" readonly="true" rows="4" cols="20" style="font-size: small; border: none;"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right" colspan="2">
                                                                <ice:graphicImage binding="#{Galeria.graphicImageCi}" id="graphicImageCi" value="/resources/blank.bmp"/>
                                                            </td></tr>
                                                            </table>
                                                        </ice:panelLayout>
                                                    </td>
                                                </tr>
                                            </table>
                                        </ice:panelLayout>
                                    </ice:panelTab>
                                    <ice:panelTab id="equipas_panelTab1" label="Equipas">
                                        <ice:panelLayout id="panelLayout2" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <table>
                                                <tr>
                                                    <td valign="top">
                                                        <ice:dataTable id="dataTable2" rowClasses="oddRow, evenRow" style="cursor:default" value="#{Galeria.equipas}" var="currentRow">
                                                            <ice:column id="column0">
                                                                <ice:rowSelector id="rowSelector2" selectionListener="#{Galeria.rowSelector2_processAction}" value="#{currentRow.selected}" />
                                                                <ice:outputText value="#{currentRow.nome}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText value="Nome da equipa"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <f:facet name="footer">
                                                                <ice:panelGroup id="panelGroupEqFooter" style="display: block; text-align:center">
                                                                    <ice:commandLink action="#{Galeria.dataTable1_firstPageActionEq}"
                                                                        binding="#{Galeria.dataTable1HeaderFirstButtonEq}" id="dataTable1HeaderFirstButtonEq"
                                                                        immediate="true" style="background-color: #ccccff" value="|&lt;"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_previousPageActionEq}"
                                                                        binding="#{Galeria.dataTable1HeaderPreviousButtonEq}" id="dataTable1HeaderPreviousButtonEq"
                                                                        immediate="true" style="background-color: #ccccff" value="&lt;-"/>
                                                                    <ice:commandLink style="font-size:10px" value="#{Galeria.paginacaoEq}"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_nextPageActionEq}"
                                                                        binding="#{Galeria.dataTable1HeaderNextButtonEq}" id="dataTable1HeaderNextButtonEq"
                                                                        immediate="true" style="background-color: #ccccff" value="-&gt;"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_lastPageActionEq}"
                                                                        binding="#{Galeria.dataTable1HeaderLastButtonEq}" id="dataTable1HeaderLastButtonEq"
                                                                        immediate="true" style="background-color: #ccccff" value="&gt;|"/>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:dataTable>
                                                    </td>
                                                    <td valign="top">
                                                        <ice:panelLayout id="equipa_panelLayout01" layout="absolute"
                                                            style="position: relative; visibility: visible; width: 409px; left: 24px; top: 24px; -rave-layout: grid" visible="true">
                                                            <table>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="nomeEq_outputText" style="color: silver" value="Nome:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.nomeEq1_outputText}" id="nomeEq1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Motor_outputText" style="color: silver" value="Motor:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.motorEq1_outputText}" id="Motor1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Chassi_outputText" style="color: silver" value="Chassi:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.chassiEq1_outputText}" id="Chassi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="Peneus_outputText" style="color: silver" value="Peneus:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.peneusEq1_outputText}" id="Peneus1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="AnoEntrada_outputText" style="color: silver" value="Ano de Entrada:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.anoEntradaEq1_outputText}" id="AnoEntrada1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="MelhorPosicao_outputText" style="color: silver" value="Melhor Posicao:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.melhorPosicaoEq1_outputText}" id="MelhorPosicao1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="numeroVezesMP_outputText" style="color: silver" value="Número de vezes melhor posição:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.numeroVezesMPEq1_outputText}" id="numeroVezesMP1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="polepositions_outputText" style="color: silver" value="Polepositions:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.polepositionsEq1_outputText}" id="polepositions1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="director_outputText" style="color: silver" value="Director:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.directorEq1_outputText}" id="director1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="sede_outputText" style="color: silver" value="Sede:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.sedeEq1_outputText}" id="sede1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="DescricaoEq_outputText" style="color: silver" value="Descrição:"/>
                                                                </td><td>
                                                                <ice:outputText binding="#{Galeria.descricaoEq1_outputText}" id="DescricaoEq1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="PilotosEq_outputText" style="color: silver" value="Pilotos:"/>
                                                                </td><td>
                                                                <ice:inputTextarea id="PilotosEq1_outputText" binding="#{Galeria.pilotosEq1_outputText}" readonly="true" rows="4" cols="20" style="font-size: small; border: none;"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right" colspan="2">
                                                                <ice:graphicImage binding="#{Galeria.graphicImageEq}" id="graphicImageEq" value="/resources/blank.bmp"/>
                                                            </td></tr>
                                                            </table>
                                                        </ice:panelLayout>
                                                    </td>
                                                </tr>
                                            </table>
                                        </ice:panelLayout>


                                    </ice:panelTab>
                                    <ice:panelTab id="pilotos_panelTab1" label="Pilotos">


                                        <ice:panelLayout id="panelLayout3" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                            <table>
                                                <tr>
                                                    <td valign="top">
                                                        <ice:dataTable id="dataTable3" rowClasses="oddRow, evenRow" style="cursor:default" value="#{Galeria.pilotos}" var="currentRow">
                                                            <ice:column id="column00">
                                                                <ice:rowSelector id="rowSelector3" selectionListener="#{Galeria.rowSelector3_processAction}" value="#{currentRow.selected}" />
                                                                <ice:outputText value="#{currentRow.nome}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText value="Nome do piloto"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <f:facet name="footer">
                                                                <ice:panelGroup id="panelGroupPiFooter" style="display: block; text-align:center">
                                                                    <ice:commandLink action="#{Galeria.dataTable1_firstPageActionPi}"
                                                                        binding="#{Galeria.dataTable1HeaderFirstButtonPi}" id="dataTable1HeaderFirstButtonPi"
                                                                        immediate="true" style="background-color: #ccccff" value="|&lt;"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_previousPageActionPi}"
                                                                        binding="#{Galeria.dataTable1HeaderPreviousButtonPi}" id="dataTable1HeaderPreviousButtonPi"
                                                                        immediate="true" style="background-color: #ccccff" value="&lt;-"/>
                                                                    <ice:commandLink style="font-size:10px" value="#{Galeria.paginacaoPi}"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_nextPageActionPi}"
                                                                        binding="#{Galeria.dataTable1HeaderNextButtonPi}" id="dataTable1HeaderNextButtonPi"
                                                                        immediate="true" style="background-color: #ccccff" value="-&gt;"/>
                                                                    <ice:commandLink action="#{Galeria.dataTable1_lastPageActionPi}"
                                                                        binding="#{Galeria.dataTable1HeaderLastButtonPi}" id="dataTable1HeaderLastButtonPi"
                                                                        immediate="true" style="background-color: #ccccff" value="&gt;|"/>
                                                                </ice:panelGroup>
                                                            </f:facet>
                                                        </ice:dataTable>
                                                    </td>
                                                    <td valign="top">
                                                        <ice:panelLayout id="piloto_panelLayout01" layout="absolute"
                                                            style="position: relative; visibility: visible; width: 409px; left: 24px; top: 24px; -rave-layout: grid" visible="true">
                                                            <table>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="numeroPi_outputText" style="color: silver" value="Número:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.numeroPi1_outputText}" id="numeroPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="nomePi_outputText" style="color: silver" value="Nome:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.nomePi1_outputText}" id="nomePi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="dataNascimentoPi_outputText" style="color: silver" value="Data de Nascimento:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.dataNascimentoPi1_outputText}" id="dataNascimentoPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="nacionalidadePi_outputText" style="color: silver" value="Nacionalidade:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.nacionalidadePi1_outputText}" id="nacionalidadePi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="melhorPosicaoPi_outputText" style="color: silver" value="Melhor Posição:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.melhorPosicaoPi1_outputText}" id="melhorPosicaoPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="numeroVezesMPPi_outputText" style="color: silver" value="Número de vezes melhor posição:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.numeroVezesMPPi1_outputText}" id="numeroVezesMPPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="polePositionsPi_outputText" style="color: silver" value="Polepositions:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.polePositionsPi1_outputText}" id="polePositionsPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="descricaoPi_outputText" style="color: silver" value="Descrição:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.descricaoPi1_outputText}" id="descricaoPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right">
                                                                <ice:outputText id="equipa_actualPi_outputText" style="color: silver" value="Equipa actual:"/>
                                                            </td><td>
                                                                <ice:outputText binding="#{Galeria.equipa_actualPi1_outputText}" id="equipa_actualPi1_outputText"/>
                                                            </td></tr>
                                                            <tr><td valign="top" align="right" colspan="2">
                                                                <ice:graphicImage binding="#{Galeria.graphicImagePi}" id="graphicImagePi" value="/resources/blank.bmp"/>
                                                            </td></tr>
                                                            </table>
                                                        </ice:panelLayout>
                                                    </td>
                                                </tr>
                                            </table>
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
