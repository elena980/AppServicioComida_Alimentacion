package com.example.food_delivery;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.EstructuraBD;
import com.example.food_delivery.db.HelperBD;

public class Activity03 extends AppCompatActivity {

    //DECLARACIÓN DE VARIABLES
    private Producto producto = new Producto();
    private Producto[] bebida = producto.bebidas;
    private Producto[] racion = producto.raciones;
    private Producto[] ensalada = producto.ensaladas;
    private Producto[] hamburguesa = producto.hamburguesas;
    private Producto[] sandwich = producto.sandwiches;
    private Producto[] pizza = producto.pizzas;
    private Producto[] postre = producto.postres;
    private TextView nombre,detalle,precio,cant;
    private ImageView imagen01;
    private String valor;
    public static String usuario;

    HelperBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_03);

        usuario = getIntent().getStringExtra("usuario");
        helper = new HelperBD(this);
        getSupportActionBar().hide();

        //Instanciacion de XML a JAVA
        nombre = findViewById(R.id.txt_name);
        detalle = findViewById(R.id.txt_desc);
        imagen01 = findViewById(R.id.image01);
        precio = findViewById(R.id.txt_price);
        cant = findViewById(R.id.txt_cant);
        //OBTENEMOS LA POSICION QUE ENVIA EL  ACTIVITY2
        Bundle bundle = getIntent().getExtras();
        //POSICION OBTENIDA ES DECLARADA COMO INTEGER
        int id = Integer.parseInt(bundle.getString("posicion"));
        //Se obtiene además el nombre del tipo de producto que se mostrarán
        String producto = bundle.getString("producto");

        //INSTANCIAMOS LA CLASE PRODUCTO Y LOS ARREGLOS CORRESPONDIENTES PARA SELECCIÓN
        Producto bebida = Producto.bebidas[id];
        Producto racion = Producto.raciones[id];
        Producto ensalada = Producto.ensaladas[id];
        Producto hamburguesa = Producto.hamburguesas[id];
        Producto sandwich = Producto.sandwiches[id];
        Producto pizza = Producto.pizzas[id];
        Producto postre = Producto.postres[id];

        //LUEGO DE EVALUAR EL TIPO DE PRODUCTO ESCOGIDO SE VISUALIZAN LOS DATOS CORRESPONDIENTES
        // INSTANCIADOS EN LOS COMPONENTES DEL ACTIVITY03

        switch (producto) {

            //En el caso de que la varaiable "producto" obtenida sea bebidas
            //Los TextView son definidos con sus valores correspondientes
            case "bebida":
                nombre.setText(bebida.getNombre());
                detalle.setText(bebida.getDescripcion());
                imagen01.setImageResource(bebida.getImagenID());
                valor = String.valueOf(bebida.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "racion":
                nombre.setText(racion.getNombre());
                detalle.setText(racion.getDescripcion());
                imagen01.setImageResource(racion.getImagenID());
                valor = String.valueOf(racion.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "ensalada":
                nombre.setText(ensalada.getNombre());
                detalle.setText(ensalada.getDescripcion());
                imagen01.setImageResource(ensalada.getImagenID());
                valor = String.valueOf(ensalada.getPrecio());
                precio.setText("Precio: " + valor + " €");

                break;

            case "hamburguesa":
                nombre.setText(hamburguesa.getNombre());
                detalle.setText(hamburguesa.getDescripcion());
                imagen01.setImageResource(hamburguesa.getImagenID());
                valor = String.valueOf(hamburguesa.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "sandwich":
                nombre.setText(sandwich.getNombre());
                detalle.setText(sandwich.getDescripcion());
                imagen01.setImageResource(sandwich.getImagenID());
                valor = String.valueOf(sandwich.getPrecio());
                precio.setText("Precio: " + valor + " €");

                break;

            case "pizza":
                nombre.setText(pizza.getNombre());
                detalle.setText(pizza.getDescripcion());
                imagen01.setImageResource(pizza.getImagenID());
                valor = String.valueOf(pizza.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "postre":
                nombre.setText(postre.getNombre());
                detalle.setText(postre.getDescripcion());
                imagen01.setImageResource(postre.getImagenID());
                valor = String.valueOf(postre.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            default:
                break;

        }
        /*
        //LUEGO DE EVALUAR EL TIPO DE PRODUCTO ESCOGIDO SE VISUALIZAN LOS DATOS CORRESPONDIENTES
        // INSTANCIADOS EN LOS COMPONENTES DEL ACTIVITY03
        if (producto.equals("cerveza")) {//En el caso de que la varaiable "producto" obtenida sea cerveza
            //Los TextView son definidos con sus valores correspondientes
            nombre.setText(bebida.getNombre());
            detalle.setText(bebida.getDescripcion());
            imagen01.setImageResource(bebida.getImagenID());
            valor = String.valueOf(bebida.getPrecio());
            precio.setText("Precio: " + valor + " €");

        if (producto.equals("pizza")) {//En el caso de que la varaiable "producto" obtenida sea pizza
            //Los TextView son definidos con sus valores correspondientes
            nombre.setText(pizza.getNombre());
            detalle.setText(pizza.getDescripcion());
            imagen01.setImageResource(pizza.getImagenID());
            valor = String.valueOf(pizza.getPrecio());
            precio.setText("Precio: " + valor + " €");
        }//Fin If
    }//Fin onCreate()
        */
    }
    /**
     * Método utilizado para el botón que aumenta la cantidad del producto
     * @param view Parámetro por defecto
     */
    public void agregar(View view){
        //Obtiene el valor del TextView
        String valor = cant.getText().toString();
        //Se convierte  Integer
        int aux = Integer.parseInt(valor);
        //Se define el valor de una suma de + 1 en el TextView
        cant.setText("" + (aux+1));
    }//Fin agregar()

    /**
     * Método utilizado para el botón que desminuye la cantidad del producto
     * @param view
     */

    public void restar(View view){
        //Obtiene el valor del TextView
        String valor = cant.getText().toString();
        //Se convierte  Integer
        int aux = Integer.parseInt(valor);
        //Se define el valor de una resta de - 1 en el TextView, y en el caso de que el valor
        //sea igual a 1, se mantiene
        if (aux == 1){
            cant.setText("" + 1);
        }else {
            cant.setText("" + (aux - 1));
        }//Fin If
    }//Fin restar()

    public void addProduct(View view){
        //usuario = getIntent().getStringExtra("usuario");

        helper.agregarCarrito(usuario, nombre.getText().toString(), detalle.getText().toString(), cant.getText().toString(), precio.getText().toString());

        //Se informa por pantalla ingreso exitoso
        Toast.makeText(getApplicationContext(),"SE HA AÑADIDO EL ARTÍCULO AL CARRITO" ,Toast.LENGTH_LONG).show();

        /*
        //HelperBD helper = new HelperBD(this);

        //Se habilita la base de datos para ingresar datos
        SQLiteDatabase db = helper.getWritableDatabase();

        //Se define una variable del tipo ContentValues dado que es el formato con el que funciona el ingreso de datos en una BD
        // del tipo SQLite
        ContentValues values = new ContentValues();

        //Se intgresan los valores del producto en la variable values
        values.put("USUARIO", usuario);
        values.put("NOMBRE", nombre.getText().toString() );
        values.put("DESCRIPCION", detalle.getText().toString());
        values.put("CANTIDAD", cant.getText().toString());
        values.put("PRECIO", precio.getText().toString());
        //Se insertan los datos en la BD enviándo como parámetro el nombre de la tabla y la variable values con los datos
        //long newRowId = db.insert("PEDIDOS", null, values);
        db.insert("PEDIDOS", null, values);
        db.close();
        */

    }//Fin agregarcarrito()


}
