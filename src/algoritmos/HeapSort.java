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
        for (int i = vetor.length-1; i >= 1 ; i--) {
            Generico<?, ?> temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            minHeapify(vetor, 0, i - 1);
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

    private static void minHeapify(Generico<?, ?>[] vetor, int indice, int tamanho) {
        int esq = 2*indice;
        int dir = 2*indice+1;
        int menor;

        if (esq <= tamanho && vetor[esq].compareTo(vetor[indice]) < 0) {
            menor = esq;
        } else {
            menor = indice;
        }

        if (dir <= tamanho && vetor[dir].compareTo(vetor[menor]) < 0) {
            menor = dir;
        }

        if (menor != indice) {
            Generico<?, ?> temp = vetor[menor];
            vetor[menor] = vetor[indice];
            vetor[indice] = temp;

            minHeapify(vetor, menor, tamanho);
        }
    }



    private static void buildMaxHeap(Generico<?, ?>[] vetor, int tamanho) {
        int chao = (int) Math.floor( (double) tamanho/2);
        for (int i = chao; i >= 0; i--) {
            maxHeapify(vetor, i, tamanho);
        }
    }

    private static void buildMinHeap(Generico<?, ?>[] vetor, int tamanho) {
        int chao = (int) Math.floor( (double) tamanho/2);
        for (int i = chao; i >= 0; i--) {
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
