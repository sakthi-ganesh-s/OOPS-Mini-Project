
package carwash;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarWashApp extends JFrame {
    private JTextField nameField, carField;
    private JComboBox<String> packageBox;
    private BookingManager manager = new BookingManager();

    public CarWashApp() {
        setTitle("Car Wash Booking System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Customer Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Car Number:"));
        carField = new JTextField();
        add(carField);

        add(new JLabel("Select Package:"));
        String[] packages = {"Basic - ₹200", "Deluxe - ₹350", "Premium - ₹500"};
        packageBox = new JComboBox<>(packages);
        add(packageBox);

        JButton bookBtn = new JButton("Book Now");
        JButton adminBtn = new JButton("Admin View");
        add(bookBtn);
        add(adminBtn);

        bookBtn.addActionListener(e -> bookService());
        adminBtn.addActionListener(e -> viewBookings());
    }

    private void bookService() {
        String name = nameField.getText();
        String car = carField.getText();
        String pack = (String) packageBox.getSelectedItem();

        if (name.isBlank() || car.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        Booking b = new Booking(name, car, new CarWashPackage(pack, 0, ""));
        manager.addBooking(b);
        JOptionPane.showMessageDialog(this, "Booking Successful!");
    }

    private void viewBookings() {
        String pwd = JOptionPane.showInputDialog("Enter Admin Password:");
        if (!"admin123".equals(pwd)) {
            JOptionPane.showMessageDialog(this, "Access Denied!");
            return;
        }

        java.util.List<String> bookings = manager.getAllBookings();
        JOptionPane.showMessageDialog(this, String.join("\n", bookings));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarWashApp().setVisible(true));
    }
}
