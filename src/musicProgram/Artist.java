/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicProgram;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author CUDSM37
 */

public class Artist  {
    private List< String > songs = new ArrayList< String >();
    private String name;
    private String recordCompany;
    private List< String > albums = new ArrayList< String >();
    
    private PropertyChangeSupport listeners;
  
    public static class Builder {
        private List< String > songsB = new ArrayList< String >();
        private String name;
        private List< String > albums = new ArrayList< String >();
        private String recordCompany;
        private PropertyChangeSupport listeners;

        public Builder(String name) {
            this.name = name;
            this.listeners = new PropertyChangeSupport(this);
        }

        public Builder withAlbums(String albumsS){
            String[] albumsA = albumsS.split(";");
            List< String > albumsL = Arrays.asList(albumsA);
            this.albums = albumsL;
            return this;  //By returning the builder each time, we can create a fluent interface.
        }

        public Builder withSongs(String songsS){
            String[] songsA = songsS.split(";");
            for (int i = 0; i < songsA.length; i++) {
                this.songsB.add(songsA[i]);
            }
            return this;
        }
        
        public Builder withRecordCompany(String recordCompany){
            this.recordCompany = recordCompany;
            return this;
        }

        public Artist build(){
            Artist artist = new Artist();
            artist.name = this.name;
            artist.listeners = this.listeners; 
            artist.songs = this.songsB;
            artist.albums = this.albums;
            artist.recordCompany = this.recordCompany;
            
            return artist;
        }
    }

    private Artist() {
        
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    public String getRecordCompany() {
        return recordCompany;
    }

    public void setRecordCompany(String recordCompany) {
        this.recordCompany = recordCompany;
    }

    public PropertyChangeSupport getListeners() {
        return listeners;
    }

    public void setListeners(PropertyChangeSupport listeners) {
        this.listeners = listeners;
    }

    public void addListener(PropertyChangeListener pcl) {
        this.listeners.addPropertyChangeListener(pcl);
        Listener listener = (Listener) pcl;
        listener.setArtists(this.name);
    }

    public void removeListener(PropertyChangeListener pcl) {
        this.listeners.removePropertyChangeListener(pcl);
    }

    public void addSong(String song) {
        this.listeners.firePropertyChange("songs", "" ,name +": "+song);
        this.songs.add(song);
        System.out.println("-----------------------------------------------------------------------------");
    }
    
}
