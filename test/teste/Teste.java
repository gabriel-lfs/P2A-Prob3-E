/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author guilh
 */
public class Teste {

    public static void main(String[] args) {
        int peso = 2230;
        double valor;

        if (peso <= 500) {
            // Até 500 g – cobrará R$ 12,50
            valor = 12.5;
        } else if (peso <= 750) {
            // De 501g até 750 g – cobrará R$ 20,00  
            valor = 20.0;
        } else if (peso <= 1200) {
            // De 751g até 1200 g – cobrará R$ 30,00
            valor = 30.0;
        } else if (peso < 2000) {
            // De 1201g até 2 kg – cobrará R$ 45,00
            valor = 45.0;
        } else {
            /* Acima de 2 kg – cobrará R$ 45,00 + R$ 1,50 para cada 100g ou fração adicionais. Exemplo:
             * para pedido pesando 2070 g, será cobrado R$ 46,50. Para pedido pesando 2180 g, será cobrado
             / R$ 48,00. Para pedido pesando 2230g, será cobrado R$ 49,50.
             */
            double valorBase = 45;
            int extra = peso - 2000;
            while (extra > 0) {
                extra -= 100;
                valorBase += 1.5;
            }
            valor = valorBase;
        }

        System.out.println("valor: " + valor);
    }
}
