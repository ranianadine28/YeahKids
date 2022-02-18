/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entities.Event;
import javafx.collections.ObservableList;

/**
 *
 * @author rania
 */
public interface IEventService {
     public Event getEvenementById(int id);
    public Event getEvenementByAventure(String s);
    public Event insertEvenement(Event e);
     public ObservableList<Event> getAll();
     public ObservableList<Event> getEv();
    public ObservableList<Event> getEv1();
    public boolean deleteEvenement(int ide);
     public void updateEvenement(Event e, int id) ;
}
