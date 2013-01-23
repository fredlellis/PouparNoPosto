package br.com.lellis.entity;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class Etanol extends BioCombustivel {


    private static final BigDecimal  PODER_COLORIFICO_SUPERIOR_KCAL_LITRO = new BigDecimal(5.380);

    public Etanol(BigDecimal valorEtanol) {
        super();
        setValor(valorEtanol);
    }

    @Override
    public BigDecimal getPoderCalorificoSuperior() {
        return PODER_COLORIFICO_SUPERIOR_KCAL_LITRO;
    }

    @Override
    public String toString() {
        return "ETANOL";
    }
}
