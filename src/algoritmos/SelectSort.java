package algoritmos;

import Estruturas.Generico;

public class SelectSort implements Ordenador {
    private long comparacoes = 0;
    private long atribuicoes = 0;
    @Override
    public void sort(Generico<?, ?>[] vector, int inverted) {
        if (inverted == 0) {
            selectSort(vector);
        } else {
            selectSortInverted(vector);
        }
    }

    public void selectSort (Generico<?, ?>[] vector) {
        for (int i = 0; i < vector.length - 1; i++) { atribuicoes++; comparacoes++; atribuicoes++;
            int min = i; atribuicoes++;
            for (int j = i + 1; j < vector.length; j++) { atribuicoes++; comparacoes++; atribuicoes++;
                if (vector[j].compareTo(vector[min]) < 0) { comparacoes++;
                    min = j; atribuicoes++;
                }
            }
            Generico<?, ?> temp = vector[min]; atribuicoes++;
            vector[min] = vector[i]; atribuicoes++;
            vector[i] = temp; atribuicoes++;
        }
    }

    public void selectSortInverted(Generico<?, ?>[] vector) {
        for (int i = 0; i < vector.length - 1; i++) { atribuicoes++; comparacoes++;
            int max = i; atribuicoes++;
            for (int j = i + 1; j < vector.length; j++) { atribuicoes++; comparacoes++;
                if (vector[j].compareTo(vector[max]) > 0) { comparacoes++;
                    max = j; atribuicoes++;
                }
            }
            Generico<?, ?> temp = vector[max]; atribuicoes++;
            vector[max] = vector[i]; atribuicoes++;
            vector[i] = temp; atribuicoes++;
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
        return "Select Sort";
    }
}
