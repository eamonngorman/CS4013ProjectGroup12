import java.util.ArrayList;

public class Restaurant {
    private String location;
    private Menu menu;
    // private int[] restaurantTables; This mightn't be needed anymore
    private  ArrayList<Table> notInUsetables;
    private  ArrayList<Table> inUseTables;
    // Wrapper class conversion might be needed for interaction with Staff.staffId
    private ArrayList<Integer> restaurantStaff;
    private ArrayList<Bill> restaurantBills;
    // Maybe restaurantOrders should be a map for ease of traversal and finding specific Orders to add FoodItems to?
    private static ArrayList<Order> restaurantOrders;
    private ArrayList<Reservation> reservations;

    Restaurant (String location){
        this.location = location;
        this.menu = new Menu();
        this.notInUsetables = new ArrayList<Table>();
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<Order> getRestaurantOrders() {
        return restaurantOrders;
    }

    public ArrayList<Bill> getRestaurantBills() {
        return restaurantBills;
    }

    public ArrayList<Reservation> getReservations() {
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

    
}
