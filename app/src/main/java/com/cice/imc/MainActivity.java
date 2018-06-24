package com.cice.imc;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cice.imc.listeners.MostrarListaListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    /**
     * Creamos onCreate, y dentro todos los objetos finales que vamos a usar y anteriormente hemos creado.
     *
     * @param savedInstanceState
     */
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText altura = findViewById(R.id.altura);
        final EditText peso = findViewById(R.id.peso);
        final Button calcula = findViewById(R.id.calcula);
        final Button reiniciar = findViewById(R.id.reset);
        Button mostrarLista = findViewById(R.id.mostrar_lista);
        final TextView resultado = findViewById(R.id.resultado);
        final ImageView imagenResultado = findViewById(R.id.resultado_imagen);
        final TextView textoResultado = findViewById(R.id.resultado_texto);
        /**
         * Una vez creadas las constantes podemos instanciarle eventos (listeners)
         *
         * calcula Cuando hacemos click en este boton vamos a realizar la operación con los 2 EditText asigandos antes
         * altura y peso.
         *
         */

        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
               }
                String alturaDada = altura.getText().toString();
                String pesoDado = peso.getText().toString();

                if (!alturaDada.isEmpty() && !pesoDado.isEmpty()) {
                    try {
                        double alturaNum = Double.parseDouble(alturaDada);
                        alturaNum /= 100;
                        double pesoNum = Double.parseDouble(pesoDado);


                        double resultadoIMC = pesoNum / (alturaNum * alturaNum);
                        int resultadoINT = (int) resultadoIMC;
/**
 * Mostramos en activityMain el resultado del calculo.
 */
                        resultado.setText(String.valueOf("Su indice de masa corporal es: " + resultadoINT));
                        if (resultadoIMC < 16) {
                            imagenResultado.setImageResource(R.mipmap.ic_desnutrido);
                            textoResultado.setText("DELGADEZ EXTREMA, pongase en contacto con su medico.");
                        }else if (resultadoIMC > 16 && resultadoIMC < 18.5){
                            imagenResultado.setImageResource(R.mipmap.ic_bajopeso);
                            textoResultado.setText("DEKGADEZ MIDERADA. Puede que tenga usted déficit de algún nutriente.");
                        }else if(resultadoIMC > 18.5 && resultadoIMC < 25){
                            imagenResultado.setImageResource(R.mipmap.ic_normal);
                            textoResultado.setText("NORMAL. Está usted en una buena linea, siga con el ejercicio diario");
                        }else if (resultadoIMC > 25 && resultadoIMC < 30){
                            imagenResultado.setImageResource(R.mipmap.ic_sobrepeso);
                            textoResultado.setText("PESO ALTO. Deberías de revisar los dulces que comes a diario.");
                        }else{
                            imagenResultado.setImageResource(R.mipmap.ic_obeso);
                            textoResultado.setText("OBESIDAD. Pongase en contacto con su medico.");
                        }
/**
 * Con este metodo hacemos que el teclado desaparezca al presionar el boton calcula.
 */
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(calcula.getWindowToken(),0);


                    } catch (Throwable ex) {
                        Toast.makeText(MainActivity.this, "No has introducido números", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No has introducido los dos campos", Toast.LENGTH_LONG).show();
                }
            }
        });
        /**
         * Creamos el listener para empezar a mostrar la lista.
         */

        MostrarListaListener mostrarListaListener = new MostrarListaListener(this);
       mostrarLista.setOnClickListener(mostrarListaListener);


        /**
         * Metodo que reinicia los resultados del MainActivity
         */

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                altura.setText(null);
                peso.setText(null);
                resultado.setText(null);
                imagenResultado.setImageResource(0);
                textoResultado.setText(null);
                int contador=0;
                if(contador%2 == 0){
                    if ( mInterstitialAd.isLoaded());
                    mInterstitialAd.show();

                }else{
                    contador ++;
                }
            }
        });
    }
}











