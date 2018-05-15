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
public class EntregaPAC extends Entrega {

    public EntregaPAC(Pedido pedido, String endereco) {
        super(pedido, endereco);
    }

    @Override
    public double accept(EntregaValorVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Entrega PAC para " + endereco;
    }
    
    
}
