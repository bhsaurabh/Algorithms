/**
 * Created by saurabh on 5/1/14.
 */
import java.io.*;

public class CarDeserializer {
    public static void main(String[] args) {
        Object obj;
        try {
            FileInputStream fstream = new FileInputStream("car.ser");
            ObjectInputStream istream = new ObjectInputStream(fstream);
            obj = istream.readObject();
            istream.close();
            Car car = (Car) obj;
            System.out.println(car.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error during reading objects.");
            e.printStackTrace();
        }
    }
}
