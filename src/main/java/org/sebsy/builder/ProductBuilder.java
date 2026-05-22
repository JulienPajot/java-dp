package org.sebsy.builder;

import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {
    private String name;
    private String marqueName;
    private String categoryName;
    private String unit;
    private double price;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Allergene>  allergenes  = new ArrayList<>();
    private final List<Additif>    additifs    = new ArrayList<>();

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withMarque(String marqueName) {
        this.marqueName = marqueName;
        return this;
    }

    public ProductBuilder withCategory(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public ProductBuilder withUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withIngredient(String name, double qteMilligrammes) {
        this.ingredients.add(new Ingredient(name, qteMilligrammes));
        return this;
    }

    public ProductBuilder withAdditif(String name, double qteMilligrammes) {
        this.additifs.add(new Additif(name, qteMilligrammes));
        return this;
    }

    public ProductBuilder withAllergene(String name, double qteMilligrammes) {
        this.allergenes.add(new Allergene(name, qteMilligrammes));
        return this;
    }

    public Product build() {
        return new Product(
                name,
                new Marque(marqueName),
                new Category(categoryName),
                unit,
                price,
                ingredients,
                allergenes,
                additifs
        );
    }
}