package com.example.jorge.clashroyale;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorSegundaLista extends BaseAdapter {

    Context context;
    List<Carta> listCartas;

    public AdaptadorSegundaLista(Context context, List<Carta> lista) {
        this.context = context;
        this.listCartas = lista;
    }


    @Override
    public int getCount() {
        return listCartas.size();
    }

    @Override
    public Object getItem(int i) {
        return listCartas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        LayoutInflater inflate = LayoutInflater.from(context);
        vista = inflate.inflate(R.layout.lista_cartas_item, null);

        TextView tvCalidad = vista.findViewById(R.id.tvCalidad);
        TextView tvNombre = vista.findViewById(R.id.tvNombre);
        ImageView ivFoto = vista.findViewById(R.id.ivFoto);

        if (listCartas.get(i).getCalidad().equalsIgnoreCase("normal")) {
            tvNombre.setTextColor(Color.BLACK);
        }
        if (listCartas.get(i).getCalidad().equalsIgnoreCase("especial")) {
            tvNombre.setTextColor(Color.rgb(253, 158, 34));
        }
        if (listCartas.get(i).getCalidad().equalsIgnoreCase("epica")) {
            tvNombre.setTextColor(Color.rgb(255, 51, 252));
        }

        tvNombre.setText(listCartas.get(i).getNombre().toString().toUpperCase());
        tvCalidad.setText(listCartas.get(i).getCalidad().toString());
        ivFoto.setImageResource(listCartas.get(i).getImagen());

        return vista;
    }
}

