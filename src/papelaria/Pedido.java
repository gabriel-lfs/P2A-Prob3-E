package papelaria;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    private int numero;
    private String nomeCliente;
    private Date data;
    private String endereco;
    public ArrayList<ItemPedido> itens;
    
    public Pedido() {
        itens = new ArrayList();
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
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void incluirItem(Produto p, int qtd) {
        this.itens.add(new ItemPedido(p, qtd));
    }

    public double getValorPedido() {
        double valorTotal = 0;
        for (ItemPedido ip : this.itens) {
            valorTotal += (ip.getValorItem());
        }
        return valorTotal;
    }
    
    public double getValorEntrega(TipoEntrega tipo) {
        switch (tipo) {
            case SEDEX: return EntregaSEDEX.getInstance().calcular(itens);
            case MOTOBOY: return EntregaMotoboy.getInstance().calcular(itens);
            case PAC: return EntregaPAC.getInstance().calcular(itens);
            default: return 0;
        }
    }
    
    public double getValorTotal(TipoEntrega tipo) {
        return getValorPedido() + getValorEntrega(tipo);
    }

}
