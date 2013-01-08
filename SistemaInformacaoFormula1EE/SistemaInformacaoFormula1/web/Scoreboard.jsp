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
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style="border-width: 1px; border-style: dotted; height: 502px; left: 0px; top: 0px; position: absolute; width: 694px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Scoreboard"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf" />
                        </f:subview>

                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 260px; left: 192px; top: 168px; position: absolute; width: 645px; -rave-layout: grid">
                            <ice:panelLayout id="sbtr_panelLayout" layout="flow"
                                style="height: 118px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 837px; -rave-layout: grid" visible="true">
                                <ice:panelLayout id="panelLayout1" layout="absolute" style="height: 653px; position: absolute; width: 100%; -rave-layout: grid">
                                    <ice:outputText id="titulos" value="#{Scoreboard.titulos}"/>
                                    <ice:panelLayout id="tabelaSBTR_panelLayout3" layout="flow"
                                        style="left: 0px; top: 60px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                        <ice:dataTable binding="#{Scoreboard.dataTable1_sbtrCorrida}" id="dataTable1_sbtr" rowClasses="oddRow, evenRow"
                                            style="cursor:default" value="#{Scoreboard.sbtrCorridaSet}" var="currentRow">
                                            <ice:column id="column1" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o1" value="#{currentRow.posicao}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o2" value="Pos"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o3" value="#{currentRow.numeroPiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o4" value="Nº"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o5" style="width:150px;" value="#{currentRow.nomeEquipa}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o6" value="Equipa"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o7" style="width:150px;" value="#{currentRow.nomePiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o8" value="Piloto"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o9" value="#{currentRow.gapCorrida}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o10" value="GAP"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column6" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o11" value="#{currentRow.intervaloCorrida}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o12" value="Intervalo"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o17" value="#{currentRow.s1}" style='#{currentRow.sector==1?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o18" value="S1"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o19" value="#{currentRow.s2}" style='#{currentRow.sector==2?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o20" value="S2"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o21" value="#{currentRow.s3}" style='#{currentRow.sector==3?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o22" value="S3"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o23" value="#{currentRow.s4}" style='#{currentRow.sector==4?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o24" value="S4"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column13" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o25" value="#{currentRow.s5}" style='#{currentRow.sector==5?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o26" value="S5"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column14" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o27" value="#{currentRow.s6}" style='#{currentRow.sector==6?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o28" value="S6"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column15" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o29" value="#{currentRow.s7}" style='#{currentRow.sector==7?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o30" value="S7"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column16" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o31" value="#{currentRow.s8}" style='#{currentRow.sector==8?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o32" value="S8"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column17" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o33" value="#{currentRow.s9}" style='#{currentRow.sector==9?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o34" value="S9"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column18" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="o35" value="#{currentRow.s10}" style='#{currentRow.sector==10?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o36" value="S10"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o13" value="#{currentRow.tempo_ultima_volta2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o14" value="Tempo"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="o15" value="#{currentRow.pitCount}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="o16" value="PIT"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>


                                        <ice:dataTable binding="#{Scoreboard.dataTable1_sbtrQualificacao}" id="dataTable1_sbtrQ" rowClasses="oddRow, evenRow"
                                            style="cursor:default" value="#{Scoreboard.sbtrQualificacaoSet}" var="currentRow">
                                            <ice:column id="column1" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="oo1" value="#{currentRow.posicao}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo2" value="Pos"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="oo3" value="#{currentRow.numeroPiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo4" value="Nº"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="oo5" style="width:150px;" value="#{currentRow.nomeEquipa}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo6" value="Equipa"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="oo7" style="width:150px;" value="#{currentRow.nomePiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo8" value="Piloto"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="columnQ1" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooq1" value="#{currentRow.q1}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooq2" value="Q1"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="columnQ2" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooq3" value="#{currentRow.q2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooq4" value="Q2"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="columnQ3" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooq5" value="#{currentRow.q3}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooq6" value="Q3"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo17" value="#{currentRow.s1}" style='#{currentRow.sector==1?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo18" value="S1"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo19" value="#{currentRow.s2}" style='#{currentRow.sector==2?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo20" value="S2"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo21" value="#{currentRow.s3}" style='#{currentRow.sector==3?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo22" value="S3"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo23" value="#{currentRow.s4}" style='#{currentRow.sector==4?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo24" value="S4"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column13" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo25" value="#{currentRow.s5}" style='#{currentRow.sector==5?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo26" value="S5"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column14" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo27" value="#{currentRow.s6}" style='#{currentRow.sector==6?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo28" value="S6"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column15" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo29" value="#{currentRow.s7}" style='#{currentRow.sector==7?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo30" value="S7"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column16" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo31" value="#{currentRow.s8}" style='#{currentRow.sector==8?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo32" value="S8"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column17" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo33" value="#{currentRow.s9}" style='#{currentRow.sector==9?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo34" value="S9"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column18" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="oo35" value="#{currentRow.s10}" style='#{currentRow.sector==10?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo36" value="S10"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="oo13" value="#{currentRow.tempo_ultima_volta2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo14" value="Tempo"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="oo15" value="#{currentRow.volta}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="oo16" value="Volta"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>

                                        <ice:dataTable binding="#{Scoreboard.dataTable1_sbtrTreino}" id="dataTable1_sbtrT" rowClasses="oddRow, evenRow"
                                            style="cursor:default" value="#{Scoreboard.sbtrTreinoSet}" var="currentRow">
                                            <ice:column id="column1" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo1" value="#{currentRow.posicao}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo2" value="Pos"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo3" value="#{currentRow.numeroPiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo4" value="Nº"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo5" style="width:150px;" value="#{currentRow.nomeEquipa}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo6" value="Equipa"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo7" style="width:150px;" value="#{currentRow.nomePiloto}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo8" value="Piloto"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4.5" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooomv1" value="#{currentRow.tempo_melhor_Volta2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooomv2" value="Melhor Volta"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo9" value="#{currentRow.gapCorrida}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo10" value="GAP"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column6" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo11" value="#{currentRow.intervaloCorrida}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo12" value="Intervalo"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo17" value="#{currentRow.s1}" style='#{currentRow.sector==1?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo18" value="S1"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo19" value="#{currentRow.s2}" style='#{currentRow.sector==2?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo20" value="S2"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo21" value="#{currentRow.s3}" style='#{currentRow.sector==3?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo22" value="S3"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo23" value="#{currentRow.s4}" style='#{currentRow.sector==4?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo24" value="S4"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column13" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo25" value="#{currentRow.s5}" style='#{currentRow.sector==5?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo26" value="S5"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column14" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo27" value="#{currentRow.s6}" style='#{currentRow.sector==6?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo28" value="S6"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column15" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo29" value="#{currentRow.s7}" style='#{currentRow.sector==7?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo30" value="S7"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column16" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo31" value="#{currentRow.s8}" style='#{currentRow.sector==8?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo32" value="S8"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column17" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo33" value="#{currentRow.s9}" style='#{currentRow.sector==9?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo34" value="S9"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column18" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158;":""}'>
                                                <ice:outputText id="ooo35" value="#{currentRow.s10}"  style='#{currentRow.sector==10?"color: #2554C7;":""}'/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo36" value="S10"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo13" value="#{currentRow.tempo_ultima_volta2}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo14" value="Tempo"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8" style='#{Scoreboard.ultimoPilotoRegistro==currentRow.numeroPiloto?"background-color: #F88158":""}'>
                                                <ice:outputText id="ooo15" value="#{currentRow.volta}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="ooo16" value="volta"/>
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
