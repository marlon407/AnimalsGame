<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'animal.label', default: 'Animal')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="text-center container">
			<g:form url="[resource:animalInstance, action:'save', params:[currentQuestion:currentQuestion.id]]" >
				<fieldset class="form">
					<label><g:message code="animal.whatAnimal"/></label>
					<g:textField name="name" class="text-center" maxlength="200" value="${animalInstance?.name}"/>

					<g:submitButton name="create" class="button" value="${message(code: 'default.button.create.label', default: 'Criar')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>