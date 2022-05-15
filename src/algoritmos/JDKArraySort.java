package algoritmos;

import Estruturas.Generico;
import java.util.Arrays;

public class JDKArraySort implements Ordenador{

    @Override
    public void sort(Generico<?, ?>[] vetor, int invertido) {
        Arrays.sort(vetor);
    }

    @Override
    public String toString() {
        return "JDK Array Sort";
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
