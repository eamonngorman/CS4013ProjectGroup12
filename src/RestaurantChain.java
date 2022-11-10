import java.util.ArrayList;
import java.util.Hashtable;

public class RestaurantChain {
    //Hashtable<String, Restaurant> yumRestaurants = new Hashtable<String, Restaurant>();
    ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    public double calculatePaidBills(int restaurantNum){
        double income = 0;

        for(Bill bill: restaurants.get(restaurantNum).getRestaurantBills()){
            if (bill.isPaid()){
                income += bill.getBillTotal();
            }
        }
        return income;
    }
}
