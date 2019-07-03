/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface AuteurInterface {

   public List<Auteur> getAllAuteur();
   public Auteur getOneAuteur(int id_a);
   public void addAuteur(Auteur auteur);
   public void deleteAuteur(Auteur auteur);
   public void updateAuteur(Auteur auteur);
}
