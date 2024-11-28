import java.util.Scanner;

public class Principal {
    public static int altura(NoArvore no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public static boolean estaBalanceada(NoArvore no) {
        return estaBalanceadaRecursivo(no) != -1 && verificarFolhasBalanceadas(no);
    }
    
    private static int estaBalanceadaRecursivo(NoArvore no) {
        if (no == null) return 0;
    
        int alturaEsquerda = estaBalanceadaRecursivo(no.esquerda);
        if (alturaEsquerda == -1) return -1;
    
        int alturaDireita = estaBalanceadaRecursivo(no.direita);
        if (alturaDireita == -1) return -1;
    
        if (Math.abs(alturaEsquerda - alturaDireita) > 1) {
            return -1;
        }
    
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
    
    private static boolean verificarFolhasBalanceadas(NoArvore no) {
        if (no == null) return true;
    
        // Array para armazenar a profundidade mínima e máxima
        int[] profundidades = new int[2]; // [0] = profundidade mínima, [1] = profundidade máxima
        profundidades[0] = Integer.MAX_VALUE;
        profundidades[1] = Integer.MIN_VALUE;
    
        // Calcula profundidade mínima e máxima das folhas
        calcularProfundidadeFolhas(no, 0, profundidades);
    
        // Verifica se a diferença entre a profundidade máxima e mínima é maior que 1
        return (profundidades[1] - profundidades[0]) <= 1;
    }
    
    private static void calcularProfundidadeFolhas(NoArvore no, int profundidadeAtual, int[] profundidades) {
        if (no == null) return;
    
        // Verifica se é uma folha
        if (no.esquerda == null && no.direita == null) {
            profundidades[0] = Math.min(profundidades[0], profundidadeAtual);
            profundidades[1] = Math.max(profundidades[1], profundidadeAtual);
        }
    
        // Verifica recursivamente as profundidades das subárvores
        calcularProfundidadeFolhas(no.esquerda, profundidadeAtual + 1, profundidades);
        calcularProfundidadeFolhas(no.direita, profundidadeAtual + 1, profundidades);
    }    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoArvore abb = null;
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar árvore");
            System.out.println("2. Exibir árvore");
            System.out.println("3. Buscar valor");
            System.out.println("4. Inserir valor");
            System.out.println("5. Remover valor");
            System.out.println("6. Verificar se a árvore está balanceada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    abb = null;
                    System.out.println("Árvore criada!");
                    break;
                case 2:
                    if (abb == null) {
                        System.out.println("Árvore vazia!");
                    } else {
                        System.out.println("\nEscolha o tipo de exibição:");
                        System.out.println("1. Em Ordem (In-Order)");
                        System.out.println("2. Pré-Ordem (Pre-Order)");
                        System.out.println("3. Pós-Ordem (Post-Order)");
                        System.out.print("Escolha uma opção: ");
                        int tipoExibicao = scanner.nextInt();

                        switch (tipoExibicao) {
                            case 1:
                                System.out.println("Exibindo em ordem (In-Order):");
                                abb.imprimeEmOrdem(abb);
                                break;
                            case 2:
                                System.out.println("Exibindo pré-ordem (Pre-Order):");
                                abb.imprimePreOrdem(abb);
                                break;
                            case 3:
                                System.out.println("Exibindo pós-ordem (Post-Order):");
                                abb.imprimePosOrdem(abb);
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                        System.out.println(); // Nova linha após a exibição
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor a ser buscado: ");
                    int valorBusca = scanner.nextInt();
                    NoArvore resultado = abb.busca(abb, valorBusca);
                    if (resultado == null) {
                        System.out.println("Valor não encontrado.");
                    } else {
                        System.out.println("Valor encontrado: " + resultado.valor);
                    }
                    break;
                case 4:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    if (abb == null) {
                        abb = new NoArvore(valorInserir);
                    } else {
                        abb = abb.insere(abb, valorInserir);
                    }
                    System.out.println("Valor inserido.");
                    break;
                case 5:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    if (abb.busca(abb, valorRemover) != null) {
                        abb = abb.remover(abb, valorRemover);
                        System.out.println("Valor removido.");
                    } else {
                        System.out.println("Valor não encontrado para remoção.");
                    }
                    break;
                case 6:
                    if (estaBalanceada(abb)) {
                        System.out.println("A árvore está balanceada.");
                    } else {
                        System.out.println("A árvore não está balanceada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
