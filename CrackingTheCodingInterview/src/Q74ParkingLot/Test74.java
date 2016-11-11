package Q74ParkingLot;

import java.util.Random;

/**
 * Created by ziwen on 08/11/2016.
 */
public class Test74 {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle v = null;
        while (v == null || lot.parkVehicle(v)) {
            lot.print();
            Random random = new Random();
            int r = random.nextInt(11);
            if (r < 2) {
                v = new Bus();
            } else if (r < 4) {
                v = new Motorcycle();
            } else {
                v = new Car();
            }
            System.out.print("\nParking a ");
            v.print();
            System.out.println("");
        }
        System.out.println("Parking failed. Final state: ");
        lot.print();;
    }
}
