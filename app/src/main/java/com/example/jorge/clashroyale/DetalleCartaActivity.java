package com.example.jorge.clashroyale;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.jorge.clashroyale.PantallaCargaActivity.fontClashRoyale;

public class DetalleCartaActivity extends AppCompatActivity {

    private int progreso;
    private TextView tvCalidad, tvTipo, tvVelocidad, nombre, descripcion;
    private ImageView ivImagen, ivTabla;
    private ImageButton btnClashRoyale;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carta);

        //ASIGNACIÓN DE COMPONENTES
        tvCalidad = (TextView) findViewById(R.id.tvCalidad);
        tvTipo = (TextView) findViewById(R.id.tvTipo);
        tvVelocidad = (TextView) findViewById(R.id.tvVelocidad);
        nombre = (TextView) findViewById(R.id.tvNombre);
        descripcion = (TextView) findViewById(R.id.tvDescripcion);
        ivImagen = (ImageView) findViewById(R.id.ivImagen);
        ivTabla = (ImageView) findViewById(R.id.ivTabla);
        btnClashRoyale = (ImageButton) findViewById(R.id.btnImage);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //RECOGO EL OBJETO MANDADO DEL ListCartasActivity
        Carta cartaDetalle = (Carta) getIntent().getExtras().getSerializable("objeto");

        //IMPRIMO EN EL ACTIVITY_DETALLE LO QUE CONTIENE CADA OBJETO
        tvCalidad.setText(cartaDetalle.getCalidad());
        tvTipo.setText(cartaDetalle.getTipo());
        tvVelocidad.setText(cartaDetalle.getVelocidad());
        nombre.setText(cartaDetalle.getNombre());
        nombre.setTypeface(fontClashRoyale);
        if(tvCalidad.getText().toString().toLowerCase().equals("normal"))
            nombre.setShadowLayer(11, 11, 11, Color.BLACK);
        else if(tvCalidad.getText().toString().toLowerCase().equals("especial"))
            nombre.setShadowLayer(11, 11, 11, Color.rgb(253, 158, 34)); //COLOR NARANJA
        else if(tvCalidad.getText().toString().toLowerCase().equals("epica"))
            nombre.setShadowLayer(11, 11, 11, Color.rgb(255, 51, 252)); //COLOR VIOLETA
        else if(tvCalidad.getText().toString().toLowerCase().equals("legendaria"))
            nombre.setShadowLayer(8, 8, 8, Color.rgb(240, 255, 23)); //COLOR LEGENCDARIO
        descripcion.setText(cartaDetalle.getDescripcion());
        ivImagen.setImageResource(cartaDetalle.getImagen());
        ivTabla.setImageResource(cartaDetalle.getImagenTabla());

        //CLICK EN EL BOTON DE LA PARTE INFERIOR
        btnClashRoyale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pongo la Progress Bar en visible --> POR DEFECTO INVISIBLE
                progressBar.setVisibility(View.VISIBLE);
                new Thread(miHilo).start();
                Toast abrirApp = Toast.makeText(getApplicationContext(), "Abriendo Clash Royale...", Toast.LENGTH_SHORT);
                abrirApp.show();
            }
        });
    }

        //CREACION DE HILO PARA PROGRESS BAR
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
                                                                            //com.companyname.applicationname
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.supercell.clashroyale");
                //SI EXISTE LA APP INICIALA
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                //SINO ABRE PLAYSTORE CON LA DIRECCION DE CLASH ROYALE
                } else if (intent != null){
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + "com.supercell.clashroyale"));
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                //POR ULTIMO SI EL DISPOSITIVO NO DISPONE DE PLAY STORE LE LLEVA A LA PAGINA WEB DE PLAY STORE (CLASH ROYALE)
                //PARA SU DESCARGA
                }else{
                    Uri urlPlayStore = Uri.parse("https://play.google.com/store/apps/details?id=com.supercell.clashroyale&hl=es");
                    Intent intent3 = new Intent(Intent.ACTION_VIEW, urlPlayStore );
                    startActivity(intent3);
                    overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                }
            }

            Handler miHandle = new Handler(){

                public void handleMessage(Message msg) {
                    progreso++;
                    progressBar.setProgress(progreso);
                }
            };
        };
}
