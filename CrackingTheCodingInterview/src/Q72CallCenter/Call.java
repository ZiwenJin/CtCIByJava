package Q72CallCenter;

/**
 * Created by ziwen on 08/11/2016.
 */
public class Call {
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller c) {
        rank = Rank.Respondent;
        caller = c;
    }

    public void setHandler(Employee e) { handler = e; }

    public void reply(String message) { System.out.println(message); }
    public Rank getRank() { return rank; }
    public void setRank(Rank r) { rank = r; }
    public Rank incrementRank() {
        if (rank == Rank.Respondent) rank = Rank.Manager;
        else if (rank == Rank.Manager) rank = Rank.Director;
        return rank;
    }
    public void disconnect() { reply("Thank you for calling."); }
}
