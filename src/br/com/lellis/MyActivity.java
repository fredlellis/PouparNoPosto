package br.com.lellis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.R;

import java.math.BigDecimal;

public class MyActivity extends Activity {

    public static final String COLOQUE_GASOLINA = "GASOLINA";
    public static final String COLOQUE_ETANOL = "ETANOL";
    private final BigDecimal DIFERENCA_POTENCIAL_ENERGETICO = new BigDecimal(0.7);
    public final static String RESULTADO_MESSAGE = "com.example.myfirstapp.RESULTADO_MESSAGE";

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

        BigDecimal valorGasolina = new BigDecimal(ETValorGasolina.getText().toString());
        BigDecimal valorEtanol = new BigDecimal(ETValorEtanol.getText().toString());

        String resultado = calcularResultado(valorGasolina, valorEtanol);


        resultadoDisplay.putExtra(RESULTADO_MESSAGE, resultado);
        startActivity(resultadoDisplay);
    }

    private String calcularResultado(BigDecimal valorGasolina, BigDecimal valorEtanol) {

        if (valorGasolina.multiply(DIFERENCA_POTENCIAL_ENERGETICO).compareTo(valorEtanol) == -1){
            return COLOQUE_GASOLINA;
        }
        return COLOQUE_ETANOL;
    }
}
