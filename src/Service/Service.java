/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;
/**
 *
 * @author fedi
 */
public interface Service<T> {
    public void ajout(T t);
    public void modifier(T t);
    public void supprimer(int id);
    public List<T> afficher();
    
}
