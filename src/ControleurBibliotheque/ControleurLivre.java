/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleurBibliotheque;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modele.Auteur;
import modele.Livre;
import modele.LivreDao;
import modele.TypeLivre;
import modele.TypeLivreDao;
import vue.LivreVue;

/**
 *
 * @author Administrateur
 */
public class ControleurLivre implements ActionListener,MouseListener {
    
    private LivreVue lVue;
    private LivreDao lDao;
    private TypeLivreDao typeLivreDao;
    private DefaultTableModel modelLivre;
    
    public ControleurLivre() {
        
        this.lVue = new LivreVue();
        this.lDao = new LivreDao();
        this.typeLivreDao = new TypeLivreDao();
        
        ajoutType();
        addListener();
        initModelLivre();
        this.lVue.setVisible(true);
        
    }
   public void addListener(){
       this.lVue.getBtnAjouterLivre().addActionListener(this);
       this.lVue.getBtnModifierLivre().addActionListener(this);
       this.lVue.getBtnResetLivre().addActionListener(this);
       this.lVue.getBtnSupprimerLivre().addActionListener(this);
       this.lVue.getTableEmprunt().addMouseListener(this);
   }

   public void ajoutType(){
       List<TypeLivre> listeTypeLivre = this.typeLivreDao.getAllTypeLivre();
       for(TypeLivre typeLivre : listeTypeLivre){
           this.lVue.getComboType_t().addItem(typeLivre.getId_t()+""+typeLivre.getLibelle_t());
       }
       
   }
     public int findIdTypeLivre(String chaine){
        String [] tabIdTypeLivre = chaine.split(" ");  
        return Integer.parseInt(tabIdTypeLivre[0]);
    }
   public void initModelLivre (){
        
         modelLivre = new DefaultTableModel();   
          //création du modele livre
        //Ajout des Colonnes du dodele Catégorie
        modelLivre.addColumn("ID Livre");
        modelLivre.addColumn("Titre");
        modelLivre.addColumn("Annee");
        modelLivre.addColumn("Resume");
       
        //inserer les lignes dans le medele livre
        List<Livre> allLivre = new ArrayList<>();
        allLivre = this.lDao.getAllLivre();
        
        for (Livre Livre : allLivre) {
            modelLivre.addRow(new Object[]{Livre.getId_l(),
                Livre.getTitre_l(),Livre.getAnnee_l(),Livre.getResume_l(),
           });
        }
        this.lVue.getTableEmprunt().setModel(modelLivre);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(this.lVue.getBtnSupprimerLivre())) {

            Livre Livre = new Livre();
            Livre.setId_l(Integer.parseInt(this.lVue.getTxtId_l().getText())
            );
            this.lDao.deleteLivre(Livre);

            initModelLivre();

            if (ae.getSource().equals(this.lVue.getBtnAjouterLivre())) {
                Livre livre = new Livre();
                livre.setId_l(Integer.parseInt(this.lVue.getTxtId_l().getText()));
                livre.setTitre_l(this.lVue.getTxtTitre_l().getText());
                livre.setResume_l(this.lVue.getTxtAreaResume_l().getText());
                livre.setAnnee_l(this.lVue.getTxtAnnee_l().getText());

                String chaine = this.lVue.getComboType_t().getSelectedItem().toString();
                //Création d'un Type en fonction de l'id du combobox
                TypeLivre typeLivre = this.typeLivreDao.getOneTypeLivre(findIdTypeLivre(chaine));
                //ajout du Type
                livre.setTypeLivre_l(typeLivre);
                this.lDao.addLivre(livre);

                initModelLivre();
            }
                if (ae.getSource().equals(this.lVue.getBtnModifierLivre())) {
                    Livre livre = new Livre();
                    livre.setId_l(Integer.parseInt(this.lVue.getTxtId_l().getText()));
                    livre.setTitre_l(this.lVue.getTxtTitre_l().getText());
                    livre.setResume_l(this.lVue.getTxtAreaResume_l().getText());
                    livre.setAnnee_l(this.lVue.getTxtAnnee_l().getText());
                    
                    
                    String chaine = this.lVue.getComboType_t().getSelectedItem().toString();
                    //Création d'un Type en fonction de l'id du combobox
                    TypeLivre typeLivre = this.typeLivreDao.getOneTypeLivre(findIdTypeLivre(chaine));
                    //ajout du Type
                    livre.setTypeLivre_l(typeLivre);
                    this.lDao.updateLivre(livre);
                    
                    initModelLivre();
                }

            }
        }
    
        @Override
        public void mouseClicked(MouseEvent me) {
        
        int ligne = this.lVue.getTableEmprunt().getSelectedRow();
            this.lVue.getTxtId_l().setText(modelLivre.getValueAt(ligne, 0).toString());
            this.lVue.getTxtAnnee_l().setText(modelLivre.getValueAt(ligne, 1).toString());
            this.lVue.getTxtAreaResume_l().setText(modelLivre.getValueAt(ligne, 2).toString());
            this.lVue.getTxtTitre_l().setText(modelLivre.getValueAt(ligne, 3).toString());

        }

        @Override
        public void mousePressed
        (MouseEvent me
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased
        (MouseEvent me
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered
        (MouseEvent me
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited
        (MouseEvent me
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
