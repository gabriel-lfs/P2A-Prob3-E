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
public interface EntregaValorVisitor {

    double visit(EntregaPAC entrega);

    double visit(EntregaSedex entrega);

    double visit(EntregaRetiradaLocal entrega);

}
