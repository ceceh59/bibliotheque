/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
        
     DBObject objEdition = (DBObject) objExemplaire.get("EditionExemplaire");

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
    public Exemplaire getOneExemplaire(int ref_e) {
        
        Exemplaire exemplaire = new Exemplaire();
        
        //création d'un document avec l'id passé en paramètre
        BasicDBObject docIns = new BasicDBObject("_id", ref_e);
        DBObject objExemplaire = this.bibliothequeExemplaire.findOne(docIns);
        exemplaire.setRef_e((int) objExemplaire.get("ref_e"));
        

        /*Creation d'un document pour recupere le type dans le document livre*/
        DBObject objEditionExemplaire = (DBObject) objExemplaire.get("ref_e");

        /*maj du pays dans l'objet livre*/
        exemplaire.setEditionExemplaire(new Edition((int) objEditionExemplaire.get("_id"), objEditionExemplaire.get("nom_ed").toString()));

          /*Creation d'un document pour recupere le type dans le document livre*/
        DBObject objLivreExemplaire = (DBObject) objExemplaire.get("ref_e");

        /*maj du pays dans l'objet livre*/
        exemplaire.setLivreExemplaire(new Livre ((int) objLivreExemplaire.get("_id"), objLivreExemplaire.get("titre_l").toString()));
        
        return exemplaire;
    }

    @Override
    public void addExemplaire(Exemplaire exemplaire) {
        
      //création d'un document
       BasicDBObject docExemplaire = new BasicDBObject();
       docExemplaire.append("_ref_e",exemplaire.getRef_e());
     
       docExemplaire.append("_id",new BasicDBObject("_id",exemplaire.getEditionExemplaire().getId_ed()));
       docExemplaire.append("_id",new BasicDBObject("_id",exemplaire.getLivreExemplaire().getId_l()));
       
       //ajout du document dans la collection inscrit
       this.bibliothequeExemplaire.insert(docExemplaire);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");   
           
        
    }

    @Override
    public void deleteExemplaire(Exemplaire exemplaire) {
        
       //création
       BasicDBObject docExemplaire = new BasicDBObject();
       docExemplaire.append("_id",exemplaire.getRef_e());
       this.bibliothequeExemplaire.remove(docExemplaire);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");  
        
    }

    @Override
    public void updateExemplaire(Exemplaire exemplaire) {
        
      //création du document à l'id de l'inscrit
        BasicDBObject docExemplaireOld = new BasicDBObject();
        docExemplaireOld.append("_id", exemplaire.getRef_e());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docExemplaireNew = new BasicDBObject();
        docExemplaireNew.append("_id", exemplaire.getRef_e());
       
        docExemplaireNew.append("_id",new BasicDBObject("_id",exemplaire.getEditionExemplaire().getId_ed()));
        docExemplaireNew.append("_id",new BasicDBObject("_id",exemplaire.getLivreExemplaire().getId_l()));
        
        this.bibliothequeExemplaire.update(docExemplaireOld, docExemplaireNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes");   
        
        
    }
}
