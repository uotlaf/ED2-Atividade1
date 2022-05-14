package algoritmos;

import Estruturas.Generico;

public class MergeSort implements Ordenador{

    @Override
    public void sort(Generico<?, ?>[] vetor) {
        Generico<?, ?>[] temp = new Generico[vetor.length];
        MergeMain(vetor, temp, 0, vetor.length - 1);
    }

    private static Generico<?, ?>[] MergeMain(Generico<?, ?>[] vetor, Generico<?, ?>[] vetorTemp, int esq, int dir) {
        int meio;

        if (esq < dir) {
            meio = (esq + dir) / 2;
            MergeMain(vetor, vetorTemp, esq, meio);
            MergeMain(vetor, vetorTemp, meio + 1, dir);
            merge(vetor, vetorTemp, esq, meio + 1, dir);
        }
        return vetor;
    }

    private static void merge (Generico<?, ?>[] vetor, Generico<?, ?>[] vetorTemp, int esqPos, int dirPos, int dirFim) {
        int esqFim = dirPos - 1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while (esqPos <= esqFim && dirPos <= dirFim) {
            if (vetor[esqPos].compareTo(vetor[dirPos]) <= 0) {
                vetorTemp[tempPos++] = vetor[esqPos++];
            } else {
                vetorTemp[tempPos++] = vetor[dirPos++];
            }
        }

            while (esqPos <= esqFim) {
                vetorTemp[tempPos++] = vetor[esqPos++];
            }
            while (dirPos <= dirFim) {
                vetorTemp[tempPos++] = vetor[dirPos++];
            }


            for (int i = 0; i < numElem; i++, dirFim--) {
                vetor[dirFim] = vetorTemp[dirFim];
            }
    }
}
