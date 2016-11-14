package Q77ChatServer;

import java.util.Date;

/**
 * Created by ziwen on 12/11/2016.
 */
public class Message {
    private String content;
    private Date date;

    public Message(String content, Date date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }
}
