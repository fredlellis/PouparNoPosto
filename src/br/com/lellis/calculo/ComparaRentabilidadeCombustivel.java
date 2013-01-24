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

    ComparaRentabilidadeCombustivel() {
        super();
    }

    public static ComparaRentabilidadeCombustivel getInstance(){
        return new ComparaRentabilidadeCombustivel();
    }

    public String compararDoisCombustiveis(Combustivel primeiroCombustivel, Combustivel segundoCombustivel){
        return calcularCombustivelMaisRentavel(primeiroCombustivel, segundoCombustivel) < 1 ? primeiroCombustivel.toString() : segundoCombustivel.toString();
    }


    BigDecimal percentagemDiferencaEntrePoderCalorifico(BigDecimal poderCalorificoCombustivel01, BigDecimal poderCalorificoCombustivel02){
        BigDecimal percentagemDiferencaEntreCombustiveis = poderCalorificoCombustivel02.multiply(new BigDecimal(100)).divide(poderCalorificoCombustivel01, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        return percentagemDiferencaEntreCombustiveis;
    }

    int calcularCombustivelMaisRentavel(Combustivel combustivel01, Combustivel combustivel02){
        BigDecimal diferencaPoderCalorifico = percentagemDiferencaEntrePoderCalorifico(combustivel01.getPoderCalorificoSuperior(), combustivel02.getPoderCalorificoSuperior());
        diferencaPoderCalorifico = diferencaPoderCalorifico.divide(new BigDecimal(100));

        BigDecimal valorParaComparar = combustivel01.getValor().multiply(diferencaPoderCalorifico).setScale(2, RoundingMode.HALF_UP);
        int comparacao = valorParaComparar.compareTo(combustivel02.getValor().setScale(2, RoundingMode.HALF_UP));
        return comparacao;
    }

}
