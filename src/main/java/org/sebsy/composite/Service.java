package org.sebsy.composite;
import java.util.List;
import java.util.ArrayList;
public class Service implements IElement { 
    private String nom;
    private List<IElement> elements;

    public Service(String nom) {
        this.nom = nom;
        this.elements = new ArrayList<>();
    }

    public void ajouterElement(IElement element) {
        elements.add(element);
    }

    @Override
    public double calculerSalaire() {
        double totalSalaire = 0;
        for (IElement element : elements) {
            totalSalaire += element.calculerSalaire();
        }
        return totalSalaire;
    }
}