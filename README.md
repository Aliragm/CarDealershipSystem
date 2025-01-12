# O que tem que ter
- Funcionários
- Clientes
- Carros
	1. Showroom
	2. Pátio
# Telas
- Login
	- Usuário
	- Senha
- Menu
	- Gerenciamento de carros
		- Showroom ou pátio
		- Remoção
		- Adição
		- Venda
	- Gerenciamento de Funcionários
		- Cadastro
		- Registro de vendas
		- Remoção
		- Editar
	- Gerenciamento de clientes
		- Cadastro
		- Registro de vendas
		- Remoção
# Classes
- Pessoa (Abstrata)
	1. Data de nascimento
	2. Registro de vendas
	3. Nome
	4. Cpf
- Funcionário - herda pessoa
		1. Salário
		2. Data de ingresso
- Cliente - herda pessoa
	1. Endereço
	2. Fidelidade
- Carro
	1. Pátio ou Showroom
	2. Marca
	3. Cor
	4. Cavalos
	5. Ano
	6. Tipo
	7. Nome
	8. Usado ou Novo
- Gerenciador
	1. Cadastro Carro
	2. Cadastro Cliente
	3. Cadastro Funcionário
	4. Editar Carro
	5. Editar Cliente
	6. Editar Funcionário
	7. Remover Carro 
	8. Remover Funcionário
	9. Remover Cliente
	10. Cadastrar venda
- Banco de dados
	1. O própio banco
	2. Pessoas
	3. Carros