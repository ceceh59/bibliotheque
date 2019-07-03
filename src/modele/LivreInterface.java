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
public interface LivreInterface {
   public List<Livre> getAllLivre();
   public Livre getOneLivre(int id_i);
   public void addLivre(Livre livre);
   public void deleteLivre(Livre livre);
   public void updateLivre(Livre livre);
}
