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

    public RestaurantChain(String name, ArrayList<Restaurant> restaurants){
        this.chainName = name;
        this.restaurants = restaurants;
    }
    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(Restaurant r){
        restaurants.add(r);
    }
}
