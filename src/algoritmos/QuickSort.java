package algoritmos;

import Estruturas.Generico;

public class QuickSort implements Ordenador {
    private int comparacoes;
    private int atribuicoes;

    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        comparacoes = 0;
        atribuicoes = 0;
        if (invertido == 0) {
            quicksort(vetor, 0, vetor.length - 1);
        } else {
            quicksortinvertido(vetor, 0, vetor.length - 1);
        }
    }

    private void quicksort(Generico<?, ?>[] vetor, int inicio, int fim) {
        if (inicio < fim) { comparacoes++;
            int posicaoPivo = particiona(vetor, inicio, fim); atribuicoes++;

            quicksort(vetor, inicio, posicaoPivo - 1);
            quicksort(vetor, posicaoPivo + 1, fim);
        }
    }

    private void quicksortinvertido(Generico<?, ?>[] vetor, int inicio, int fim) {
        if (inicio < fim) { comparacoes++;
            int posicaoPivo = particionaInvertido(vetor, inicio, fim); atribuicoes++;
            quicksortinvertido(vetor, inicio, posicaoPivo - 1);
            quicksortinvertido(vetor, posicaoPivo + 1, fim);
        }
    }

    private int particiona(Generico<?, ?>[] vetor, int inicio, int fim) {
        Generico<?, ?> pivo = vetor[inicio]; atribuicoes++;
        int i = inicio + 1;atribuicoes++;
        int f = fim;atribuicoes++;

        while (i <= f) { comparacoes++;
            if (vetor[i].compareTo(pivo) <= 0) { comparacoes++;
                i++; atribuicoes++;
            } else if (vetor[f].compareTo(pivo) > 0) { comparacoes++;
                f--; comparacoes++;
            } else {
                Generico<?, ?> temp = vetor[i]; atribuicoes++;
                vetor[i] = vetor[f]; atribuicoes++;
                vetor[f] = temp; atribuicoes++;
                i++; atribuicoes++;
                f--; atribuicoes++;
            }
        }
        vetor[inicio] = vetor[f]; atribuicoes++;
        vetor[f] = pivo; atribuicoes++;
        return f;
    }

    private int particionaInvertido(Generico<?, ?>[] vetor, int inicio, int fim) {
        Generico<?, ?> pivo = vetor[inicio]; atribuicoes++;
        int i = inicio + 1; atribuicoes++;
        int f = fim; atribuicoes++;

        while (i <= f) { comparacoes++;
            if (vetor[i].compareTo(pivo) >= 0) { comparacoes++;
                i++; atribuicoes++;
            } else if (vetor[f].compareTo(pivo) < 0) { comparacoes++;
                f--; comparacoes++;
            } else {
                Generico<?, ?> temp = vetor[i]; atribuicoes++;
                vetor[i] = vetor[f]; atribuicoes++;
                vetor[f] = temp; atribuicoes++;
                i++; atribuicoes++;
                f--; atribuicoes++;
            }
        }

        vetor[inicio] = vetor[f]; atribuicoes++;
        vetor[f] = pivo; atribuicoes++;
        return f;
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
        return "Quick Sort";
    }
}
