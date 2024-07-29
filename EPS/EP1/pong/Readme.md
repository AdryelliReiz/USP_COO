# Identificação

Nome: Adryelli Reis dos Santos

NUSP: 14714019

# Informações importantes

## Como compilar e executar o código?

Primeiramente, tenha o Java 17 instalado na sua máquina.
Abra o terminal e vá até o diretório da pasta `pong`.
```
cd pong
```
Compile todos os arquivos .java usando:
```
javac *.java
```
Execute o código usando:
```
java Pong
```
Aproveite a experiência e que os jogos comecem :>

## Possíveis erros que podem ocorrer e por quê

### Contexto
Os únicos arquivos que foram editados e disponibilizados o código (`Ball.java`, `Player.java`, `Score.java`) já tinham métodos pré-estruturados e o objetivo era completar o código que estava faltando para o jogo funcionar.
Alguns desses métodos estão estruturados com parâmetros que não são bem aproveitados ou que poderiam ter trazido outras informações mais relevantes que poderiam melhorar o algoritmo do código em questão.
Tendo em vista que essas classes e métodos foram usados nos arquivos que não possuímos o código-fonte e que não podemos mexer no código compilado já existente, nos deparamos com alguns problemas.

### Problema da classe Score
Essa classe possui um método `Score` que é chamado no momento em que instanciamos o objeto dessa classe, e nesse método recebemos como parâmetro o ID do Player associado a esse score. Esse método basicamente cria um score do player e desenha na tela o mesmo. No entanto, quando o score é criado, alguns atributos são definidos e com isso seus valores são setados. Entretanto, um de seus atributos está sendo setado manualmente, o que não atrapalha a jogabilidade, mas não é um bom jeito de setar esse atributo.
Uma maneira mais dinâmica e eficiente para fazer isso seria passar como parâmetro o objeto Player em questão, porque assim teríamos acesso ao atributo Cor do player apenas criando um novo método que retorne esse atributo ou até mesmo passando a cor do player como parâmetro.
Assim, conseguiríamos deixar o score do player com a cor do mesmo de maneira dinâmica.

Além disso, o método `draw` compara os IDs dos players (única coisa possível de comparar) para saber onde posicionar o score de cada player. Essa comparação está sendo feita de maneira estática com IDs do tipo "Player1" pois não temos um meio melhor de identificar cada player se não assim. Se por algum acaso, o ID do player 1 for diferente ou se os IDs forem criados com outro padrão, esse código terá quer ser alterado para continuar funcionando.

### Problema da classe Ball
Essa classe possui um método chamado `onPlayerCollision` que é chamado sempre que ocorre uma colisão do player com a bola.
Esse método recebe um parâmetro `playerId` que é do tipo String. Esse parâmetro serve para sabermos qual dos players colidiu com a bola.
No entanto, essa informação se faz desnecessária quando não temos informações adicionais, como a posição atual do player. Essa informação seria bem útil para que possamos saber em qual dos lados do player a bola colidiu para assim calcular melhor o ângulo que a bola deve seguir.
Sem essas informações é mais complicado criar um método eficiente que consiga recalcular o ângulo da bola.
Dito isso, o jogo apresenta um "BUG" quando a bola colide na parte de cima e na parte de baixo do player, pois quando o método `onPlayerCollision` refaz os cálculos do ângulo, tem a probabilidade do ângulo escolhido "entrar" dentro do player, o que faz a bola "andar grudada" no mesmo.
Existem meios de fazer esse cálculo mais complexo, mas nenhum deles seria o ideal.