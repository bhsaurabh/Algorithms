import java.io.Serializable;

/**
 * Describes a Car object
 */
public class Car implements Serializable {
    private Engine engine;
    private Tire[] tires;

    public Car() {
        engine = new Engine(1000, "Bugatti", 16);
        tires = new Tire[4];
        for (int i = 0; i < 4; i++) {
            tires[i] = new Tire("Dunlop", 100);
        }
    }

    public String toString() {
        return ("Engine: " + engine.toString() + "\nTire: " + tires[0].toString());
    }
}