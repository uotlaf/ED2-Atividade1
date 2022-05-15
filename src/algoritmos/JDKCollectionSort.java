package algoritmos;

import Estruturas.Generico;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JDKCollectionSort implements Ordenador{

    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        List lista = Arrays.asList(vetor);
        Collections.sort(lista);
    }

    @Override
    public String toString() {
        return "JDK Collection Sort";
    }

    @Override
    public long getComparacoes() {
        return 0;
    }

    @Override
    public long getAtribuicoes() {
        return 0;
    }
}
