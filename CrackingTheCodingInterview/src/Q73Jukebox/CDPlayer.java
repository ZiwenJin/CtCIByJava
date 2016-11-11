package Q73Jukebox;

/**
 * Created by ziwen on 08/11/2016.
 */
public class CDPlayer {
    private Playlist p;
    private CD c;
    
    public CDPlayer(CD c, Playlist p) {
        this.p = p;
        this.c = c;
    }
    
    public CDPlayer(Playlist p) {
        this.p = p;
    }
    
    public CDPlayer(CD c) {
        this.c = c;
    }
    
    public void playSong(Song s) {
        System.out.println("Playing song \"" + s.getName() + "\" in CD \"" + c);
    }
    
    public Playlist getPlaylist() {
        return p;
    }
    
    public void setPlaylist(Playlist p) {
        this.p = p;
    }

    public CD getCD() {
        return c;
    }

    public void setCD(CD c) {
        this.c = c;
    }
}
