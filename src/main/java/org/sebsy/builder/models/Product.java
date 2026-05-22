package org.sebsy.builder;

import java.util.Collections;
import java.util.List;

public class Product {
    private String           name;
    private Marque           marque;
    private Category         category;
    private String           unit;
    private double           price;
    private List<Ingredient> ingredients;
    private List<Allergene>  allergenes;
    private List<Additif>    additifs;

    Product(String name, Marque marque, Category category, String unit, double price,
            List<Ingredient> ingredients, List<Allergene> allergenes, List<Additif> additifs) {
        this.name        = name;
        this.marque      = marque;
        this.category    = category;
        this.unit        = unit;
        this.price       = price;
        this.ingredients = ingredients;
        this.allergenes  = allergenes;
        this.additifs    = additifs;
    }

    public String           getName()        { return name;       }
    public Marque           getMarque()      { return marque;     }
    public Category         getCategory()    { return category;   }
    public String           getUnit()        { return unit;       }
    public double           getPrice()       { return price;      }

    public List<Ingredient> getIngredients() { return Collections.unmodifiableList(ingredients); }
    public List<Allergene>  getAllergenes()  { return Collections.unmodifiableList(allergenes);  }
    public List<Additif>    getAdditifs()   { return Collections.unmodifiableList(additifs);    }
}