package Q72CallCenter;

/**
 * Created by ziwen on 08/11/2016.
 */
public abstract class Employee {
    private Call currentCall = null;
    protected Rank rank;
    private CallHandler callHandler;

    public Employee(CallHandler handler) {
        callHandler = handler;
    }

    public void receiveCall(Call call) {
        currentCall = call;
    }

    public void callCompleted() {
        if (currentCall != null) {
            currentCall.disconnect();
            currentCall = null;
        }
        assignNewCall();
    }

    public void escalateAndReassing() {
        if (currentCall != null) {
            currentCall.incrementRank();
            callHandler.dispatchCall(currentCall);

            currentCall = null;
        }
        assignNewCall();
    }

    public boolean assignNewCall() {
        if (!isFree()) {
            return false;
        }
        return callHandler.assignCall(this);
    }

    public boolean isFree() {
        return currentCall == null;
    }

    public Rank getRank() {
        return rank;
    }
}

class Director extends Employee {
    public Director(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Director;
    }
}

class Manager extends Employee {
    public Manager(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Manager;
    }
}

class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
        super(callHandler);
        rank = Rank.Respondent;
    }
}
