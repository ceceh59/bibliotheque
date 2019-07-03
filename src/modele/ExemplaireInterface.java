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
public interface ExemplaireInterface {
   public List<Exemplaire> getAllExemplaire();
   public Exemplaire getOneExemplaire(int id_e);
   public void addExemplaire(Exemplaire exemplaire);
   public void deleteExemplaire(Exemplaire exemplaire);
   public void updateExemplaire(Exemplaire exemplaire);
}
