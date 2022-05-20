package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity {

    private ListView lista;
    String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = getIntent().getStringExtra("usuario");
        this.setTitle(usuario);

        lista = findViewById(R.id.opciones);

        //MÉTODO QUE NOS PERMITE ACCEDER A UN ACTIVITY SEGUN LA SELECCIÓN HECHA
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                             //SE EVALÚA QUE LA SELECCIÓN NO FUESE NULA
                                             if (position != -1) {
                                                 //Intent intento = new Intent(MainActivity.this, Activity02.class);
                                                 //intento.putExtra("posicion", position);
                                                 //startActivity(intento);

                  /*
                  //En caso de ser cualquier opcion, excepto por el carrito, envía al Activity2

                    if (position != 2) {
                        Intent intento = new Intent(MainActivity.this, Activity02.class);
                        intento.putExtra("posicion", position);
                        startActivity(intento);

                    } else {//Caso contratio envía al ActivityStore que muestra el carrito

                        Intent intento = new Intent(MainActivity.this, ActivityStore.class);
                                                     startActivity(intento);
                                                 }//Fin If
                                             }//Fin If
                                         }//Fin onItemClick()
                                     }//Fin setOnItem..
                    */
                                             }
                                             if (position != 7) {
                                                 Intent intento = new Intent(MainActivity.this, Activity02.class);
                                                 intento.putExtra("posicion", position);
                                                 intento.putExtra("usuario", usuario);
                                                 startActivity(intento);
                                                 // Fin if
                                             }else{
                                                 Intent intento = new Intent(MainActivity.this, ActivityStore.class);
                                                 intento.putExtra("usuario", usuario);
                                                 startActivity(intento);
                                             }
                                         }// Fin onItemClick()
                                     }// Fin setOnItem
        );

    }// Fin onCreate()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_02, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.carrito:
                Intent intent01 = new Intent(MainActivity.this, ActivityStore02.class);
                intent01.putExtra("usuario", usuario);
                startActivity(intent01);
                return true;

            case R.id.edicion:
                Intent intent02 = new Intent(MainActivity.this, EditionActivity.class);
                intent02.putExtra("usuario", usuario);
                startActivity(intent02);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}