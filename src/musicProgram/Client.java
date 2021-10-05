/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicProgram;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author CUDSM37
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    private static List< Artist > artists = new ArrayList< Artist >();
    private static List< Listener > listeners = new ArrayList< Listener >();
    
    public static void main(String[] args) {
        initial();
        index();
    }
    

    private static void initial() {
        //Initialization of some data
        //Some artists
        Artist artist1 = new Artist.Builder("Why don´t we")
                .build();
        artists.add(artist1);
        Artist artist2 = new Artist.Builder("Shawn Mendes")
                .build();
        artists.add(artist2);
        Artist artist3 = new Artist.Builder("American Authors")
                .build();
        artists.add(artist3);
        Artist artist4 = new Artist.Builder("Bastille")
                .build();
        artists.add(artist4);
        Artist artist5 = new Artist.Builder("Fall Out Boy")
                .build();
        artists.add(artist5);
        
        //Some listeners
        Listener observer1 = new Listener("Laura");
        listeners.add(observer1);
        Listener observer2 = new Listener("Sofia");
        listeners.add(observer2);
        Listener observer3 = new Listener("Tatiana");
        listeners.add(observer3);
        Listener observer4 = new Listener("Isabella");
        listeners.add(observer4);
        Listener observer5 = new Listener("Alejandra");
        listeners.add(observer5);
        Listener observer6 = new Listener("Andres");
        listeners.add(observer6);
        Listener observer7 = new Listener("Liam");
        listeners.add(observer7);
        Listener observer8 = new Listener("Alexander");
        listeners.add(observer8);
        Listener observer9 = new Listener("Sebastian");
        Listener observer10 = new Listener("Andrew");

        //Listeners that follow artists
        artist1.addListener(observer1);
        artist1.addListener(observer2);
        artist1.addListener(observer3);
        artist1.addListener(observer8);
        artist1.addListener(observer9);
        artist2.addListener(observer1);
        artist2.addListener(observer2);
        artist2.addListener(observer4);
        artist2.addListener(observer5);
        artist3.addListener(observer6);
        artist3.addListener(observer8);
        artist3.addListener(observer10);
        artist4.addListener(observer8);
        artist4.addListener(observer1);
        artist5.addListener(observer6);
        
     
        artist1.addSong("Love back");
        artist2.addSong("Summer of Love");
        artist3.addSong("Beliver");
        artist4.addSong("The Anchor");
        artist5.addSong("I Wanna Dance With Somebody");
    }
    
    private static void newArtist(){
        JTextField name = new JTextField();
        JTextField albums = new JTextField();
        JTextField songs = new JTextField();
        JTextField recordCompany = new JTextField();
        Object[] message = {
            "Name:", name,
            "Albums (optional) \nif it is more than one separate it by ';':", albums,
            "Songs (optional) \nif it is more than one separate it by ';':", songs,
            "Record Company (optional):", recordCompany
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Create Artist", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (albums.getText().equals("") && songs.getText().equals("") && recordCompany.getText().equals("")) {
                //Artist with name
                Artist artist = new Artist.Builder(name.getText())
                    .build();
                artists.add(artist);
            }else if (albums.getText().equals("") && songs.getText().equals("") && !recordCompany.getText().equals("")) {
                //Artist with name and record company
                Artist artist = new Artist.Builder(name.getText())
                    .withRecordCompany(recordCompany.getText())
                    .build();
                artists.add(artist);
            }else if (albums.getText().equals("") && !songs.getText().equals("") && recordCompany.getText().equals("")) {
                //Artist with name and songs
                Artist artist = new Artist.Builder(name.getText())
                    .withSongs(songs.getText())
                    .build();
                artists.add(artist);
            }else if (albums.getText().equals("") && !songs.getText().equals("") && !recordCompany.getText().equals("")){
                //Artist with name, songs and record company
                Artist artist = new Artist.Builder(name.getText())
                    .withSongs(songs.getText())
                    .withRecordCompany(recordCompany.getText())
                    .build();
                artists.add(artist);
            }else if (!albums.getText().equals("") && songs.getText().equals("") && recordCompany.getText().equals("")){
                //Artist with name and albums
                Artist artist = new Artist.Builder(name.getText())
                    .withAlbums(albums.getText())
                    .build();
                artists.add(artist);
            }else if (!albums.getText().equals("") && songs.getText().equals("") && !recordCompany.getText().equals("")){
                //Artist with name, albums and record company
                Artist artist = new Artist.Builder(name.getText())
                    .withAlbums(albums.getText())
                    .withRecordCompany(recordCompany.getText())
                    .build();
                artists.add(artist);
            }else if (!albums.getText().equals("") && !songs.getText().equals("") && recordCompany.getText().equals("")){
                //Artist with name, albums and songs
                Artist artist = new Artist.Builder(name.getText())
                    .withAlbums(albums.getText())
                    .withSongs(songs.getText())
                    .build();
                artists.add(artist);
            }else if (!albums.getText().equals("") && !songs.getText().equals("") && !recordCompany.getText().equals("")){
                //Artist with name, albums, songs and record company
                Artist artist = new Artist.Builder(name.getText())
                    .withAlbums(albums.getText())
                    .withSongs(songs.getText())
                    .withRecordCompany(recordCompany.getText())
                    .build();
                artists.add(artist);
            }
            
            artistInfo(name.getText());
        }
    }

    private static void selectArtist(){
        String[] names = new String[artists.size()+1];
        names[0] = "New artist";
        for (int i = 1; i < artists.size()+1; i++) {
            names[i] = artists.get(i-1).getName();
        }
        Object select = JOptionPane.showInputDialog(null,"Select an artist",
            "Artists", JOptionPane.QUESTION_MESSAGE, null,
            names,null);
        if (select == null) {
            index();
        }else if (select.equals("New artist")) {
            newArtist();
            selectArtist();
        } else {
            artistInfo(select.toString());
        }
    }

    private static void artistInfo(String select){
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getName().equals(select)) {
                System.out.println(artists.get(i).getName()+"\n");
                String album ="";
                for (int j = 0; j < artists.get(i).getAlbums().size(); j++) {
                    album += "        "+artists.get(i).getAlbums().get(j) + "\n";
                }
                System.out.println("Albums:\n"+album);
                String songs ="";
                for (int j = 0; j < artists.get(i).getSongs().size(); j++) {
                    songs += "      "+artists.get(i).getSongs().get(j) + "\n";
                }
                System.out.println("Songs: \n"+songs);
                System.out.println("Record Company: "+artists.get(i).getRecordCompany());
                System.out.println("--------------------------------------------------------------------------");
                String song = JOptionPane.showInputDialog("Are you going to release a new song?\nWrite the name here");
                if (song != null) {
                    artists.get(i).addSong(song);
                    artistInfo(select);
                }else{
                    selectArtist();
                }
                break;
            }
        }
    }

    private static void index(){
        int seleccion = JOptionPane.showOptionDialog( null,"Select an option",
            "Select the user",JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,null,
            new Object[] { "Artist", "Listener", "Exit" },null);
        if (seleccion == 0) {
            selectArtist();           
        } else if (seleccion == 1) {
            selectListener();
        }
    }

    private static void selectListener(){
        String[] names = new String[listeners.size()+1];
        names[0] = "New Listener";
        for (int i = 1; i < listeners.size()+1; i++) {
            names[i] = listeners.get(i-1).getName();
        }
        Object select = JOptionPane.showInputDialog(null,"Select a listener",
            "Listeners", JOptionPane.QUESTION_MESSAGE, null,
            names,null);
        if (select == null) {
            index();
        }else if (select.equals("New Listener")) {
            String name = JOptionPane.showInputDialog("Name of the new listener");
            Listener listener = new Listener(name);
            listeners.add(listener);
            selectListener();
        } else {
            listenerInfo(select.toString());
        }
    }

    private static void listenerInfo(String select){
        for (int i = 0; i < listeners.size(); i++) {
            if (listeners.get(i).getName().equals(select)) {
                System.out.println(listeners.get(i).getName()+"\n");
                String history ="";
                for (int j = 0; j < listeners.get(i).getHistory().size(); j++) {
                    history += "        "+listeners.get(i).getHistory().get(j) + "\n";
                }
                System.out.println("History:\n"+history);
                String artist ="";
                for (int j = 0; j < listeners.get(i).getArtists().size(); j++) {
                    artist += "                   "+listeners.get(i).getArtists().get(j) + "\n";
                }
                System.out.println("Artists you follow: \n"+artist);
                System.out.println("--------------------------------------------------------------------------");
                String[] names = new String[artists.size()-listeners.get(i).getArtists().size()];
                int index = 0;
                boolean ok = true;
                for (int j = 0; j < artists.size(); j++) {
                    for (int k = 0; k < listeners.get(i).getArtists().size(); k++) {
                        if (artists.get(j).getName().equals(listeners.get(i).getArtists().get(k))){
                            ok = false;
                            break;
                        }   
                    }
                    if (ok) {
                        names[index] = artists.get(j).getName();
                        index++;
                    }
                    ok = true;
                }
                Object follow = JOptionPane.showInputDialog(null,"You want to follow someone else?\nChoose an artist",
                    "Artists", JOptionPane.QUESTION_MESSAGE, null,
                    names,null);
                if (follow != null) {
                    for (int j = 0; j < artists.size(); j++) {
                        if (artists.get(j).getName().equals(follow.toString())) {
                            artists.get(j).addListener(listeners.get(i));
                            break;
                        }
                    }
                    
                    listenerInfo(select);
                }else{
                    selectListener();
                }
                break;
            }
        }
    }
}
    
