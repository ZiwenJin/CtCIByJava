package Q75OnlineBookReader;

import java.util.HashMap;

/**
 * Created by ziwen on 10/11/2016.
 */
public class UserManager {
    private HashMap<Integer, User> users;

    public User addUser(int id, String details, int accountType) {
        if (users.containsKey(id)) {
            return null;
        }
        User user = new User(id, details, accountType);
        users.put(id, user);
        return user;
    }

    public User find(int id) {
        return users.get(id);
    }

    public boolean remove(User u) {
        return remove(u.getID());
    }

    public boolean remove(int id) {
        if (!users.containsKey(id)) {
            return false;
        }
        users.remove(id);
        return true;
    }
}
