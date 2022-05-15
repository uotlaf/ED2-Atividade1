package algoritmos;

import Estruturas.Generico;

public class MergeSort implements Ordenador{
    private long comparacoes;
    private long atribuicoes;
    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        comparacoes = 0;
        atribuicoes = 0;
        Generico<?, ?>[] temp = new Generico[vetor.length];
        if (invertido == 1) {
            MergeMainInvertido(vetor, temp, 0, vetor.length - 1);
        } else {
            MergeMain(vetor, temp, 0, vetor.length - 1);
        }
    }

    private Generico<?, ?>[] MergeMain(Generico<?, ?>[] vetor, Generico<?, ?>[] vetorTemp, int esq, int dir) {
        int meio;

        if (esq < dir) { comparacoes++;
            meio = (esq + dir) / 2; atribuicoes++;
            MergeMain(vetor, vetorTemp, esq, meio);
            MergeMain(vetor, vetorTemp, meio + 1, dir);
            merge(vetor, vetorTemp, esq, meio + 1, dir);
        }
        return vetor;
    }

    private Generico<?, ?>[] MergeMainInvertido(Generico<?, ?>[] vetor, Generico<?, ?>[] vetorTemp, int esq, int dir) {
        int meio;

        if (esq < dir) { comparacoes++;
            meio = (esq + dir) / 2; atribuicoes++;
            MergeMainInvertido(vetor, vetorTemp, esq, meio);
            MergeMainInvertido(vetor, vetorTemp, meio + 1, dir);
            mergeInvertido(vetor, vetorTemp, esq, meio + 1, dir);
        }
        return vetor;
    }

    private void merge (Generico<?, ?>[] vetor, Generico<?, ?>[] vetorTemp, int esqPos, int dirPos, int dirFim) {
        int esqFim = dirPos - 1; atribuicoes++;
        int tempPos = esqPos; atribuicoes++;
        int numElem = dirFim - esqPos + 1; atribuicoes++;

        while (esqPos <= esqFim && dirPos <= dirFim) {  comparacoes++;comparacoes++;
            if (vetor[esqPos].compareTo(vetor[dirPos]) <= 0) { comparacoes++;
                vetorTemp[tempPos++] = vetor[esqPos++];atribuicoes++;
            } else {
                vetorTemp[tempPos++] = vetor[dirPos++];atribuicoes++;
            }
        }

            while (esqPos <= esqFim) { comparacoes++;
                vetorTemp[tempPos++] = vetor[esqPos++];atribuicoes++;
            }
            while (dirPos <= dirFim) { comparacoes++;
                vetorTemp[tempPos++] = vetor[dirPos++];atribuicoes++;
            }


            for (int i = 0; i < numElem; i++, dirFim--) { atribuicoes++;comparacoes++;atribuicoes++;
                vetor[dirFim] = vetorTemp[dirFim]; atribuicoes++;
            }
    }

    private void mergeInvertido (Generico<?, ?>[] vetor, Generico<?, ?>[] vetorTemp, int esqPos, int dirPos, int dirFim) {
        int esqFim = dirPos - 1; atribuicoes++;
        int tempPos = esqPos; atribuicoes++;
        int numElem = dirFim - esqPos + 1; atribuicoes++;

        while (esqPos <= esqFim && dirPos <= dirFim) { comparacoes++; comparacoes++;
            if (vetor[esqPos].compareTo(vetor[dirPos]) >= 0) { comparacoes++;
                vetorTemp[tempPos++] = vetor[esqPos++]; atribuicoes++;
            } else {
                vetorTemp[tempPos++] = vetor[dirPos++]; atribuicoes++;
            }
        }

        while (esqPos <= esqFim) { comparacoes++;
            vetorTemp[tempPos++] = vetor[esqPos++]; atribuicoes++;
        }
        while (dirPos <= dirFim) { comparacoes++;
            vetorTemp[tempPos++] = vetor[dirPos++]; atribuicoes++;
        }


        for (int i = 0; i < numElem; i++, dirFim--) { atribuicoes++; comparacoes++; atribuicoes++; atribuicoes++;
            vetor[dirFim] = vetorTemp[dirFim]; atribuicoes++;
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
        return "Merge Sort";
    }
}
