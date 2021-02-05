package entities;

import java.io.Serializable;

public class Transfert implements Serializable {

    private int id;
    private String date;
    private int montant;


    public Transfert() {
    }

    public Transfert(int id, String date, int montant) {
        this.id = id;
        this.date = date;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
