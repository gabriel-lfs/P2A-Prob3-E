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
public class TipoEntregaInvalido extends RuntimeException {

    public TipoEntregaInvalido(String message) {
        super(message);
    }

}
