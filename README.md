
# Encaixe WebComponent no Vue e Java

  

Projeto em Vue e Java para mostrar integração com endpoints e WebComponent da Encaixe.
Nesse projeto de referência, todas as comunicações para as APIs estão sendo realizadas através do Vue > Java > APIs Encaixe.
Caso queiram integrar direto o Vue > APIs Encaixe, sem utilizar o Java, toda a comunicação Rest no Java deve ser implementada exatamente igual no Vue.

  

**Índice:**

1 - Requisitos para rodar

2 - Explicação passo a passo do fluxo integrado a Encaixe

  
  

# 1 - Requisitos para rodar

Necessário efetuar o download de uma IDE (STS ou Eclipse padrão).

Download do Java JDK 8: https://jdk.java.net/java-se-ri/8-MR3

Siga os passos abaixo para conseguir rodar a aplicação.

  

## Importar o projeto

  

Faça o download do projeto e o importe como um "Maven Project".

  

git clone https://github.com/BrunoMarc/vue-using-webcomponent.git

  

1 - Rode o projeto JAVA com o "Run as" "Spring Boot App".

2 - Para rodar o front em Vue, entre na pasta vuejs-java-example\src\main\ui e execute o comando "npm install".

3 - Após o comando acima finalizar com sucesso, execute o comando "npm run serve".

  
  

# 2 - Explicação passo a passo do fluxo integrado a Encaixe

1 - A tela foi estruturada conforme a imagem abaixo:
![enter image description here](https://encaixe-general-assets.s3.sa-east-1.amazonaws.com/VUE-JAVA-WEBCOMPONENT/home.PNG)
No combo **Estabelecimento** será carregado o estabelecimento que irá disponibilizar as categorias e serviços para a listagem das agendas (futuramente, poderão ter mais estabelecimentos).

2 - Seleção de Categoria
![enter image description here](https://encaixe-general-assets.s3.sa-east-1.amazonaws.com/VUE-JAVA-WEBCOMPONENT/categorias.PNG)
A categoria selecionada irá popular o combo **Serviço** de acordo com os serviços existentes nessa categoria.

3 - Seleção de Serviço
![enter image description here](https://encaixe-general-assets.s3.sa-east-1.amazonaws.com/VUE-JAVA-WEBCOMPONENT/servicos.PNG)
  Após a seleção do serviço, o combo **Agenda** deverá ser carregado através da API utilizando os valores selecionados anteriormente.
  
4 - Seleção de Agenda
![enter image description here](https://encaixe-general-assets.s3.sa-east-1.amazonaws.com/VUE-JAVA-WEBCOMPONENT/agendas.PNG)

5 - Renderização do componente da Encaixe para agendamento
![enter image description here](https://encaixe-general-assets.s3.sa-east-1.amazonaws.com/VUE-JAVA-WEBCOMPONENT/webcomponent.PNG)
O componente deverá ser criado utilizando as informações selecionadas nos combos acima.

6 - Tela inicial do componente de agendamento da Encaixe
![enter image description here](https://encaixe-general-assets.s3.sa-east-1.amazonaws.com/VUE-JAVA-WEBCOMPONENT/webcomponent+aberto.PNG)
