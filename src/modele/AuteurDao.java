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
public class AuteurDao implements AuteurInterface{
    
    
    private DB db;
    private DBCollection bibliothequeAuteur;

    public AuteurDao() {
        //connexion a la db
        this.db = Connexion.getConnexion();
        //connexion a la collection Auteur
        bibliothequeAuteur = this.db.getCollection("Auteur");  
}
  //--------------------------------------------------------------------------
//Les Attributs de la class Auteur  
    /*private int id_a;
    private String nom_a;
    private String prenom_a;
    private String date_naissance;
    private Pays id_p;*/
    
 //--------------------------------------------------------------------------
// Les Méthodes
//--------------------------------------------------------------------------

//Pour récupérer tous les Auteurs
       
    
    @Override
    public List<Auteur> getAllAuteur() {
         
    List<Auteur> listeAuteur = new ArrayList<>();
    //stockage de tous les Auteurs dans l'objet DBCursor
    DBCursor cursor = this.bibliothequeAuteur.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
        DBObject objAuteur = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Auteur auteur= new Auteur(); 
    auteur.setId_a((int)objAuteur.get("_id_a"));
    auteur.setNom_a(objAuteur.get("nom_a").toString());
    auteur.setPrenom_a(objAuteur.get("prenom_a").toString());
    auteur.setDate_naissance_a(objAuteur.get("date_naissance_a").toString());
        
    DBObject objPays = (DBObject)objAuteur.get("idPaysAuteur");
    
    auteur.setPays_a(new Pays((int)objPays.get("_id_a"))); 
     
    listeAuteur.add(auteur);
    }
    
    return listeAuteur;   
        
    }

    @Override
    public Auteur getOneAuteur(int id_a) {
      Auteur auteur = new Auteur();
        //création d'un document avec l'id passé en paramètre
        BasicDBObject docAuteur = new BasicDBObject("_id_a", id_a);
        DBObject objAuteur = this.bibliothequeAuteur.findOne(docAuteur);
        auteur.setId_a((int) objAuteur.get("_id_a"));
        auteur.setNom_a(objAuteur.get("nom_a").toString());
        auteur.setPrenom_a(objAuteur.get("prenom_a").toString());
        auteur.setDate_naissance_a(objAuteur.get("date_naissance_a").toString());
        
        /*Creation d'un document pour recupere le pays dans le document auteur*/
        
        DBObject objPays = (DBObject) objAuteur.get("_id_a");

        /*maj du pays dans l'objet auteur*/
        auteur.setPays_a(new Pays((int) objPays.get("_id_a")));
        

        return auteur;
    }

    @Override
    public void addAuteur(Auteur auteur) {
       //création d'un document
       BasicDBObject docAuteur = new BasicDBObject();
       docAuteur.append("_id_a",auteur.getId_a());
       docAuteur.append("nom_a",auteur.getNom_a()); 
       docAuteur.append("prenom_a",auteur.getPrenom_a());
       docAuteur.append("date_naissance_a",auteur.getDate_naissance_a()); 
       docAuteur.append("_id_p", new BasicDBObject("_id_a",auteur.getPays_a().getId_p()));
       
       
      
      
         //ajout du document dans la collection Auteur
       this.bibliothequeAuteur.insert(docAuteur);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");
    }

    @Override
    public void deleteAuteur(Auteur auteur) {
      //création
       BasicDBObject docAuteur = new BasicDBObject();
       docAuteur.append("_id_a",auteur.getId_a());
       this.bibliothequeAuteur.remove(docAuteur);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");   
    }

    @Override
    public void updateAuteur(Auteur auteur) {
      
        //création du document à l'id de l'Auteur
        BasicDBObject docAuteurOld = new BasicDBObject();
        docAuteurOld.append("_id_a", auteur.getId_a());
        
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docAuteurNew = new BasicDBObject();
        docAuteurNew.append("_id_a", auteur.getId_a());
        docAuteurNew.append("nom_a", auteur.getNom_a());
        docAuteurNew.append("prenom_a", auteur.getPrenom_a());
        docAuteurNew.append("date_naissance_a", auteur.getDate_naissance_a()); 
        docAuteurNew.append("_id_p", new BasicDBObject("_id_a",auteur.getPays_a().getId_p()));
        
        this.bibliothequeAuteur.update(docAuteurOld, docAuteurNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes");
    }
  
}
