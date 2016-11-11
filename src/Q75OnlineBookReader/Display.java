package Q75OnlineBookReader;

/**
 * Created by ziwen on 10/11/2016.
 */
public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;

        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        pageNumber--;
        refreshPage();
    }

    public void refreshUsername() {
        System.out.println("User id: " + activeUser.getID() + ", details: " + activeUser.getDetails() + ", account type: " + activeUser.getAccountType());
    }

    public void refreshTitle() {
        System.out.println("Book id: " + activeBook.getID());
    }

    public void refreshDetails() {
        System.out.println("Book details: " + activeBook.getDetails());
    }

    public void refreshPage() {
        System.out.println("Current page: " + pageNumber);
    }
}
