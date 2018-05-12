package papelaria.produto;

public class Produto {

    private String descricao;
    private double valor;
    private int peso;

    /**
     * @param descricao
     * @param valor
     * @param peso
     */
    public Produto(String descricao, double valor, int peso) {
        setDescricao(descricao);
        setValor(valor);
        setPeso(peso);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso do produto deve ser acima de ZERO");
        } else {
            this.peso = peso;
        }
    }
}
