/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class ExemplaireDao implements ExemplaireInterface{
    
    private DB db;
    private DBCollection bibliothequeExemplaire;
    
    public ExemplaireDao(){
        this.db = Connexion.getConnexion();
        bibliothequeExemplaire = this.db.getCollection("Exemplaire");
    }
    //-----------------------------------------------------------------
    //les attributs de la class Exemplaire
    /*   private int ref_e;
    private Edition editionExemplaire;
    private  Livre livreExemplaire;*/
   //---------------------------------------------------------------------- 

    @Override
    public List<Exemplaire> getAllExemplaire() {
        
     List<Exemplaire> listeExemplaire = new ArrayList<>();
    //stockage de tous les Exemplaires dans l'objet DBCursor
    DBCursor cursor = this.bibliothequeExemplaire.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
        DBObject objExemplaire = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Exemplaire Exemplaire= new Exemplaire(); 
    Exemplaire.setRef_e((int)objExemplaire.get("ref_e"));
  
     /*Creation d'un document pour recupere l'edition dans le document exemplaire*/
        
     DBObject objEdition = (DBObject) objExemplaire.get("idEditionExemplaire");

     /*maj de l'édition dans l'objet exemplaire*/
     
     Exemplaire.setEditionExemplaire(new Edition((int) objEdition.get("ref_e")));
     
     
          
     /* Création d'un document pour recuperer le livre dans le document exemplaire*/
     
     DBObject objLivre = (DBObject) objExemplaire.get("idLivreExemplaire");
     
     /*du livre dans l'objet exemplaire*/
     
     Exemplaire.setLivreExemplaire(new Livre((int) objLivre.get("id_l")));
     
     
    
    listeExemplaire.add(Exemplaire);
    }
    
    return listeExemplaire;   
            
    }

    @Override
    public Exemplaire getOneExemplaire(int id_e) {
      return null;  
    }

    @Override
    public void addExemplaire(Exemplaire exemplaire) {
        
    }

    @Override
    public void deleteExemplaire(Exemplaire exemplaire) {
        
    }

    @Override
    public void updateExemplaire(Exemplaire exemplaire) {
        
    }
}
