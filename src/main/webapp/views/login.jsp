<%-- 
    Document   : login
    Created on : Dec 12, 2014, 12:59:09 PM
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
	</div>
	<div class="content">
		<div class="search-box">
			<div class="search-box-form">
                            <form:form commandName="login" class="search-box-form requirement" action="${pageContext.request.contextPath}/login">
					<div class="main-search">
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<br/>
						<div class="login-box">
							<span class="regular-text">Usuário:</span>
							<form:input path="username" name="protocol-number" class="login-input"/>
							</br></br>
							<span class="regular-text">Senha:</span>
							<form:password path="password" name="protocol-number" class="login-input"/>
						</div>			
						<div class="actions">
							<a href="admin/index.html" class="regular-text">Login</a>
							<span> | </span>
							<a href="#" class="regular-text">Esqueci minha senha</a>
						</div>
			</form:form>
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>
