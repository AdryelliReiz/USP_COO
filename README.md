# USP_COO
♨️ (USP) Exercícios, aulas e trabalhos de Computação Orientada a Objetos

## Introdução a JAVA

Java é a base de praticamente todos os tipos de aplicativo em rede e é o padrão global para desenvolvimento e fornecimento de aplicativos para celular, jogos, conteúdo on-line e software corporativo (ORACLE, 2012). Foi projetada com alguns objetivos como orientação a objetos, portabilidade (pode ser executado em qualquer ambiente), recursos de redes (grande quantidade de biblioteca cooperam com os protocolocos de rede), segurança e a sintaxe similar a C/C++.

O código criado pelo programador não é interpretado pelo ambiente onde está sendo executado, é gerado um código intermediário, denominado bytecode, que será interpretado e executado pela máquina virtual (JVM), dessa forma o programa pode ser executado em uma grande quantidade de plataforma.

### Tecnologia

A tecnologia Java é formada pela a linguagem de programação e a plataforma. Programação Java é uma linguagem de alto nível que tem as características abaixo:
    - Orientada a Objetos
    - Distribuída
    - Multitread
    - Portável
    - Alta Perfomance
    - Robusta
    - Segura

Em Java os códigos-fonte são escritos em arquivos com a extensão .java, que depois são compilados e transformados em arquivos .class pelo compilador javac. Esses arquivos contém os bytecodes que serão interpretados e executados pela Máquina virtual (JVM).

A plataforma Java é formada por dois componentes:
    - Java Virtual Machine (JVM): é a máquina virtual java, responsavel em interpretar e executar os programas escritos na linguagem java.
    - Java Application Programming Interface (API): é uma coleção de componentes de software, agrupada em bibliotecas de classes e interfaces que são conhecidas como packages. Elas disponibilizam funções prontas para serem usadas pelos programadores.

### Linguagem

A linguagem Java é orientada a objetos e é parecida com a sintaxe do C/C++, simples e robusta, minimizando assim bugs e aumentando a produtividade, dá suporte a threads nativo, acoplamento em tempo de execução, tem um garbage colletor (coletor de lixo) para remover valores da memória, não depende de plataforma. O código intermediário é interpretado por uma máquina virtual, disponibilizando assim uma compilação rápida, a sintaxe é uniforme e rigorosa a quanto a tipos (Rocha, 2012).

### API

Java disponibiliza uma grande coleção de APIS organizadas em pacotes(java.*, javax. e extensões) usadas pelos ambientes de execução(JRE) e de desenvolvimento (SDK). Principais Apis são distribuídas juntamente com os produtos para desenvolvimento (J2SE, J2EE, J2ME) (Rocha, 2012).

### Máquina Virtual

Quando um programa Java é compilado um código intermediário é gerado, chamado de bytecode. Este bytecode é interpretado pelas máquinas virtuais java (JVMs) para a maioria dos sistemas operacionais. A máquina virtual é a responsável por criar um ambiente multiplataforma (DEVJR, 2012). A execução de um programa depende da origem do código a ser executado e da forma como foi implementada A JVM (Rocha, 2012).

### Ambiente

- Java 2 System Development Kit: é uma coleção de ferramentas de linha de comando para compilar, executar e depurar aplicações Java.
- Java Runtime Environment: conjunto de arquivo que é necessário para executar aplicações Java.
- Java Micro Edition: utilizados para rodar aplicações java em dispositivos móveis.

Algumas ambiente de desenvolvimento integrado(IDE) para desenvolver Java:

    - JCeator: editor de sintaxe para a linguagem de programação Java leve e muito elegante.
    - NetBeans: é um ambiente de desenvolvimento integrado (IDE) gratuito e de código aberto para desenvolvedores de software nas linguagens Java, C, C++, PHP, Groovy, Ruby, entre outras
    - Eclipse: é uma IDE para o desenvolvimento aplicações nas linguagens Java, C, C++, PHP, Groovy, Ruby, entre outras.

## Desenvolvimento

### Package

Um Package (Pacote) é uma forma de organizar as classes dentro dos namespaces similar nos outros módulos. Um pacote fornece um namespace exclusivo para os tipos que ele contém.

### Classe, Objeto e Instância

Classe e um conjunto de objetos que possuem estados semelhantes, comportamento comum e relacionamentos comuns com outros objetos (José Eduardo Deboni).

Objeto é um elemento do munto real (José Davi Furlan), contém comportamentos (forma com que reage a estímulos) e atributos (características).

Instância é criar fisicamente uma representação concreta da classe.

O método main() é o primeiro método que vai ser chamado pelo interpretador Java, o argumento é um vetor formado por textos passados na linha de comando (Rocha, 2012).

### Palavras chaves

    abstract: um método marcado como abstract informa que o mesmo não possui uma implementação ainda, mas que uma classe que o estiver herdando precisará implementá-lo.
    assert: utilizado para fazer debug de lógica em tempo de execução.
    boolean: para variáveis de valor lógico: true e false.
    break: normalmente utilizado para interromper execuções de estruturas de repetição.
    byte: para variáveis numéricas de precisão -128 até 127.
    case: indica uma opção entre várias em blocos catch.
    catch: é utilizado juntamente com try, seu bloco é executado somente em caso de o programa lançar uma exceção do tipo indicado no seu parâmetro.
    char: para variáveis de caracteres, onde a sua representação interna equivale a um tipo numérico.
    lass: para definir o início de um arquivo Java, todas as classes possuem pelo menos essa palavra-chave.
    const: essa palavra não tem uso específico em Java mas mesmo assim é uma palavra-chave.
    continue: para pular a iteração atual de uma estrutura de repetição.
    default: normalmente utilizado para o final de uma ou mais opções case´s de um bloco catch.
    do: estrutura de repetição que garante que o bloco será executado pelo menos uma vez durante a execução do programa.
    double: para variáveis numéricas e de pontos flutuantes com precisão de 64 bits.
    else: complemento de estrutura de condição.
    enum: palavra-chave adicionada na versão 5 do Java, é um tipo especifico de dados, que assemelha-se com uma classe, que tem operações e dados internos.
    extends: utilizado para aplicar o conceito de herança para uma classe, onde uma classe receberá os métodos e variáveis de instância da classe chamada de pai.
    final: marca uma variável, classe ou método para que não seja possível modificar o seu valor ou comportamento no decorrer da execução do programa.
    finally: compõe o início de um bloco que sempre é executado para um bloco de tratamento de erros, mais utilizado para limpar recursos que foram abertos no bloco de tratamento.
    float: variáveis numéricas e de pontos flutuantes com precisão de 32 bits.
    for: estrutura de repetição que declara, testa e incrementa variável para uso local.
    goto: não tem uso específico na linguagem.
    if: estrutura de condição mais comum da linguagem.
    implements: informa que uma determinada classe irá implementar uma determinada interface.
    import: para relacionar classes externas à atual, permitindo o uso de nomes mais curtos para recursos da classe externa.
    instaceof: serve para fazer o teste "É-UM" com duas referências.
    int: para variáveis numéricas de precisão -2.147.483.648 até 2.147.483.647.
    interface: informa que o modelo não é uma classe, mas sim um protótipo de classe sem implementação para os métodos, obrigando as classes que a implementarão siga as regras de retorno, assinatura de métodos, etc...
    long: para variáveis numéricas de precisão de 64 bits.
    native: métodos marcados como native dizem que sua implementação é feita em uma outra linguagem (por exemplo C), para que se possa acessar recursos específicos do sistema operacional.
    new: utilizada para se criar novas instâncias de objetos.
    package: informa em que estrutura de diretórios a classe está localizada.
    private: marca a visibilidade de um método ou variável de instância para que apenas a própria classe acesse.
    protected: marca a visibilidade de um método ou variável de instância para que a própria classe ou suas filhas acessem.
    public: marca a visibilidade de uma classe, método ou variável de instância para que todas as classes em todos os pacotes tenham acesso.
    return: devolve para o método chamador um valor que é do mesmo tipo declarado na assinatura do método.
    short: para variáveis numéricas de precisão de -32.768 até 32.767.
    static: marca um método ou variável para que se tenha apenas uma cópia da memória desse membro.
    strictfp: serve para aumentar a precisão em operações com pontos flutuantes.
    super: chama membros da classe pai.
    switch: representa blocos de decisões de fluxos semelhantes ao if, mas com mais organização em determinadas situações.
    synchronized: um método com essa marcação será controlado para que não se possa ter duas threads acessando o mesmo objeto.
    this: representa a instância que está atualmente sendo executada.
    throw: é utilizado para lançar uma exceção.
    throws: é utilizado para se declarar que um método pode lançar uma exceção.
    transient: indica que uma determinada variável de instância não será serializada junto com o objeto da classe.
    try: para executar métodos que têm chances de lançar exceções, mas que serão tratados em blocos catch´s que o seguirão.
    void: representa um retorno vazio, ou seja, nenhum retorno para esse método.
    volatile: indica que uma determinada variável de instância pode ser modificada em duas threads distintas ao mesmo tempo.
    while: bloco de repetição que será executado enquanto seu parâmetro estiver retornando verdadeiro (true).

