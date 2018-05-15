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
public class EntregaRetiradaLocal extends Entrega {

    public EntregaRetiradaLocal(Pedido pedido) {
        super(pedido, null);
    }

    @Override
    public double accept(EntregaValorVisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Retirada no local";
    }
 
    
}
