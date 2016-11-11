package Q72CallCenter;

/**
 * Created by ziwen on 08/11/2016.
 */
public class Test72 {
    public static void main(String[] args) {
        CallHandler ch = new CallHandler(10, 4, 2);

        /*
        Call[] callList = new Call[20];
        for (int i=0; i<20; i++) {
            callList[i] = new Call(new Caller(i, "Ziwen"+i));
        }
        for (Call call: callList) {
            ch.dispatchCall(call);
        }
        */

        for (int i=0; i<11; i++) {
            ch.dispatchCall(new Caller(i, "Ziwen"+i));
        }

        ch.employeeLevels.get(0).get(0).callCompleted();
        ch.employeeLevels.get(0).get(1).escalateAndReassing();
    }
}
