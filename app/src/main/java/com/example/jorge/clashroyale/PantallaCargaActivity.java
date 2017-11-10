package com.example.jorge.clashroyale;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PantallaCargaActivity extends AppCompatActivity {

    private ProgressBar barraProgreso;
    private TextView tvProgreso;
    private ImageView ivFoto;
    private int progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);
        barraProgreso = (ProgressBar) findViewById(R.id.pbCarga);
        tvProgreso = (TextView) findViewById(R.id.tvCarga);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
        ivFoto.setImageResource(R.drawable.pantallacarga);
        //progreso = 0;

        new Thread(miHilo).start();
    }
    private Runnable miHilo = new Runnable() {
        @Override
        public void run() {
            while(progreso < 100){
                try {

                    miHandle.sendMessage(miHandle.obtainMessage());
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }catch (Throwable t){
                    t.printStackTrace();
                }
            }

            Intent i = new Intent(PantallaCargaActivity.this, ListaEleccionActivity.class);
            startActivity(i);
            finish();
        }

        Handler miHandle = new Handler(){

            public void handleMessage(Message msg) {
                progreso++;
                barraProgreso.setProgress(progreso);
               //tvProgreso.setText(progreso);
            }
        };
    };
}


