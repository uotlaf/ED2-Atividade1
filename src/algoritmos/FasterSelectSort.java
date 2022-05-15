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
        int fim = vetor.length - 1; atribuicoes++;
        for (int i = 0; i < fim; i++, fim--) { atribuicoes++; comparacoes++; atribuicoes++;
            int min = i; atribuicoes++;
            int max = fim; atribuicoes++;

            for (int j = i + 1, k = fim - 1; j <= fim; j++, k--) { atribuicoes++; atribuicoes++; comparacoes++; atribuicoes++; atribuicoes++;
                if (vetor[j].compareTo(vetor[min]) < 0) {
                    comparacoes++;
                    min = j;
                    atribuicoes++;
                }

                if (vetor[k].compareTo(vetor[max]) > 0) {
                    comparacoes++;
                    max = k;
                    atribuicoes++;
                }
            }
            Generico<?, ?> temp = vetor[i]; atribuicoes++;
            vetor[i] = vetor[min]; atribuicoes++;
            vetor[min] = temp; atribuicoes++;

            if (max == i) {
                atribuicoes++;
                max = min;
                atribuicoes++;
            }

            temp = vetor[fim]; atribuicoes++;
            vetor[fim] = vetor[max]; atribuicoes++;
            vetor[max] = temp; atribuicoes++;
        }
    }

    private void FasterSelectSortInvertido(Generico<?, ?>[] vetor) {
        // Itera no início e no fim ao mesmo tempo
        // Vai adicionando no início e tirando do fim
        int fim = vetor.length - 1; atribuicoes++;
        for (int i = 0; i < fim; i++, fim--) { atribuicoes++; comparacoes++; atribuicoes++; atribuicoes++;
            int min = i; atribuicoes++;
            int max = fim; atribuicoes++;

            for (int j = i + 1, k = fim - 1; j <= fim; j++, k--) { atribuicoes++; atribuicoes++; comparacoes++; atribuicoes++; atribuicoes++;
                if (vetor[j].compareTo(vetor[min]) > 0) comparacoes++;
                    min = j; comparacoes++;

                if (vetor[k].compareTo(vetor[max]) < 0) { comparacoes++;
                    max = k; atribuicoes++;
                }
            }
            Generico<?, ?> temp = vetor[i]; atribuicoes++;
            vetor[i] = vetor[min]; atribuicoes++;
            vetor[min] = temp; atribuicoes++;

            if (max == i) { comparacoes++;
                max = min; atribuicoes++;
            }

            temp = vetor[fim]; atribuicoes++;
            vetor[fim] = vetor[max]; atribuicoes++;
            vetor[max] = temp; atribuicoes++;
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
