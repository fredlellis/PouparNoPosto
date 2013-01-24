package br.com.lellis.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.com.lellis.entity.Combustivel;

/**
 * Created with IntelliJ IDEA.
 * User: y3wg
 * Date: 23/01/13
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */
public class ResultadoDisplay extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        Combustivel resultado = (Combustivel) intent.getSerializableExtra(MyActivity.RESULTADO);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(resultado.toString());
        textView.setTextColor(resultado.cor());
        // Set the text view as the activity layout
        setContentView(textView);
    }
}
