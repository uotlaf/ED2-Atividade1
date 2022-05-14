package algoritmos;

import Estruturas.Generico;

public class SelectSort implements Ordenador {
    @Override
    public void sort (Generico<?, ?>[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j].compareTo(vetor[min]) < 0) {
                    min = j;
                }
            }
            Generico<?, ?> temp = vetor[min];
            vetor[min] = vetor[i];
            vetor[i] = temp;
        }



    }
}
