<%-- 
    Document   : create-protocol
    Created on : Dec 12, 2014, 12:59:02 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>UNEB - Universidade do Estado da Bahia - Sistema de Protocolo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="header">
    <div class="restricted-area">
			<span class="acesso-restrito">
				<a href="${pageContext.request.contextPath}/loginForm" target='_blank'>Acesso Restrito</a>
			</span>
    </div>
</div>
<div class="content">
    <div class="protocol-detail">
        <form:form commandName="protocolo" action="${pageContext.request.contextPath}/add" class="form-protocol-detail">
            <fieldset>
                <legend>Requerimento</legend>
            <p><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-name">Nome</label></span>
                <form:input required="required" path="nome" class="regular-input" id="input-name"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-matricula">N°
                Matrícula</label></span>
                <form:input required="required" path="matricula" class="regular-input"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                         id="label-curso">Curso</label></span>
                <form:input required="required" path="curso" class="regular-input"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-semestre">Semestre</label></span>
                <form:select class="regular-select" id="select-semestre" path="semestre">
                    <form:option value="1">1</form:option>
                    <form:option value="2">2</form:option>
                    <form:option value="3">3</form:option>
                    <form:option value="4">4</form:option>
                    <form:option value="5">5</form:option>
                    <form:option value="6">6</form:option>
                    <form:option value="7">7</form:option>
                    <form:option value="8">8</form:option>
                    <form:option value="9">9</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="11">11</form:option>
                    <form:option value="12">12</form:option>
                    <form:option value="13">13</form:option>
                    <form:option value="14">14</form:option>
                </form:select><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                  id="label-rg">RG</label></span><form:input required="required" path="rg"
                                                                                        class="regular-input"
                                                                                        /><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                  id="label-cpf">CPF</label></span><form:input required="required" path="cpf"
                                                                                          class="regular-input"
                                                                                          /><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                         id="label-endereco">Endereço</label></span>
                <form:input required="required" path="endereco" class="regular-input" size="150"/> <br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-telefone">Telefone</label></span>
                <form:input required="required" path="telefone" class="regular-input"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-data">Data:</label></span>
                <p class="regular-input">${data}</p><br/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-objeto">Objeto do
                    Requerimento</label></span>
                <form:select class="regular-select" id="select-objeto" path="objetoRequerimento">
                    <form:option value="historico"> Histórico Escolar</form:option>
                    <form:option value="segundaChamada"> Segunda Chamada</form:option>
                    <%-- <form:option value="ementa"> Ementa </form:option>  mexi--%>
                </form:select><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-esclarecimento">Esclarecimento
                    sobre o objeto do requerimento:</label></span><br/><br/>
                    <p><form:textarea rows="6" cols="80" class="regular-text-area" path="esclarescimento"/></p>

                <p> <div class="actions">
                        <input type="submit" value="Enviar" class="btn"></input>
                        <span> | </span>
                        <input type="reset" value="Limpar" class="btn"></input>
                        <div class="regular-text-right">
                        <a href="${pageContext.request.contextPath}/" class="regular-text">Voltar</a>
                        </div>
                    </div>
                </p>
            </fieldset>
        </form:form>
    </div>
</html>
