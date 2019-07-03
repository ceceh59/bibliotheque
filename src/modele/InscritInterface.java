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
public interface InscritInterface {
    
   public List<Inscrit> getAllInscrit();
   public Inscrit getOneInscrit(int id_i);
   public void addInscrit(Inscrit ins);
   public void deleteInscrit(Inscrit ins);
   public void updateInscrit(Inscrit ins);
}
