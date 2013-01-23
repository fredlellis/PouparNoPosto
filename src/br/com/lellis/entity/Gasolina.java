package br.com.lellis.entity;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class Gasolina extends CombustivelFossil {

    private static final BigDecimal  PODER_COLORIFICO_SUPERIOR_KCAL_LITRO = new BigDecimal(8.325);

    @Override
    public BigDecimal getPoderCalorificoSuperior() {
        return PODER_COLORIFICO_SUPERIOR_KCAL_LITRO;
    }

    public Gasolina(BigDecimal valor) {
        super();
        setValor(valor);
    }

    @Override
    public String toString() {
        return "GASOLINA";
    }
}
