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
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Login"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 260px; left: 192px; top: 168px; position: absolute; width: 405px; -rave-layout: grid">
                            <ice:panelLayout id="login_panelLayout" layout="flow"
                                style="height: 118px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 214px; -rave-layout: grid" visible="true">
                                <ice:outputText id="username_outputText" style="left: 0px; top: 0px; position: absolute" value="username:"/>
                                <ice:inputText binding="#{Login.username_inputText}" id="username_inputText" style="left: 70px; top: -2px; position: absolute; width: 120px"/>
                                <ice:outputText id="password_outputText" style="left: 0px; top: 24px; position: absolute" value="password:"/>
                                <ice:inputSecret binding="#{Login.password_inputSecret}" id="password_inputSecret" redisplay="true"
                                    style="left: 70px; top: 22px; position: absolute; width: 120px" value=""/>
                                <ice:commandButton action="#{Login.login_button_action}" id="login_button"
                                    style="height: 24px; left: 144px; top: 72px; position: absolute; width: 48px" value="login"/>
                            </ice:panelLayout>
                            <ice:panelLayout id="erro_panelLayout" layout="flow"
                                style="height: 58px; left: 0px; top: 120px; position: absolute; visibility: visible; width: 214px; -rave-layout: grid" visible="true">
                                <ice:outputText binding="#{Login.erro_outputText}" id="erro_outputText" style="left: 0px; top: 0px; position: absolute; color: red;" value=""/>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
