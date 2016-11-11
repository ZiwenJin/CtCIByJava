package Q73Jukebox;

/**
 * Created by ziwen on 08/11/2016.
 */
public class Song {
    private int id;
    private String name;
    private CD cd;
    private double length;

    public Song(int id, String name, CD cd, double length) {
        this.id = id;
        this.name = name;
        this.cd = cd;
        this.length = length;
    }

    public Song(int id, String name, double length) {
        this.id = id;
        this.name = name;
        this.length = length;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CD getCD() {
        return cd;
    }

    public void setCD(CD cd) {
        this.cd = cd;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString() {
        if (cd == null) {
            return "Name: " + name;
        } else {
            return "Name: " + name + ", CD: " + cd;
        }
    }
}
