<%-- 
    Document   : menu
    Created on : Dec 14, 2014, 10:58:03 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>UNEB - Universidade do Estado da Bahia - Sistema de Protocolo</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div class="header">
		<div class="restricted-area">
			<span class="saudacao">
				Olá ${usuario}, seja bem vindo!
			</span>
			<span class="acesso-restrito">
				<a class="link-list" href="${pageContext.request.contextPath}/login">Efetuar Logout</a>
                                </span>
			<span class="user-menu">
				<a class="link-list" href="systemConfiguration.php">Configuração do Sistema</a> | <a class="link-list" href="#">Meus dados</a> | <a class="link-list" href="index.html">Histórico de Solicitações</a> |
			</span>
		
		</div>
	</div>
	<div class="content">
		<h2 class="regular-text list-protocol-header">SOLICITAÇÕES</h2>
		<div class="list-protocol">
			<div class="CSSTableGenerator" >
                <table >
                    <tr>
                        <td>
                            Nº Protocolo
                        </td>
                        <td >
                            Objeto de Requerimento
                        </td>
                        <td>
                            Data da Solicitação
                        </td>
                        <td>
                            Status
                        </td>
                    </tr>
                    <c:forEach var="protocol" items="${protocols}">
                        <tr>
                            <td >
                                <a class="link-list" href="protocol-detail/${protocol.codigo}">${protocol.codigo}</a>
                            </td>
                            <td>
                                ${protocol.objetoRequerimento}
                            </td>
                            <td>
                                ${protocol.date}
                            </td>
                            <td>
                                ${protocol.status}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            
		</div>
	</div>
	<div class="footer"></div>
</body>
</html>
