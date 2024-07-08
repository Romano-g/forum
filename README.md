<h1 align="center"><img loading="lazy" src="https://github.com/Romano-g/forum/assets/143983377/30e91f1f-df97-470b-bba6-c5267cc22ae7"></h1>
<br>
<p align="center">
  <img loading="lazy" alt="License badge" src="https://img.shields.io/badge/LICENSE-MIT-darkgreen">
  <img loading="lazy" alt="Java Developer Kit badge" src="https://img.shields.io/badge/JDK-V17.0.10-%23eb8302">
  <img loading="lazy" alt="Status badge" src="https://img.shields.io/badge/STATUS-FINALIZADO-9400D3">
</p>
<br>
<p>SpringTalks é um fórum criado seguindo as regras do modelo API REST, utilizando token JWT como instrumento de autenticação e base de dandos MySql, sendo a primeira API REST que criei sozinho e último desafio do projeto ONE.</p>

<br>
<h2>🔨 Funcionalidades do Projeto</h2>
<br>

- `Cadastro de usuários`: Utilizando o endpoint `/cadastrar`, o usuário pode enviar seu login e senha, que serão salvos na base de dados MySql, neste processo a senha será cripografada antes de ser salva;
<br>

- `Login`: Após o usuario e senha terem sido cadastrados, o usuário poderá enviar no corpo da requisição um JSON contendo login e senha, se encontrado na base de dados e os dados baterem, a API irá retornar um token JWT;
<br>

- `Autenticação`: Após receber o token JWT, o mesmo terá 2 horas de validade, e deverá ser enviado no header das próximas requisições que o usuário fizer, caso contrário as requisições serão barradas;
<br>

- `Cadastrar tópico`: Enviando uma requisição POST ao endpoint `/topicos` o usuário poderá criar seu próprio tópico, enviando no corpo da requisição o título, a mensagem e a qual curso se refere o tópico, a data de criação e o nome do usuário que realizou o cadastro serão adicionados automaticamente;
<br>

- `Listar tópicos`: Enviando uma requisição GET ao endpoint `/topicos` o retorno será uma lista com os tópicos existentes na base de dados;
<br>

- `Atualizar tópico`: Enviando uma requisição PUT ao endpoint `/topicos` o usuário deverá enviar no corpo da requisição o id do tópico, e a auteração que deseja fazer, no título, mensagem, nome do curso ou se o estado do tópico continuará como "ABERTO" ou será mudado para "FECHADO", a atualização só será aplicada se os dados do usuário forem compatíveis com o criador do tópico;
<br>

- `Detalhar tópico`: Enviando uma requisição GET ao endpoint `/topicos/{id}` o retorno será somente o tópico que contém o id enviado;
<br>

- `Deletar tópico`: Enviando uma requisição DELETE ao endpoint `/topicos/{id}` caso os dados do usuário sejam os mesmos do criador do tópico, ele será deletado da base de dados.
<br>

<h2>🛠️ Abrindo e rodando o projeto</h2>
<br>

<p>Após baixar o projeto, você pode abrir com o IntelliJ, será necessário ter o MySql e o Postman ou Insomnia instalados, como descrito no passo a passo abaixo:</p>
<br>

- Abra o IntelliJ, e selecione <b>"File" > "open"</b> (ou alguma opção similar);
- Abra o projeto do local onde foi baixado (caso esteja em zip será necessário extraí-lo antes);
- Após abrir o projeto, vá no arquivo <b>"pom.xml"</b> e atualize as dependências do maven;
- Configure as variáveis de ambiente do arquivo `application.properties`;
- Crie uma base de dados MySql com o mesmo nome da base de dados escolhido na variável de ambiente `${DB_NAME}`;
- Rode a aplicação, as atualizações da base de dados, bem como criação de tabelas e campos necessários serão automáticas;
- Utilize o Postman ou Insomnia para enviar requisições para os endpoints citados nas <b>"Funcionalidades do Projeto"</b>.
<br>

<h2>✔️ Tecnologias utilizadas</h2>
<br>

- `JDK V17.0.10`
<br>
  
- `IntelliJ IDEA`
<br>
  
- `Spring`
<br>

- `Spring Boot`
<br>

- `MySql`
<br>

- `Auth0`
<br>

- `Lombok`
<br>

- `Flyway`
