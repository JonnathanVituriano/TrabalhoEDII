public class NoArvore {
    int valor; 
    NoArvore esquerda, direita;

    // Construtor padrão
    public NoArvore() {}

    // Construtor que inicializa o nó com um valor
    public NoArvore(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public void imprimeEmOrdem(NoArvore a) {
        if (a == null) return; 
        imprimeEmOrdem(a.esquerda);
        System.out.print(a.valor + " ");
        imprimeEmOrdem(a.direita);
    }

    public void imprimePreOrdem(NoArvore a) {
        if (a == null) return;
        System.out.print(a.valor + " ");
        imprimePreOrdem(a.esquerda);
        imprimePreOrdem(a.direita);
    }

    public void imprimePosOrdem(NoArvore a) {
        if (a == null) return;
        imprimePosOrdem(a.esquerda);
        imprimePosOrdem(a.direita);
        System.out.print(a.valor + " ");
    }

    // Busca um valor na árvore binária
    public NoArvore busca(NoArvore raiz, int valorProcurado) {
        if (raiz == null || raiz.valor == valorProcurado) {
            return raiz;
        }
        if (valorProcurado < raiz.valor) {
            return busca(raiz.esquerda, valorProcurado);
        }
        return busca(raiz.direita, valorProcurado);
    }

    // Insere um valor na árvore binária
    public NoArvore insere(NoArvore a, int v) {
        if (a == null) return new NoArvore(v);
        if (v < a.valor) {
            a.esquerda = insere(a.esquerda, v);
        } else if (v > a.valor) {
            a.direita = insere(a.direita, v);
        }
        return a;
    }

    // Remove um valor da árvore binária
    public NoArvore remover(NoArvore r, int v) {
        if (r == null) return null;
        if (v < r.valor) {
            r.esquerda = remover(r.esquerda, v);
        } else if (v > r.valor) {
            r.direita = remover(r.direita, v);
        } else {
            // Caso o nó tenha apenas um filho ou nenhum
            if (r.esquerda == null) return r.direita;
            else if (r.direita == null) return r.esquerda;
            // Caso o nó tenha dois filhos: encontra o maior valor da subárvore esquerda
            r.valor = encontraMaior(r.esquerda);
            r.esquerda = remover(r.esquerda, r.valor);
        }
        return r;
    }

    // Encontra o maior valor em uma subárvore (último nó à direita)
    private int encontraMaior(NoArvore no) {
        while (no.direita != null) {
            no = no.direita;
        }
        return no.valor;
    }
}