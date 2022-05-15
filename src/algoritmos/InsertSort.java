package algoritmos;

import Estruturas.Generico;

public class InsertSort implements Ordenador{
    private long comparacoes;
    private long atribuicoes;
    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        comparacoes = 0;
        atribuicoes = 0;
        if (invertido == 1) {
            insertSortInvertido(vetor);
        } else {
            insertSort(vetor);
        }
    }

    public void insertSort(Generico <?, ?>[] vetor) {
        for (int i = 1; i < vetor.length; i++) { atribuicoes++; comparacoes++; atribuicoes++;
            Generico<?, ?> temp = vetor[i]; atribuicoes++;
            int j;
            for (j = i - 1; j >= 0 && vetor[j].compareTo(temp) > 0; j--) { atribuicoes++; comparacoes++; atribuicoes++;
                vetor[j+1] = vetor[j]; atribuicoes++;
            }
            vetor[j+1] = temp; atribuicoes++;
        }
    }

    public void insertSortInvertido(Generico<?, ?>[] vetor) {
        for (int i = 1; i < vetor.length; i++) { atribuicoes++; comparacoes++; atribuicoes++;
            Generico<?, ?> temp = vetor[i]; atribuicoes++;
            int j;
            for (j = i - 1; j >= 0 && vetor[j].compareTo(temp) < 0; j--) { atribuicoes++; comparacoes++; atribuicoes++;
                vetor[j+1] = vetor[j]; atribuicoes++;
            }
            vetor[j+1] = temp; atribuicoes++;
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
        return "Insert Sort";
    }
}
