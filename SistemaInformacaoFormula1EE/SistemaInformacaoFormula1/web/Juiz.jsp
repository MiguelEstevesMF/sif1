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
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Juiz"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf" />
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style="border-width: 1px; border-style: dotted; height: 260px; left: 192px; top: 168px; position: absolute; width: 405px; -rave-layout: grid">
                            <ice:panelLayout id="login_panelLayout" layout="flow"
                                style="height: 118px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 214px; -rave-layout: grid" visible="true"/>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
