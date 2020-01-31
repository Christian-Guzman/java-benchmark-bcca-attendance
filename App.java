import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<StudentCheckIn> entrys = load();

        StudentCheckIn entry = start();
        entrys.add(entry);
        save(entrys);

    }

    public static StudentCheckIn start() {
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Date (day/month/year): ");
        String date = in.nextLine();
        System.out.print("Time (hour:min): ");
        String time = in.nextLine();
        System.out.print(name + " checked in at " + time + " on " + date);
        return new StudentCheckIn(name, date, time);
    }

    public static ArrayList<StudentCheckIn> load() {
        try {
            FileInputStream fileStream = new FileInputStream("entrys.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<StudentCheckIn> entrys = (ArrayList<StudentCheckIn>) os.readObject();
            os.close();
            return entrys;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<StudentCheckIn>();
        }
    }

    private static void save(ArrayList<StudentCheckIn> entrys) {
        // try {
        // FileOutputStream fileOutput = new FileOutputStream("entrys.ser");
        // ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);
        // objectOut.writeObject(entrys);
        // objectOut.close();
        // } catch (IOException ex) {
        // System.out.println("IT DIDN'T SAVE FIX IT");
        // }
        try {
            String fileName = "entry.ser";
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(entrys);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved to " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}