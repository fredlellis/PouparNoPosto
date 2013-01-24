package br.com.lellis.calculo;

import android.test.AndroidTestCase;
import android.test.AndroidTestRunner;
import br.com.lellis.entity.Combustivel;
import br.com.lellis.entity.Etanol;
import br.com.lellis.entity.Gasolina;

import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 24/01/13
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public class CalculoTest extends AndroidTestCase {

    public void testGasolinaMaisRentavel(){
        Combustivel gasolina = new Gasolina(new BigDecimal(2.89));
        Combustivel etanol = new Etanol(new BigDecimal(2.65));
        assertEquals(gasolina.toString(), ComparaRentabilidadeCombustivel.getInstance().compararDoisCombustiveis(gasolina, etanol));
    }

    public void testEtanolMaisRentavel(){
        Combustivel gasolina = new Gasolina(new BigDecimal(2.89));
        Combustivel etanol = new Etanol(new BigDecimal(1.85));
        assertEquals(etanol.toString(), ComparaRentabilidadeCombustivel.getInstance().compararDoisCombustiveis(gasolina, etanol));
    }

    public void testCalculoPercentagem(){
        ComparaRentabilidadeCombustivel comparaRentabilidadeCombustivel = new ComparaRentabilidadeCombustivel();

        Combustivel gasolina = new Gasolina(new BigDecimal(10.0));
        Combustivel etanol = new Etanol(new BigDecimal(1.0));

        assertEquals(new BigDecimal(64.62).setScale(2, RoundingMode.HALF_UP),comparaRentabilidadeCombustivel.percentagemDiferencaEntrePoderCalorifico(gasolina.getPoderCalorificoSuperior(), etanol.getPoderCalorificoSuperior()));
    }

    public void testCalculoRentabilidade(){
        ComparaRentabilidadeCombustivel comparaRentabilidadeCombustivel = new ComparaRentabilidadeCombustivel();

        Combustivel gasolina = new Gasolina(new BigDecimal(10.0));
        Combustivel etanol = new Etanol(new BigDecimal(1.0));

        assertEquals(1,gasolina.getValor().compareTo(etanol.getValor()));
        assertEquals(0,new BigDecimal(1.0).compareTo(etanol.getValor()));
        assertEquals(-1,new BigDecimal(0.1).compareTo(etanol.getValor()));

        assertEquals(1,comparaRentabilidadeCombustivel.calcularCombustivelMaisRentavel(gasolina, etanol));
    }


}
