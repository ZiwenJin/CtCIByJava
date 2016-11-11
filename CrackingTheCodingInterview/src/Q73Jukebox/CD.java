package Q73Jukebox;

/**
 * Created by ziwen on 08/11/2016.
 */

import java.util.Queue;

public class CD {
    private int id;
    private String artist;
    private Queue<Song> songs;

    public CD(int id, String artist, Queue<Song> songs) {
        this.id = id;
        this.artist = artist;
        this.songs = songs;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Queue<Song> getSongs() {
        return songs;
    }

    public void setSOngs(Queue<Song> songs) {
        this.songs = songs;
    }
}
