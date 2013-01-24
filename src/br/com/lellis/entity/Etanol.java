package br.com.lellis.entity;

import android.graphics.Color;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class Etanol extends BioCombustivel {


    private static final BigDecimal AUTONOMIA_COMPARADO_COM_GASOLINA = new BigDecimal(70);

    public Etanol(BigDecimal valorEtanol) {
        super();
        setValor(valorEtanol);
    }

    @Override
    public BigDecimal getAutonomiaComparadoComGasoliona() {
        return AUTONOMIA_COMPARADO_COM_GASOLINA;
    }

    @Override
    public int cor() {
        return Color.GREEN;
    }

    @Override
    public String toString() {
        return "ETANOL";
    }
}
