<%-- 
    Document   : protocol-detail
    Created on : Dec 14, 2014, 11:07:03 PM
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
			<span class="saudacao">
				Olá, ${usuario} seja bem vindo!
			</span>
			<span class="acesso-restrito">
				<a href="${pageContext.request.contextPath}/logout">Efetuar Logout</a>
			</span>
			<span class="user-menu">
				<a href="${pageContext.request.contextPath}/menu">Histórico de Solicitações</a> |
			</span>

    </div>
</div>
<div class="content">
    <div class="protocol-detail">
        <form:form commandName="protocolo" name="protocolo" action="${pageContext.request.contextPath}/encaminhar" class="form-protocol-detail">
                      <fieldset>
                <legend>Requerimento</legend>
            <p><br/>
                <form:input style="visibility:hidden" path="id"/>
                <form:input id="codigo" style="visibility:hidden" path="codigo"/>
                <form:input style="visibility:hidden" path="data"/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-name">Nome</label></span>
                <form:input path="nome" class="regular-input" id="input-name"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-matricula">N°
                Matrícula</label></span>
                <form:input path="matricula" class="regular-input"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                         id="label-curso">Curso</label></span>
                <form:input path="curso" class="regular-input"/><br/><br/>
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
                                                  id="label-rg">RG</label></span><form:input path="rg"
                                                                                        class="regular-input"
                                                                                        /><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                  id="label-cpf">CPF</label></span><form:input path="cpf"
                                                                                          class="regular-input"
                                                                                          /><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                         id="label-endereco">Endereço</label></span>
                <form:input path="endereco" class="regular-input" size="150"/> <br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-telefone">Telefone</label></span>
                <form:input path="telefone" class="regular-input"/><br/><br/>
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

                    <p> <a href="${pageContext.request.contextPath}/menu">Voltar</a>
                   <a href="${pageContext.request.contextPath}/deferir/${codigo}">Deferir</a>
                   <a href="${pageContext.request.contextPath}/indeferir/${codigo}">Indeferir</a>
                <span class="regular-text">Encaminhar:</span>
                <form:select path="setorID">
                    <c:forEach var="s" items="${setores}">
                        <form:option value="${s.id}">${s.nome}</form:option>
                    </c:forEach>
                </form:select>
                <input type="submit" value="Encaminhar" class="btn-encaminhar"></input>
            </p>

            </fieldset>
        </form:form>
    </div>
</body>

<script>
    function deferir(){
        var codigo = document.getElementById("codigo");
        window.open("${pageContext.request.contextPath}/deferir/"+codigo.value);
    }
    function indeferir(){
        var codigo = document.getElementById("codigo");
        window.open("${pageContext.request.contextPath}/indeferir/"+codigo.value);
    }
</script>
</html>
