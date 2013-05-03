package br.com.lellis.pouparnoposto.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import br.com.lellis.R;
import br.com.lellis.pouparnoposto.calculo.ComparaRentabilidadeCombustivel;
import br.com.lellis.pouparnoposto.entity.Combustivel;
import br.com.lellis.pouparnoposto.entity.Etanol;
import br.com.lellis.pouparnoposto.entity.Gasolina;
import br.com.lellis.pouparnoposto.entity.Combustivel;


import java.math.BigDecimal;

public class MyActivity extends Activity {

    public static final String COLOQUE_GASOLINA = "GASOLINA";
    public static final String COLOQUE_ETANOL = "ETANOL";
    public static final String BLANK = "";
    private final BigDecimal DIFERENCA_POTENCIAL_ENERGETICO = new BigDecimal(0.7);
    public final static String RESULTADO = "com.example.myfirstapp.RESULTADO";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void calcular(View view) {

        Intent resultadoDisplay = new Intent(this, ResultadoDisplay.class);

        EditText ETValorGasolina = (EditText) findViewById(R.id.valor_gasolina);
        EditText ETValorEtanol = (EditText) findViewById(R.id.valor_etanol);

        if (valoresPreenchidos(ETValorGasolina, ETValorEtanol)){

            BigDecimal valorGasolina = new BigDecimal(ETValorGasolina.getText().toString());
            BigDecimal valorEtanol = new BigDecimal(ETValorEtanol.getText().toString());

            Combustivel gasolina = new Gasolina(valorGasolina);
            Combustivel etanol = new Etanol(valorEtanol);

            resultadoDisplay.putExtra(RESULTADO, ComparaRentabilidadeCombustivel.getInstance().compararDoisCombustiveis(gasolina, etanol));
            startActivity(resultadoDisplay);
        }
    }

    private boolean valoresPreenchidos(EditText ETValorGasolina, EditText ETValorEtanol) {
        return !(ETValorGasolina.getText().toString().equals(BLANK) && ETValorEtanol.getText().toString().equals(BLANK));
    }

}
