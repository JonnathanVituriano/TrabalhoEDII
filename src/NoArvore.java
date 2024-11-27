public class NoArvore {
    int valor;
    NoArvore direita;
    NoArvore esquerda;

    public void imprime(NoArvore a, boolean isFirst) {
        // Em-ordem (esquerda, raiz, direita)
        if (a != null){
            imprime (a.esquerda, isFirst);
            if(!isFirst){
                System.out.print(" - ");
            }
            System.out.print(a.valor);
            imprime(a.direita, false);
        
        }
    }

    public NoArvore busca(NoArvore raiz, int valorprocurado) {
        if (raiz == null) {
            return null;
        }
        else if (raiz.valor > valorprocurado) {
            return busca(raiz.esquerda, valorprocurado);
        }
        else if (raiz.valor < valorprocurado) {
            return busca(raiz.direita, valorprocurado);
        }
        else {
            return raiz;
        }
    }

    public NoArvore insere (NoArvore a, int v) {
        //Caso a árvore não tenha filhos (ou seja nula)
        if (a == null) {
            a = new NoArvore();
            a.valor = v;
            a.esquerda = a.direita = null;
        }
        //Inserir na esquerda da árvore
        else if (v < a.valor) {
            a.esquerda = insere(a.esquerda, v);
        }
        //Inserir na direita da árvore
        else if (v > a.valor) {
            a.direita = insere(a.direita, v);
        }
        // Caso o valor já exista na árvore, não é necessário fazer nada
        return a;
    }

    public NoArvore remover(NoArvore r, int v) {
        if (r == null){
            return null;
        } else if (r.valor > v) {
            r.esquerda = remover(r.esquerda, v);
        } else if (r.valor < v) {
            r.direita = remover(r.direita, v);
        } else {
            //Achou o nó a ser removido

            //1 - Se o nó não tem filhos, ele será eliminado...
            if (r.esquerda == null && r.direita == null) {
                r = null;
            }
            //2 - Se o nó tem filho apenas a direita...
            else if (r.esquerda == null) {
                r = r.direita;
            }
            //3 - Se o nó tem filho apenas a esquerda...
            else if (r.direita == null) {
                r = r.esquerda;
            }
            //4 - Se o nó tem dois filhos...
            else {
                NoArvore subesquerda = r.esquerda;
                while (subesquerda.direita !=null) {
                    //Capturar o maior nó da subárvore esquerda
                    subesquerda = subesquerda.direita;
                }
                //subesquerda.valor é o maior nó da subárvore esquerda
                r.valor = subesquerda.valor; //troca as informações
                r.esquerda = remover (r.esquerda, subesquerda.valor); 
            }
        }
        return r;
    }

}