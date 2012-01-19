#language: pt
@javascript
Funcionalidade: Carros
	Para vender meu carro
	Como usuário do sistema
	Eu quero registrar meu carro

	Esquema do Cenario: Login
	Dado que estou na pagina inicial
	Dado que os seguintes usuarios existem:
		| login    | email           | password |
		| jose     | jose@email.com  | 123456   |
		E clico no link "Login"
		E preencho o campo "user[email]" com "<login>"
		E preencho o campo "user[password]" com "<password>"
		E aperto o botao "Sign in"
		Entao eu deveria ver "<texto>"

	Exemplos:
		| login             | password | texto                     |
		| jose@email.com    | 123456   | Logout                    |
		| invalido          | 123456   | Invalid email or password |


	Cenario: Registrando um carro
		Dado que estou na pagina inicial
		Dado que os seguintes usuarios existem:
			| login    | email           | password |
			| jose     | jose@email.com  | 123456   |
		E clico no link "Login"
		E preencho o campo "user[email]" com "jose@email.com"
		E preencho o campo "user[password]" com "123456"
		E aperto o botao "Sign in"
		E preencho o campo "car[name]" com "Monza"
		E preencho o campo "car[description]" com "Muito bom estado." 
		E preencho o campo "car[value]" com "5000"
		E aperto o botao "Anunciar!"
		Entao eu deveria ver "Muito bom estado."


