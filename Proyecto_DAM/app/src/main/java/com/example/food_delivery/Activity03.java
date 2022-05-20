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
    private Producto[] bebidas = producto.bebidas;
    private Producto[] raciones = producto.raciones;
    private Producto[] ensaladas = producto.ensaladas;
    private Producto[] hamburguesas = producto.hamburguesas;
    private Producto[] sandwiches = producto.sandwiches;
    private Producto[] pizzas = producto.pizzas;
    private Producto[] postres = producto.postres;
    private TextView nombre, detalle, precio, cant, cantCart;
    private ImageView imagen01;
    private String valor;
    private String usuario;

    //private HelperBD helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_03);

        usuario = getIntent().getStringExtra("usuario");
        // HelperBD helper = new HelperBD(this);
        getSupportActionBar().hide();

        //InstanciacewById(R.id.txt_cant);
        nombre = findViewById(R.id.txt_name);
        detalle = findViewById(R.id.txt_desc);
        imagen01 = findViewById(R.id.image01);
        precio = findViewById(R.id.txt_price);
        cant = findViewById(R.id.txt_cant);
        cantCart = findViewById(R.id.cantCart);



        //OBTENEMOS LA POSICION QUE ENVIA EL  ACTIVITY2
        Bundle bundle = getIntent().getExtras();
        //POSICION OBTENIDA ES DECLARADA COMO INTEGER
        int id = Integer.parseInt(bundle.getString("posicion"));
        //Se obtiene además el nombre del tipo de producto que se mostrarán
        String producto = bundle.getString("producto");

        //INSTANCIAMOS LA CLASE PRODUCTO Y LOS ARREGLOS CORRESPONDIENTES PARA SELECCIÓN
        Producto bebidas = Producto.bebidas[id];
        Producto raciones = Producto.raciones[id];
        Producto ensaladas = Producto.ensaladas[id];
        Producto hamburguesas = Producto.hamburguesas[id];
        Producto sandwiches = Producto.sandwiches[id];
        Producto pizzas = Producto.pizzas[id];
        Producto postres = Producto.postres[id];

        //LUEGO DE EVALUAR EL TIPO DE PRODUCTO ESCOGIDO SE VISUALIZAN LOS DATOS CORRESPONDIENTES
        // INSTANCIADOS EN LOS COMPONENTES DEL ACTIVITY03

        switch (producto) {

            //En el caso de que la varaiable "producto" obtenida sea bebidas
            //Los TextView son definidos con sus valores correspondientes
            case "bebidas":
                nombre.setText(bebidas.getNombre());
                detalle.setText(bebidas.getDescripcion());
                imagen01.setImageResource(bebidas.getImagenID());
                valor = String.valueOf(bebidas.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "raciones":
                nombre.setText(raciones.getNombre());
                detalle.setText(raciones.getDescripcion());
                imagen01.setImageResource(raciones.getImagenID());
                valor = String.valueOf(raciones.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "ensaladas":
                nombre.setText(ensaladas.getNombre());
                detalle.setText(ensaladas.getDescripcion());
                imagen01.setImageResource(ensaladas.getImagenID());
                valor = String.valueOf(ensaladas.getPrecio());
                precio.setText("Precio: " + valor + " €");

                break;

            case "hamburguesas":
                nombre.setText(hamburguesas.getNombre());
                detalle.setText(hamburguesas.getDescripcion());
                imagen01.setImageResource(hamburguesas.getImagenID());
                valor = String.valueOf(hamburguesas.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "sandwiches":
                nombre.setText(sandwiches.getNombre());
                detalle.setText(sandwiches.getDescripcion());
                imagen01.setImageResource(sandwiches.getImagenID());
                valor = String.valueOf(sandwiches.getPrecio());
                precio.setText("Precio: " + valor + " €");

                break;

            case "pizzas":
                nombre.setText(pizzas.getNombre());
                detalle.setText(pizzas.getDescripcion());
                imagen01.setImageResource(pizzas.getImagenID());
                valor = String.valueOf(pizzas.getPrecio());
                precio.setText("Precio: " + valor + " €");
                break;

            case "postres":
                nombre.setText(postres.getNombre());
                detalle.setText(postres.getDescripcion());
                imagen01.setImageResource(postres.getImagenID());
                valor = String.valueOf(postres.getPrecio());
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
     *
     * @param view Parámetro por defecto
     */
    public void agregar(View view) {
        //Obtiene el valor del TextView
        String valor = cant.getText().toString();
        //Se convierte  Integer
        int aux = Integer.parseInt(valor);
        //Se define el valor de una suma de + 1 en el TextView
        cant.setText("" + (aux + 1));
    }//Fin agregar()

    // metodo contador para el carrito
    public void addCart(View view) {
        String countProduct = cant.getText().toString();
        int aux1 = Integer.parseInt(countProduct);
        String numberCart = cantCart.getText().toString();
        int aux2 = Integer.parseInt(numberCart);
        cantCart.setText(aux1 + aux2);
    }

    /**
     * Método utilizado para el botón que desminuye la cantidad del producto
     *
     * @param view
     */

    public void restar(View view) {
        //Obtiene el valor del TextView
        String valor = cant.getText().toString();
        //Se convierte  Integer
        int aux = Integer.parseInt(valor);
        //Se define el valor de una resta de - 1 en el TextView, y en el caso de que el valor
        //sea igual a 1, se mantiene
        if (aux == 1) {
            cant.setText("" + 1);
        } else {
            cant.setText("" + (aux - 1));
        }//Fin If
    }//Fin restar()

    HelperBD helper = new HelperBD(this);

    public void viewCart(View view) {
        //HelperBD helper = new HelperBD(this);
        //Se habilita la base de datos para ingresar datos
        SQLiteDatabase db = helper.getWritableDatabase();
        //Se define una variable del tipo ContentValues dado que es el formato con el que funciona el ingreso de datos en una BD
        // del tipo SQLite
        ContentValues values = new ContentValues();
        //Se intgresan los valores del producto en la variable values
        values.put("USUARIO", usuario);
        values.put("NOMBRE", nombre.getText().toString());
        values.put("DESCRIPCION", detalle.getText().toString());
        values.put("CANTIDAD", cant.getText().toString());
        values.put("PRECIO", precio.getText().toString());
        //Se insertan los datos en la BD enviándo como parámetro el nombre de la tabla y la variable values con los datos
        //long newRowId = db.insert("PEDIDOS", null, values);
        db.insert("PEDIDOS", null, values);
        db.close();
        //Se informa por pantalla ingreso exitoso
        Toast.makeText(getApplicationContext(), "SE HA AÑADIDO EL ARTÍCULO AL CARRITO", Toast.LENGTH_LONG).show();
    }//Fin agregarcarrito()
}