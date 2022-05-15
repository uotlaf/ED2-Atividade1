import algoritmos.*;
import Estruturas.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static String RandomString(int max) {// Gera strings. Fonte: https://www.programiz.com/java-programming/examples/generate-random-string
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!@#$%*()_-+=§{}[]ªºÇç:;.><,/?°";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < max; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Generico<?, ?> [] vetor = null;
        Ordenador algoritmo = null;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int resposta;
        int tipo = 0; // 1=a, 2=b e 3=c
        int direcao = 0; // normal = 0, invertido = 1
        int maxStringSize = 15;
        String respostastr;
        Double respostadbl;
        int comparacoes = 0;

        while (true) {
            if (algoritmo != null) {
                System.out.print("- Algoritmo escolhido: " + algoritmo);
                if (direcao == 1) {
                    System.out.println(" Invertido");
                } else {
                    System.out.println("");
                }
            } else {
                System.out.println("- Nenhum Algoritmo escolhido");
            }

            if (vetor != null) {
                switch (tipo) {
                    case 1:
                        System.out.println("- Vetor tem " + vetor.length + " posições com dados do tipo A (String e Double)");
                        break;
                    case 2:
                        System.out.println("- Vetor tem " + vetor.length + " posições com dados do tipo B (Double e String)");
                        break;
                    case 3:
                        System.out.println("- Vetor tem " + vetor.length + " posições com dados do tipo C (Double e Integer)");
                        break;
                    default:
                        System.out.println("- Vetor tem " + vetor.length + " posições sem tipo de dado definido");
                }
            } else {
                System.out.println("- Tamanho do vetor não definido");
            }

            System.out.println("Menu principal");
            System.out.println("1 - Definir tamanho do vetor");
            System.out.println("2 - Definir tipo de dado");
            System.out.println("3 - Popular vetor");
            System.out.println("4 - Definir algoritmo");
            System.out.println("5 - Inverter direção do algoritmo");
            System.out.println("6 - Manda brasa!");
            System.out.print("Digite um número: ");
            try {
                resposta = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
                continue;
            }

            switch (resposta) {
                case 1: // Tamanho do vetor
                    while (true) {
                        System.out.println("Defina o tamanho do vetor:");
                        try {
                            resposta = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            scanner.next();
                            continue;
                        }
                        vetor = new Generico[resposta];
                        break;
                    }
                    break;
                case 2: // Tipo de dado
                    while (true) {
                        System.out.println("Escolha o tipo de dado:");
                        System.out.println("1 - TIPO A: Chave String e Valor Double");
                        System.out.println("2 - TIPO B: Chave Double e Valor String");
                        System.out.println("3 - TIPO C: Chave Double e Valor Integer");
                        System.out.print("Escolha um número:");
                        try {
                            resposta = scanner.nextInt();
                            if (resposta < 1 || resposta > 3) continue;
                        } catch (InputMismatchException e) {
                            scanner.next();
                            continue;
                        }
                        tipo = resposta;
                        break;
                    }
                    break;
                case 3: // Popular vetor
                    if (vetor == null) {
                        System.out.println("Primeiro crie um vetor");
                        break;
                    } else if (tipo == 0) {
                        System.out.println("Primeiro defina o tipo de variável");
                        break;
                    }
                    while (true) {
                        System.out.println("Como você quer popular:");
                        System.out.println("1 - Automagicamente/Gerar aleatoriamente");
                        System.out.println("2 - Escolher manualmente");
                        try {
                            resposta = scanner.nextInt();
                            if (resposta < 1 || resposta > 2) continue;
                        } catch (InputMismatchException e) {
                            scanner.next();
                            continue;
                        }
                        break;
                    }
                    switch (resposta) {
                        case 1: // Automagicamente
                            System.out.println("Gerando...");
                            switch (tipo) {
                                case 1:// Gerar strings e doubles no vetor
                                    for (int i = 0; i < vetor.length; i++) {
                                        vetor[i] = new Generico<String, Double>(RandomString(maxStringSize), random.nextDouble());
                                    }
                                    break;
                                case 2: // Gerar doubles e strings
                                    for (int i = 0; i < vetor.length; i++) {
                                        vetor[i] = new Generico<Double, String>(random.nextDouble(), RandomString(maxStringSize));
                                    }
                                    break;
                                case 3: // Gerar doubles e inteiros
                                    for (int i = 0; i < vetor.length; i++) {
                                        vetor[i] = new Generico<Double, Integer>(random.nextDouble(), random.nextInt());
                                    }
                                    break;
                            }
                            System.out.println("Resultados gerados com sucesso");
                            break;
                        case 2: // Manualmente
                            switch (tipo) {
                                case 1: // String+Double
                                    for (int i = 0; i < vetor.length; i++) {
                                        while (true) {
                                            System.out.println("Digite a chave " + i + " [String]:");
                                            // Chave
                                            respostastr = scanner.next();
                                            if (respostastr.length() < 10) {
                                                System.out.println("A string deve ter no mínimo 10 caracteres");
                                                continue;
                                            }
                                            break;
                                        }
                                        while (true) {
                                            // Valor
                                            System.out.println("Digite o valor " + i + " [Double]:");
                                            try {
                                                respostadbl = scanner.nextDouble();
                                            } catch (InputMismatchException e) {
                                                scanner.next();
                                                continue;
                                            }
                                            break;
                                        }
                                        vetor[i] = new Generico<String,Double>(respostastr,respostadbl);
                                        System.out.println("Chave " + respostastr + " e Valor " + respostadbl + " Adicionados a posição " + i);
                                    }
                                    break;
                                case 2: // Double+String
                                    for (int i = 0; i < vetor.length; i++) {
                                        while (true) {
                                            // Chave
                                            System.out.println("Digite a chave " + i + " [Double]:");
                                            try {
                                                respostadbl = scanner.nextDouble();
                                            } catch (InputMismatchException e) {
                                                scanner.next();
                                                continue;
                                            }
                                            break;
                                        }
                                        while (true) {
                                            System.out.println("Digite o valor " + i + " [String]:");
                                            // Valor
                                            respostastr = scanner.next();
                                            if (respostastr.length() < 10) {
                                                System.out.println("A string deve ter no mínimo 10 caracteres");
                                                continue;
                                            }
                                            break;
                                        }
                                        vetor[i] = new Generico<Double, String>(respostadbl,respostastr);
                                        System.out.println("Chave " + respostadbl + " e Valor " + respostastr + " Adicionados a posição " + i);
                                    }
                                    break;
                                case 3: // Double+Integer
                                    for (int i = 0; i < vetor.length; i++) {
                                        while (true) {
                                            // Chave
                                            System.out.println("Digite a chave " + i + " [Double]:");
                                            try {
                                                respostadbl = scanner.nextDouble();
                                            } catch (InputMismatchException e) {
                                                scanner.next();
                                                continue;
                                            }
                                            break;
                                        }
                                        while (true) {
                                            // Chave
                                            System.out.println("Digite a chave " + i + " [Integer]:");
                                            try {
                                                resposta = scanner.nextInt();
                                            } catch (InputMismatchException e) {
                                                scanner.next();
                                                continue;
                                            }
                                            break;
                                        }
                                        vetor[i] = new Generico<Double, Integer>(respostadbl,resposta);
                                        System.out.println("Chave " + respostadbl + " e Valor " + resposta + " Adicionados a posição " + i);
                                    }
                                    break;

                            }
                    }
                    break;
                case 4: // definir algoritmo
                    while (true) {
                        System.out.println("Algoritmos disponíveis:");
                        System.out.println("1 - Select Sort");
                        System.out.println("2 - Quick Sort");
                        System.out.println("3 - Merge Sort");
                        System.out.println("4 - Insert Sort");
                        System.out.println("5 - Merge Sort + Insert Sort");
                        System.out.println("6 - Heap Sort");
                        System.out.println("7 - Faster Select Sort");
                        System.out.println("8 - JDK Array Sort");
                        System.out.println("9 - JDK Collection Sort");

                        try {
                            resposta = scanner.nextInt();
                            if (resposta < 1 || resposta > 9) continue;
                        } catch (InputMismatchException e) {
                            scanner.next();
                            continue;
                        }

                        switch (resposta) {
                            case 1:
                                algoritmo = new SelectSort();
                                break;
                            case 2:
                                algoritmo = new QuickSort();
                                break;
                            case 3:
                                algoritmo = new MergeSort();
                                break;
                            case 4:
                                algoritmo = new InsertSort();
                                break;
                            case 5:
                                algoritmo = new InsertMergeSort();
                                break;
                            case 6:
                                algoritmo = new HeapSort();
                                break;
                            case 7:
                                algoritmo = new FasterSelectSort();
                                break;
                            case 8:
                                algoritmo = new JDKArraySort();
                                break;
                            case 9:
                                algoritmo = new JDKCollectionSort();
                                break;
                            default:
                                System.out.println("Algoritmo desconhecido");
                                break;
                        }
                        break;
                    }
                    break;
                case 5: // Definir direção o algoritmo
                    if (direcao == 0) direcao = 1;
                    else direcao = 0;
                    break;
                case 6: // Manda brasa!!!
                    if (vetor == null) {
                        System.out.println("Defina o vetor");
                        break;
                    } else if (tipo == 0) {
                        System.out.println("Defina o tipo de dado");
                        break;
                    } else if (vetor[0] == null) {
                        System.out.println("Popule o vetor");
                        break;
                    } else if (algoritmo == null) {
                        System.out.println("Defina o algoritmo");
                    }

                    // Manda brasa!
                    long timeinicio = System.nanoTime();
                    System.out.println("AOOOOOOOOOOBAAAAA!!!");

                    System.out.println("Executando algoritmo...");
                    algoritmo.sort(vetor, direcao);
                    long timefim = System.nanoTime();

                    long tempo = timefim - timeinicio;
                    long micro;
                    long mili = 0;
                    long sec = 0;
                    long min = 0;
                    long hour = 0;

                    micro = tempo / 1000;
                    if (micro > 1000) {
                        mili = micro / 1000;
                        micro -= mili * 1000;
                    }
                    if (mili > 1000) {
                        sec = mili / 1000;
                        mili -= sec * 1000;
                    }
                    if (sec > 60) {
                        min = sec / 60;
                        sec -= min * 60;
                    }
                    if (min > 60) {
                        hour = min / 60;
                        min -= hour * 60;
                    }

                    System.out.println("Tempo: " + hour + "h:" + min + "m:" + sec + "s:" + mili + "ms:" + micro + "us");
                    System.out.println("Comparações: " + algoritmo.getComparacoes());
                    System.out.println("Atribuições: " + algoritmo.getAtribuicoes());

                    System.out.println("Verificando vetor...");
                    if (direcao == 0) {
                        for (int i = 0; i < vetor.length - 1; i++) {
                            if (vetor[i].compareTo(vetor[i+1]) > 0) {
                                System.out.println("Achei um erro: " + vetor[i].getValor() + "é maior que " + vetor[i+1].getValor());
                            }
                        }
                    } else {
                        for (int i = 0; i < vetor.length - 1; i++) {
                            if (vetor[i].compareTo(vetor[i+1]) < 0) {
                                System.out.println("Achei um erro: " + vetor[i].getValor() + "é menor que " + vetor[i+1].getValor());
                            }
                        }
                    }

                    if (vetor.length < 10) {
                        for (int i = 0; i < vetor.length; i++) {
                            System.out.println("Posição" + i + " Chave \t" + vetor[i].getChave() + " Valor \t" + vetor[i].getValor());
                        }
                    }

                    System.out.print("Vetor verificado com sucesso");;
                    break;
            }

            //System.out.println("Pressione enter para continuar");
            //scanner.nextLine();
            //scanner.nextLine();
        }
    }
}