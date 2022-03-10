/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author lotfi
 */
public interface jardenfantService<T> {
    public void ajouter(T je);
    public void modifier(T je);
    public void supprimer(int id);
    public List<T> afficher();
    
}
