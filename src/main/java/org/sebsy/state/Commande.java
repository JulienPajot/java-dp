package org.sebsy.state;

public class Commande {
    private EtatCommande etat;
    private List<Produit> produits;
    private double montant;
    private String adresse;

    public Commande() {
        this.etat = new EtatCreation();
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        etat.ajouterProduit(this, produit);
    }

    public void payer() {
        etat.payer(this);
    }

    public void livrer(String adresse) {
        etat.livrer(this, adresse);
    }

    public void annuler() {
        etat.annuler(this);
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}