import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {
    private String location;
    private Menu menu;
    // private int[] restaurantTables; This mightn't be needed anymore
    private static ArrayList<Table> notInUsetables;
    private  ArrayList<Table> inUseTables;
    // Wrapper class conversion might be needed for interaction with Staff.staffId
    private ArrayList<Integer> restaurantStaff;
    private ArrayList<Bill> restaurantBills;
    // Maybe restaurantOrders should be a map for ease of traversal and finding specific Orders to add FoodItems to?
    private static HashMap<Integer, Order> restaurantOrders;
    private static ArrayList<Reservation> reservations;

    Restaurant (String location){
        this.location = location;
        this.menu = new Menu();
        this.notInUsetables = new ArrayList<Table>();
    }

    public static ArrayList<Table> getTables() {
        ArrayList<Table> tables = new ArrayList<>();
        return tables;
    }

    public static HashMap<Integer, Order> getRestaurantOrders() {
        return restaurantOrders;
    }

    public ArrayList<Bill> getRestaurantBills() {
        return restaurantBills;
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addTable(Table t){
        //Table t = new Table(tablenum, size);
        notInUsetables.add(t);
    }

    public ArrayList<Table> showAvailableTables(int partySize){
       
        ArrayList<Table> availableTables = new ArrayList<Table>();

        for(Table t: notInUsetables){
            if(t.getNumSeats() >= partySize){
                availableTables.add(t);
            }
        }

        return availableTables;
    }

    public void sendReservationReminders(){
        for (Reservation reservation : reservations){
            if (reservation.getReservationDate().minusDays(1).isBefore(LocalDateTime.now())){
                textReminder(reservation.getCustomer().getPhoneNumber());
            }
        }
    }

    public void textReminder(String phoneNumber){
        // sends a textReminder to this phoneNumber
    }

    
}
