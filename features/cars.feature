#language: pt
Funcionalidade: Carros
	Para vender meu carro
	Como usuário do sistema
	Eu quero registrar meu carro

	Cenario: Registrando um carro
		Dado que estou na pagina inicial
		E preencho o campo "car[name]" com "Monza"
		E preencho o campo "car[description]" com "Muito bom estado." 
		E preencho o campo "car[value]" com "5000"
		E aperto o botao "Anunciar!"
		Entao eu deveria ver "Muito bom estado."

