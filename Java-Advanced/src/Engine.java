import java.io.Serializable;

/**
 * Describes a car engine
 */
public class Engine implements Serializable {
    private int lotNum;
    private String manufacturer;
    private int numCylinders;

    /**
     * Constructor initialises the Engine object
     *
     * @param _lotNum is the lot number (unique) of the engine
     * @param _manufacturer is the name of the Engine manufacturer
     * @param _numCylinders is the number of cylinders this engine has
     */
    public Engine(int _lotNum, String _manufacturer, int _numCylinders) {
        lotNum = _lotNum;
        manufacturer = _manufacturer;
        numCylinders = _numCylinders;
    }

    /**
     * Returns a String representation of the Engine object
     *
     * @return a String representation of the Engine object
     */
    public String toString() {
        return (lotNum + ": " + manufacturer + " has " + numCylinders + " cylinders.");
    }
}