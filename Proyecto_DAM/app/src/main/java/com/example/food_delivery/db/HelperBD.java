package com.example.food_delivery.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperBD extends SQLiteOpenHelper {
    //Declaración de constantes que contienen información de la BD a la que se realiza la conexión
    public static final int DATABASE_VERSION = 1;
    //public static final String DATABASE_NAME = "food_delivery.db";
    public static final String DATABASE_NAME = "database_food.db";


    /**
     * Contructor por defecto
     *
     * @param context Parametro por defecto
     */
    public HelperBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Método encargado de crear la base de datos llamando una constante de la clase EstructuraBD
     *
     * @param db Objeto de la clase SQLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(EstructuraBD.SQL_CREATE_ENTRIES_01);
        //db.execSQL(EstructuraBD.SQL_CREATE_ENTRIES_02);
        db.execSQL("CREATE TABLE " + EstructuraBD.TABLE_NAME_01 +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USUARIO TEXT, PASSWORD TEXT, NOMBRE TEXT," +
                " APELLIDOS TEXT, DIRECCION TEXT, TELEFONO TEXT)");

        db.execSQL("CREATE TABLE " + EstructuraBD.TABLE_NAME_02 +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " USUARIO TEXT, NOMBRE TEXT, DESCRIPCION TEXT," +
                " CANTIDAD TEXT, PRECIO TEXT, " +
                " FOREIGN KEY(USUARIO) REFERENCES " + EstructuraBD.TABLE_NAME_01 + "(ID))");


    }//Fin onCreate()

    /**
     * Método encargado de eliminar la tabla especificada en la constante de la clase EstructuraBD a modo de actualización
     *
     * @param db         Objeto de la clase SQLiteDatabase
     * @param oldVersion Id de la versión de la BD anterior
     * @param newVersion Id de la versión de la BD nueva
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EstructuraBD.SQL_DELETE_ENTRIES_01);
        db.execSQL(EstructuraBD.SQL_DELETE_ENTRIES_02);
        onCreate(db);
    }//Fin onUpgrade()

    /**
     * Método encargado de eliminar la tabla especificada en la constante de la clase EstructuraBD a modo de desactualización
     *
     * @param db         Objeto de la clase SQLiteDatabase
     * @param oldVersion Id de la versión de la BD anterior
     * @param newVersion Id de la versión de la BD nueva
     */
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }//Fin onDowngrade()


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
}


