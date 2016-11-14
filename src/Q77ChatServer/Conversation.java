package Q77ChatServer;

import java.util.ArrayList;

/**
 * Created by ziwen on 12/11/2016.
 */
public abstract class Conversation {
    protected ArrayList<User> participants = new ArrayList<>();
    protected int id;
    protected ArrayList<Message> messages = new ArrayList<>();

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public boolean addMessage(Message m) {
        messages.add(m);
        return true;
    }

    public int getId() {
        return id;
    }
}
