# Projeto de Estruturas de Dados - Árvore Binária de Busca (ABB)

Este projeto implementa uma **Árvore Binária de Busca (ABB)** em Java, permitindo a criação, inserção, remoção e busca de elementos. O programa também oferece funcionalidades para exibir a árvore em ordem (traversal em ordem), verificar se a árvore está balanceada e mostrar a altura das subárvores.

## Funcionalidades:

1. **Criar árvore**: Inicializa uma árvore vazia.
2. **Exibir árvore (Em-ordem)**: Exibe os elementos da árvore de forma ordenada (traversal em ordem).
3. **Buscar valor**: Realiza a busca de um valor específico na árvore.
4. **Inserir valor**: Insere um novo valor na árvore seguindo as regras da Árvore Binária de Busca.
5. **Remover valor**: Remove um valor da árvore, ajustando os ponteiros conforme necessário.
6. **Verificar balanceamento**: Verifica se a árvore está balanceada, ou seja, se a diferença de altura entre as subárvores é menor ou igual a 1.

## Como usar:

### 1. **Compilação e Execução no VS Code**

Para executar o projeto no **Visual Studio Code**, siga os passos abaixo:

#### Pré-requisitos:

- Instale o [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versão 11 ou superior).
- Instale o [Visual Studio Code](https://code.visualstudio.com/).
- Instale a extensão **Java Extension Pack** no VS Code.

#### Passos:

1. **Clone o repositório** ou faça o download do código.
   
   ```bash
   git clone https://github.com/seu-repositorio/aabb-java.git
Abra o projeto no VS Code.

No VS Code, abra a pasta onde o projeto foi clonado.

Compile e execute o código:

Pressione Ctrl + Shift + B para compilar o código.
Pressione F5 para rodar o código no terminal integrado.
Menu de opções: Após executar, será exibido um menu para interação com a Árvore Binária de Busca. Selecione as opções conforme desejado.

<h3>2. Compilação e Execução no Eclipse</h3>
Para executar o projeto no <strong>Eclipse</strong>, siga os passos abaixo:

<h4>Pré-requisitos:</h4>
Instale o <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">Java JDK</a> (versão 11 ou superior).
Instale o <a href="https://www.eclipse.org/downloads/">Eclipse IDE</a> (recomenda-se a versão para desenvolvedores Java).
<h4>Passos:</h4>
Crie um novo projeto no Eclipse:

Abra o Eclipse e clique em File > New > Java Project.
Dê um nome para o projeto (por exemplo: ArvoreBinariaDeBusca).
Adicione o código-fonte:

Clique com o botão direito no projeto e selecione New > Class.
Adicione as classes NoArvore e Principal (ou cole o código já copiado).
Compile e execute o código:

Clique com o botão direito na classe Principal e selecione Run As > Java Application.
O terminal do Eclipse exibirá o menu de opções para interação com a árvore.
<h2>Objetivo</h2>
Este projeto foi desenvolvido como parte de um trabalho acadêmico para estudar e implementar conceitos fundamentais de estruturas de dados, como a <strong>Árvore Binária de Busca (ABB)</strong> e suas operações.

<h2>Como o código funciona:</h2> <h4>Estrutura de classes:</h4>
NoArvore: Classe que representa um nó da árvore binária. Contém os atributos valor, esquerda e direita, além dos métodos para inserir, buscar, remover e imprimir elementos.

Principal: Classe principal que contém a função main, que gerencia as operações de menu e interage com a árvore binária.

<h4>Operações realizadas:</h4>
Inserção: Ao inserir um valor, o código insere no nó correto, respeitando as regras da Árvore Binária de Busca.
Busca: Realiza uma busca recursiva pela árvore, retornando o nó correspondente ou null se o valor não for encontrado.
Remoção: A remoção lida com os casos onde o nó a ser removido tem zero, um ou dois filhos.
Exibição em ordem: A árvore é exibida de forma ordenada com um percurso em ordem (in-order traversal).
Verificação de balanceamento: A árvore é considerada balanceada se a diferença de altura entre as subárvores esquerda e direita de cada nó for no máximo 1.
<h2>Tecnologias utilizadas:</h2>
Java 11 (ou superior)
Eclipse IDE (para projetos Java)
Visual Studio Code (para desenvolvimento em Java)
<h2>Licença:</h2>
Este projeto está licenciado sob a MIT License - veja o arquivo <a href="LICENSE">LICENSE</a> para mais detalhes.
