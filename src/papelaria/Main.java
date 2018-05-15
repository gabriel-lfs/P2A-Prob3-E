/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papelaria;

import java.text.DecimalFormat;
import java.util.Date;
import papelaria.model.EntregaPAC;
import papelaria.model.EntregaRetiradaLocal;
import papelaria.model.EntregaSedex;
import papelaria.model.Pedido;
import papelaria.model.Produto;

/**
 *
 * @author guilh
 */
public class Main {

    private final static Produto[] PRODUTOS = new Produto[]{
        new Produto("Objeto A", 0.25, 100),
        new Produto("Objeto B", 1.50, 150),
        new Produto("Item C", 1.50, 120),
        new Produto("Item D", 3.50, 500),
        new Produto("Treco E", 5.00, 1500),
        new Produto("Treco D", 10.50, 2500)
    };

    public static void main(String[] args) {
        /*
        Crie uma classe contendo o método main para demonstrar a instanciação do pedido, inclusão de itens
        e a chamada ao método para cálculo da entrega do pedido (getValorEntrega). Mantendo a mesma
        instância de pedido, modifique o tipo de entrega e demonstre a aplicação correta do valor para a entrega
        utilizada. Inclua uma situação em que a exceção deve ser lançada.
         */
        System.out.println("Demonstração de calculo de entrega");
        DecimalFormat dmf = new DecimalFormat("###,###,##0.00");

        String localEntrega = "Local de entrega";

        Pedido pedido = new Pedido();
        pedido.setData(new Date());
        pedido.setNomeCliente("Jon Doe");
        pedido.setNumero(1);

        // Com os produtos inclusos
        pedido.incluirItem(PRODUTOS[0], 5);// Incluindo 5 'Objetos A' =  500g || R$ 1,25
        pedido.incluirItem(PRODUTOS[1], 1);// Incluindo 5 'Objeto B'  =  150g || R$ 1,50
        pedido.incluirItem(PRODUTOS[3], 1);// Incluindo 5 'Objeto B'  =  500g || R$ 3,50
        //                                    Totais:                 = 1150g || R$ 6,25

        // Retirar o produto no local é de graça e não precisa de endereço do cliente
        // Entrega = 0
        // Pedido  = 6,25
        // Total   = 6,25
        pedido.setEntrega(new EntregaRetiradaLocal(pedido));
        System.out.println(pedido.toString());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        
        // Entrega via SEDEX
        // Entrega = 30,00 (até 1,2Kg)
        // Pedido  =  6,25
        // Total   = 36,25
        pedido.setEntrega(new EntregaSedex(pedido, localEntrega));
        System.out.println(pedido.toString());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        
        // Entrega via PAC
        // Entrega = 15,00 (até 2Kg)
        // Pedido  =  6,25
        // Total   = 21,25
        pedido.setEntrega(new EntregaPAC(pedido, localEntrega));
        System.out.println(pedido.toString());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        
        // Alterando para lançar exceção
        //System.out.println("PAC lançando exceção");
        //pedido.incluirItem(PRODUTOS[5], 3);// Incluindo 5 'Treco D'  - 7500g
        // Entrega = 15,00 (até 2Kg)
        // Pedido  =  6,25
        // Total   = 21,25
        //System.out.println(pedido.toString());
    }

}
