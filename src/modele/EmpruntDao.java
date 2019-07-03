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
public class EmpruntDao implements EmpruntInterface {
    
    private DB db;
    private DBCollection bibliothequeEmprunt;

    public EmpruntDao() {
        this.db = Connexion.getConnexion();
        bibliothequeEmprunt = this.db.getCollection("Emprunt");  
}
//--------------------------------------------------------------------------
//Les Attributs de la class emprunt
    /*private int id_em;
    private String date_em;
    private String delais_em;
    this.inscrit_em = inscritEmprunt;
    this.exemplaire_em = exemplaireEmprunt;*/
   
    
//-------------------------------------------------------------------------
    //LES METHODES
//---------------------------------------------------------------------------
    
 //Pour récupérer tous les emprunts
    
//---------------------------------------------------------------------------
    
    
    
    @Override
    public List<Emprunt> getAllEmprunt() {
       
     List<Emprunt> listeEmprunt = new ArrayList<>();
    //stockage de tous les Emprunts dans l'objet DBCursor
    DBCursor cursor = this.bibliothequeEmprunt.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
    DBObject objEmprunt = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Emprunt emprunt= new Emprunt(); 
    emprunt.setId_em((int)objEmprunt.get("_id"));
    emprunt.setDate_em(objEmprunt.get("date_em").toString());
    emprunt.setDelais_em(objEmprunt.get("delais_em").toString());
    
    
    listeEmprunt.add(emprunt);
    }
    
    return listeEmprunt;
    
    }
//----------------------------------------------------------------------
    //pour trouver un emprunt
//------------------------------------------------------------------
    
    @Override
    public Emprunt getOneEmprunt(int id_em) {
        
      Emprunt emprunt = new Emprunt();
       //création d'un document avec l'id passé en paramètre
        BasicDBObject docEmprunt = new BasicDBObject("_id",id_em);
        DBObject objEmprunt = this.bibliothequeEmprunt.findOne(docEmprunt);
        emprunt.setId_em((int) objEmprunt.get("_id"));
        emprunt.setDate_em(objEmprunt.get("date_em").toString());
        emprunt.setDelais_em(objEmprunt.get("delais_em").toString());
        
        return emprunt;  
        
    }
 //-------------------------------------------------------------------------
    //pour ajouter un emprunt
//---------------------------------------------------------------------

    @Override
    public void addEmprunt(Emprunt emprunt) {
        
         //création d'un document
       BasicDBObject docEmprunt = new BasicDBObject();
       docEmprunt.append("_id",emprunt.getId_em());
       docEmprunt.append("date_em",emprunt.getId_em()); 
       docEmprunt.append("delais_em",emprunt.getId_em());  
       
        //ajout du document dans la collection Empruntcrit
       this.bibliothequeEmprunt.insert(docEmprunt);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");   
        
    }

 //-----------------------------------------------------------------------
   // pour supprimer un Emprunt
//----------------------------------------------------------------------    
    @Override
    public void deleteEmprunt(Emprunt emprunt) {
        
      //création
       BasicDBObject docEmprunt = new BasicDBObject();
       docEmprunt.append("_id",emprunt.getId_em());
       this.bibliothequeEmprunt.remove(docEmprunt);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");     
    }

 //---------------------------------------------------------------------
    //pour modifier un Emprunt
//------------------------------------------------------------------------
    @Override
    public void updateEmprunt(Emprunt emprunt) {
        
     //création du document à l'id de l'Emprunt
        BasicDBObject docEmpruntOld = new BasicDBObject();
        docEmpruntOld.append("_id", emprunt.getId_em());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docEmpruntNew = new BasicDBObject();
        docEmpruntNew.append("_id", emprunt.getId_em());
        docEmpruntNew.append("date_ed", emprunt.getDate_em()); 
        docEmpruntNew.append("delais_ed", emprunt.getDelais_em()); 
        
         this.bibliothequeEmprunt.update(docEmpruntOld, docEmpruntNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes");   
    }
    
}
