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
public class EntregaVisitorTotal implements EntregaValorVisitor {

    @Override
    public double visit(EntregaRetiradaLocal entrega) {
        return 0;
    }

    @Override
    public double visit(EntregaPAC entrega) {
        int peso = entrega.getPedido().getPeso();

        if (peso <= 1000) {
            // Até 1 kg – cobrará R$ 10,00
            return 10.0;
        } else if (peso <= 2000) {
            // Acima de 1 a 2 kg – cobrará R$ 15,00
            return 15.0;
        } else if (peso <= 3000) {
            // Acima de 2 a 3 kg – cobrará R$ 20,00
            return 20.0;
        } else if (peso <= 5000) {
            //  Acima de 3 a 5 kg – cobrará R$ 30,00
            return 30.0;
        }

        throw new TipoEntregaInvalido("Estourou o peso limite para entrega via PAC");
    }

    @Override
    public double visit(EntregaSedex entrega) {
        int peso = entrega.getPedido().getPeso();

        if (peso <= 500) {
            // Até 500 g – cobrará R$ 12,50
            return 12.5;
        } else if (peso <= 750) {
            // De 501g até 750 g – cobrará R$ 20,00  
            return 20.0;
        } else if (peso <= 1200) {
            // De 751g até 1200 g – cobrará R$ 30,00
            return 30.0;
        } else if (peso < 2000) {
            // De 1201g até 2 kg – cobrará R$ 45,00
            return 45.0;
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
            return valorBase;
        }
    }

}
