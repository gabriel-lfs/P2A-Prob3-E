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
public class EntregaMotoboy implements Entrega{
    
     private static EntregaMotoboy entrega;
    
    private EntregaMotoboy() {}
    
    @Override
    public double calcular(List<ItemPedido> itens) {
        Integer peso = itens
                .stream()
                .map(i -> i.getProduto().getPeso())
                .reduce(Integer::sum)
                .orElse(0);
        
        if(peso <= 25 && itens.size() <= 30)
            return 7.0;
        
        throw new TipoEntregaInvalido("O tipo de entrega escolhido não é valido");
    }
    
    public static EntregaMotoboy getInstance() {
        if (entrega == null) {
            entrega = new EntregaMotoboy();
        }
        return entrega;
    }
}
