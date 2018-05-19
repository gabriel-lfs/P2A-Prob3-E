package teste;

import papelaria.*;
import java.util.stream.*;

/**
 *
 * @author guilh
 */
public class Teste {

    private final static Produto[] PRODUTOS = new Produto[]{
        new Produto("Objeto A", 0.25, 1),
        new Produto("Objeto B", 1.50, 1),
        new Produto("Item C", 1.50, 2),
        new Produto("Item D", 3.50, 5),
        new Produto("Treco E", 5.00, 15),
        new Produto("Treco D", 10.50, 25)
    };
    
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.incluirItem(PRODUTOS[0], 1);
        pedido.incluirItem(PRODUTOS[1], 1);
        pedido.incluirItem(PRODUTOS[2], 1);
        
        System.out.println("Retirada no local.");
        System.out.println("Valor pedido: " + pedido.getValorPedido());
        System.out.println("Valor entrega: " + pedido.getValorEntrega(TipoEntrega.RETIRADA));
        System.out.println("Valor total: " + pedido.getValorTotal(TipoEntrega.RETIRADA));
        
        System.out.println("Entrega PAC.");
        System.out.println("Valor pedido: " + pedido.getValorPedido());
        System.out.println("Valor entrega: " + pedido.getValorEntrega(TipoEntrega.PAC));
        System.out.println("Valor total: " + pedido.getValorTotal(TipoEntrega.PAC));
        
        System.out.println("Entrega SEDEX.");
        System.out.println("Valor pedido: " + pedido.getValorPedido());
        System.out.println("Valor entrega: " + pedido.getValorEntrega(TipoEntrega.SEDEX));
        System.out.println("Valor total: " + pedido.getValorTotal(TipoEntrega.SEDEX));
        
        System.out.println("Entrega Motoboy.");
        System.out.println("Valor pedido: " + pedido.getValorPedido());
        System.out.println("Valor entrega: " + pedido.getValorEntrega(TipoEntrega.MOTOBOY));
        System.out.println("Valor total: " + pedido.getValorTotal(TipoEntrega.MOTOBOY));
        
        pedido.incluirItem(PRODUTOS[3], 1);
        pedido.incluirItem(PRODUTOS[4], 1);
        pedido.incluirItem(PRODUTOS[5], 1);
        
        System.out.println("Entrega PAC lançando exceção.");
        System.out.println("Valor pedido: " + pedido.getValorPedido());
        System.out.println("Valor entrega: " + pedido.getValorEntrega(TipoEntrega.PAC));
        System.out.println("Valor total: " + pedido.getValorTotal(TipoEntrega.PAC));
    }
}
