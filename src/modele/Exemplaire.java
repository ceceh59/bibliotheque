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
public class Exemplaire {
    private int ref_e;
    private Edition editionExemplaire;
    private  Livre livreExemplaire;

    public Exemplaire(int ref_e) {
        this.ref_e = ref_e;
    }

    public Exemplaire(int ref_e, Edition editionExemplaire, Livre livreExemplaire) {
        this.ref_e = ref_e;
        this.editionExemplaire = editionExemplaire;
        this.livreExemplaire = livreExemplaire;
    }

     
    
    public Exemplaire() {
    }

  
    public int getRef_e() {
        return ref_e;
    }

    public void setRef_e(int ref_e) {
        this.ref_e = ref_e;
    }

    public Edition getEditionExemplaire() {
        return editionExemplaire;
    }

    public void setEditionExemplaire(Edition editionExemplaire) {
        this.editionExemplaire = editionExemplaire;
    }

    public Livre getLivreExemplaire() {
        return livreExemplaire;
    }

    public void setLivreExemplaire(Livre livreExemplaire) {
        this.livreExemplaire = livreExemplaire;
    }

    @Override
    public String toString() {
        return "Exemplaire{" + "ref_e=" + ref_e + ", editionExemplaire=" + editionExemplaire + ", livreExemplaire=" + livreExemplaire + '}';
    }

   

   
    

  
}
