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
public interface PaysInterface {
 
   public List<Pays> getAllPays();
   public Pays getOnePays(int id_p);
   public void addPays(Pays pays);
   public void deletePays(Pays pays);
   public void updatePays(Pays pays);
}
