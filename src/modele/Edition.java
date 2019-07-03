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
public class Edition {
    private int id_ed;
    private String nom_ed;

    public Edition() {
    }

    public Edition(int id_ed) {
        this.id_ed = id_ed;
    }

    public Edition(int id_ed, String nom_ed) {
        this.id_ed = id_ed;
        this.nom_ed = nom_ed;
    }

    public int getId_ed() {
        return id_ed;
    }

    public void setId_ed(int id_ed) {
        this.id_ed = id_ed;
    }

    public String getNom_ed() {
        return nom_ed;
    }

    public void setNom_ed(String nom_ed) {
        this.nom_ed = nom_ed;
    }

    @Override
    public String toString() {
        return "Edition{" + "id_ed=" + id_ed + ", nom_ed=" + nom_ed + '}';
    }
    
}
