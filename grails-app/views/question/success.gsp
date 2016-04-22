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
			<h2>Uhul, acertei de novo!</h2>
			<a class="button" href="/Animals"/> Jogar novamente</a>
		</div>
	</body>

</html>
