package algoritmos;
import Estruturas.Generico;
import java.lang.Math;

public class HeapSort implements Ordenador{
    @Override
    public void sort(Generico<?, ?>[] vetor) {
        buildMaxHeap(vetor, vetor.length-1);
        for (int i = vetor.length-1; i >= 1 ; i--) {
            Generico<?, ?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            maxHeapify(vetor, 0, i - 1);
        }

    }

    private static void maxHeapify(Generico<?, ?>[] vetor, int indice, int tamanho) {
        int esq = 2*indice;
        int dir = 2*indice+1;
        int maior;

        if (esq <= tamanho && vetor[esq].compareTo(vetor[indice]) > 0) {
            maior = esq;
        } else {
            maior = indice;
        }

        if (dir <= tamanho && vetor[dir].compareTo(vetor[maior]) > 0) {
            maior = dir;
        }

        if (maior != indice) {
            Generico<?, ?> temp = vetor[maior];
            vetor[maior] = vetor[indice];
            vetor[indice] = temp;

            maxHeapify(vetor, maior, tamanho);
        }
    }

    private static void buildMaxHeap(Generico<?, ?>[] vetor, int tamanho) {
        int chao = (int) Math.floor( (double) tamanho/2);
        for (int i = chao; i >= 0; i--) {
            maxHeapify(vetor, i, tamanho);
        }
    }
}
