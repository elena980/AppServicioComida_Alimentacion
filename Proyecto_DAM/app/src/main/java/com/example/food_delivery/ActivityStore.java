package com.example.food_delivery;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.EstructuraBD;
import com.example.food_delivery.db.HelperBD;



import java.util.ArrayList;

public class ActivityStore extends AppCompatActivity {
    //Declaración de variables
    Cursor cursor;
    //HelperBD helper;
    ListView lista;
    TextView total;
    String usuario;

    @Override
    /**
     * Método onCreate por defecto
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        //helper = new HelperBD(this);
        usuario = getIntent().getStringExtra("usuario");
        this.setTitle("Carrito");


        //Llamado al método definirLista()
        definirLista();
    }//Fin onCreate()

    /**
     * Método encargado de hacer la conexión con la BD
     */

    //public void ejecutarQuery(String usuario){
      public void ejecutarQuery(String usuario){
        //Instanciación de la clase HelperBD
        HelperBD helper = new HelperBD(this);
        //Se habilita la bd para obtener datos
        SQLiteDatabase db = helper.getReadableDatabase();
        //Arreglo que define de cuales columnas de la BD se recopilará información
        /*
          String[] projection = {
                EstructuraBD.COLUMNA10,
                EstructuraBD.COLUMNA12,
                EstructuraBD.COLUMNA13
        };
        */
        //String [] usuario01 ={usuario};

        //Se almacena los datos obtenidos de la consulta en un objeto del tipo Cursor
       /*
        cursor = db.query(
                EstructuraBD.TABLE_NAME_02,   // La tabla de la consulta
                projection,             // El arreglo de las columnas de las cuales se retorna información
                null,              // Columnas involucradas en declaración WHERE
                null,                   // Valores de la declaración WHERE
                null,                   // Agrupación de filas
                null,                   // Filtro de filas
                null              // Orden
        );
        */
        cursor = db.rawQuery("SELECT NOMBRE, CANTIDAD, PRECIO FROM PEDIDOS WHERE USUARIO=?",new String[]{usuario});
        db.close();
    }//Fin ejecutarQuery()

    /**
     * Método encargado de definir los datos del ListView correspondiente
     */
    public void definirLista(){
        //Se realiza un captura de error en caso de que no existan articulos en la tabla
        try {
            //Llamado al método ejecutarQuery()
            //ejecutarQuery(usuario);
            ejecutarQuery(usuario);
            //Se posiciona el cursor en el primer valor obtenido
            cursor.moveToFirst();
            //Se instancia XML a JAVA
            lista = findViewById(R.id.lista);
            total = findViewById(R.id.txt_total);
            //Creación de una variable acumuladora utilizada para el total
            int acum = 0;
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
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, producto);
            lista.setAdapter(adaptador);
            //Se define el total obtenido en el TextView total
            total.setText(total.getText() + " €" + acum);
            //Se cierra el cursor
            cursor.close();
        }catch(Exception e ){
            //Se muestra en pantalla si no se encuentran registros en la tabla de la BD
            Toast.makeText(this,"NO HAY ARTICULOS EN EL CARRITO",Toast.LENGTH_SHORT).show();
        }//Fin Try-Catch
    }//Fin definirLista()

    /**
     * Método que elimina todos los registro de la tabla pedidos, "limpia" el carrito
     * @param view Parámetro por defecto
     */
    public void borrarPedido(View view){
        //Captura de error de Activity
        try {
            //Se habilita BD para escucha
            HelperBD helper = new HelperBD(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            //Se ejecuta una sentencia SQL que elimina todos los registros de la tabla
            db.execSQL(EstructuraBD.SQL_DELETE_REGISTERS_02);
            db.close();
            onCreate(null);
        }catch (Exception e){//En caso de error de Activity producido
            //Se informa por pantalla que el carrito ha sido vaciado
            Toast.makeText(this,"SE HA VACIADO EL CARRITO",Toast.LENGTH_SHORT).show();
            //Se inicia la Activity MainActivity
            Intent intento = new Intent(this,MainActivity.class);
            startActivity(intento);
        }//Fin Try-Catch
    }//Fin borrarPedido()

    public void pay(View view){
        Intent intent = new Intent(this,Payment.class);
        startActivity(intent);
    }

}//Fin Class


