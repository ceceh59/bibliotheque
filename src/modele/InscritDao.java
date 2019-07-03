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
public class InscritDao implements InscritInterface{
    

  private DB db;
    private DBCollection bibliothequeInscrit;

    public InscritDao() {
        this.db = Connexion.getConnexion();
        bibliothequeInscrit = this.db.getCollection("Inscrit");  
}
//--------------------------------------------------------------------------
//Les Attributs de la class Inscrit
    /* private int id_i;
    private String nom_i;
    private String prenom_i;
    private String date_naissance_i;
    private String rue_i;
    private String ville_i;
    private String email_i;
    private String tel_i;
    private String tel_portable_i;*/

//--------------------------------------------------------------------------
// Les Méthodes
//--------------------------------------------------------------------------

//Pour récupérer tous les inscrits
    
    
    @Override
    public List<Inscrit> getAllInscrit() {
      
    List<Inscrit> listeInscrit = new ArrayList<>();
    //stockage de tous les inscrits dans l'objet DBCursor
    DBCursor cursor = this.bibliothequeInscrit.find();
    //parcours du cursor
    while(cursor.hasNext()){
    //hasNext permet de tester la fin du curseur
        DBObject objInscrit = cursor.next();
    // next permet de récupérer le document ds le curseur après chaque itération
    
    Inscrit ins= new Inscrit(); 
    ins.setId_i((int)objInscrit.get("_id"));
    ins.setNom_i(objInscrit.get("nom_i").toString());
    ins.setPrenom_i(objInscrit.get("prenom_i").toString());
    ins.setDate_naissance_i(objInscrit.get("date_naissance_i").toString());
    ins.setRue_i(objInscrit.get("rue_i").toString());
    ins.setVille_i(objInscrit.get("ville_i").toString());
    ins.setEmail_i(objInscrit.get("email_i").toString());
    ins.setTel_i(objInscrit.get("tel_i").toString());
    ins.setTel_portable_i(objInscrit.get("tel_portable_i").toString());
    
    
    listeInscrit.add(ins);
    }
    
    return listeInscrit;
    
    }

    @Override
    public Inscrit getOneInscrit(int id_i) {
       Inscrit ins = new Inscrit();
       //création d'un document avec l'id passé en paramètre
        BasicDBObject docIns = new BasicDBObject("_id",id_i);
        DBObject objInscrit = this.bibliothequeInscrit.findOne(docIns);
        ins.setId_i((int) objInscrit.get("_id"));
        ins.setNom_i(objInscrit.get("nom_i").toString());
        ins.setPrenom_i(objInscrit.get("prenom_i").toString());
        ins.setDate_naissance_i(objInscrit.get("date_naissance_i").toString());
        ins.setRue_i(objInscrit.get("rue_i").toString());
        ins.setVille_i(objInscrit.get("ville_i").toString());
        ins.setEmail_i(objInscrit.get("email_i").toString());
        ins.setTel_i(objInscrit.get("tel_i").toString());
        ins.setTel_portable_i(objInscrit.get("tel_portable_i").toString());
        
        return ins;
    }

    @Override
    public void addInscrit(Inscrit ins) {
       //création d'un document
       BasicDBObject docIns = new BasicDBObject();
       docIns.append("_id",ins.getId_i());
       docIns.append("nom_i",ins.getNom_i()); 
       docIns.append("prenom_i",ins.getPrenom_i());
       docIns.append("date_naissance_i",ins.getDate_naissance_i());
       docIns.append("rue_i",ins.getRue_i());
       docIns.append("ville_i",ins.getVille_i());
       docIns.append("email_i",ins.getEmail_i());
       docIns.append("tel_i",ins.getTel_i());
       docIns.append("tel_portable_i",ins.getTel_portable_i());
       //ajout du document dans la collection inscrit
       this.bibliothequeInscrit.insert(docIns);
       
        JOptionPane.showMessageDialog(null, "opération effectuée avec succès");
       
    }

    @Override
    public void deleteInscrit(Inscrit ins) {
       //création
       BasicDBObject docIns = new BasicDBObject();
       docIns.append("_id",ins.getId_i());
       this.bibliothequeInscrit.remove(docIns);
       JOptionPane.showMessageDialog(null,"opération effectuée avec succès");
    }

    @Override
    public void updateInscrit(Inscrit ins) {
        //création du document à l'id de l'inscrit
        BasicDBObject docInsOld = new BasicDBObject();
        docInsOld.append("_id", ins.getId_i());
        //création du document avec les valeurs à mettre à jour
        BasicDBObject docInsNew = new BasicDBObject();
        docInsNew.append("_id", ins.getId_i());
        docInsNew.append("nom_i", ins.getNom_i());
        docInsNew.append("prenom_i", ins.getPrenom_i());
        docInsNew.append("date_naissance_i", ins.getDate_naissance_i());
        docInsNew.append("rue_i", ins.getRue_i());
        docInsNew.append("ville_i", ins.getVille_i());
        docInsNew.append("email_i", ins.getEmail_i());
        docInsNew.append("tel_i", ins.getTel_i());
        docInsNew.append("tel_portable_i", ins.getTel_portable_i());
        
        this.bibliothequeInscrit.update(docInsOld, docInsNew);
        
        JOptionPane.showMessageDialog
        (null, "Opération effectuée avec succes");
    }
    
}