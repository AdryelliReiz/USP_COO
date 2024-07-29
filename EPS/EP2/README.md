# Gerador de Relatórios de Produtos

Este programa Java permite gerar relatórios HTML a partir de dados de produtos armazenados em um arquivo CSV, utilizando diferentes algoritmos de ordenação e critérios de filtragem.

## Pré-requisitos

- JDK (Java Development Kit) instalado
- Arquivo CSV contendo os dados dos produtos

## Compilação

Para compilar o programa, execute o seguinte comando na linha de comando:

```bash
javac -d bin src/codigo_refatorado/*.java
```

## Uso

Para executar o programa, utilize o seguinte comando:

```bash
java -cp bin codigo_refatorado.Main <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <arquivo de entrada (.csv)> <arquivo de saída (.html)>
```

### Parâmetros:

- `<algoritmo>`: Escolha entre 'quick' para QuickSort ou 'insertion' para InsertionSort.
- `<critério de ordenação>`: Escolha entre 'preco_c', 'descricao_c', 'estoque_c' para ordenação crescente ou 'preco_d', 'descricao_d', 'estoque_d' para ordenação decrescente.
- `<critério de filtragem>`: Escolha entre 'todos', 'estoque_menor_igual', 'categoria_igual', 'preco_intervalo', 'descricao_contem'.
- `<parâmetro de filtragem>`:
  - Para 'estoque_menor_igual': Valor numérico máximo de estoque.
  - Para 'categoria_igual': Categoria específica do produto.
  - Para 'preco_intervalo': Intervalo de preços no formato 'min,max'.
  - Para 'descricao_contem': Substring que deve estar na descrição do produto.
- `<arquivo de entrada (.csv)>`: Caminho completo para o arquivo CSV contendo os dados dos produtos.
- `<arquivo de saída (.html)>`: Caminho completo onde o relatório HTML gerado será salvo.

### Exemplo:

```bash
java -cp bin codigo_refatorado.Main quick preco_c todos 0 produtos.csv relatorio.html
```

Este exemplo utiliza o algoritmo QuickSort para ordenar os produtos pelo preço em ordem crescente, sem aplicar nenhum filtro específico, a partir do arquivo CSV 'produtos.csv', gerando o relatório 'relatorio.html'.

