package com.example.ejemplomenudieta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvresultado;
    private Spinner sp1;
    private CheckBox chkAlimento1,chkAlimento2, chkAlimento3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvresultado = (TextView) findViewById(R.id.textView2);
        chkAlimento1 = (CheckBox) findViewById(R.id.checkBox1);
        chkAlimento2 = (CheckBox) findViewById(R.id.checkBox2);
        chkAlimento3 = (CheckBox) findViewById(R.id.checkBox3);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones());
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

    private String[] opciones() {
        // TODO Auto-generated method stub
        String [] valores={"Desayuno","Comida","Cena"};
        return valores;
    }

    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String dato=sp1.getSelectedItem().toString();

            if(dato.equals("Desayuno")){
                chkAlimento1.setText("Chocolate con churros");
                chkAlimento2.setText("Café con tostada");
                chkAlimento3.setText("Café con barrita con tomate");
            }
            if(dato.equals("Comida")){
                chkAlimento1.setText("Fabada Asturiana");
                chkAlimento2.setText("Cocido Madrileño");
                chkAlimento3.setText("Paella Valenciana");
            }
            if(dato.equals("Cena")){
                chkAlimento1.setText("Tortilla de patata");
                chkAlimento2.setText("Croquetas");
                chkAlimento3.setText("Calamares");
            }
        }


        public void onNothingSelected(AdapterView parent) {
        }
    }

    public void generarmenu (View view){
        String resultado = sp1.getSelectedItem().toString() + ": ";
        if(chkAlimento1.isChecked()==true){
            resultado = resultado + chkAlimento1.getText().toString() + ",";

        }
        if(chkAlimento2.isChecked()==true){
            resultado = resultado + chkAlimento2.getText().toString() + ",";
        }
        if(chkAlimento3.isChecked()==true){
            resultado = resultado + chkAlimento3.getText().toString() + ",";
        }
        resultado=resultado.substring(0, resultado.length()-1);
        tvresultado.setText(resultado);
        chkAlimento1.setChecked(false);
        chkAlimento2.setChecked(false);
        chkAlimento3.setChecked(false);

    }

}
