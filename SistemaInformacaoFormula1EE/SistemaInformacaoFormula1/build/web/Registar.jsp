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
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style=" height: 598px; left: 0px; top: 0px; position: absolute; width: 694px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Registar"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 405px; left: 192px; top: 168px; position: absolute; width: 405px; -rave-layout: grid">
                            <ice:panelLayout id="registar_panelLayout" layout="flow"
                                style="height: 381px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                <ice:outputText id="nome_outputText" style="left: 0px; top: 0px; position: absolute" value="Nome:"/>
                                <ice:inputText binding="#{Registar.nome_inputText}" id="nome_inputText" style="left: 144px; top: 0px; position: absolute; width: 150px"/>
                                <ice:outputText id="email_outputText" style="left: 0px; top: 25px; position: absolute" value="Email:"/>
                                <ice:inputText binding="#{Registar.email_inputText}" id="email_inputText" style="left: 144px; top: 25px; position: absolute; width: 150px"/>
                                <ice:outputText id="data_nascimento_outputText1" style="left: 0px; top: 49px; position: absolute" value="Data de nascimento:"/>
                                <ice:selectInputDate binding="#{Registar.date1}" id="date1" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                                    renderMonthAsDropdown="true" renderYearAsDropdown="true" style="font-size: 10px; left: 144px; top: 49px; position: absolute"
                                    value="#{Registar.data1}" visible="true">
                                    <f:convertDateTime pattern="dd/MM/yyyy" timeZone="#{Registar.timeZone}"/>
                                </ice:selectInputDate>
                                <ice:outputText id="username_outputText1" style="left: 0px; top: 76px; position: absolute" value="Username:"/>
                                <ice:inputText binding="#{Registar.username_inputText}" id="username_inputText" style="left: 144px; top: 76px; position: absolute; width: 150px"/>
                                <ice:outputText id="password_outputText1" style="left: 0px; top: 100px; position: absolute" value="Password:"/>
                                <ice:inputSecret binding="#{Registar.password_inputSecret1}" id="password_inputSecret1" redisplay="true"
                                    style="position: absolute; left: 144px; top: 100px; width: 150px" value=""/>
                                <ice:outputText id="confirm_password_outputText1" style="left: 0px; top: 125px; position: absolute" value="Confirmar password:"/>
                                <ice:inputSecret binding="#{Registar.confirm_password_inputSecret1}" id="confirm_password_inputSecret1" redisplay="true"
                                    style="position: absolute; left: 144px; top: 125px; width: 150px" value=""/>
                                <ice:outputText id="credenciais_outputText1" style="left: 0px; top: 150px; position: absolute" value="Credenciais:"/>
                                <ice:commandButton action="#{Registar.submeter_registo_button_action}" id="submeter_registo_button"
                                    style="bottom: 0px; right: 12px; position: absolute" value="submeter registo"/>
                                <ice:panelLayout binding="#{Registar.credenciais_panelLayout}" id="credenciais_panelLayout" style="left: 130px; top: 150px; position: absolute">
                                    <ice:selectManyCheckbox binding="#{Registar.selectManyCheckbox1}" id="selectManyCheckbox1" layout="pageDirection"
                                        partialSubmit="true" value="#{Registar.selectManyCheckbox1Bean.selectedItems}">
                                        <f:selectItems id="selectManyCheckbox1selectItems" value="#{Registar.selectManyCheckbox1DefaultItems}"/>
                                    </ice:selectManyCheckbox>
                                </ice:panelLayout>
                                <ice:outputText binding="#{Registar.outputText1}" id="outputText1" style="height: 17px; left: 24px; top: 360px; position: absolute; width: 165px; color: red;"/>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
