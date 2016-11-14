package Q77ChatServer;

/**
 * Created by ziwen on 12/11/2016.
 */
public class GroupChat extends Conversation {
    public void removeParticipant(User user) {
        participants.remove(user);
    }

    public void addParticipant(User user) {
        participants.add(user);
    }
}
