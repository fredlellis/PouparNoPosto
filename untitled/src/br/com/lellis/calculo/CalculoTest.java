package br.com.lellis.calculo;

import android.test.AndroidTestCase;
import br.com.lellis.entity.Combustivel;
import br.com.lellis.entity.Etanol;
import br.com.lellis.entity.Gasolina;

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
        Combustivel gasolina = new Gasolina(new BigDecimal(2.563));
        Combustivel etanol = new Etanol(new BigDecimal(1.906));
        assertEquals(gasolina.toString(), ComparaRentabilidadeCombustivel.getInstance().compararDoisCombustiveis(gasolina, etanol));
    }

    public void testEtanolMaisRentavel(){
        Combustivel gasolina = new Gasolina(new BigDecimal(2.899));
        Combustivel etanol = new Etanol(new BigDecimal(1.906));
        assertEquals(etanol.toString(), ComparaRentabilidadeCombustivel.getInstance().compararDoisCombustiveis(gasolina, etanol));
    }

}
