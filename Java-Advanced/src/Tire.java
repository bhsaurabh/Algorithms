import java.io.Serializable;

/**
 * Describes a Tire object
 */
public class Tire implements Serializable {
    private String manufacturer;
    private float radius;

    /**
     * Constructor initialises the Tire object
     *
     * @param _manufacturer is the name of the tire manufacturer
     * @param _radius is the radius of the tire
     */
    public Tire(String _manufacturer, float _radius) {
        manufacturer = _manufacturer;
        radius = _radius;
    }

    /**
     * Returns a String representation of the Tire object
     *
     * @return String representation of the Tire object
     */
    public String toString() {
        return (manufacturer + ": " + radius);
    }
}