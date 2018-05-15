package papelaria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private final ArrayList<ItemPedido> itens;
    private Optional<Entrega> entrega;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public int getPeso() {
        return itens.stream()
                .mapToInt(it -> it.getProduto().getPeso() * it.getQuantidade())
                .sum();
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = Optional.ofNullable(entrega);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        if (entrega.isPresent()) {
            return entrega.get().getEndereco();
        }
        return null;
    }

    public void incluirItem(Produto p, int qtd) {
        this.itens.add(new ItemPedido(p, qtd));
    }

    public double getValorPedido() {
        return this.itens.stream()
                .mapToDouble(it -> it.getValorItem())
                .sum();
    }

    public double getValorEntrega() {
        if (entrega.isPresent()) {
            return entrega.get().accept(new EntregaVisitorTotal());
        }
        return 0;
    }

    public double getValorTotal() {
        return getValorPedido() + getValorEntrega();
    }

}
