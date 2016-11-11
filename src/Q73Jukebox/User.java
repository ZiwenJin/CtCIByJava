package Q73Jukebox;

/**
 * Created by ziwen on 08/11/2016.
 */
public class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public User getUser() {
        return this;
    }

    public static User addUser(String name, int id) {
        return new User(name, id);
    }
}
