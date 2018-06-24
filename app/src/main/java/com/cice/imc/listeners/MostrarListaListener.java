package com.cice.imc.listeners;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.cice.imc.ListaActivity;


public class MostrarListaListener implements View.OnClickListener {
    /**
     * Creamos un objeto de tipo Context , es una clase abstracta que contiene muchas variables finales que podemos usar.
     */

    private Context context;


    public MostrarListaListener(Context context) {
        this.context = context;
    }

    /**
     * Metodo implementado que utilizamos para inciar la actividad de la lista.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(context, ListaActivity.class);
        context.startActivity(intent);
    }
}
