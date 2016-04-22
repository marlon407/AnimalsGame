<!DOCTYPE html>
<%@ page import="animals.Question" %>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="animal.clearSuccess" default="Limpar"/></title>
	</head>
	<body>
		<div class="text-center container">
			<h2><g:message code="animal.allClean"/></h2>
			<a class="button" href="/Animals"/> <g:message code="animal.startGame" default="Limpar"/></a>
		</div>
	</body>

</html>
