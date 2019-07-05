/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliothèque;

import ControleurBibliotheque.ControleurLivre;
import modele.Auteur;
import modele.AuteurDao;
import modele.Connexion;
import modele.Edition;
import modele.EditionDao;
import modele.Exemplaire;
import modele.ExemplaireDao;
import modele.Inscrit;
import modele.InscritDao;
import modele.Livre;
import modele.LivreDao;
import modele.Pays;
import modele.PaysDao;
import modele.TypeLivre;
import modele.TypeLivreDao;
import vue.LivreVue;

/**
 *
 * @author Administrateur
 */
public class Bibliothèque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connexion.getConnexion();
        
        //----------------------------------------------
        //TEST DES METHODES
        //----------------------------------------------
        // pour ajouter des editions
        
        
        //Edition edition = new Edition(0,"presse de la cite");
        //Edition edition = new Edition(1,"pour les nuls");
        //Edition edition = new Edition(2,"la recherche");
       // Edition edition = new Edition(3, "j'aime lire");
        //EditionDao editionDao = new EditionDao();
       // editionDao.addEdition(edition);
       
       
       //-----------------------------------------------
       
       //pour supprimer une edition
       //Edition edition = new Edition(3, "j'aime lire");
       //EditionDao editionDao = new EditionDao();
       //editionDao.deleteEdition(edition);
       
       //------------------------------------------------
       
       //pour modifier une edition
       //Edition edition = new Edition(2, "la science");
       //EditionDao editionDao = new EditionDao();
       //editionDao.updateEdition(edition);
       
       //----------------------------------------------------
       
       //pour récupérer une edition
       //EditionDao editionDao = new EditionDao();
       //System.out.println(editionDao.getOneEdition(1));
       
       //-----------------------------------------------------
       //PAYS
       //-------------------------------------------------------
       
        //pour ajouter des pays
       //Pays pays = new Pays(0,"France");
       //Pays pays = new Pays(1,"Belgique");
       //Pays pays = new Pays(2,"Espagne");
       //Pays pays = new Pays(3,"Allemagne");
       //Pays pays = new Pays(4,"Suisse");
       //PaysDao paysDao = new PaysDao();
       //paysDao.addPays(pays);
       
       //-------------------------------------------------
       
       //pour supprimer un pays
       //Pays pays = new Pays(4,"Suisse");
       //PaysDao paysDao = new PaysDao();
       //paysDao.deletePays(pays);
       
       //--------------------------------------------------
       
        //pour modifier un pays
        //Pays pays = new Pays(3, "Suisse");
        //PaysDao paysDao = new PaysDao();
        //paysDao.updatePays(pays);
        
        //---------------------------------------------------
        
        //getOne
        //PaysDao paysDao = new PaysDao();
        //System.out.println(paysDao.getOnePays(2));
        
        //-----------------------------------------------------
        //TypeLivre
        //-----------------------------------------------------
        
        //pour ajouter des types de livre
        
        //TypeLivre typelivre = new TypeLivre(0,"science fiction");
        //TypeLivre typelivre = new TypeLivre(1,"romantique");
        //TypeLivre typelivre = new TypeLivre(2,"aventure");
        //TypeLivreDao Typelivre = new TypeLivreDao();
        //Typelivre.addTypeLivre(typelivre);
        
        //-------------------------------------------------------
        //pour supprimer un type de livre
        
        //TypeLivre typelivre = new TypeLivre(2,"aventure");
        //TypeLivreDao Typelivre = new TypeLivreDao();
        //Typelivre.deleteTypeLivre(typelivre);
        
        //---------------------------------------------------------
        //pour modifier un pays
        
        //TypeLivre typelivre = new TypeLivre(1,"policier");
        //TypeLivreDao Typelivre = new TypeLivreDao();
        //Typelivre.updateTypeLivre(typelivre);
        
        //----------------------------------------------------------
        
        //getOne
        //TypeLivreDao Typelivre = new TypeLivreDao();
        //System.out.println(Typelivre.getOneTypeLivre(0));
        
        //--------------------------------------------------------
        //Inscrit
        //----------------------------------------------------------
        
        //pour ajouter un inscrit
        
        //Inscrit inscrit = new Inscrit(4,"Roland","Robert","12/08/56",
         // "15,allee des peupliers","lille","robert@sfr.fr","0328256512","0612147896");
         //Inscrit inscrit = new Inscrit(0,"Jules","Dupond","15/08/77",
         //"15,allee des soles","Lomme","dupond@sfr.fr","0328131615","0612151814");
          //Inscrit inscrit = new Inscrit(1,"Brigitte","Hermand","02/11/87",
         //"6, rue de l'église","Roubaix","brigitte@sfr.fr","0325855623","0660212565");
         // Inscrit inscrit = new Inscrit(2,"Nicolas","Masse","23/06/84",
         //"25, rue de Roubaix","Louvil","nicolas@sfr.fr","0327895621","0656231489");
          //Inscrit inscrit = new Inscrit(3,"jules","jerk","12/05/87",
         //"55,rue de l'égalité","Bersée","jules@sfr.fr","0328965484","0674562123"); 
          
         //InscritDao insDao = new InscritDao();
      
       
        //insDao.addInscrit(inscrit);
    //----------------------------------------------------------
    
    //Pour supprimer un inscrit
    
    //InscritDao insDao = new InscritDao();
    
    //Inscrit inscrit = new Inscrit(4,"Roland","Robert","12/08/56",
         //"15,allee des peupliers","lille","robert@sfr.fr","0328256512","0612147896");
    
    //insDao.deleteInscrit(inscrit);
    
    //----------------------------------------------------------
    
    //pour modifier un inscrit
    
   // Inscrit inscrit = new Inscrit(3,"Roland","Robert","12/08/56",
        // "15,allee des peupliers","lille","robert@sfr.fr","0328256512","0612147896");    
    
    //InscritDao insDao = new InscritDao();
    
    //insDao.updateInscrit(inscrit);
    
    //--------------------------------------------------------------
    
    //Pour selectionner un inscrit
    
    //InscritDao insDao = new InscritDao();
    
    //System.out.println(insDao.getOneInscrit(2));
    
    
    //-------------------------------------------------------
    
    //Auteur
    
    //----------------------------------------------------------
    
    
    //pour ajouter un auteur
    
    //Auteur auteur = new Auteur(0,"Debeauvoir","Simone","01/02/19",new Pays(0,"France"));
    
    //AuteurDao auteurDao = new AuteurDao();
    
    //auteurDao.addAuteur(auteur);
    
     //Auteur auteur = new Auteur(1,"Hugo","Victor","02/05/45",new Pays(0,"France"));
    
   // AuteurDao auteurDao = new AuteurDao();
    
    //auteurDao.addAuteur(auteur);
    
    // Auteur auteur = new Auteur(2,"Zola","Emile","07/05/12",new Pays(0,"France"));
    
    //AuteurDao auteurDao = new AuteurDao();
    
    //auteurDao.addAuteur(auteur);
    
    //Auteur auteur = new Auteur(3,"Colette","","01/05/43",new Pays(0,"France"));
    
    //AuteurDao auteurDao = new AuteurDao();
    
    //auteurDao.addAuteur(auteur);
    
    //-----------------------------------------------------------
    // pour modifier un auteur
    
    //Auteur auteur = new Auteur(3,"Verne","Jules","02/08/25",new Pays(0,"France"));
    
   // AuteurDao auteurDao = new AuteurDao();
    
    //auteurDao.updateAuteur(auteur);
    
    //----------------------------------------------------
    
    //pour supprimer un auteur
    
   // Auteur auteur = new Auteur(3,"Verne","Jules","02/08/25",new Pays(0,"France"));
    
    //AuteurDao auteurDao = new AuteurDao();
    
    //auteurDao.deleteAuteur(auteur);
    
    //-----------------------------------------------------------------
    //Livre
    //--------------------------------------------------------------------
    // pour ajouter un livre
    
    //Livre livre = new Livre (1,"le monde","2010","tres bien",new TypeLivre(1));
  // LivreDao livreDao = new LivreDao();
    
    //livreDao.addLivre(livre);
    
    //-------------------------------------------------------------------
    //pour modifier un livre
    
    //Livre livre = new Livre(0,"La terre","2010","tres bien",new TypeLivre(1));
    //LivreDao livreDao = new LivreDao();
    
    //livreDao.updateLivre(livre);
    
    //-------------------------------------------------------------------------
    
    //pour supprimer un livre
    
    //Livre livre = new Livre(0,"La terre","2010","tres bien",new TypeLivre(1));
    //LivreDao livreDao = new LivreDao();
    
    //livreDao.deleteLivre(livre);
    
     
    //--------------------------------------------------------------------
    //Exemplaire
    //----------------------------------------------------------------------
    
    
    // pour ajouter un exemplaire
    
   //Exemplaire exemplaire = new Exemplaire (0,new Edition(0),new Livre(0));
   
   //ExemplaireDao exemplaireDao = new ExemplaireDao();
   
   //exemplaireDao.addExemplaire(exemplaire);
   
   LivreVue lVue = new LivreVue();
   ControleurLivre controleurLivre = new ControleurLivre();
   
   
   
   
   
    }
    
    
    
}
