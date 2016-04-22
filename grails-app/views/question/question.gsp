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
			<g:set var="question" value="${questionInstance.question}" />
			<h3><g:message code="animal.whatDidYouThink" args="[question]" /></h3>
			<a class="button" href="${createLink(controller:'question', action:'answer', params:['answer':true, question:questionInstance.id])}"/> Sim</a>
			<a class="button" href="${createLink(controller:'question', action:'answer', params:['answer':false, question:questionInstance.id])}"/> Não</a>
		</div>
	</body>

</html>
