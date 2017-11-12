package com.example.jorge.clashroyale;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaEleccionActivity extends AppCompatActivity {

    private ArrayList<String> listaCalidades;
    private ListView lvTipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tipo);
        listaCalidades = new ArrayList<>();
        listaCalidades.add("Normal"); listaCalidades.add("Especial"); listaCalidades.add("Epica"); listaCalidades.add("Legendaria");
        lvTipos = (ListView)findViewById(R.id.listViewTipo);

        AdaptadorPrimeraLista myAdaptor = new AdaptadorPrimeraLista(getApplicationContext(), listaCalidades);
        lvTipos.setAdapter(myAdaptor);



        lvTipos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String calidad = (String) adapterView.getItemAtPosition(i);
                //MUESTRO POR CONSOLA --> SI COGE LA CALIDAD!
                Log.i("********", calidad);
                Intent e = new Intent(getApplicationContext(), ListaCartasActivity.class);
                e.putExtra("calidad", calidad);
                startActivity(e);
                //TRANSICION PONER DESPUES DEL START
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }
        });
    }
}
