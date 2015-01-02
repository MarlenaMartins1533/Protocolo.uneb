<%-- 
    Document   : index
    Created on : Dec 12, 2014, 11:43:41 AM
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
                            <a href="${pageContext.request.contextPath}/login" class="regular-text">Acesso Restrito</a>
			</span>
		</div>
	</div>
	<div class="content">
		<div class="search-box">
			<div class="search-box-form">
                            <form:form commandName="codigo" class="search-box-form requirement" action="${pageContext.request.contextPath}/search">
					<div class="main-search">
						<br/>
						<br/>
						<br/>
                                                 <div class="regular-text-right">
                                                     <span> Seja bem-vindo! <label id="label-data"><p>Data: ${data}</p></label></span>
                                                 </div>
						<br/>
                                                <br/>
						<br/>				
						<span class="regular-text">Número do Protocolo</span><br/>
						<form:input path="codigo" name="protocol-number" class="basicInput" placeholder="Buscar"/>
						<br/><br/>
						<div class="actions">
							<a href="${pageContext.request.contextPath}/create-protocol" class="regular-text">Criar novo requerimento</a>
							<span> | </span>
							<a href="${pageContext.request.contextPath}/protocol-detail" class="regular-text">Buscar Requerimento</a>
						</div>
                            </form:form>
                        </div>
                </div>
        </div>
	<div class="footer"></div>
</body>
</html>
