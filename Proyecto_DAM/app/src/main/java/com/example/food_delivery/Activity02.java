package com.example.food_delivery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity02 extends AppCompatActivity {

    //DECLARACIÓN DE VARIABLES
    ListView listaBebidas;
    ListView listaRaciones;
    ListView listaEnsaladas;
    ListView listaHamburguesas;
    ListView listaSandwiches;
    ListView listaPizzas;
    ListView listaPostres;
    public static int pos;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);

        usuario = getIntent().getStringExtra("usuario");
        //En la variable "pos" se obtiene el valor de posición enviado a través del intent
        //se declara valor por defecto "-1"
        pos = getIntent().getIntExtra("posicion",-1);
        //Llamado al método para definir los datos de la Listview que corresponda
        definirLista(pos);
    }//Fin onCreate()


    /**
     * Método encargado de definir los valores del ListView según corresponda
     * @param pos Valor de la posición del item seleccionado en el activity "MainActivity"
     */
    public void definirLista(int pos) {

        //SE EVALÚA EL ITEM SELECCIONADO EN EL ACTIVITY ANTERIOR PARA LISTAR LOS DATOS CORRESPONDIENTES
        switch (pos) {
            case 0:

                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaBebidas = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador01 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.drinks);
                //Definición del adaptador
                listaBebidas.setAdapter(adaptador01);
                this.setTitle("Drinks");
                //Creación de ItemClickListener para el ListView ListaCervezas
                listaBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "bebidas");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            case 1:
                this.setTitle("Raciones");
                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaRaciones = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador02 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.rations);
                //Definición del adaptador
                listaRaciones.setAdapter(adaptador02);
                this.setTitle("Rations");
                //Creación de ItemClickListener para el ListView ListaCervezas
                listaRaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "raciones");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            case 2:
                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaEnsaladas = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador03 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.salads);
                //Definición del adaptador
                listaEnsaladas.setAdapter(adaptador03);
                this.setTitle("Salads");
                //Creación de ItemClickListener para el ListView ListaCervezas
                listaEnsaladas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "ensaladas");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            case 3:
                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaHamburguesas = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador04 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.hamburguers);
                //Definición del adaptador
                listaHamburguesas.setAdapter(adaptador04);
                this.setTitle("Hamburguers");
                //Creación de ItemClickListener para el ListView ListaCervezas
                listaHamburguesas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "hamburguesas");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            case 4:
                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaSandwiches = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador05 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.sandwiches);
                //Definición del adaptador
                listaSandwiches.setAdapter(adaptador05);
                this.setTitle("Sandwiches");
                //Creación de ItemClickListener para el ListView ListaCervezas
                listaSandwiches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "sandwiches");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            case 5:
                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaPizzas = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador06 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.pizzas);
                //Definición del adaptador
                listaPizzas.setAdapter(adaptador06);
                this.setTitle("Pizzas");

                //Creación de ItemClickListener para el ListView ListaCervezas
                listaPizzas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "pizzas");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            case 6:
                //SE VISUALIZAN TODOS LOS PRODUCTOS CORRESPONDIENTES AL TIPO SELECCIONADO MEDIANTE UNA LISTA,
                //DE DECLARA EL ARREGLO MEDIANTE UN ADAPTADOR
                listaPostres = findViewById(R.id.lista);
                //Se define un adaptador que contiene un ArrayList de Producto.cervezas
                ArrayAdapter<Product> adaptador07 = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, Product.deserts);
                //Definición del adaptador
                listaPostres.setAdapter(adaptador07);
                this.setTitle("Deserts");

                //Creación de ItemClickListener para el ListView ListaCervezas
                listaPostres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "postres");
                            intento.putExtra("usuario", usuario);
                            //LLamado al método onPause()
                            onPause();
                            //Utilización del Intent para llamar al sgte activity
                            startActivity(intento);
                        }//Fin If
                    }//Fin onItemClick
                });//Fin setOn..
                break;

            default:
                break;
        }
    }

    /**
     * Método heredado de la Super Clase Activity para que al momento de salir del activity actual
     * la ListView quede guardada mediante SharedPreferences y poder volver al activity sin problemas
     */
    public void onPause(){
        //LLamado al método Super
        super.onPause();
        //Instanciacion de SharedPreferences
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        //Se habilita el objeto de tipo SharedPreferences para poder editar el "archivo" local
        SharedPreferences.Editor editor = datos.edit();
        //Se ingresa el valor de posicion traido del activity anterior en el "archivo" mediante un método
        // key + value
        editor.putInt("posicion", pos);
        //Se aplican los cambios, en este caso un ingreso de datos , al "archivo"
        editor.apply();
    }//Fin onPause()

    /**
     * Método heredado de la Super Clase Activity para que al momento de volver al Activity2 se cargen los valores
     * guardados mediante SharedPreferences
     * NOTA: El método onResume, por defecto, es llamado siempre que el Activity es llamado
     */
    public void onResume () {
        //Llamado el método Super
        super.onResume();
        //Si el valor de pos es -1 se obtiene el valor guardado en el "archivo" local mediante SharedPreferences
        if(pos == -1){
            //Se intancia la clase SharedPreferences
            SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
            //Se obtiene el valor de "posicion" guardado en el "archivo" local
            pos = datos.getInt("posicion", 0);
            //LLamado al método definirLista con parámetro obtenido mediante SharedPreferences
            definirLista(pos);
        }else{//En caso contrario, cuando se llama por primera vez el activity.
            //LLamado al método definirListan con parámetro obtenido mediante el getIntent();
            definirLista(pos);
        }//Fin If
    }//Fin onResume()

}

