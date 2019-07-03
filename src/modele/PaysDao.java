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
public class PaysDao implements PaysInterface{
    
  private DB db;
    private DBCollection bibliothequePays;

    public PaysDao() {
        this.db = Connexion.getConnexion();
        bibliothequePays = this.db.getCollection("Pays");  
        
    }
//--------------------------------------------------------------------------
//Les Attributs de la class Pays
    /*  private int id_p;
    private String nom_p;*/
//--------------------------------------------------------------------------
//LES METHODES
//--------------------------------------------------------------------------

//Pour récupérer tous les pays
 //--------------------------------------------------------------------   

    
    @Override
    public List<Pays> getAllPays() {
        
      List<Pays> listePays = new ArrayList<>();
    //stockage de tous les Payss dans l'objet DBCursor
    DBCursor cursor = this.bibliothequePays.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
        DBObject objPays = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Pays pays= new Pays(); 
    pays.setId_p((int)objPays.get("_id"));
    pays.setNom_p(objPays.get("nom_p").toString()); 
    
       listePays.add(pays);
    }
    
    return listePays;
          
    }
//----------------------------------------------------------------------
    //pour trouver un Pays
//------------------------------------------------------------------
    @Override
    public Pays getOnePays(int id_p) {
        
       Pays pays = new Pays();
       //création d'un document avec l'id passé en paramètre
        BasicDBObject docPays = new BasicDBObject("_id",id_p);
        DBObject objPays = this.bibliothequePays.findOne(docPays);
        pays.setId_p((int) objPays.get("_id"));
        pays.setNom_p(objPays.get("nom_p").toString());
        
        return pays;    
        
    }
//-------------------------------------------------------------------------
    //pour ajouter un Pays
//---------------------------------------------------------------------
    @Override
    public void addPays(Pays pays) {
      //création d'un document
       BasicDBObject docPays = new BasicDBObject();
       docPays.append("_id",pays.getId_p());
       docPays.append("nom_p",pays.getNom_p()); 
       
        //ajout du document dans la collection Pays
       this.bibliothequePays.insert(docPays);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");   
        
    }
//-----------------------------------------------------------------------
   // pour supprimer un pays
//---------------------------------------------------------------------- 
    @Override
    public void deletePays(Pays pays) {
     
       //création
       BasicDBObject docPays = new BasicDBObject();
       docPays.append("_id",pays.getId_p());
       this.bibliothequePays.remove(docPays);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");    
    }
//---------------------------------------------------------------------
    //pour modifier un pays
//------------------------------------------------------------------------
    @Override
    public void updatePays(Pays pays) {
         //création du document à l'id du pays
        BasicDBObject docPaysOld = new BasicDBObject();
        docPaysOld.append("_id", pays.getId_p());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docPaysNew = new BasicDBObject();
        docPaysNew.append("_id", pays.getId_p());
        docPaysNew.append("nom_p", pays.getNom_p());   
        
         this.bibliothequePays.update(docPaysOld, docPaysNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes"); 
    }
    
    
    
}
