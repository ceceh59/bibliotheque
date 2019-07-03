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
public class EditionDao implements EditionInterface {
    
     private DB db;
    private DBCollection bibliothequeEdition;

    public EditionDao() {
        this.db = Connexion.getConnexion();
        bibliothequeEdition = this.db.getCollection("Edition");  
}
//--------------------------------------------------------------------------
//Les Attributs de la class Edition
    /* private int id_ed;
    private String nom_ed;*/
//--------------------------------------------------------------------------
//LES METHODES
//--------------------------------------------------------------------------

//Pour récupérer toutes les editions
 //--------------------------------------------------------------------   
    @Override
    public List<Edition> getAllEdition() {
        
     List<Edition> listeEdition = new ArrayList<>();
    //stockage de tous les Editions dans l'objet DBCursor
    DBCursor cursor = this.bibliothequeEdition.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
        DBObject objEdition = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Edition edition= new Edition(); 
    edition.setId_ed((int)objEdition.get("_id"));
    edition.setNom_ed(objEdition.get("nom_ed").toString()); 
    
       listeEdition.add(edition);
    }
    
    return listeEdition;
    
    }
//----------------------------------------------------------------------
    //pour trouver une edition
//------------------------------------------------------------------
    @Override
    public Edition getOneEdition(int id_ed) {
        
         Edition edition = new Edition();
       //création d'un document avec l'id passé en paramètre
        BasicDBObject docEdition = new BasicDBObject("_id",id_ed);
        DBObject objEdition = this.bibliothequeEdition.findOne(docEdition);
        edition.setId_ed((int) objEdition.get("_id"));
        edition.setNom_ed(objEdition.get("nom_ed").toString());
        
        return edition;
    }
//-------------------------------------------------------------------------
    //pour ajouter une edition
//---------------------------------------------------------------------
    @Override
    public void addEdition(Edition edition) {
        
       //création d'un document
       BasicDBObject docEdition = new BasicDBObject();
       docEdition.append("_id",edition.getId_ed());
       docEdition.append("nom_ed",edition.getNom_ed()); 
       
        //ajout du document dans la collection Editioncrit
       this.bibliothequeEdition.insert(docEdition);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");
    }
//-----------------------------------------------------------------------
   // pour supprimer une edition
//----------------------------------------------------------------------            
    @Override
    public void deleteEdition(Edition edition) {
        
       //création
       BasicDBObject docEdition = new BasicDBObject();
       docEdition.append("_id",edition.getId_ed());
       this.bibliothequeEdition.remove(docEdition);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");  
    }
//---------------------------------------------------------------------
    //pour modifier une edition
//------------------------------------------------------------------------
    @Override
    public void updateEdition(Edition edition) {
        
      //création du document à l'id de l'Edition
        BasicDBObject docEditionOld = new BasicDBObject();
        docEditionOld.append("_id", edition.getId_ed());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docEditionNew = new BasicDBObject();
        docEditionNew.append("_id", edition.getId_ed());
        docEditionNew.append("nom_ed", edition.getNom_ed());   
        
         this.bibliothequeEdition.update(docEditionOld, docEditionNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes");
    }
    
}
