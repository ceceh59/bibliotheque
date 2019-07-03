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
public class Emprunt {
    private int id_em;
    private String date_em;
    private String delais_em;
    private Inscrit inscritEmprunt;
    private Exemplaire exemplaireEmprunt;
    

    public Emprunt() {
    }

    public Emprunt(int id_em, String date_em, String delais_em, Inscrit inscritEmprunt, Exemplaire exemplaireEmprunt) {
        this.id_em = id_em;
        this.date_em = date_em;
        this.delais_em = delais_em;
        this.inscritEmprunt = inscritEmprunt;
        this.exemplaireEmprunt = exemplaireEmprunt;
    }

    public Inscrit getInscritEmprunt() {
        return inscritEmprunt;
    }

    public void setInscritEmprunt(Inscrit inscritEmprunt) {
        this.inscritEmprunt = inscritEmprunt;
    }

    public Exemplaire getExemplaireEmprunt() {
        return exemplaireEmprunt;
    }

    public void setExemplaireEmprunt(Exemplaire exemplaireEmprunt) {
        this.exemplaireEmprunt = exemplaireEmprunt;
    }

   

    public int getId_em() {
        return id_em;
    }

    public void setId_em(int id_em) {
        this.id_em = id_em;
    }

    public String getDate_em() {
        return date_em;
    }

    public void setDate_em(String date_em) {
        this.date_em = date_em;
    }

    public String getDelais_em() {
        return delais_em;
    }

    public void setDelais_em(String delais_em) {
        this.delais_em = delais_em;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "id_em=" + id_em + ", date_em=" + date_em + ", delais_em=" + delais_em + ", inscritEmprunt=" + inscritEmprunt + ", exemplaireEmprunt=" + exemplaireEmprunt + '}';
    }

  

   
    
}
