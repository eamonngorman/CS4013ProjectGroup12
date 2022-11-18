import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    private String location;
    private ArrayList<Menu> menu;
    private static ArrayList<Table> tables;
    private static ArrayList<Staff> staff;
    private static ArrayList<Customer> customers;
    private ArrayList<Bill> bills;
    private static ArrayList<Reservation> reservations;
    // Maybe restaurantOrders should be a map for ease of traversal and finding specific Orders to add FoodItems to?
    private static HashMap<Integer, Order> restaurantOrders;

    Restaurant(String location) {
        this.location = location;
        this.menu = new ArrayList<Menu>();
        this.tables = new ArrayList<Table>();
        this.staff = new ArrayList<Staff>();
        this.bills = new ArrayList<Bill>();
    }

    public static ArrayList<Table> getTables() {
        return tables;
    }

    public static HashMap<Integer, Order> getRestaurantOrders() {
        return restaurantOrders;
    }

    public ArrayList<Bill> getRestaurantBills() {
        return bills;
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addTable(Table t) {
        tables.add(t);
    }

    public ArrayList<Table> showAvailableTables(int partySize) {

        ArrayList<Table> availableTables = new ArrayList<Table>();

        for (Table t : notInUsetables) {
            if (t.getNumSeats() >= partySize) {
                availableTables.add(t);
            }
        }

        return availableTables;
    }

    public void sendReservationReminders() {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationDate().minusDays(1).isBefore(LocalDateTime.now())) {
                textReminder(reservation.getCustomer().getPhoneNumber());
            }
        }
    }

    public void textReminder(String phoneNumber) {
        // sends a textReminder to this phoneNumber
    }

    public static ArrayList<Staff> getStaff() {
        return staff;
    }
}
