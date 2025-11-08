package carwash;
import java.io.*;
import java.util.*;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();
    private static final String FILE_NAME = "bookings.txt";

    public void addBooking(Booking b) {
        bookings.add(b);
        saveBookings();
    }

    public void saveBookings() {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Booking b : bookings) {
                out.println(b.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllBookings() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

