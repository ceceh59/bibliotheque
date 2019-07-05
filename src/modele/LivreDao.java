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
public class LivreDao implements LivreInterface{
    
    private DB db;
    private DBCollection bibliothequeLivre;
    
    
    public LivreDao() {
        this.db = Connexion.getConnexion();
        bibliothequeLivre = this.db.getCollection("Livre");
    }
  
 // -----------------------------------------------------------------  
  //les attributs de la class Livre  
  /*  private int id_l;
    private String titre_l;
    private String annee_l;
    private String resume_l;
    private TypeLivre id_t;*/
    
    //------------------------------------------------------------------
    // Les methodes
    //-------------------------------------------------------------------
    
    //Pour récupérer tous les livres

    @Override
    public List<Livre> getAllLivre() {
      List<Livre> listeLivre = new ArrayList<>();
    //stockage de tous les Livres dans l'objet DBCursor
    DBCursor cursor = this.bibliothequeLivre.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
        DBObject objLivre = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Livre livre= new Livre(); 
    
    livre.setId_l((int)objLivre.get("_id"));
    livre.setTitre_l(objLivre.get("titre_l").toString());
    livre.setAnnee_l(objLivre.get("annee_l").toString());
    livre.setResume_l(objLivre.get("resume_l").toString());
   
    /*Creation d'un document pour recupere le type dans le document livre*/
    DBObject objTypeLivre =(DBObject) objLivre.get("typeLivre");
    
    /*maj du type livre dans l'objet livre*/
    livre.setTypeLivre_l(new TypeLivre((int) objTypeLivre.get("_id_t")));
    
    
    listeLivre.add(livre);
    }
    
    return listeLivre;
       
    }

    @Override
    public Livre getOneLivre(int id_l) {
        
        Livre livre = new Livre();
        
        //création d'un document avec l'id passé en paramètre
        BasicDBObject docIns = new BasicDBObject("_id", id_l);
        DBObject objLivre = this.bibliothequeLivre.findOne(docIns);
        livre.setId_l((int) objLivre.get("_id"));
        livre.setTitre_l(objLivre.get("titre_l").toString());
        livre.setAnnee_l(objLivre.get("annee_l").toString());
        livre.setResume_l(objLivre.get("resume_l").toString());

        /*Creation d'un document pour recupere le type dans le document livre*/
        DBObject objTypeLivre = (DBObject) objLivre.get("_id");

        /*maj du pays dans l'objet livre*/
        livre.setTypeLivre_l(new TypeLivre((int) objTypeLivre.get("_id_t")));

        return livre;
    }

    @Override
    public void addLivre(Livre livre) {
       //création d'un document
       BasicDBObject docLivre = new BasicDBObject();
       docLivre.append("_id",livre.getId_l());
       docLivre.append("titre_l",livre.getTitre_l()); 
       docLivre.append("annee_l",livre.getAnnee_l());
       docLivre.append("resume_l",livre.getResume_l());
       docLivre.append("typeLivre",new BasicDBObject("_id",livre.getTypeLivre_l().getId_t()));
      
       //ajout du document dans la collection inscrit
       this.bibliothequeLivre.insert(docLivre);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");   
       
    }

    @Override
    public void deleteLivre(Livre livre) {
     //création
       BasicDBObject docLivre = new BasicDBObject();
       docLivre.append("_id",livre.getId_l());
       this.bibliothequeLivre.remove(docLivre);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");    
        
    }

    @Override
    public void updateLivre(Livre livre) {
       //création du document à l'id de l'inscrit
        BasicDBObject docLivreOld = new BasicDBObject();
        docLivreOld.append("_id", livre.getId_l());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docLivreNew = new BasicDBObject();
        docLivreNew.append("_id", livre.getId_l());
        docLivreNew.append("titre_l", livre.getTitre_l());
        docLivreNew.append("annee_l", livre.getAnnee_l());
        docLivreNew.append("resume_l", livre.getResume_l());
        docLivreNew.append("typeLivre",new BasicDBObject("_id",livre.getTypeLivre_l().getId_t()));
        
        this.bibliothequeLivre.update(docLivreOld, docLivreNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes"); 
    }
    
    
    
}
