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

    private static final BigDecimal AUTONOMIA_COMPARADO_COM_GASOLINA = new BigDecimal(100);

    @Override
    public BigDecimal getAutonomiaComparadoComGasoliona() {
        return AUTONOMIA_COMPARADO_COM_GASOLINA;
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
