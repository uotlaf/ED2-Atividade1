package algoritmos;

import Estruturas.Generico;

public class QuickSort implements Ordenador {
    @Override
    public void sort(Generico<?, ?>[] vetor) {
        quicksort(vetor, 0, vetor.length - 1);
    }

    private static void quicksort(Generico<?, ?>[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particiona(vetor, inicio, fim);

            quicksort(vetor, inicio, posicaoPivo - 1);
            quicksort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int particiona(Generico<?, ?>[] vetor, int inicio, int fim) {
        Generico<?, ?> pivo = vetor[inicio];
        int i = inicio + 1;
        int f = fim;

        while (i <= f) {
            if (vetor[i].compareTo(pivo) <= 0) {
                i++;
            } else if (vetor[f].compareTo(pivo) > 0) {
                f--;
            } else {
                Generico<?, ?> temp = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = temp;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
}
