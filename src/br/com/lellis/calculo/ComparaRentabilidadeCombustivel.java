package br.com.lellis.calculo;

import br.com.lellis.entity.Combustivel;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
public class ComparaRentabilidadeCombustivel {

    private ComparaRentabilidadeCombustivel() {
        super();
    }

    public static ComparaRentabilidadeCombustivel getInstance(){
        return new ComparaRentabilidadeCombustivel();
    }

    public String compararDoisCombustiveis(Combustivel primeiroCombustivel, Combustivel segundoCombustivel){
        return calcularCombustivelMaisRentavel(primeiroCombustivel, segundoCombustivel) >= 0 ? primeiroCombustivel.toString() : segundoCombustivel.toString();
    }


    private BigDecimal percentagemDiferencaEntrePoderCalorifico(BigDecimal poderCalorificoCombustivel01, BigDecimal poderCalorificoCombustivel02){
        BigDecimal percentagemDiferencaEntreCombustiveis = poderCalorificoCombustivel02.multiply(new BigDecimal(100)).divide(poderCalorificoCombustivel01);
        return percentagemDiferencaEntreCombustiveis;
    }

    private int calcularCombustivelMaisRentavel(Combustivel combustivel01, Combustivel combustivel02){
        BigDecimal diferencaPoderCalorifico = percentagemDiferencaEntrePoderCalorifico(combustivel01.getPoderCalorificoSuperior(), combustivel02.getPoderCalorificoSuperior());
        return combustivel01.getValor().multiply(diferencaPoderCalorifico).compareTo(combustivel02.getValor());
    }

}
