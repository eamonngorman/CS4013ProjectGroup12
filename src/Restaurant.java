import java.util.ArrayList;

public class Restaurant {
    private Menu menu;
    // private int[] restaurantTables; This mightn't be needed anymore
    private  ArrayList<Table> tables;
    // Wrapper class conversion might be needed for interaction with Staff.staffId
    private ArrayList<Integer> restaurantStaff;
    private ArrayList<Bill> restaurantBills;
    private ArrayList<Reservation> reservations;

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<Bill> getRestaurantBills() {
        return restaurantBills;
    }
}
