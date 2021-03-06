package com.protopo.previewplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

public class Agrimensura extends AppCompatActivity {

    Spinner lista; Tabla_agrimensura tabla; Button continuar;
    EditText grados_a, minutos_a, segundos_a;
    TextView val_ene;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrimensura);
        lista =  (Spinner) findViewById(R.id.spinner2);
        continuar =  (Button) findViewById( R.id.btn_cont);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.datos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lista.setAdapter(adapter);
        val_ene= (TextView) findViewById(R.id.editText55);
        grados_a= (EditText) findViewById(R.id.editText6);
        minutos_a= (EditText) findViewById(R.id.editText2);
        segundos_a = (EditText) findViewById(R.id.editText);


//comentarios
    }


    public void btn_continuar (View view)
    {
        double valor =Double.parseDouble(val_ene.getText().toString());
        Intent i = new Intent(getApplicationContext(), tabla_datos_agri.class );
        //i.putExtra("lista", lista_envio);
        i.putExtra("val_n", valor );

        String envio  =""+ lista.getSelectedItem().toString();
        i.putExtra("sentido", envio);
        i.putExtra("angulo", calcular_grados());
        startActivity(i);

    }


    double grados_c=0;
    public String calcular_grados() {
        Double segundos_c = 0.0, minutos_c = 0.0;
        segundos_c = Double.parseDouble(segundos_a.getText().toString()) / 60;
        minutos_c = Double.parseDouble(minutos_a.getText().toString()) + segundos_c;
        minutos_c = minutos_c / 60;
        grados_c = Double.parseDouble(grados_a.getText().toString()) + minutos_c;
        return  ""+grados_c;
    }

    }
