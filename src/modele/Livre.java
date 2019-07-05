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
public class Livre {
    private int id_l;
    private String titre_l;
    private String annee_l;
    private String resume_l;
    private TypeLivre typeLivre_l;

    public Livre(int id_l, String titre_l, String annee_l, String resume_l, TypeLivre typeLivre_l) {
        this.id_l = id_l;
        this.titre_l = titre_l;
        this.annee_l = annee_l;
        this.resume_l = resume_l;
        this.typeLivre_l = typeLivre_l;
    }

    public TypeLivre getTypeLivre_l() {
        return typeLivre_l;
    }

    public Livre(int id_l, String titre_l) {
        this.id_l = id_l;
        this.titre_l = titre_l;
    }
    

    public void setTypeLivre_l(TypeLivre typeLivre_l) {
        this.typeLivre_l = typeLivre_l;
    }

    public Livre(int id_l) {
        this.id_l = id_l;
    }

   
    public Livre() {
    }

    public int getId_l() {
        return id_l;
    }

    public void setId_l(int id_l) {
        this.id_l = id_l;
    }

    public String getTitre_l() {
        return titre_l;
    }

    public void setTitre_l(String titre_l) {
        this.titre_l = titre_l;
    }

    public String getAnnee_l() {
        return annee_l;
    }

    public void setAnnee_l(String annee_l) {
        this.annee_l = annee_l;
    }

    public String getResume_l() {
        return resume_l;
    }

    public void setResume_l(String resume_l) {
        this.resume_l = resume_l;
    }

    @Override
    public String toString() {
        return "Livre{" + "id_l=" + id_l + ", titre_l=" + titre_l + ", annee_l=" + annee_l + ", resume_l=" + resume_l + ", typeLivre_l=" + typeLivre_l + '}';
    }

  
}
