package Q75OnlineBookReader;

/**
 * Created by ziwen on 10/11/2016.
 */
public class Book {
    private int id;
    private String details;

    public Book(int id, String details) {
        this.id = id;
        this.details = details;
    }

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

    public void print() {
        System.out.println("Book id: " + id + ", details: " + details);
    }
}
