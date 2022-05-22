package com.example.food_delivery;

public class Product {

    private String name;
    private String description;
    private int imagenProduct;
    private double price ;

    public Product() {
    }

    public Product(String name, String description, int imagenProduct, double price) {
        this.name = name;
        this.description = description;
        this.imagenProduct = imagenProduct;
        this.price = price;
    }

    public final static Product drinks[]={
            new Product("Water","Mineral water 50 cl", R.mipmap.botella_agua,1.50),
            new Product("Coca Cola", "Coca Cola Soft Drink 50 cl",R.mipmap.botella_cocacola,2.50),
            new Product("Nestea","Iced tea soda 50 cl",R.mipmap.botella_nestea,2.50),
            new Product("Beer","Can of Mahou beer 33 cl",R.mipmap.cerveza_mahou,2.00)
    };

    public final static Product rations[]={
            new Product("Spicy potatoes","Potato ration with brava sauce", R.mipmap.patatas_bravas,3.50),
            new Product("Croquettes","Serving of chicken croquettes - 8 unds",R.mipmap.croquetas,5.75),
            new Product("Galician pulgo", "Ration of Galician pulgo with oil, spicy paprika accompanied by cooked potato",R.mipmap.pulpo_gallega,11.50),
            new Product("Belly","Portion of pickled belly loins",R.mipmap.ventresca,6.50),
    };

    public final static Product salads[]={
            new Product("Mixed Salad","Romaine lettuce, tomato, tuna, onion, cucumber and boiled egg", R.mipmap.ensalada_mixta,5.00),
            new Product("Caesar Salad","Romaine lettuce, egg, Worcestershire sauce, anchovies, Dijon mustard, Parmesan cheese and chicken",R.mipmap.ensalada_cesar,6.50),
            new Product("Rice salad", "Basmati rice, olives, boiled egg and peppers",R.mipmap.ensalada_arroz,5.50),
            new Product("Caprese Salad","Basil, tomato, buffalo mozzarella and black olives",R.mipmap.ventresca,6.50)
    };

    public final static Product hamburguers[]={
            new Product("Classic Hamburger","Beef 100 g, lettuce, tomato, onion and pickles", R.mipmap.hamburguesa_clasica,4.50),
            new Product("Bacon-Cheese Burger","Beef 100 g (2 units), bacon, cheddar cheese",R.mipmap.hamburguesa_bancon_queso,7.50),
            new Product("BBQ Burger","Beef 100g, onion, pickle and barcacoa sauce",R.mipmap.hamburgues_bbq,5.50),
            new Product("Jalapeña Burger", "Beef 100g, onion, pickle and barcacoa sauce",R.mipmap.hamburguesa_jalapenios,6.50),

    };

    public final static Product sandwiches[]={
            new Product("Habanero sandwich","Ham, cheese, lettuce, tomato, boiled egg and mayonnaise", R.mipmap.sandwich_california,5.50),
            new Product("Mixto sandwich","Ham and cheese",R.mipmap.sandwich_mixto,4.00),
            new Product("Habanero sandwich","Serrano ham, cheese, French omelette and mayonnaise",R.mipmap.sandwich_habanero,6.00),
            new Product("Chicken Sandwich", "Chicken, cheese, lettuce, tomato and mayonnaise",R.mipmap.sandwich_pollo,5.50)

    };

    public final static Product pizzas[]={
            new Product("Pizza Margarita","Mozarella, tomato sauce, oregano and basil", R.mipmap.pizza_margarita,7.50),
            new Product("Pizza Carbonara","Parmesan, bacon, mushrooms and carbonara sauce",R.mipmap.pizza_carbonara,8.50),
            new Product("Pizza 4 Cheeses","Mozzarella, Parmesan, Cheddar and Roquefort",R.mipmap.pizza_4_quesos,8.50),
            new Product("Pizza Pepperoni", "Gorgonzola, pepperoni, tomato sauce and oregano",R.mipmap.pizza_pepperoni,6.50),
    };

    public final static Product deserts[]={
            new Product("Truffle ice cream","Two scoops of truffle ice cream with chocolate shavings", R.mipmap.helado_trufa,3.50),
            new Product("Cheesecake","Ricotta base, cottage cheese, quark cheese, sugar and cream of milk",R.mipmap.tarta_queso,5.50),
            new Product("Tiramisu","Sponge cake dough soaked in coffee with liquor, compound cream and soft cheese",R.mipmap.tiramisu,4.50),
            new Product("Lemon mousse", "Yogurt cream and condensed milk with lemon flavor",R.mipmap.mousse_limon,4.50),
    };

    //GETTERS Y SETTERS
    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
                return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImagenProduct() {
        return imagenProduct;
    }

    public void setImagenProduct(int imagenProduct) {
        this.imagenProduct = imagenProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return name;
    }

    public static Product[] getDrinks() {
        return drinks;
    }

    public static Product[] getRations() {
        return rations;
    }

    public static Product[] getSalads() {
        return salads;
    }

    public static Product[] getHamburguers() {
        return hamburguers;
    }

    public static Product[] getSandwiches() {
        return sandwiches;
    }

    public static Product[] getPizzas() {
        return pizzas;
    }

    public static Product[] getDeserts() {
        return deserts;
    }


}



