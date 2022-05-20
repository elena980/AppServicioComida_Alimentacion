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
    public static String usuario;

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
                //Se define un adaptador que contiene un ArrayList de Producto.bebidas
                ArrayAdapter<Producto> adaptador01 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.bebidas);
                //Definición del adaptador
                listaBebidas.setAdapter(adaptador01);
                this.setTitle("Bebidas");
                //Creación de ItemClickListener para el ListView ListaBebidas
                listaBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "bebida");
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
                //Se define un adaptador que contiene un ArrayList de Producto.raciones
                ArrayAdapter<Producto> adaptador02 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.raciones);
                //Definición del adaptador
                listaRaciones.setAdapter(adaptador02);
                this.setTitle("Raciones");
                //Creación de ItemClickListener para el ListView ListaRaciones
                listaRaciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "racion");
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
                //Se define un adaptador que contiene un ArrayList de Producto.ensaladas
                ArrayAdapter<Producto> adaptador03 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.ensaladas);
                //Definición del adaptador
                listaEnsaladas.setAdapter(adaptador03);
                this.setTitle("Ensaladas");
                //Creación de ItemClickListener para el ListView ListaEnsaladas
                listaEnsaladas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "ensalada");
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
                //Se define un adaptador que contiene un ArrayList de Producto.hamburguesas
                ArrayAdapter<Producto> adaptador04 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.hamburguesas);
                //Definición del adaptador
                listaHamburguesas.setAdapter(adaptador04);
                this.setTitle("Hamburguesas");
                //Creación de ItemClickListener para el ListView ListaHamgurguesas
                listaHamburguesas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "hamburguesa");
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
                //Se define un adaptador que contiene un ArrayList de Producto.sandwiches
                ArrayAdapter<Producto> adaptador05 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.sandwiches);
                //Definición del adaptador
                listaSandwiches.setAdapter(adaptador05);
                this.setTitle("Sandwiches");
                //Creación de ItemClickListener para el ListView ListaSandwiches
                listaSandwiches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "sandwich");
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
                //Se define un adaptador que contiene un ArrayList de Producto.pizzas
                ArrayAdapter<Producto> adaptador06 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.pizzas);
                //Definición del adaptador
                listaPizzas.setAdapter(adaptador06);
                this.setTitle("Pizzas");

                //Creación de ItemClickListener para el ListView ListaPizzas
                listaPizzas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "pizza");
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
                //Se define un adaptador que contiene un ArrayList de Producto.postres
                ArrayAdapter<Producto> adaptador07 = new ArrayAdapter<Producto>(this, android.R.layout.simple_list_item_1, Producto.postres);
                //Definición del adaptador
                listaPostres.setAdapter(adaptador07);
                this.setTitle("Postres");

                //Creación de ItemClickListener para el ListView ListaPostres
                listaPostres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position != -1) {//SE REALIZA UN INTENT CON EL ITEM SELECCIONADO DE LA LISTA
                            Intent intento = new Intent(Activity02.this, Activity03.class);
                            //SE ENVIAN LOS PARAMETROS NECESARIOS PARA VISUALIZAR EL ITEM EN EL SGTE ACTIVITY
                            intento.putExtra("posicion", String.valueOf(position));
                            intento.putExtra("producto", "postre");
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
     * Método heredado de la Super Clase Activity para que al momento de volver al Activity02 se cargen los valores
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

