package br.com.lellis.entity;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class Combustivel {


    private BigDecimal valor;
    public abstract BigDecimal getPoderCalorificoSuperior();

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
