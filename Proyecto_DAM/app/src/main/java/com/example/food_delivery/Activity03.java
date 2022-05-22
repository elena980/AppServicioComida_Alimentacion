package com.example.food_delivery;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.HelperBD;

public class Activity03 extends AppCompatActivity {

    //DECLARACIÓN DE VARIABLES
    private Product producto = new Product();
    private Product[] bebidas = producto.drinks;
    private Product[] raciones = producto.rations;
    private Product[] ensaladas = producto.salads;
    private Product[] hamburguesas = producto.hamburguers;
    private Product[] sandwiches = producto.sandwiches;
    private Product[] pizzas = producto.pizzas;
    private Product[] postres = producto.deserts;
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
        Product bebidas = Product.drinks[id];
        Product raciones = Product.rations[id];
        Product ensaladas = Product.salads[id];
        Product hamburguesas = Product.hamburguers[id];
        Product sandwiches = Product.sandwiches[id];
        Product pizzas = Product.pizzas[id];
        Product postres = Product.deserts[id];

        //LUEGO DE EVALUAR EL TIPO DE PRODUCTO ESCOGIDO SE VISUALIZAN LOS DATOS CORRESPONDIENTES
        // INSTANCIADOS EN LOS COMPONENTES DEL ACTIVITY03

        switch (producto) {

            //En el caso de que la varaiable "producto" obtenida sea bebidas
            //Los TextView son definidos con sus valores correspondientes
            case "bebidas":
                nombre.setText(bebidas.getName());
                detalle.setText(bebidas.getDescription());
                imagen01.setImageResource(bebidas.getImagenProduct());
                valor = String.valueOf(bebidas.getPrice());
                precio.setText("Price: " + valor + " €");
                break;

            case "raciones":
                nombre.setText(raciones.getName());
                detalle.setText(raciones.getDescription());
                imagen01.setImageResource(raciones.getImagenProduct());
                valor = String.valueOf(raciones.getPrice());
                precio.setText("Price: " + valor + " €");
                break;

            case "ensaladas":
                nombre.setText(ensaladas.getName());
                detalle.setText(ensaladas.getDescription());
                imagen01.setImageResource(ensaladas.getImagenProduct());
                valor = String.valueOf(ensaladas.getPrice());
                precio.setText("Price: " + valor + " €");

                break;

            case "hamburguesas":
                nombre.setText(hamburguesas.getName());
                detalle.setText(hamburguesas.getDescription());
                imagen01.setImageResource(hamburguesas.getImagenProduct());
                valor = String.valueOf(hamburguesas.getPrice());
                precio.setText("Price: " + valor + " €");
                break;

            case "sandwiches":
                nombre.setText(sandwiches.getName());
                detalle.setText(sandwiches.getDescription());
                imagen01.setImageResource(sandwiches.getImagenProduct());
                valor = String.valueOf(sandwiches.getPrice());
                precio.setText("Price: " + valor + " €");

                break;

            case "pizzas":
                nombre.setText(pizzas.getName());
                detalle.setText(pizzas.getDescription());
                imagen01.setImageResource(pizzas.getImagenProduct());
                valor = String.valueOf(pizzas.getPrice());
                precio.setText("Price: " + valor + " €");
                break;

            case "postres":
                nombre.setText(postres.getName());
                detalle.setText(postres.getDescription());
                imagen01.setImageResource(postres.getImagenProduct());
                valor = String.valueOf(postres.getPrice());
                precio.setText("Price: " + valor + " €");
                break;

            default:
                break;

        }
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
        Toast.makeText(getApplicationContext(), "THE ITEM HAS BEEN ADDED TO THE CART", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ActivityStore.class);
        startActivity(intent);
    }//Fin agregarcarrito()
}