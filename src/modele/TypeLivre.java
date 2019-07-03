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
    public class TypeLivre {
    private int id_t;
    private String libelle_t;

    public TypeLivre() {
    }

    public TypeLivre(int id_t) {
        this.id_t = id_t;
    }
    
    
    public TypeLivre(int id_t, String libelle_t) {
        this.id_t = id_t;
        this.libelle_t = libelle_t;
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public String getLibelle_t() {
        return libelle_t;
    }

    public void setLibelle_t(String libelle_t) {
        this.libelle_t = libelle_t;
    }

    @Override
    public String toString() {
        return "TypeLivre{" + "id_t=" + id_t + ", libelle_t=" + libelle_t + '}';
    }
    
    
    
}
