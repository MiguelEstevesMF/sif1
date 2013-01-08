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
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style=" height: 694px; left: 0px; top: 0px; position: absolute; width: 982px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Administração"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 453px; left: 192px; top: 168px; position: absolute; width: 765px; -rave-layout: grid">
                            <ice:panelLayout id="administracao_panelLayout" layout="absolute"
                                style="height: 405px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 789px; -rave-layout: grid" visible="true">
                                <table>
                                    <tr>
                                        <td>
                                            <ice:dataTable id="dataTable1" resizable="true" rows="#{AdministracaoSessionBean.limit}" rowClasses="oddRow, evenRow" 
                                                sortAscending="#{AdministracaoSessionBean.ascending}" sortColumn="#{AdministracaoSessionBean.sortColumnName}"
                                                style="cursor:default" value="#{AdministracaoSessionBean.utilizadores}" var="currentRow">
                                                <ice:column id="column0">
                                                    <ice:rowSelector id="rowSelector1" selectionListener="#{Administracao.rowSelector1_processAction}" value="#{currentRow.selected}"/>
                                                    <ice:outputText id="outputText0" style="#{currentRow.activestyle}" value="#{currentRow.user}"/>
                                                    <f:facet name="header">
                                                        <ice:commandSortHeader arrow="true" columnName="#{AdministracaoSessionBean.usernameColumnName}">
                                                            <ice:outputText id="outputText01" value="username"/>
                                                        </ice:commandSortHeader>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column1">
                                                    <ice:outputText id="outputText1" style="#{currentRow.activestyle}" value="#{currentRow.nome}"/>
                                                    <f:facet name="header">
                                                        <ice:commandSortHeader arrow="true" columnName="#{AdministracaoSessionBean.nomeColumnName}">
                                                            <ice:outputText id="outputText2" value="nome"/>
                                                        </ice:commandSortHeader>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column2">
                                                    <ice:outputText id="outputText3" style="#{currentRow.activestyle}" value="#{currentRow.datanasc2}"/>
                                                    <f:facet name="header">
                                                        <ice:commandSortHeader arrow="true" columnName="#{AdministracaoSessionBean.datanascColumnName}">
                                                            <ice:outputText id="outputText4" value="datanasc"/>
                                                        </ice:commandSortHeader>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="column3">
                                                    <ice:outputText id="outputText5" style="#{currentRow.activestyle}" value="#{currentRow.estado}"/>
                                                    <f:facet name="header">
                                                        <ice:commandSortHeader arrow="true" columnName="#{AdministracaoSessionBean.estadoColumnName}">
                                                            <ice:outputText id="outputText6" value="estado"/>
                                                        </ice:commandSortHeader>
                                                    </f:facet>
                                                </ice:column>
                                                <f:facet name="footer">
                                                    <ice:panelGroup id="panelGroup1" style="display: block; text-align:center">
                                                        <ice:commandLink action="#{Administracao.dataTable1_firstPageAction}"
                                                            binding="#{Administracao.dataTable1HeaderFirstButton}" id="dataTable1HeaderFirstButton"
                                                            immediate="true" style="background-color: #ccccff" value="|&lt;"/>
                                                        <ice:commandLink action="#{Administracao.dataTable1_previousPageAction}"
                                                            binding="#{Administracao.dataTable1HeaderPreviousButton}" id="dataTable1HeaderPreviousButton"
                                                            immediate="true" style="background-color: #ccccff" value="&lt;-"/>
                                                        <ice:commandLink style="font-size:10px" value="#{AdministracaoSessionBean.paginacao}"/>
                                                        <ice:commandLink action="#{Administracao.dataTable1_nextPageAction}"
                                                            binding="#{Administracao.dataTable1HeaderNextButton}" id="dataTable1HeaderNextButton"
                                                            immediate="true" style="background-color: #ccccff" value="-&gt;"/>
                                                        <ice:commandLink action="#{Administracao.dataTable1_lastPageAction}"
                                                            binding="#{Administracao.dataTable1HeaderLastButton}" id="dataTable1HeaderLastButton"
                                                            immediate="true" style="background-color: #ccccff" value="&gt;|"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                            </ice:dataTable>
                                            <ice:commandButton action="#{Administracao.button1_action}" id="button1" value="submit"/>
                                        </td>
                                        <td valign="top">
                                            <ice:panelLayout id="registar_panelLayout" layout="flow"
                                                style="position: relative; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                                <ice:outputText id="nome_outputText" style="left: 0px; top: 0px; position: absolute" value="Nome:"/>
                                                <ice:inputText binding="#{Administracao.nome_inputText}" id="nome_inputText" style="left: 144px; top: 0px; position: absolute; width: 150px"/>
                                                <ice:outputText id="email_outputText" style="left: 0px; top: 25px; position: absolute" value="Email:"/>
                                                <ice:inputText binding="#{Administracao.email_inputText}" id="email_inputText" style="left: 144px; top: 25px; position: absolute; width: 150px"/>
                                                <ice:outputText id="data_nascimento_outputText1" style="left: 0px; top: 49px; position: absolute" value="Data de nascimento:"/>
                                                <ice:selectInputDate binding="#{Administracao.date1}" id="date1" popupDateFormat="dd/MM/yyyy"
                                                    renderAsPopup="true" renderMonthAsDropdown="true" renderYearAsDropdown="true"
                                                    style="font-size: 10px; left: 144px; top: 49px; position: absolute" value="#{Administracao.data1}" visible="true">
                                                    <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                                </ice:selectInputDate>
                                                <ice:outputText id="username_outputText1" style="left: 0px; top: 76px; position: absolute" value="Username:"/>
                                                <ice:inputText binding="#{Administracao.username_inputText}" id="username_inputText" style="left: 144px; top: 76px; position: absolute; width: 150px"/>
                                                <ice:outputText id="credenciais_outputText1" style="left: 0px; top: 100px; position: absolute" value="Credenciais:"/>
                                                <ice:panelLayout id="credenciais_panelLayout" style="left: 130px; top: 100px; position: absolute">
                                                    <ice:selectManyCheckbox binding="#{Administracao.selectManyCheckbox1}" id="selectManyCheckbox1"
                                                        layout="pageDirection" partialSubmit="true" value="#{Administracao.selectManyCheckbox1Bean.selectedItems}">
                                                        <f:selectItems id="selectManyCheckbox1selectItems" value="#{Administracao.selectManyCheckbox1DefaultItems}"/>
                                                    </ice:selectManyCheckbox>
                                                </ice:panelLayout>
                                                <ice:outputText id="selectEquipaOutputText" style="position: absolute; right: 20px; top: 200px" value="Equipa:"/>
                                                <ice:selectOneMenu binding="#{Administracao.selectOneMenu1}" id="selectOneMenu1" partialSubmit="true"
                                                    style="position: absolute; right: 15px; top: 230px" value="#{Administracao.selectOneMenu1Bean.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Administracao.selectOneMenu1DefaultItems}"/>
                                                </ice:selectOneMenu>
                                                <ice:panelLayout id="activo_panelLayout" style="background-color: #e7e2e2; right: 15px; top: 270px; position: absolute; text-align: center; vertical-align: middle">
                                                    <ice:selectBooleanCheckbox binding="#{Administracao.selectBooleanCheckbox1}" id="selectBooleanCheckbox1"
                                                        partialSubmit="true" value="#{Administracao.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:outputText id="activo_outputText1" value="activo"/>
                                                </ice:panelLayout>
                                                <ice:commandButton action="#{Administracao.submeter_registo_button_action}" id="submeter_registo_button"
                                                    style="top: 300px; right: 12px; position: absolute" value="submeter registo"/>
                                                <ice:outputText binding="#{Administracao.outputText7}" id="outputText7" style="text-align: right; right: 12px; top: 334px; position: absolute; color: red"/>
                                            </ice:panelLayout>
                                        </td>
                                    </tr>
                                </table>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
