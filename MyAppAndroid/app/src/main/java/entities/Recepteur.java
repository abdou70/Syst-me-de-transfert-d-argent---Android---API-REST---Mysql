package entities;

import java.io.Serializable;

public class Recepteur implements Serializable {

    private int id;

    private String nom;

    private String prenom;

    private String telephone;

    private String cni;

    private String montant_recu;

    public Recepteur() {
    }

    public Recepteur(int id, String nom, String prenom, String telephone, String cni, String montant_recu) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.cni = cni;
        this.montant_recu = montant_recu;
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

    public String getMontant_recu() {
        return montant_recu;
    }

    public void setMontant_recu(String montant_recu) {
        this.montant_recu = montant_recu;
    }
}
