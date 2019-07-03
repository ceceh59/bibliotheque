/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface TypeLivreInterface {
    
    public List<TypeLivre>getAllTypeLivre();
    public TypeLivre getOneTypeLivre(int id_t);
    public void addTypeLivre(TypeLivre typeLivre);
    public void deleteTypeLivre(TypeLivre typeLivre);
    public void updateTypeLivre(TypeLivre typeLivre);
    
}
