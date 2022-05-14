package Estruturas;

//
public class Generico<Chave, Valor> implements Comparable{
    private Chave chave;
    private Valor valor;

    public Chave getChave() {
        return chave;
    }

    public Valor getValor() {
        return valor;
    }

    public Generico(Chave chave, Valor valor) {
        this.chave = chave;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Estrutura genérica: " + chave +
                ", " + valor;
    }

    @Override
    public int compareTo(Object o) {
        // Cast para o tipo correto
        Generico<?,?> objeto = (Generico<?, ?>) o;

        // Teste do tipo do valor
        if (this.valor instanceof Integer) {
            return ((Integer) this.valor).compareTo((Integer)objeto.valor);
        } else if (this.valor instanceof Double) {
            return ((Double) this.valor).compareTo((Double) objeto.valor);
        }
        // Caso nenhum dos acima, considere string
        return ((String) this.valor).compareTo((String) objeto.valor);
    }
}
