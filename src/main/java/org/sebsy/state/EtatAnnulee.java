package org.sebsy.state;

public class EtatAnnulee implements EtatCommande {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {

        System.out.println("Commande annulée");
    }

    @Override
    public void payer(Commande commande) {

        System.out.println("Commande annulée");
    }

    @Override
    public void livrer(Commande commande, String adresse) {

        System.out.println("Commande annulée");
    }

    @Override
    public void annuler(Commande commande) {

        System.out.println("Commande déjà annulée");
    }
}