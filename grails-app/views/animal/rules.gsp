<!DOCTYPE html>
<%@ page import="animals.Question" %>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'question.label', default: 'Question')}" />
		<title><g:message code="animal.rules"/></title>
	</head>
	<body>
		<div class="text-center container">
			<h2><g:message code="animal.rules"/></h2>
			<p class="text-left">
				Neste desafio, você deve implementar um jogo com o mesmo comportamento e lógica do executável enviado em anexo. O jogo deve ser implementado utilizando o framework Grails (versão 2.4.5), o mais orientado a objetos, simples e elegante possível.<br>
				O prazo para entrega é de duas semanas após o envio, porém quanto mais rápido você fizer, melhor.
				<br>

				Algumas considerações:<br>
				1. Garanta que o seu jogo funcione conforme o original. Parte do processo é avaliar se você foi capaz de compreender a lógica do jogo original.<br>
				2. Não são necessárias telas extremamente bem acabadas, pois não se trata de um teste de interface, porém tudo o que for feito além do mínimo conta pontos a seu favor, uma vez que demonstra cuidado com o acabamento daquilo que você cria.<br>
				3. Pode parecer estranho implementar um jogo como esse em uma aplicação Web, porém a intenção é justamente entender como você vai usar sua criatividade para tornar o jogo funcional e fluído.<br>
				4. Tanto o código fonte quanto os comentários devem ser escritos em Inglês.<br>
				5. Os conceitos chave para resolução desse problema são recursividade e árvore binária.<br>
				6. Todas as informações dos animais devem ser persistidas no banco de dados (MySQL). Desta maneira, quando a aplicação for iniciada novamente, você deve recompor a árvore a partir dos dados do banco.<br>
				7. As informações iniciais no banco devem ser inseridas na primeira vez que a aplicação rodar, ou seja, caso o banco de dados esteja vazio, insira os primeiros registros.<br>
				8. Deve ser possível apagar todos os dados do banco e retorná-lo ao estado inicial, sem as informações inseridas pelo usuário.<br>
				9. Os fontes do jogo devem ser armazenados em um repositório Git de sua preferência (Github, Bitbucket, etc), e compartilhados comigo.<br>
				10. Caso encontre problemas durante a implementação, me retorne para que possamos avaliar a situação e chegarmos a uma solução.<br>
				11. Você pode copiar uma solução pronta do Google, mas realmente não é isso que eu gostaria, já que o objetivo dessa fase do programa é avaliar a sua experiência em programação. Mesmo assim, se você copiar qualquer trecho de código da internet, livro ou artigo, por favor, faça uma referência para essa fonte no seu programa.<br>

			</p>
			<a class="button" href="/Animals"/> Começar a jogar</a>
		</div>
	</body>

</html>
