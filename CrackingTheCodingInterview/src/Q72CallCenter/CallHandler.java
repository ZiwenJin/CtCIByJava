package Q72CallCenter;

/**
 * Created by ziwen on 08/11/2016.
 */
import java.util.ArrayList;
import java.util.List;

public class CallHandler {
    private final int LEVELS = 3; // 3 levels of employees

    // initialize number of employees
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;

    List<List<Call>> callQueues;

    public CallHandler(int numRes, int numMan, int numDir) {
        employeeLevels = new ArrayList<>(LEVELS);
        callQueues = new ArrayList<>(LEVELS);

        ArrayList<Employee> respondents = new ArrayList<>(numRes);
        for (int k=0; k<numRes; k++) {
            respondents.add(new Respondent(this));
        }
        employeeLevels.add(respondents);
        callQueues.add(new ArrayList<>());

        ArrayList<Employee> managers = new ArrayList<>(numMan);
        for (int k=0; k<numMan; k++) {
            managers.add(new Manager(this));
        }
        employeeLevels.add(managers);
        callQueues.add(new ArrayList<>());

        ArrayList<Employee> directors = new ArrayList<>(numDir);
        for (int k=0; k<numDir; k++) {
            directors.add(new Director(this));
        }
        employeeLevels.add(directors);
        callQueues.add(new ArrayList<>());
    }

    public Employee getHandlerForCall(Call call) {
        for (int level = call.getRank().getValue(); level< LEVELS; level++) {
            List<Employee> employeeLevel = employeeLevels.get(level);
            for (Employee emp: employeeLevel) {
                if (emp.isFree()) { return emp; }
            }
        }
        return null;
    }

    public void dispatchCall(Caller caller) {
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call) {
        Employee emp = getHandlerForCall(call);
        if (emp != null) {
            emp.receiveCall(call);
            call.setHandler(emp);
            int empId = employeeLevels.get(emp.getRank().getValue()).indexOf(emp);
            System.out.println(emp.getRank() + "" + empId + " is online");
        } else {
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank().getValue()).add(call);
        }
    }

    public boolean assignCall(Employee emp) {
        for (int rank=emp.getRank().getValue(); rank>=0; rank--) {
            List<Call> que = callQueues.get(rank);

            if (que.size() > 0) {
                Call call = que.remove(0);
                if (call != null) {
                    emp.receiveCall(call);
                    int empId = employeeLevels.get(emp.getRank().getValue()).indexOf(emp);
                    System.out.println("Re: " + emp.getRank() + "" + empId + " is online");
                    return true;
                }
            }
        }
        return false;
    }
}
