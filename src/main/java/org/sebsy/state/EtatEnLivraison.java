package org.sebsy.state;

public class EtatEnLivraison implements EtatCommande {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {

        System.out.println("Commande déjà en livraison");
    }

    @Override
    public void payer(Commande commande) {

        System.out.println("Commande déjà payée");
    }

    @Override
    public void livrer(Commande commande, String adresse) {

        System.out.println("Commande déjà en livraison");
    }

    @Override
    public void annuler(Commande commande) {

        System.out.println("Impossible d'annuler : commande déjà en livraison");
    }
}