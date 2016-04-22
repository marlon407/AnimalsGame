<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="text-center container">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${questionInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${questionInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:questionInstance, action:'save', params:[parentQuestion:parentQuestion.id, animal:animal.id, answer:answer, oldAnimal:oldAnimal.id]]" >
				<fieldset class="form">
					<label>Um(a) ${animal.name} _____ mas um(a) ${oldAnimal.name} não?</label>
					<g:textField name="question" maxlength="200" value="${questionInstance?.question}"/>

					<g:submitButton name="create" class="button" value="${message(code: 'default.button.create.label', default: 'Criar')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
