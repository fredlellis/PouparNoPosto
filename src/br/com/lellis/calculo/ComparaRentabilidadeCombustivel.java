package br.com.lellis.calculo;

import br.com.lellis.entity.Combustivel;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
public class ComparaRentabilidadeCombustivel {

    private final int ESCALA = 3;
    private final BigDecimal CEM = new BigDecimal(100).setScale(3);


    ComparaRentabilidadeCombustivel() {
        super();
    }

    public static ComparaRentabilidadeCombustivel getInstance(){
        return new ComparaRentabilidadeCombustivel();
    }

    public String compararDoisCombustiveis(Combustivel primeiroCombustivel, Combustivel segundoCombustivel){
        return calcularCombustivelMaisRentavel(primeiroCombustivel, segundoCombustivel) < 1 ? primeiroCombustivel.toString() : segundoCombustivel.toString();
    }


   int calcularCombustivelMaisRentavel(Combustivel combustivel01, Combustivel combustivel02){
        return combustivel01.getValor().multiply(combustivel02.getAutonomiaComparadoComGasoliona().divide(CEM)).setScale(ESCALA, RoundingMode.HALF_UP).compareTo(combustivel02.getValor().setScale(ESCALA, RoundingMode.HALF_UP));
    }

}
