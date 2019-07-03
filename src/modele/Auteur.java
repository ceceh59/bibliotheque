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
public class Auteur {
    private int id_a;
    private String nom_a;
    private String prenom_a;
    private String date_naissance_a;
    private Pays pays_a;

    public Auteur() {
    }

    public Auteur(int id_a, String nom_a, String prenom_a, String date_naissance_a, Pays pays_a) {
        this.id_a = id_a;
        this.nom_a = nom_a;
        this.prenom_a = prenom_a;
        this.date_naissance_a = date_naissance_a;
        this.pays_a = pays_a;
    }

    public Pays getPays_a() {
        return pays_a;
    }

    public void setPays_a(Pays pays_a) {
        this.pays_a = pays_a;
    }

       public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }

    public String getNom_a() {
        return nom_a;
    }

    public void setNom_a(String nom_a) {
        this.nom_a = nom_a;
    }

    public String getPrenom_a() {
        return prenom_a;
    }

    public void setPrenom_a(String prenom_a) {
        this.prenom_a = prenom_a;
    }

    public String getDate_naissance_a() {
        return date_naissance_a;
    }

    public void setDate_naissance_a(String date_naissance_a) {
        this.date_naissance_a = date_naissance_a;
    }

   

  
    
            
    
}
