/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papelaria.model;

/**
 *
 * @author guilh
 */
public abstract class Entrega implements EntregaElement {

    protected String endereco;
    protected final Pedido pedido;

    protected Entrega(Pedido pedido, String endereco) {
        this.pedido = pedido;
        this.endereco = endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public String getEndereco() {
        return endereco;
    }

}
