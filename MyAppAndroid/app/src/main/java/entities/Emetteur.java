package entities;

import java.io.Serializable;

public class Emetteur  implements Serializable {

    private int id;

    private String nom;

    private String prenom;

    private String telephone;

    private String cni;

    private String montant_envoyer;

    public Emetteur(int id, String nom, String prenom, String telephone, String cni, String montant_envoyer) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.cni = cni;
        this.montant_envoyer = montant_envoyer;
    }

    public Emetteur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getMontant_envoyer() {
        return montant_envoyer;
    }

    public void setMontant_envoyer(String montant_envoyer) {
        this.montant_envoyer = montant_envoyer;
    }
}
