<%-- 
    Document   : create-setor
    Created on : Jan 6, 2015, 5:17:57 PM
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
				<a href="${pageContext.request.contextPath}/config">Voltar</a>
			</span>
    </div>
</div>
<div class="content">
    <div class="protocol-detail">
        <form:form commandName="setor" action="${pageContext.request.contextPath}/addSetor" class="form-protocol-detail">
            <fieldset>
                <legend>Cadastro Setor</legend>
                <br/>
                <br/>
                <label for="nomeSetor">Nome</label>
                <form:input id="nomeSetor" path="nome"/>
                <br/>
                <br/>
                <button type="submit">Cadastrar</button>
            </fieldset>
        </form:form>
    </div>
</html>

