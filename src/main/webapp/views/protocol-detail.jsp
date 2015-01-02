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
				Olá User, seja bem vindo!
			</span>
			<span class="acesso-restrito">
				<a href="../login.html">Efetuar Logout</a>
			</span>
			<span class="user-menu">
				<a href="#">Meus dados</a> | <a href="index.html">Histórico de Solicitações</a> |
			</span>

    </div>
</div>
<div class="content">
    <div class="protocol-detail">
        <form name="protocolo" method="post" action="index.html" class="form-protocol-detail">
            <fieldset>
                <legend>Requerimento</legend>
            <p>
                <span class="regular-text"><label class="regular-label-requirement" id="label-name">Nome</label></span>
                <input type="text" class="regular-input" value="José da Silva" id="input-name"/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-matricula">N°
                Matrícula</label></span>
                <input type="text" class="regular-input" value="007265123"></input><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                         id="label-curso">Curso</label></span>
                <input type="text" class="regular-input" value="Sistemas de Informação"> </input><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-semestre">Semestre</label></span>
                <select class="regular-select" id="select-semestre">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                </select><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                  id="label-rg">RG</label></span><input type="text"
                                                  class="regular-input"
                                                  value="13113112-21"></input><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                  id="label-cpf">CPF</label></span><input
                                                  type="text"
                                                  class="regular-input"
                                                  value="067.345.445-27"></input><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement"
                                                  id="label-endereco">Endereço</label></span>
                <input type="text" class="regular-input" value="Alto do Cabula VI, Apt 202 N 64" size="150"></input> <br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-telefone">Telefone</label></span><input
                    type="text" class="regular-input" value="(71) 3333-3333"></input><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-data">Data:</label></span><input
                    type="text" class="regular-input" value="12/12/1969"></input><br/><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" 
                                                  id="label-objeto">Objeto do Requerimento</label></span>
                <select class="regular-select" id="select-objeto">
                    <option value="historico" default="true">Histórico Escolar</option>
                    <option value="2chamada">Segunda Chamada</option>
                    <option value="ementa">Ementa</option>
                </select><br/><br/>
                <span class="regular-text"><label class="regular-label-requirement" id="label-esclarecimento">Esclarecimento
                    sobre o objeto do requerimento:</label></span><br/><br/>
            <p><textarea rows="6" cols="80" class="regular-text-area" placeholder="Histórico Escolar para comprovação de carga horária."></textarea></p>

            <p> <input type="submit" value="Voltar" class="btn" onClick="goBack()"></input>
                <input type="submit" value="Deferir" class="btn"></input>
                <input type="submit" value="Indeferir" class="btn"></input>
                <span class="regular-text">Encaminhar:</span>
                <select>
                    <option value="1">Selecione o destino</option>
                    <option value="1">DCET - Campus I</option>
                    <option value="1">Colegiado</option>
                    <option value="1">PPG</option>
                </select>
                <input type="submit" value="Encaminhar" class="btn-encaminhar"></input>
            </p>

            </fieldset>
        </form>
    </div>
</html>
