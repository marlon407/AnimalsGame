<!DOCTYPE html>
<%@ page import="animals.Question" %>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="text-center container">
			<h3>Bem vindo ao Jogo dos Animais!<h3>
			<h3>Agora pense em um animal!</h3>
			<a class="button" href="${createLink(controller:'question', action:'index')}"/>Começar</a>
		</div>
	</body>

</html>
