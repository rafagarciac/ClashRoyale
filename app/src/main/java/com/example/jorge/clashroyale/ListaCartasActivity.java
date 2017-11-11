package com.example.jorge.clashroyale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaCartasActivity extends AppCompatActivity {

    private ArrayList<Carta> listaCartas;
    ListView lvCartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cartas);
        listaCartas = new ArrayList<Carta>();
        lvCartas = (ListView)findViewById(R.id.lvCartas);

        // CREO OBJETOS
        Carta duendesLanza = new Carta("Duendes con lanza", "Normal", "Tropa", "Tres luchadores a distancia que atacan a pecho descubierto. ¿Quién narices decidió enseñar a estos tipos a arrojar lanzas? A ver, ¿En qué cabeza cabe que eso sea una buena idea?", "Muy alta", R.drawable.duendeslanza);
        Carta descarga = new Carta("Descarga", "Normal", "Hechizo", "La descarga inflige daño brevemente a los enemigos dentro de un radio de alcance reducido. Es menos efectiva contra las torres de coronas.", null, R.drawable.descarga);
        Carta torreTesla = new Carta("Torre Tesla", "Normal", "Estructura", "Estructura defensiva. Si no hay ningún enemigo alrededor, prefiere resguardarse bajo tierra.", null, R.drawable.torretesla);
        Carta caballero = new Carta("Caballero", "Normal", "Tropa", "Un aguerrido luchador cuerpo a cuerpo, mucho más apuesto y culto que su primo lejano, el bárbaro. Se rumorea que el único motivo por el que fue nombrado caballero es la genialidad de su bigote.", "Media", R.drawable.caballero);

        Carta mosquetera = new Carta("Mosquetera", "Especial", "Tropa", "Que no te engañe su estupendo peinado de peluquería, porque la mosquetera no falla ni un tiro con su fiel trabuco.", "Media", R.drawable.mosquetera);
        Carta valquiria = new Carta("Valquiria", "Especial", "Tropa", "Una luchadora cuerpo a cuerpo de armas tomar, capaz de infligir daño de área a su alrededor. Enviadle hordas o enjambres, ¡y se los merendará sin despeinarse!", "Media", R.drawable.valquiria);
        Carta gigante = new Carta("Gigante", "Especial", "Tropa", "Es lento, pero resistente, y solo ataca las estructuras. ¿Habías llamado a la brigada de demolición? ¡aquí tienes a su único miembro!", "Baja", R.drawable.gigante);
        Carta montapuercos = new Carta("Montapuercos", "Especial", "Tropa", "Unidad cuerpo a cuerpo rápida que ataca las estructuras y puede saltar el río. Sigue la llamada del montapuercos de una puerta de la arena a la otra.", "Muy alta", R.drawable.montapuercos);

        Carta pekka = new Carta("P.E.K.K.A", "Epica", "Tropa", "Un luchador cuerpo a cuerpo pesado y lento. Se contonea ligeramente al andar, ¡pero atiza un puñetazo que no veas!", "Lenta", R.drawable.pekka);
        Carta verdugo = new Carta("Verdugo", "Epica", "Tropa", "Lanza su hacha como un bumerán, golpeando a todos los enemigos en ida y en vuelta. Es un milagro que no se le salga un brazo.", "Media", R.drawable.verdugo);
        Carta veneno = new Carta("Veneno", "Epica", "Hechizo", "Cubre la zona afectada con una toxina letal que daña a las tropas y estructuras enemigas con el paso del tiempo. Y, sin embargo, parece que al césped le va de maravilla; ¡vaya cosas!", null, R.drawable.veneno);
        Carta bruja = new Carta("Bruja", "Epica", "Tropa", "Invoca esqueletos y dispara rayos destructores. Por desgracia, sus brillantes ojos de color rosa no disparan rayos láser.", "Media", R.drawable.bruja);

        Carta magoElectrico = new Carta("Mago electrico", "Legendaria", "Tropa", "Aterriza con un estruendo, aturde a los enemigos cercanos y lanza rayos con ambas manos. Le encanta ser el centro de atención...", "Alta", R.drawable.magoelectrico);
        Carta princesa = new Carta("Princesa", "Legendaria", "Tropa", "Esta despampanante princesa lanza una lluvia de flechas ardientes desde una gran distancia. Si te despierta sentimientos cálidos seguramente sea por que estás en llamas.", "Media", R.drawable.princesa);
        Carta elTronco = new Carta("El Tronco", "Legendaria", "Hechizo", "Una botella de furia derramada transformó un inofensivo tronco en \"el Tronco\". ¡Ahora quiere vengarse aplastando todo a su paso!", null, R.drawable.tronco);
        Carta bandida = new Carta("Bandida", "Legendaria", "Tropa", "¡La bandida asalta a su objetivo y le asesta un tremendo golpe extra! No podrás golpearla mientras embiste. La máscara que porta oculta su identidad... ¡y le da un toque interesante!", "Alta", R.drawable.bandida);

        listaCartas.add(duendesLanza); listaCartas.add(descarga); listaCartas.add(torreTesla); listaCartas.add(caballero);listaCartas.add(mosquetera); listaCartas.add(valquiria);
        listaCartas.add(gigante); listaCartas.add(montapuercos); listaCartas.add(pekka); listaCartas.add(verdugo); listaCartas.add(veneno); listaCartas.add(bruja); listaCartas.add(magoElectrico);
        listaCartas.add(princesa); listaCartas.add(elTronco); listaCartas.add(bandida);

        // RECOGO LA CALIDAD SELECCIONADA DE ListaEleccionActivity
        String calidad = getIntent().getExtras().getString("calidad");


        // METO EN UN ARRAYLIST AUXILIAR LAS CARTAS QUE TENGAN LA CALIDAD ELEGIDA
        ArrayList<Carta> aux  = new ArrayList();
        for (Carta c : listaCartas) {
            //Compara calidades y te saca en el ListView las cartas correspondientes
            if (c.getCalidad().toLowerCase().equals(calidad.toLowerCase())) {
                aux.add(c);
            }
        }

        //Le meto el ArrayList Auxiliar
        AdaptadorSegundaLista myAdaptor = new AdaptadorSegundaLista(getApplicationContext(), aux);
        lvCartas.setAdapter(myAdaptor);

        lvCartas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //RECOJO UNA CARTA DE LA POSICION DE LA LIST VIEW
            Carta c = (Carta) adapterView.getItemAtPosition(i);
            //MANDO EL OBJETO SELECCIONADO EN EL LISTVIEW A MI NUEVO ACTIVITY DETALLE
            Intent e = new Intent(getApplicationContext(), DetalleCartaActivity.class);
            e.putExtra("objeto", (Serializable) c);
            startActivity(e);
            }
        });
    }
}
