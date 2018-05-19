/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papelaria;

import java.util.List;

/**
 *
 * @author gabriel-souza
 */
public class EntregaPAC implements Entrega{

    private static EntregaPAC entrega;
    
    private EntregaPAC() {}
    
    @Override
    public double calcular(List<ItemPedido> itens) {
        Integer peso = itens
                .stream()
                .map(i -> i.getProduto().getPeso())
                .reduce(Integer::sum)
                .orElse(0);
        
        if (peso > 1 && peso <= 2) {
            return 15.;
        } else if (peso > 2 && peso <= 3) {
            return 20.;
        } else if (peso > 3 && peso <= 5) {
            return 30.;
        } else {
            throw new TipoEntregaInvalido("Tipo de entrega inválido.");
        }
    }
    
    public static EntregaPAC getInstance() {
        if(entrega == null)
            entrega = new EntregaPAC();
        return entrega;
    }
    
}
