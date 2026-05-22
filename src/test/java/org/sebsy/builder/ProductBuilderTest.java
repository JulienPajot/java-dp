package org.sebsy.builder;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductBuilderTest {

    // =========================================================================
    // CAS NOMINAL
    // =========================================================================

    @Test
    public void buildProduitComplet() {
        Product p = new ProductBuilder()
                .withName("Nutella")
                .withMarque("Ferrero")
                .withCategory("Pâte à tartiner")
                .withUnit("g")
                .withPrice(3.49)
                .withIngredient("Sucre",          400_000)
                .withIngredient("Huile de palme", 200_000)
                .withAdditif("Lécithine de soja",  10_000)
                .withAllergene("Noisette",        130_000)
                .withAllergene("Lait",             85_000)
                .build();

        assertEquals("Nutella",           p.getName());
        assertEquals("Ferrero",           p.getMarque().getName());
        assertEquals("Pâte à tartiner",   p.getCategory().getName());
        assertEquals("g",                 p.getUnit());
        assertEquals(3.49,                p.getPrice(), 0.001);

        assertEquals(2,                   p.getIngredients().size());
        assertEquals("Sucre",             p.getIngredients().get(0).getName());
        assertEquals(400_000,             p.getIngredients().get(0).getQuantity(), 0.001);

        assertEquals(1,                   p.getAdditifs().size());
        assertEquals("Lécithine de soja", p.getAdditifs().get(0).getName());

        assertEquals(2,                   p.getAllergenes().size());
        assertEquals("Noisette",          p.getAllergenes().get(0).getName());
    }

    @Test
    public void buildProduitMinimal() {
        Product p = new ProductBuilder()
                .withName("Eau minérale")
                .withMarque("Evian")
                .withCategory("Boisson")
                .build();

        assertEquals("Eau minérale", p.getName());
        assertEquals("Evian",        p.getMarque().getName());
        assertEquals("Boisson",      p.getCategory().getName());
        assertNull(p.getUnit());
        assertEquals(0.0,            p.getPrice(), 0.001);
        assertTrue(p.getIngredients().isEmpty());
        assertTrue(p.getAdditifs().isEmpty());
        assertTrue(p.getAllergenes().isEmpty());
    }

    @Test
    public void chainage_retourne_meme_builder() {
        ProductBuilder builder = new ProductBuilder();
        assertSame(builder, builder.withName("X"));
        assertSame(builder, builder.withMarque("Y"));
        assertSame(builder, builder.withCategory("Z"));
        assertSame(builder, builder.withUnit("g"));
        assertSame(builder, builder.withPrice(1.0));
        assertSame(builder, builder.withIngredient("I", 100));
        assertSame(builder, builder.withAdditif("A", 10));
        assertSame(builder, builder.withAllergene("AL", 5));
    }

    @Test
    public void ordreDesCollections() {
        Product p = new ProductBuilder()
                .withName("Biscuit")
                .withMarque("LU")
                .withCategory("Confiserie")
                .withIngredient("Farine", 500_000)
                .withIngredient("Beurre", 200_000)
                .withIngredient("Sel",      5_000)
                .withAdditif("E471",        1_000)
                .withAdditif("E322",        2_000)
                .withAllergene("Gluten",  500_000)
                .withAllergene("Lait",    200_000)
                .build();

        assertEquals("Farine", p.getIngredients().get(0).getName());
        assertEquals("Beurre", p.getIngredients().get(1).getName());
        assertEquals("Sel",    p.getIngredients().get(2).getName());
        assertEquals("E471",   p.getAdditifs().get(0).getName());
        assertEquals("E322",   p.getAdditifs().get(1).getName());
        assertEquals("Gluten", p.getAllergenes().get(0).getName());
        assertEquals("Lait",   p.getAllergenes().get(1).getName());
    }

    @Test
    public void withName_ecrase_valeur_precedente() {
        Product p = new ProductBuilder()
                .withName("Premier nom")
                .withName("Nom final")
                .withMarque("MDD")
                .withCategory("Divers")
                .build();

        assertEquals("Nom final", p.getName());
    }

    // =========================================================================
    // CAS ALTERNATIFS
    // =========================================================================

    @Test
    public void prixDefaut() {
        Product p = new ProductBuilder()
                .withName("Produit test")
                .withMarque("MDD")
                .withCategory("Divers")
                .build();

        assertEquals(0.0, p.getPrice(), 0.001);
    }

    @Test
    public void prixNegatif() {
        Product p = new ProductBuilder()
                .withName("Promo")
                .withMarque("MDD")
                .withCategory("Promo")
                .withPrice(-0.50)
                .build();

        assertEquals(-0.50, p.getPrice(), 0.001);
    }

    @Test
    public void ingredientQuantiteZero() {
        Product p = new ProductBuilder()
                .withName("Eau gazeuse")
                .withMarque("Perrier")
                .withCategory("Boisson")
                .withIngredient("Sel minéral", 0)
                .build();

        assertEquals(1,   p.getIngredients().size());
        assertEquals(0.0, p.getIngredients().get(0).getQuantity(), 0.001);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void liste_ingredients_non_modifiable() {
        Product p = new ProductBuilder()
                .withName("Yaourt").withMarque("Danone").withCategory("Laitage")
                .withIngredient("Lait", 900_000)
                .build();
        p.getIngredients().add(new Ingredient("X", 1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void liste_additifs_non_modifiable() {
        Product p = new ProductBuilder()
                .withName("Yaourt").withMarque("Danone").withCategory("Laitage")
                .withAdditif("E415", 500)
                .build();
        p.getAdditifs().add(new Additif("X", 1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void liste_allergenes_non_modifiable() {
        Product p = new ProductBuilder()
                .withName("Yaourt").withMarque("Danone").withCategory("Laitage")
                .withAllergene("Lait", 900_000)
                .build();
        p.getAllergenes().add(new Allergene("X", 1));
    }

    @Test
    public void deuxBuildersIndependants() {
        Product p1 = new ProductBuilder().withName("A").withMarque("M1").withCategory("C1").build();
        Product p2 = new ProductBuilder().withName("B").withMarque("M2").withCategory("C2").build();

        assertNotSame(p1, p2);
        assertNotEquals(p1.getName(), p2.getName());
    }
}