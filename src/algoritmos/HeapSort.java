package algoritmos;
import Estruturas.Generico;
import java.lang.Math;

public class HeapSort implements Ordenador{
    private long comparacoes;
    private long atribuicoes;
    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        comparacoes = 0;
        atribuicoes = 0;
        if (invertido == 1) {
            HeapSortInvertido(vetor);
        } else {
            HeapSort(vetor);
        }
    }

    public void HeapSort(Generico<?, ?>[] vetor) {
        buildMaxHeap(vetor, vetor.length-1);
        for (int i = vetor.length-1; i >= 1 ; i--) {
            Generico<?, ?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            maxHeapify(vetor, 0, i - 1);
        }
    }

    public void HeapSortInvertido(Generico<?, ?>[] vetor) {
        buildMinHeap(vetor, vetor.length-1);
        for (int i = vetor.length-1; i >= 1 ; i--) { atribuicoes++; comparacoes++; atribuicoes++;
            Generico<?, ?> temp = vetor[0]; atribuicoes++;
            vetor[0] = vetor[i]; atribuicoes++;
            vetor[i] = temp; atribuicoes++;
            minHeapify(vetor, 0, i - 1);
        }
    }

    private void maxHeapify(Generico<?, ?>[] vetor, int indice, int tamanho) {
        int esq = 2*indice; atribuicoes++;
        int dir = 2*indice+1; atribuicoes++;
        int maior;

        if (esq <= tamanho && vetor[esq].compareTo(vetor[indice]) > 0) { comparacoes++; comparacoes++;
            maior = esq; atribuicoes++;
        } else {
            maior = indice; atribuicoes++;
        }

        if (dir <= tamanho && vetor[dir].compareTo(vetor[maior]) > 0) { comparacoes++; comparacoes++;
            maior = dir; atribuicoes++;
        }

        if (maior != indice) { comparacoes++;
            Generico<?, ?> temp = vetor[maior]; atribuicoes++;
            vetor[maior] = vetor[indice]; atribuicoes++;
            vetor[indice] = temp; atribuicoes++;

            maxHeapify(vetor, maior, tamanho);
        }
    }

    private void minHeapify(Generico<?, ?>[] vetor, int indice, int tamanho) {
        int esq = 2*indice; atribuicoes++;
        int dir = 2*indice+1; atribuicoes++;
        int menor;

        if (esq <= tamanho && vetor[esq].compareTo(vetor[indice]) < 0) { comparacoes++; comparacoes++;
            menor = esq; atribuicoes++;
        } else {
            menor = indice; atribuicoes++;
        }

        if (dir <= tamanho && vetor[dir].compareTo(vetor[menor]) < 0) { comparacoes++; comparacoes++;
            menor = dir; atribuicoes++;
        }

        if (menor != indice) { comparacoes++;
            Generico<?, ?> temp = vetor[menor]; atribuicoes++;
            vetor[menor] = vetor[indice]; atribuicoes++;
            vetor[indice] = temp; atribuicoes++;

            minHeapify(vetor, menor, tamanho);
        }
    }



    private void buildMaxHeap(Generico<?, ?>[] vetor, int tamanho) {
        int chao = (int) Math.floor( (double) tamanho/2); atribuicoes++;
        for (int i = chao; i >= 0; i--) { atribuicoes++; comparacoes++; atribuicoes++;
            maxHeapify(vetor, i, tamanho);
        }
    }

    private void buildMinHeap(Generico<?, ?>[] vetor, int tamanho) {
        int chao = (int) Math.floor( (double) tamanho/2); atribuicoes++;
        for (int i = chao; i >= 0; i--) { atribuicoes++; comparacoes++; atribuicoes++;
            minHeapify(vetor, i, tamanho);
        }
    }

    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public long getAtribuicoes() {
        return atribuicoes;
    }
    @Override
    public String toString() {
        return "Heap Sort";
    }
}
