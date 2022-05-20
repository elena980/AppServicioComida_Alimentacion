package com.example.food_delivery.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class HelperBD extends SQLiteOpenHelper {

    //Declaración de constantes que contienen información de la BD a la que se realiza la conexión
    public static final String DATABASE_NAME = "food_delivery.db";
    public static final String TABLA_USUARIOS = "USUARIOS";
    public static final String TABLA_PEDIDOS = "PEDIDOS";

    /**
     * Contructor por defecto
     *
     * @param context Parametro por defecto
     */
    public HelperBD(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * Método encargado de crear la base de datos
     *
     * @param db Objeto de la clase SQLiteDatabase
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(EstructuraBD.SQL_CREATE_ENTRIES_01);
        //db.execSQL(EstructuraBD.SQL_CREATE_ENTRIES_02);
        db.execSQL("CREATE TABLE " + EstructuraBD.TABLE_NAME_01 +
                " (ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USUARIO TEXT, PASSWORD TEXT, NOMBRE TEXT," +
                " APELLIDOS TEXT, DIRECCION TEXT, TELEFONO TEXT)");

        db.execSQL("CREATE TABLE " + EstructuraBD.TABLE_NAME_02 +
                " (ID_PEDIDO INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USUARIO TEXT, NOMBRE TEXT, DESCRIPCION TEXT," +
                " CANTIDAD TEXT, PRECIO TEXT, " +
                " FOREIGN KEY (USUARIO) REFERENCES " + EstructuraBD.TABLE_NAME_01 + "(ID_USUARIO))");


    }//Fin onCreate()

    /*
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLA_USUARIOS + "(ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT, USUARIO TEXT, PASSWORD TEXT, NOMBRE TEXT, APELLIDOS TEXT, DIRECCION TEXT, TELEFONO TEXT)");
        db.execSQL("CREATE TABLE " + TABLA_PEDIDOS + "(ID_PEDIDOS INTEGER PRIMARY KEY AUTOINCREMENT, USUARIO TEXT, NOMBRE TEXT, DESCRIPCION TEXT, CANTIDAD TEXT, PRECIO TEXT, FOREIGN KEY (USUARIO) REFERENCES USUARIOS(ID_USUARIO))");
    }
    */

    /**
     * Método encargado de eliminar la tabla especificada a modo de actualización
     *
     * @param db         Objeto de la clase SQLiteDatabase
     * @param oldVersion Id de la versión de la BD anterior
     * @param newVersion Id de la versión de la BD nueva
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PEDIDOS);
        onCreate(db);
    }//Fin onUpgrade()

    /*
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EstructuraBD.SQL_DELETE_ENTRIES_01);
        db.execSQL(EstructuraBD.SQL_DELETE_ENTRIES_02);
        onCreate(db);
    }//Fin onUpgrade()
    */

    public void addUsuario(String usuario, String pass, String nombre, String apellidos, String direccion, String telefono) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("USUARIO", usuario);
        registro.put("PASSWORD", pass);
        registro.put("NOMBRE", nombre);
        registro.put("APELLIDOS", apellidos);
        registro.put("DIRECCION", direccion);
        registro.put("TELEFONO", telefono);

        db.insert("USUARIOS", null, registro);
        db.close();
    }

    public void editarUsuario(String usuario, String password, String name, String lastname, String address, String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PASSWORD", password);
        contentValues.put("NOMBRE", name);
        contentValues.put("APELLIDOS", lastname);
        contentValues.put("DIRECCION", address);
        contentValues.put("TELEFONO", phoneNumber);

        db.update("USUARIOS", contentValues, "USUARIO=?", new String[]{usuario});
        db.close();

    }

    public boolean booleanUser(String usuario) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS WHERE USUARIO=?", new String[]{usuario});

        boolean resultado = false;

        int regs = cursor.getCount();
        if (regs == 0) {
            db.close();
            resultado = false;
        } else {
            String dato = new String();
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                dato = cursor.getString(1);
                if (dato.equals(usuario)) {
                    resultado = true;
                } else {
                    resultado = false;
                }
            }
            db.close();
            //}
        }
        return resultado;
    }

    public boolean booleanPass(String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS WHERE PASSWORD=?", new String[]{password});

        boolean resultado = false;

        int regs = cursor.getCount();
        if (regs == 0) {
            db.close();
            resultado = false;
        } else {
            String dato = new String();
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                dato = cursor.getString(2);
                if (dato.equals(password)) {
                    resultado = true;
                } else {
                    resultado = false;
                }
            }
            db.close();
            //}
        }
        return resultado;
    }

    public void agregarCarrito(String usuario, String nombre, String descripcion, String cantidad, String precio){

        //Se habilita la base de datos para ingresar datos
        SQLiteDatabase db = this.getWritableDatabase();
        //Se define una variable del tipo ContentValues dado que es el formato con el que funciona el ingreso de datos en una BD
        // del tipo SQLite
        ContentValues values = new ContentValues();

        //Se intgresan los valores del producto en la variable values
        values.put("USUARIO", usuario);
        values.put("NOMBRE", nombre);
        values.put("DESCRIPCION", descripcion);
        values.put("CANTIDAD", cantidad);
        values.put("PRECIO", precio);
        //Se insertan los datos en la BD enviándo como parámetro el nombre de la tabla y la variable values con los datos
        long newRowId = db.insert("PEDIDOS", null, values);
        // db.insert("PEDIDOS", null, values);
        db.close();

    }//Fin agregarcarrito()

    public void borrarPedido (String usuario) {
        //Se habilita la base de datos para ingresar datos
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("PEDIDOS","USUARIO=?",new String[]{usuario});
        db.close();
    }//Fin agregarcarrito()

    public ArrayList<String> obtenerPedidos(String usuario) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT NOMBRE, CANTIDAD, PRECIO FROM PEDIDOS WHERE USUARIO=?", new String[]{usuario});

        int regs = cursor.getCount();
        if (regs == 0) {
            db.close();
            return null;
        } else {
            int acum = 0;
            ArrayList<String> producto = new ArrayList<String>();
            // int cant = Integer.parseInt(cursor.getString(1));
            //String[] nombres = new String[regs];
            //String [] cantidades = new String [regs];
            //String [] precios = new String [regs];
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                int cant = Integer.parseInt(cursor.getString(1));
                int precio = Integer.parseInt(cursor.getString(2));
                producto.add(cursor.getString(0) + " \nCantidad: " + cant + " \nPrecio unitario: $" + precio +
                        " \nSubtotal: $" + (precio * cant));
                // nombres[i] = cursor.getString(0);
                // cantidades[i] = cursor.getString(1);
                // precios[i] = cursor.getString(2);
                acum = acum + (precio * cant);
                cursor.moveToNext();
            }
            db.close();
            return producto;
        }
    }
/*
    public ArrayList<String> obtenerPedidos02(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT NOMBRE, CANTIDAD, PRECIO FROM PEDIDOS WHERE USUARIO=?",null);

        int regs = cursor.getCount();
        if(regs == 0){
            db.close();
            return null;
        }else {
            int acum = 0;
            ArrayList<String> producto = new ArrayList<String>();
            // int cant = Integer.parseInt(cursor.getString(1));
            //String[] nombres = new String[regs];
            //String [] cantidades = new String [regs];
            //String [] precios = new String [regs];
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                int cant = Integer.parseInt(cursor.getString(1));
                int precio = Integer.parseInt(cursor.getString(2));
                producto.add(cursor.getString(0) + " \nCantidad: " + cant + " \nPrecio unitario: $" + precio +
                        " \nSubtotal: $" + (precio * cant));
                // nombres[i] = cursor.getString(0);
                // cantidades[i] = cursor.getString(1);
                // precios[i] = cursor.getString(2);
                acum = acum + (precio * cant);
                cursor.moveToNext();
            }
            db.close();
            return producto;

        }
    }
    */

/*
    //public String[] obtenerPedidos03(){
    public String[] obtenerPedidos03() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT NOMBRE, CANTIDAD, PRECIO FROM PEDIDOS", null);

        int regs = cursor.getCount();
        if(regs == 0) {
            db.close();
            return null;
        }else {
            int acum = 0;
            //ArrayList<String> producto = new ArrayList<String>();
            //String[] nombres = new String[regs];
            //String[] cantidades = new String [regs];
            //String [] precios = new String [regs];
            String[] productos = new String[regs];
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                int cant = Integer.parseInt(cursor.getString(1));
                int precio = Integer.parseInt(cursor.getString(2));
                productos[i] = (cursor.getString(0) + " \nCantidad: " + cant + " \nPrecio unitario: €" + precio +
                        " \nSubtotal: " + (precio * cant) + " €");
                acum = acum + (precio * cant);
                //nombres[i] = cursor.getString(0);
                //cantidades[i] = cursor.getString(1);
                //precios [i] = cursor.getString(2);

                cursor.moveToNext();
            }
            db.close();
            return productos;
        }
    }

        /*
        }else {
            int acum = 0;
            ArrayList<String> producto = new ArrayList<String>();
            // int cant = Integer.parseInt(cursor.getString(1));
            //String[] nombres = new String[regs];
            //String [] cantidades = new String [regs];
            //String [] precios = new String [regs];
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                int cant = Integer.parseInt(cursor.getString(1));
                int precio = Integer.parseInt(cursor.getString(2));
                producto.add(cursor.getString(0) + " \nCantidad: " + cant + " \nPrecio unitario: $" + precio +
                        " \nSubtotal: $" + (precio * cant));
                // nombres[i] = cursor.getString(0);
                // cantidades[i] = cursor.getString(1);
                // precios[i] = cursor.getString(2);
                acum = acum + (precio * cant);
                cursor.moveToNext();
            }
            db.close();
            return producto;

        }



*/
        public int numeroRegistros () {
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor01 = db.rawQuery("SELECT * FROM PEDIDOS", null);
            return cursor01.getCount();
        }
    }



