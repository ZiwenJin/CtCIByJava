/**
 * Created by ziwen on 8/4/16.
 */
enum Mobile {
    a(200, 20), b(100, 10), c(50, 5);

    int xx;
    int yy;
    Mobile(int x, int y) {
        xx = x;
        yy = y;
    }

    int showXX() {
        return xx;
    }
    int showYY() {
        return yy;
    }

    void setxx(int x) {
        xx = x;
    }
}

public class RootTest {
    public static void main(String[] args) {
        for (Mobile m: Mobile.values()) {
            System.out.println(m.name() + ", " + m.ordinal() + ", " + m.showXX() + ", " + m.showYY());
        }

        Mobile m = Mobile.a;
        m = Mobile.b;
        System.out.println(m.name() + ", " + m.showXX() + ", " + m.showYY());

        m.setxx(1);
        System.out.println(m.name() + ", " + m.showXX() + ", " + m.showYY());

        switch (m) {
            case a: System.out.println("a");
            case b: System.out.println("b"); break;
            case c: System.out.println("c");
        }
    }
}
