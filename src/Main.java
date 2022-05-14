import algoritmos.*;
import Estruturas.*;

public class Main {
    public static void main(String[] args) {
        Generico<Integer, Integer> [] vetor = new Generico[10];
        Ordenador algoritmo = new MergeSort();

        vetor[0]  = new Generico<Integer, Integer>(2, 3);
        vetor[1]  = new Generico<Integer, Integer>(3, 9);
        vetor[2]  = new Generico<Integer, Integer>(6, 6);
        vetor[3]  = new Generico<Integer, Integer>(8, 8);
        vetor[4]  = new Generico<Integer, Integer>(2, 7);
        vetor[5]  = new Generico<Integer, Integer>(1, 5);
        vetor[6]  = new Generico<Integer, Integer>(3, 4);
        vetor[7]  = new Generico<Integer, Integer>(2, 2);
        vetor[8]  = new Generico<Integer, Integer>(4, 3);
        vetor[9]  = new Generico<Integer, Integer>(6, 1);

        System.out.println("Teste do vetor");
        System.out.println("Posições:");
        for (int i = 0; i < vetor.length; i++ ) {
            System.out.println("P="  + i + ", Chave=" + vetor[i].getChave() + ", Valor=" + vetor[i].getValor());
        }

        System.out.println("Ordenando...");
        algoritmo.sort(vetor);

        System.out.println("Novo vetor:");
        System.out.println("Posições:");
        for (int i = 0; i < vetor.length; i++ ) {
            System.out.println("P="  + i + ", Chave=" + vetor[i].getChave() + ", Valor=" + vetor[i].getValor());
        }


    }
}