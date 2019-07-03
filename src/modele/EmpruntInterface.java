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
public interface EmpruntInterface {
    
   public List<Emprunt> getAllEmprunt();
   public Emprunt getOneEmprunt(int id_em);
   public void addEmprunt(Emprunt emprunt);
   public void deleteEmprunt(Emprunt emprunt);
   public void updateEmprunt(Emprunt emprunt);
}
