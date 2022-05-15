package algoritmos;

import Estruturas.Generico;

public interface Ordenador {

    // Retorna a quantidade de iterações
    public void sort(Generico<?, ?>[] vetor, int invertido);

    public long getComparacoes();

    public long getAtribuicoes();
}
