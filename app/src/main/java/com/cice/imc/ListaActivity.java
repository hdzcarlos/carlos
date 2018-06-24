package com.cice.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cice.imc.adapters.RangoAdapter;
import com.cice.imc.listeners.BajoPesoActivity;
import com.cice.imc.listeners.DesnutridoActivity;
import com.cice.imc.listeners.NormalActivity;
import com.cice.imc.listeners.ObesoActivity;
import com.cice.imc.listeners.SobrePesoActivity;

/**
 * inicializacion de la activity lista, y su xml
 */
public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
/**
 * Creacion de la lista, que se llenara con el bucle , le decimos que el recurso fila es la plantilla , el estilo que se va usar para todas las filas igual.
 * Se crean archivos xml como contenedores , donde almacenamos toda la información y así clonarla con facilidad.
 * el objeto RangoAdapter le pasamos un contexto , que es este mismo , la lista y se lo setaemos a la listView.
 */
        ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.fila, generarLista());
        ListView lv = findViewById(R.id.lista_rangos);
        //lv.setAdapter(listAdapter);

        RangoAdapter rangoAdapter = new RangoAdapter(this);
        lv.setAdapter(rangoAdapter);
        /**
         * Seteamos un item al click en cada posicion de la lista , y lo instanciamos en nuevas activitys que hemos creado con anterioridad.
         * en este caso unicamente hemos utilizado esas activity con el .xml em diseño no tienen nada de lógica.
         */

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent myIntent = new Intent(view.getContext(), DesnutridoActivity.class);
                    startActivityForResult(myIntent,0);
                } if(i == 1){
                    Intent myIntent = new Intent(view.getContext(), BajoPesoActivity.class);
                    startActivityForResult(myIntent,1);
                } if(i == 2){
                    Intent myIntent = new Intent(view.getContext(), NormalActivity.class);
                    startActivityForResult(myIntent,2);
                } if(i == 3){
                    Intent myIntent = new Intent(view.getContext(), SobrePesoActivity.class);
                    startActivityForResult(myIntent,3);
                } if(i == 4){
                    Intent myIntent = new Intent(view.getContext(), ObesoActivity.class);
                    startActivityForResult(myIntent,4);
                }



            }
        });


    }

    /**
     * Generamos una lista de x posiciones y la rellenamos con este sencillo metodo , un array que rellenamos con un bucle.
     *
     * @return
     */

    private String[] generarLista(){
        String[] array = new String[20];
        for(int i = 0; i < 20; i++){
            array[i] = "Elemento " + i;
        }
        return array;
    }

}
