package br.com.lellis.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import br.com.lellis.calculo.ComparaRentabilidadeCombustivel;
import br.com.lellis.entity.Combustivel;
import br.com.lellis.entity.Etanol;
import br.com.lellis.entity.Gasolina;
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

        Combustivel gasolina = new Gasolina(valorGasolina);
        Combustivel etanol = new Etanol(valorEtanol);


        String resultado = ComparaRentabilidadeCombustivel.getInstance().compararDoisCombustiveis(gasolina, etanol);


        resultadoDisplay.putExtra(RESULTADO_MESSAGE, resultado);
        startActivity(resultadoDisplay);
    }

}
