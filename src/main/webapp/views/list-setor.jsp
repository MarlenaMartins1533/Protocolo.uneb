<%-- 
    Document   : list-setor
    Created on : Jan 7, 2015, 9:31:52 AM
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
				<a class="link-list" href="${pageContext.request.contextPath}/logout">Efetuar Logout</a>
                                </span>
			<span class="user-menu">
				<a class="link-list" href="${pageContext.request.contextPath}/menu">Histórico de Solicitações</a> |
			</span>
		
		</div>
	</div>
	<div class="content">
		<h2 class="regular-text list-protocol-header">SETORES</h2>
		<div class="list-protocol">
			<div class="CSSTableGenerator" >
                <table >
                    <tr>
                        <td>
                            Nome
                        </td>
                        <td>
                            Operacoes
                        </td>
                    </tr>
                    <c:forEach var="setor" items="${setores}">
                        <tr>
                            <td>
                                ${setor.nome}
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/EditSetor/${setor.id}">Edit</a> | 
                                <a href="${pageContext.request.contextPath}/DeleteSetor/${setor.id}">Delete</a>
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
