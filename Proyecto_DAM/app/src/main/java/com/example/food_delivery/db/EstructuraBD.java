package com.example.food_delivery.db;

public class EstructuraBD {
    /**
     * Constructor por defecto
     */
    private EstructuraBD() {}

    //Declaración de constantes que contienen la información correspondiente a la estructura de la base de datos
    public static final String TABLE_NAME_01 = "USUARIOS";
    public static final String COLUMNA01= "id";
    public static final String COLUMNA02 = "usuario";
    public static final String COLUMNA03 = "password";
    public static final String COLUMNA04= "nombre";
    public static final String COLUMNA05= "apellidos";
    public static final String COLUMNA06= "telefono";
    public static final String COLUMNA07= "direccion";


    public static final String TABLE_NAME_02 = "PEDIDOS";
    public static final String COLUMNA08= "id";
    public static final String COLUMNA09 = "usuario";
    public static final String COLUMNA10= "nombre";
    public static final String COLUMNA11= "descripcion";
    public static final String COLUMNA12= "cantidad";
    public static final String COLUMNA13= "precio";

    //Declaración de constante que contiene la sentencia SQL para la creación de la tabla "pedidos"
    public static final String SQL_CREATE_ENTRIES_01 =
            "CREATE TABLE " + EstructuraBD.TABLE_NAME_01 +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " USUARIO TEXT, PASSWORD TEXT, NOMBRE TEXT," +
                    " APELLIDOS TEXT, DIRECCION TEXT, TELEFONO TEXT)";

                    /*EstructuraBD.COLUMNA01 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EstructuraBD.COLUMNA02 + " TEXT," +
                    EstructuraBD.COLUMNA03 + " TEXT," +
                    EstructuraBD.COLUMNA04 + " TEXT," +
                    EstructuraBD.COLUMNA05 + " TEXT," +
                    EstructuraBD.COLUMNA06 + " TEXT," +
                    EstructuraBD.COLUMNA07 + " TEXT)";
                     */

    public static final String SQL_CREATE_ENTRIES_02 =
            "CREATE TABLE " + EstructuraBD.TABLE_NAME_02 +
                    " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " USUARIO TEXT, NOMBRE TEXT, DESCRIPCION TEXT," +
                    " CANTIDAD TEXT, PRECIO TEXT, " +
                    " FOREIGN KEY(USUARIO) REFERENCES " + TABLE_NAME_01 + "(ID))";
                    /*
                    EstructuraBD.COLUMNA08 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EstructuraBD.COLUMNA09 + " TEXT," +
                    EstructuraBD.COLUMNA10 + " TEXT," +
                    EstructuraBD.COLUMNA11 + " TEXT," +
                    EstructuraBD.COLUMNA12 + " TEXT," +
                    EstructuraBD.COLUMNA13 + " TEXT," +
                    " FOREIGN KEY(" + EstructuraBD.COLUMNA09 + ") REFERENCES " +
                    TABLE_NAME_01 + "(" + COLUMNA01 + ")";
                       */

    //Declaración de constante que contiene la sentencia SQL para eliminar la tabla "pedidos" de la BD
    public static final String SQL_DELETE_ENTRIES_01 =
            "DROP TABLE IF EXISTS " + EstructuraBD.TABLE_NAME_01;

    public static final String SQL_DELETE_ENTRIES_02 =
            "DROP TABLE IF EXISTS " + EstructuraBD.TABLE_NAME_02;

    //Declaración de constante que contiene la sentencia SQL para eliminar los registros de la tabla "pedidos" de la BD
    public static final String SQL_DELETE_REGISTERS_02 =
            "DELETE FROM " + EstructuraBD.TABLE_NAME_02;
}//Fin Class

