package org.sebsy.composite;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestComposite {

    @Test
    public void testCalculSalaireDSIN() {

        Service dsin = new Service("DSIN");

        dsin.ajouterElement(
                new Employe("Dupont", "Jean", 10000)
        );

        dsin.ajouterElement(
                new Employe("Martin", "Paul", 8000)
        );

        assertEquals(18000, dsin.calculerSalaire(), 0.0000001);
    }

    @Test
    public void testCalculSalaireBigData() {

        Service bigdata = new Service("Big Data");

        bigdata.ajouterElement(
                new Employe("Bernard", "Alice", 7500)
        );

        bigdata.ajouterElement(
                new Employe("Petit", "Sophie", 3500)
        );

        assertEquals(11000, bigdata.calculerSalaire(), 0.0000001);
    }

    @Test
    public void testCalculSalaireJavaDev() {

        Service javadev = new Service("Java Dev");

        javadev.ajouterElement(
                new Employe("Robert", "Lucas", 7500)
        );

        javadev.ajouterElement(
                new Employe("Richard", "Emma", 3500)
        );

        assertEquals(11000, javadev.calculerSalaire(), 0.0000001);
    }

    @Test
    public void testCalculSalaireEntreprise() {

        Service entreprise = new Service("Entreprise");

        Service dsin = new Service("DSIN");
        Service bigdata = new Service("Big Data");
        Service javadev = new Service("Java Dev");

        // DSIN
        dsin.ajouterElement(
                new Employe("Dupont", "Jean", 10000)
        );

        dsin.ajouterElement(
                new Employe("Martin", "Paul", 8000)
        );

        // Big Data
        bigdata.ajouterElement(
                new Employe("Bernard", "Alice", 7500)
        );

        bigdata.ajouterElement(
                new Employe("Petit", "Sophie", 3500)
        );

        // Java Dev
        javadev.ajouterElement(
                new Employe("Robert", "Lucas", 7500)
        );

        javadev.ajouterElement(
                new Employe("Richard", "Emma", 3500)
        );

        // Ajout des services à l'entreprise
        entreprise.ajouterElement(dsin);
        entreprise.ajouterElement(bigdata);
        entreprise.ajouterElement(javadev);

        assertEquals(40000, entreprise.calculerSalaire(), 0.0000001);
    }
}