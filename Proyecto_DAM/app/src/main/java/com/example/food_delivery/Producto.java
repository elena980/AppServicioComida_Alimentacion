package com.example.food_delivery;

public class Producto {

    private String nombre;
    private String descripcion;
    private int imagenID;
    private double precio ;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, int imagenID, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenID = imagenID;
        this.precio = precio;
    }

    public final static Producto bebidas[]={
            new Producto("Agua","Agua mineal 50 cl", R.mipmap.botella_agua,1.50),
            new Producto("Coca Cola", "Refresco Coca Cola 50 cl",R.mipmap.botella_cocacola,2.50),
            //new Producto("Limonada","Refresco de limón 50 cl",R.mipmap.botella_limonada,2.00),
            new Producto("Nestea","Refresco de té helado 50 cl",R.mipmap.botella_nestea,2.50),
            new Producto("Cerveza","Lata de cerveza Mahou 33 cl",R.mipmap.cerveza_mahou,2.00)
    };

    public final static Producto raciones[]={
            new Producto("Patatas Bravas","Ración de patatas con salsa brava", R.mipmap.patatas_bravas,3.50),
            new Producto("Croquetas","Ración de croquetas de pollo - 8 unidades",R.mipmap.croquetas,5.75),
            new Producto("Pulgo a la gallega", "Ración de pulgo gallego con aceite, pimentón picante acompañado de patata cocida",R.mipmap.pulpo_gallega,11.50),
            new Producto("Ventresca","Ración de lomos de ventresca en escabeche",R.mipmap.ventresca,6.50),
            //new Producto("Jamón Ibérico","Ración de jamón ibérico de bellota 5J",R.mipmap.jamon_iberico,12.75)
    };

    public final static Producto ensaladas[]={
            new Producto("Ensalada Mixta","Lechuga romana, tomate, atún, cebolla, pepino y huevo cocido", R.mipmap.ensalada_mixta,5.00),
            new Producto("Ensalada César","Lechuga romana, huevo, salsa Worcestershire, anchoas, mostaza de Dijon, queso parmesano y pollo",R.mipmap.ensalada_cesar,6.50),
            new Producto("Ensalada de arroz", "Arroz basmati, aceitunas, huevo cocido y pimientos",R.mipmap.ensalada_arroz,5.50),
            new Producto("Ensalada Caprese","Albahaca, tomate, mozzarella de búfala y aceitunas negras",R.mipmap.ventresca,6.50)
    };

    public final static Producto hamburguesas[]={
            new Producto("Hamburgesa Clásica","Carne de vacuno 100 g, lechuga, tomate, cebolla y pepinillos", R.mipmap.hamburguesa_clasica,4.50),
            new Producto("Hamburguesa Bacon-Queso","Carne de vacuno 100 g (2 unidades), bacon, queso cheddar",R.mipmap.hamburguesa_bancon_queso,7.50),
            new Producto("Hamburguesa BBQ","Carne de vacuno 100g, cebolla, pepinillo y salsa barcacoa",R.mipmap.hamburgues_bbq,5.50),
            new Producto("Hamburguesa Jalapeña", "Carne de vacuno 100 g, cebolla, queso emmental y jalapeños",R.mipmap.hamburguesa_jalapenios,6.50),
            //new Producto("Hamburguesa Pollo","Carne de pollo 100 g, lechuga, tomate, cebolla y pepinillos",R.mipmap.hamburguesa_pollo,5.50)
    };

    public final static Producto sandwiches[]={
            new Producto("Sandwich California","Jamón york, queso, lechuga, tomate, huevo cocido y mayonesa", R.mipmap.sandwich_california,5.50),
            new Producto("Sandwich Mixto","Jamón york y queso",R.mipmap.sandwich_mixto,4.00),
            new Producto("Sandwich Habanero","Jamón serrano, queso, tortilla francesa y mayonesa",R.mipmap.sandwich_habanero,6.00),
            new Producto("Sandwich Pollo", "Pollo, queso, lechuga, tomate y mayonesa",R.mipmap.sandwich_pollo,5.50)

    };

    public final static Producto pizzas[]={
            new Producto("Pizza Margarita","Mozarella, salsa de tomate, orégano y albahaca", R.mipmap.pizza_margarita,7.50),
            new Producto("Pizza Carbonara","Parmesano, bacon, champiñones y salsa carbonara",R.mipmap.pizza_carbonara,8.50),
            new Producto("Pizza 4 Quesos","Mozzarella, Parmesano, Cheddar y Roquefort",R.mipmap.pizza_4_quesos,8.50),
            //new Producto("Pizza Barbacoa", "Parmesano, carne de vacuno, bacon, pollo marinado y salsa barbacoa",R.mipmap.pizza_barbacoa,7.50),
            new Producto("Pizza Pepperoni", "Gorgonzola, pepperoni, salsa de tomate y orégano",R.mipmap.pizza_pepperoni,6.50),
            //new Producto("Pizza Hawaiana", "Parmesano, jamón york, piña, salsa de tomate y orégano",R.mipmap.pizza_hawaiana,7.50)

    };

    public final static Producto postres[]={
            new Producto("Helado de trufa","Dos bolas de helado de trufa con virutas de chocolate", R.mipmap.helado_trufa,3.50),
            new Producto("Tarta de queso","Base de ricota, requesón, queso quark, azúcar y crema de leche",R.mipmap.tarta_queso,5.50),
            new Producto("Tiramisu","Masa de bizcocho empapadas en café con licor, crema compuesta y queso suave",R.mipmap.tiramisu,4.50),
            new Producto("Mousse de limón", "Crema de yogur y leche condensada con sabor a limón",R.mipmap.mousse_limon,4.50),
            //new Producto("Crepes de chocolate", "Dos crepes de masa de harina de trigo con sirope de chocolate",R.mipmap.crepes_chocolate,6.50)

    };

    //GETTERS Y SETTERS
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
                return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenID() {
        return imagenID;
    }

    public void setImagenID(int imagenID) {
        this.imagenID = imagenID;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return nombre;
    }

    public static Producto[] getBebidas() {
        return bebidas;
    }

    public static Producto[] getRaciones() {
        return raciones;
    }

    public static Producto[] getEnsaladas() {
        return ensaladas;
    }

    public static Producto[] getHamburguesas() {
        return hamburguesas;
    }

    public static Producto[] getSandwiches() {
        return sandwiches;
    }

    public static Producto[] getPizzas() {
        return pizzas;
    }

    public static Producto[] getPostres() {
        return postres;
    }


}



