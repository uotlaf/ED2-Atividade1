package algoritmos;

import Estruturas.Generico;

public class FasterSelectSort implements Ordenador {
    private long comparacoes;
    private long atribuicoes;
    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        comparacoes = 0;
        atribuicoes = 0;
        if (invertido == 1) {
            FasterSelectSortInvertido(vetor);
        } else {
            FasterSelectSort(vetor);
        }
    }

    private void FasterSelectSort(Generico<?, ?>[] vetor) {
        // Itera no início e no fim ao mesmo tempo
        // Vai adicionando no início e tirando do fim
        int fim = vetor.length - 1;
        for (int i = 0; i < fim; i++, fim--) {
            int min = i;
            int max = fim;

            for (int j = i + 1, k = fim - 1; j <= fim; j++, k--) {
                if (vetor[j].compareTo(vetor[min]) < 0)
                    min = j;

                if (vetor[k].compareTo(vetor[max]) > 0)
                    max = k;
            }
            Generico<?, ?> temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;

            if (max == i)
                max = min;

            temp = vetor[fim];
            vetor[fim] = vetor[max];
            vetor[max] = temp;
        }
    }

    private void FasterSelectSortInvertido(Generico<?, ?>[] vetor) {
        // Itera no início e no fim ao mesmo tempo
        // Vai adicionando no início e tirando do fim
        int fim = vetor.length - 1;
        for (int i = 0; i < fim; i++, fim--) {
            int min = i;
            int max = fim;

            for (int j = i + 1, k = fim - 1; j <= fim; j++, k--) {
                System.out.println("Passou");
                if (vetor[j].compareTo(vetor[min]) > 0)
                    min = j;

                if (vetor[k].compareTo(vetor[max]) < 0)
                    max = k;
            }
            Generico<?, ?> temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;

            if (max == i)
                max = min;

            temp = vetor[fim];
            vetor[fim] = vetor[max];
            vetor[max] = temp;
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
        return "Faster Select Sort";
    }
}
