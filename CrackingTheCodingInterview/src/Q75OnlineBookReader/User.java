package Q75OnlineBookReader;

/**
 * Created by ziwen on 10/11/2016.
 */
public class User {
    private int id;
    private String details;
    private int accountType;

    public User(int id, String details, int accountType) {
        this.id = id;
        this.details = details;
        this.accountType = accountType;
    }

    public void renewMembership() {}

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public void print() {
        System.out.println("User id: " + id + ", details: " + details + ", account type: " + accountType);
    }
}
