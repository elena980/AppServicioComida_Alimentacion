package com.example.food_delivery;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.HelperBD;

import java.util.ArrayList;

/**
 * Clase que muestra los datos de la base de datos "pedidos", los productos agregados al carrito
 */

public class ActivityStore extends AppCompatActivity {
    //Declaración de variables
    public static Cursor cursor;
    public static ListView lista;
    public static TextView total;
    public static String usuario;
    public static int acum;
    public static HelperBD helper;
    public static Context context;

    @Override
    /**
     * Método onCreate por defecto
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        usuario = getIntent().getStringExtra("usuario");
        helper = new HelperBD(this);

        // Se instancia XML a JAVA
        lista =(ListView) findViewById(R.id.lista);
        total = (TextView) findViewById(R.id.txt_total);
        //Llamado al método definirLista()
        definirLista();

        this.setTitle("Carrito");

    }//Fin onCreate()

    /**
     * Método encargado de definir los datos del ListView correspondiente
     */
    public static void definirLista(){
        //Se realiza un captura de error en caso de que no existan articulos en la tabla
        try {
            // Llamado al método ejecutarQuery()
            cursor = helper.ejecutarQuery(usuario);

            //Se posiciona el cursor en el primer valor obtenido
            cursor.moveToFirst();

            //Creación de una variable acumuladora utilizada para el total
            acum = 0;

            //Instanciación de un ArrayList del tipo String que será utilizada para ingresar los datos obtenidos
            //de la consulta, en el adaptador
            ArrayList<String> producto = new ArrayList<String>();

            //Ciclo do-while que recorre el cursor guardando los datos obtenidos en el ArrayList producto
            do{
                // Declaración de valores obtenidos en variables utilizadas para calcular el total
                int cant = Integer.parseInt(cursor.getString(1));
                int precio = Integer.parseInt(cursor.getString(2));
                //Se guarda una sentencia en el ArrayList que contiente todos los valores obtenidos de la consulta
                producto.add(cursor.getString(0) + " \nCantidad: " + cant + " \nPrecio unitario: €" + precio +
                         " \nSubtotal: " + (precio * cant) + " €");
                //Variable acumuladora que va calculando el total el pedido
                 acum = acum + (precio * cant);
            }while (cursor.moveToNext());//Fin Do-While


            //Definición de adaptador
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, producto);
            lista.setAdapter(adaptador);

            //Se define el total obtenido en el TextView total
            total.setText(total.getText() + " €" + acum);
            //Se cierra el cursor
            cursor.close();
        }catch(Exception e ){
            //Se muestra en pantalla si no se encuentran registros en la tabla de la BD
           Toast.makeText(context, "NO HAY ARTICULOS EN EL CARRITO",Toast.LENGTH_LONG).show();
        }//Fin Try-Catch
    }//Fin definirLista()

    /**
     * Método que elimina todos los registro de la tabla pedidos, "limpia" el carrito
     * @param view Parámetro por defecto
     */
    public void cancelarPedido(View view){
        //Captura de error de Activity
        try {
            //Se habilita BD para escucha
            helper.borrarPedido(usuario);
            onCreate(null);
        }catch (Exception e){//En caso de error de Activity producido
            //Se informa por pantalla que el carrito ha sido vaciado
            Toast.makeText(this,"SE HA VACIADO EL CARRITO",Toast.LENGTH_LONG).show();
            //Se inicia la Activity MainActivity
            Intent intento = new Intent(this,MainActivity.class);
            startActivity(intento);
        }//Fin Try-Catch
    }//Fin cancelarPedido()


    public static Cursor getCursor() {
        return cursor;
    }

    public static ListView getLista() {
        return lista;
    }

    public static TextView getTotal() {
        return total;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static int getAcum() {
        return acum;
    }

    public static Context getContext() {
        return context;
    }

}//Fin Class


