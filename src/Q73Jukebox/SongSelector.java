package Q73Jukebox;

/**
 * Created by ziwen on 08/11/2016.
 */
public class SongSelector {
    private Song currentSong;

    public SongSelector(Song s) {
        currentSong = s;
    }

    public void setSong(Song s) {
        currentSong = s;
    }

    public Song getCurrentSong() {
        return currentSong;
    }
}
