/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicProgram;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CUDSM37
 */
public class Listener implements PropertyChangeListener {

    private List< String > history = new ArrayList< String >();
    private String name;
    private List< String > artists = new ArrayList< String >();
    
    public Listener(String name) {
        this.name =  name;
    }
    
    public void propertyChange(PropertyChangeEvent evt) {
        String update = (String) evt.getNewValue();
        String[] updates = update.split(": ");
        this.setHistory(update);
        System.out.println(this.name + " " + updates[0] + " drop a new song named "+updates[1]);
    }

    public List<String> getHistory() {
        return history;
    }

    private void setHistory(String history) {
        this.history.add(history);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(String artist) {
        this.artists.add(artist);
    }
    
    public void deleteArtists(String artist) {
        for (int i = 0; i < this.artists.size(); i++) {
            if (artist.equals(artists.get(i))) {
                this.artists.remove(i);
            }
        }
    }
    
    
}
