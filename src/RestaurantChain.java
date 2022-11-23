import java.util.ArrayList;

public class RestaurantChain {
    private ArrayList<Restaurant> restaurants;
    private String chainName;

    public RestaurantChain(String name){
        this.restaurants = new ArrayList<Restaurant>();
        this.chainName = name;
    }
    public RestaurantChain(){

    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
