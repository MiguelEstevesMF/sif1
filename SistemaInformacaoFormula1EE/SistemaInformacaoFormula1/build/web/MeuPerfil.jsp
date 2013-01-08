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
                    <ice:panelLayout id="geral_panelLayout" layout="flow" style=" height: 526px; left: 0px; top: 0px; position: absolute; width: 694px; -rave-layout: grid">
                        <ice:outputText id="nome_pagina_outputText" style="font-size: 24px; left: 24px; top: 120px; position: absolute" value="Meu Perfil"/>
                        <f:subview id="menu">
                            <jsp:directive.include file="MenuUtilizador.jspf"/>
                        </f:subview>
                        <ice:panelLayout id="conteudo_panelLayout" style=" height: 333px; left: 192px; top: 168px; position: absolute; width: 405px; -rave-layout: grid">
                            <ice:panelLayout id="registar_panelLayout1" layout="flow"
                                style="height: 309px; left: 0px; top: 0px; position: absolute; visibility: visible; width: 309px; -rave-layout: grid" visible="true">
                                <ice:outputText id="nome_outputText1" style="left: 0px; top: 0px; position: absolute" value="Nome:"/>
                                <ice:outputText id="email_outputText1" style="left: 0px; top: 25px; position: absolute" value="Email:"/>
                                <ice:outputText id="data_nascimento_outputText1" style="left: 0px; top: 49px; position: absolute" value="Data de nascimento:"/>
                                <ice:outputText id="username_outputText1" style="left: 0px; top: 96px; position: absolute" value="Username:"/>
                                <ice:outputText id="password_outputText1" style="left: 0px; top: 120px; position: absolute" value="Password:"/>
                                <ice:inputSecret binding="#{MeuPerfil.password_inputSecret1}" id="password_inputSecret1"
                                    style="left: 142px; top: 118px; position: absolute; width: 150px" value=""/>
                                <ice:outputText id="confirm_password_outputText1" style="left: 0px; top: 144px; position: absolute" value="Confirmar password:"/>
                                <ice:inputSecret binding="#{MeuPerfil.confirm_password_inputSecret1}" id="confirm_password_inputSecret1"
                                    style="left: 142px; top: 142px; position: absolute; width: 150px" value=""/>
                                <ice:outputText id="credenciais_outputText1" style="left: 0px; top: 192px; position: absolute" value="Credenciais:"/>
                                <ice:commandButton action="#{MeuPerfil.alterar_password_button1_action}" id="alterar_password_button1"
                                    style="bottom: 0px; right: 12px; position: absolute" value="Alterar password"/>
                                <ice:outputText binding="#{MeuPerfil.nome_text}" id="nome_text" style="height: 17px; left: 144px; top: 0px; position: absolute; width: 165px"/>
                                <ice:outputText binding="#{MeuPerfil.email_text}" id="email_text" style="height: 17px; left: 144px; top: 24px; position: absolute; width: 165px"/>
                                <ice:outputText binding="#{MeuPerfil.data_nasc_text}" id="data_nasc_text" style="height: 17px; left: 144px; top: 48px; position: absolute; width: 165px"/>
                                <ice:outputText binding="#{MeuPerfil.username_text}" id="username_text" style="height: 17px; left: 144px; top: 96px; position: absolute; width: 165px"/>
                                <ice:outputText binding="#{MeuPerfil.credenciais_text}" id="credenciais_text" style="height: 41px; left: 144px; top: 192px; position: absolute; width: 165px"/>
                                <ice:outputText binding="#{MeuPerfil.erro_text}" id="erro_text" style="color: red; height: 17px; left: 24px; top: 288px; position: absolute; width: 165px"/>
                                <ice:outputText id="equipa_outputText" style="left: 0px; top: 72px; position: absolute" value="Equipa:"/>
                                <ice:outputText binding="#{MeuPerfil.equipa_text}" id="equipa_text" style="height: 17px; left: 144px; top: 72px; position: absolute; width: 165px"/>
                            </ice:panelLayout>
                        </ice:panelLayout>
                    </ice:panelLayout>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
