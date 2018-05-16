/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papelaria;

import java.util.List;
import papelaria.ItemPedido;

/**
 *
 * @author gabriel-souza
 */
public interface Entrega {
    double calcular(List<ItemPedido> itens);
}
