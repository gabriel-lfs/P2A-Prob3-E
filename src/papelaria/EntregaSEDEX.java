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
public class EntregaSEDEX implements Entrega{
    private static EntregaSEDEX entrega;
    
    private EntregaSEDEX() {}
    
    @Override
    public double calcular(List<ItemPedido> itens) {
        Integer peso = itens
                .stream()
                .map(i -> i.getProduto().getPeso())
                .reduce(Integer::sum).orElse(0);
        
        if (peso <= .5) {
            return 12.5;
        } else if (peso <= .75) {
            return 20.;
        } else if (peso <= 1.2) {
            return 30.;
        } else {
            double valor = 45.;
            if (peso - 2 >= .1) {
                for (int i = 0; i < (peso - 2) * 100 / 10; i++) {
                    valor += 1.5;
                }
            }
            if (peso * 10 - (int) peso * 10 > 0) {
                valor += 1.5;
            }
            return valor;
        }
    }
    
    public static EntregaSEDEX getInstance() {
        if (entrega == null) {
            entrega = new EntregaSEDEX();
        }
        return entrega;
    }
}
