import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CarTest {
    public static void main(String[] args) {
        // create a Car object
        Car car = new Car();
        System.out.println(car.toString());

        // Serialise
        try {
        FileOutputStream fstream = new FileOutputStream("car.ser");
        ObjectOutputStream ostream = new ObjectOutputStream(fstream);
        ostream.writeObject(car);
        ostream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred while writing this object");
            e.printStackTrace();
        }
    }
}