import java.util.Scanner;

public class Principal {
    // Verifica se a árvore está balanceada:

    public static int altura(NoArvore no) {
        if (no == null) {
            return 0;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public static boolean estaBalanceada(NoArvore no) {
        if (no == null) {
            return true;
        }
        int alturaEsquerda = altura(no.esquerda);
        int alturaDireita = altura(no.direita);

        return Math.abs(alturaEsquerda - alturaDireita) <= 1
        && estaBalanceada(no.esquerda) 
        && estaBalanceada(no.direita);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoArvore abb = null;//Árore começa vazia
        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar árvore");
            System.out.println("2. Exibir árvore (Em-ordem)");
            System.out.println("3. Buscar valor");
            System.out.println("4. Inserir valor");
            System.out.println("5. Remover valor");
            System.out.println("6. Verificar se a árvore está balanceada");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    abb = new NoArvore();
                    System.out.println("Árvore criada!");
                    System.out.println();
                    break;
                case 2:
                    if (abb == null) {
                        System.out.println("Árvore vazia!");
                    } else {
                        abb.imprime(abb, true);
                    }
                    System.out.println();
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
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valorInserir = scanner.nextInt();
                    abb = abb.insere(abb, valorInserir);
                    System.out.println("Valor inserido.");
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Digite o valor a ser removido: ");
                    int valorRemover = scanner.nextInt();
                    abb = abb.remover(abb, valorRemover);
                    System.out.println("Valor removido.");
                    System.out.println();
                    break;
                case 6:
                    if (estaBalanceada(abb)) {
                        System.out.println("A árvore está balanceada.");
                    } else {
                        System.out.println("A árvore não está balanceada.");
                    }
                    System.out.println();
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
