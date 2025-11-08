

package carwash;

public class Booking {
    private String customerName;
    private String carNumber;
    private CarWashPackage selectedPackage;

    public Booking(String customerName, String carNumber, CarWashPackage selectedPackage) {
        this.customerName = customerName;
        this.carNumber = carNumber;
        this.selectedPackage = selectedPackage;
    }

    @Override
    public String toString() {
        return "Customer: " + customerName + " | Car: " + carNumber + 
               " | Package: " + selectedPackage.getName();
    }
}
