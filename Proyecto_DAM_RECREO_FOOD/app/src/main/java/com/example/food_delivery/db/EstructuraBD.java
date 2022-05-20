package com.example.food_delivery.db;

public class EstructuraBD {

    // Constructor por defectO
    private EstructuraBD() {}

    // Declaración de constantes que contienen la información
    // correspondiente a la estructura de la base de datos
    public static final String TABLE_NAME_01 = "USUARIOS";
    public static final String COLUMNA01= "ID_USUARIO";
    public static final String COLUMNA02 = "USUARIO";
    public static final String COLUMNA03 = "PASSWORD";
    public static final String COLUMNA04= "NOMBRE";
    public static final String COLUMNA05= "APELLIDOS";
    public static final String COLUMNA06= "TELEFONO";
    public static final String COLUMNA07= "DIRECCION";

    public static final String TABLE_NAME_02 = "PEDIDOS";
    public static final String COLUMNA08= "ID_USUARIO";
    public static final String COLUMNA09 = "USUARIO";
    public static final String COLUMNA10= "NOMBRE";
    public static final String COLUMNA11= "DESCRIPCION";
    public static final String COLUMNA12= "CANTIDAD";
    public static final String COLUMNA13= "PRECIO";

    //Declaración de constante que contiene la sentencia SQL para la creación de la tabla "USUARIOS"
    public static final String SQL_CREATE_ENTRIES_01 =
            "CREATE TABLE " +  EstructuraBD.TABLE_NAME_01 +
                    EstructuraBD.COLUMNA01 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EstructuraBD.COLUMNA02 + " TEXT," +
                    EstructuraBD.COLUMNA03 + " TEXT," +
                    EstructuraBD.COLUMNA04 + " TEXT," +
                    EstructuraBD.COLUMNA05 + " TEXT," +
                    EstructuraBD.COLUMNA06 + " TEXT," +
                    EstructuraBD.COLUMNA07 + " TEXT)";

    //Declaración de constante que contiene la sentencia SQL para la creación de la tabla "PEDIDOS"
    public static final String SQL_CREATE_ENTRIES_02 =
            "CREATE TABLE " + EstructuraBD.TABLE_NAME_02 +
                    EstructuraBD.COLUMNA08 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    EstructuraBD.COLUMNA09 + " TEXT," +
                    EstructuraBD.COLUMNA10 + " TEXT," +
                    EstructuraBD.COLUMNA11 + " TEXT," +
                    EstructuraBD.COLUMNA12 + " TEXT," +
                    EstructuraBD.COLUMNA13 + " TEXT," +
                    " FOREIGN KEY (" + EstructuraBD.COLUMNA09 + ") REFERENCES " +
                    TABLE_NAME_01 + "(" + COLUMNA01 + ")";


    //Declaración de constante que contiene la sentencia SQL para eliminar la tabla "USUARIOS" de la BD
    public static final String SQL_DELETE_ENTRIES_01 =
            "DROP TABLE IF EXISTS " + EstructuraBD.TABLE_NAME_01;

    //Declaración de constante que contiene la sentencia SQL para eliminar la tabla "PEDIDOS" de la BD
    public static final String SQL_DELETE_ENTRIES_02 =
            "DROP TABLE IF EXISTS " + EstructuraBD.TABLE_NAME_02;

    //Declaración de constante que contiene la sentencia SQL para eliminar los registros de la tabla "PEDIDOS" de la BD
    public static final String SQL_DELETE_REGISTERS_02 =
            "DELETE FROM " + EstructuraBD.TABLE_NAME_02;
}//Fin Class

