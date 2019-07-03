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
public class Inscrit {
    private int id_i;
    private String nom_i;
    private String prenom_i;
    private String date_naissance_i;
    private String rue_i;
    private String ville_i;
    private String email_i;
    private String tel_i;
    private String tel_portable_i;

    public Inscrit() {
    }

    public Inscrit(int id_i, String nom_i, String prenom_i, String date_naissance_i, String rue_i, String ville_i, String email_i, String tel_i, String tel_portable_i) {
        this.id_i = id_i;
        this.nom_i = nom_i;
        this.prenom_i = prenom_i;
        this.date_naissance_i = date_naissance_i;
        this.rue_i = rue_i;
        this.ville_i = ville_i;
        this.email_i = email_i;
        this.tel_i = tel_i;
        this.tel_portable_i = tel_portable_i;
    }

    @Override
    public String toString() {
        return "Inscrit{" + "id_i=" + id_i + ", nom_i=" + nom_i + ", prenom_i=" + prenom_i + ", date_naissance_i=" + date_naissance_i + ", rue_i=" + rue_i + ", ville_i=" + ville_i + ", email_i=" + email_i + ", tel_i=" + tel_i + ", tel_portable_i=" + tel_portable_i + '}';
    }

    public int getId_i() {
        return id_i;
    }

    public void setId_i(int id_i) {
        this.id_i = id_i;
    }

    public String getNom_i() {
        return nom_i;
    }

    public void setNom_i(String nom_i) {
        this.nom_i = nom_i;
    }

    public String getPrenom_i() {
        return prenom_i;
    }

    public void setPrenom_i(String prenom_i) {
        this.prenom_i = prenom_i;
    }

    public String getDate_naissance_i() {
        return date_naissance_i;
    }

    public void setDate_naissance_i(String date_naissance_i) {
        this.date_naissance_i = date_naissance_i;
    }

    public String getRue_i() {
        return rue_i;
    }

    public void setRue_i(String rue_i) {
        this.rue_i = rue_i;
    }

    public String getVille_i() {
        return ville_i;
    }

    public void setVille_i(String ville_i) {
        this.ville_i = ville_i;
    }

    public String getEmail_i() {
        return email_i;
    }

    public void setEmail_i(String email_i) {
        this.email_i = email_i;
    }

    public String getTel_i() {
        return tel_i;
    }

    public void setTel_i(String tel_i) {
        this.tel_i = tel_i;
    }

    public String getTel_portable_i() {
        return tel_portable_i;
    }

    public void setTel_portable_i(String tel_portable_i) {
        this.tel_portable_i = tel_portable_i;
    }
    
}
