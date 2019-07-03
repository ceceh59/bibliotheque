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
public class TypeLivreDao implements TypeLivreInterface{
    
    
     private DB db;
    private DBCollection bibliothequeTypeLivre;

    public TypeLivreDao() {
        this.db = Connexion.getConnexion();
        bibliothequeTypeLivre = this.db.getCollection("Typelivre");  
    
}
  //------------------------------------------------------------------
    // les attributs de la class TypeLivre
    /* private int id_t;
    private String libelle_t;*/
    
//--------------------------------------------------------------------------
// Les Méthodes
//--------------------------------------------------------------------------

//Pour récupérer tous les TypeLivre

    @Override
    public List<TypeLivre> getAllTypeLivre() {
        
        List<TypeLivre> listeTypeLivre = new ArrayList<>();
        //stockage de tous les types de livre dans l'objet DBCursor
        DBCursor cursor = this.bibliothequeTypeLivre.find();
        //parcours du cursor
        while(cursor.hasNext()){
            //hasNext permet de tester la fin du curseur
            DBObject objTypeLivre = cursor.next();
            // next permet de récupérer le document ds le curseur après chaque itération
            
            TypeLivre typeLivre = new TypeLivre();
            typeLivre.setId_t((int)objTypeLivre.get("_id"));
            typeLivre.setLibelle_t(objTypeLivre.get("libelle_t").toString());
            
            listeTypeLivre.add(typeLivre);
        }
        
        return listeTypeLivre;
        
    }

    @Override
    public TypeLivre getOneTypeLivre(int id_t) {
        
        TypeLivre typeLivre = new TypeLivre();
        //création d'un document avec l'id passé en paramètre
        BasicDBObject docTypeLivre = new BasicDBObject("_id",id_t);
        DBObject objTypeLivre = this.bibliothequeTypeLivre.findOne(docTypeLivre);
        typeLivre.setId_t((int)objTypeLivre.get("_id"));
        typeLivre.setLibelle_t(objTypeLivre.get("libelle_t").toString());
        
        return typeLivre;
       
    }

    @Override
    public void addTypeLivre(TypeLivre typeLivre) {
        
        // création d'un document
        BasicDBObject docTypeLivre = new BasicDBObject();
        docTypeLivre.append("_id",typeLivre.getId_t());
        docTypeLivre.append("libelle_t",typeLivre.getLibelle_t());
        
        //ajout du document dans la collection TypeLivre
        
        this.bibliothequeTypeLivre.insert(docTypeLivre);
        
        JOptionPane.showMessageDialog(null,"opération effectuée avec succès");
        
        
    }

    @Override
    public void deleteTypeLivre(TypeLivre typeLivre) {
        //création
        BasicDBObject docTypeLivre = new BasicDBObject();
        docTypeLivre.append("_id",typeLivre.getId_t());
        this.bibliothequeTypeLivre.remove(docTypeLivre);
        JOptionPane.showMessageDialog(null,"opération effectuée avec succès"); 
        
    }

    @Override
    public void updateTypeLivre(TypeLivre typeLivre) {
        
        //création du document à l'id du type de livre
        BasicDBObject docTypeLivreOld = new BasicDBObject();
        docTypeLivreOld.append("_id",typeLivre.getId_t());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docTypeLivreNew = new BasicDBObject();
        docTypeLivreNew.append("_id",typeLivre.getId_t());
        docTypeLivreNew.append("libelle_t",typeLivre.getLibelle_t());
        this.bibliothequeTypeLivre.update(docTypeLivreOld, docTypeLivreNew);
        
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes");
    }
    

    
    
}