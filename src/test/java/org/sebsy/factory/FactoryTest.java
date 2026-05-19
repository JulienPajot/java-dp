package org.sebsy.factory;

import org.junit.Test;
import static org.junit.Assert.*;
import org.sebsy.factory.TypeElement;
import org.sebsy.factory.Additif;
import org.sebsy.factory.Allergene;
import org.sebsy.factory.ElementFactory;
import org.sebsy.factory.Ingredient;

public class FactoryTest {

    @Test
    public void testCreerIngredient() {
        Element element = ElementFactory.creerElement(TypeElement.INGREDIENT, "Sucre", 10.5, "g");

        assertNotNull(element);
        assertTrue(element instanceof Ingredient);
        assertEquals("Sucre", element.getNom());
        assertEquals(10.5, element.getValeur(), 0.0000001);
        assertEquals("g", element.getUnite());
    }

    @Test
    public void testCreerAllergene() {
        Element element = ElementFactory.creerElement(TypeElement.ALLERGENE, "Gluten", 2.0, "mg");

        assertNotNull(element);
        assertTrue(element instanceof Allergene);
        assertEquals("Gluten", element.getNom());
        assertEquals(2.0, element.getValeur(), 0.0000001);
        assertEquals("mg", element.getUnite());
    }

    @Test
    public void testCreerAdditif() {
        Element element = ElementFactory.creerElement(TypeElement.ADDITIF, "E150", 0.5, "g");

        assertNotNull(element);
        assertTrue(element instanceof Additif);
        assertEquals("E150", element.getNom());
        assertEquals(0.5, element.getValeur(), 0.0000001);
        assertEquals("g", element.getUnite());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTypeInconnu() {
        // Ce test vérifie que la factory lève bien une exception si le type est invalide
        // En pratique avec une enum c'est difficile à déclencher, mais c'est une bonne pratique
        ElementFactory.creerElement(TypeElement.UNKNOWN, "Test", 1.0, "g");
    }
}