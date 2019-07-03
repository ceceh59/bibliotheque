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
public interface EditionInterface {
    
   public List<Edition> getAllEdition();
   public Edition getOneEdition(int id_e);
   public void addEdition(Edition edition);
   public void deleteEdition(Edition edition);
   public void updateEdition(Edition edition);
}
