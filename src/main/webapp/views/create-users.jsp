<%-- 
    Document   : create-users
    Created on : Jan 6, 2015, 5:15:14 PM
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
        <form:form commandName="usuario" action="${pageContext.request.contextPath}/${action}" class="form-protocol-detail">
            <fieldset>
                <legend>Cadastro Usuario</legend>
                <label for="nome">Nome</label>
                <form:input id="nome" path="nome"/>
                <br/>
                <br/>
                <label for="password">Password</label>
                <form:password id="password" path="password"/>
                <br/>
                <br/>
                <label for="username">Username</label>
                <form:input id="username" path="username"/>
                
                <br/>
                <br/>
                <form:select class="regular-select" id="select-semestre" path="setorID">
                    <c:forEach var="s" items="${setores}">
                        <form:option value="${s.id}">${s.nome}</form:option>
                    </c:forEach>
                </form:select>
                <br/>
                <br/>
                <br/>
                <button type="submit">${botao}</button>
                <form:input style="visibility: hidden;" path="id"/>
            </fieldset>
        </form:form>
    </div>
</html>

