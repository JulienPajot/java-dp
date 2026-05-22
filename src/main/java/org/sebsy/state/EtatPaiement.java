package org.sebsy.state;

public class EtatPaiement implements EtatCommande {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {

        System.out.println("Impossible d'ajouter un produit après paiement");
    }

    @Override
    public void payer(Commande commande) {

        System.out.println("Commande déjà payée");
    }

    @Override
    public void livrer(Commande commande, String adresse) {

        commande.setAdresse(adresse);

        commande.setEtat(new EtatEnLivraison());

        System.out.println("Commande en livraison vers : " + adresse);
    }

    @Override
    public void annuler(Commande commande) {

        commande.setEtat(new EtatAnnulee());

        System.out.println("Commande annulée");
    }
}