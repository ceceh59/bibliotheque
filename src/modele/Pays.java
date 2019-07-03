/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Administrateur
 */
public class Pays {
    private int id_p;
    private String nom_p;

    public Pays() {
    }

    public Pays(int id_p) {
        this.id_p = id_p;
    }

    public Pays(int id_p, String nom_p) {
        this.id_p = id_p;
        this.nom_p = nom_p;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getNom_p() {
        return nom_p;
    }

    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    @Override
    public String toString() {
        return "Pays{" + "id_p=" + id_p + ", nom_p=" + nom_p + '}';
    }
    
}
