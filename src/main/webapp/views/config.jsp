<%-- 
    Document   : config
    Created on : Jan 6, 2015, 5:41:37 PM
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
                            <a href="${pageContext.request.contextPath}/logout" class="regular-text">Efetuar Logout</a>
			</span>
		</div>
	</div>
	<div class="content">
		<div class="search-box">
			<div class="search-box-form">
                            <br/>
                            <br/>
                            <br/>	
                            <div class="main-search">
                                <p><a href="${pageContext.request.contextPath}/create-user" class="regular-text">Cadastrar Usuarios</a></p>
                                <p><a href="${pageContext.request.contextPath}/create-setor" class="regular-text">Cadastrar Setores</a></p>
                                <p><a href="${pageContext.request.contextPath}/listUser" class="regular-text">Listar Usuarios</a></p>
                                <p><a href="${pageContext.request.contextPath}/listSetor" class="regular-text">Listar Setores</a></p>
                            </div>
                        </div>
                </div>
        </div>
	<div class="footer"></div>
</body>
</html>
