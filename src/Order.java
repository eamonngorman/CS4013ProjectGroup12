/*import java.util.ArrayList;

public class Order {
    private static int count = 0;
    private int orderNumber;
    int deleteOrder;
    private int tableNum;
    private ArrayList<FoodItem> items;
    private String orderStatus;
    private final String[] statuses = {"Waiting for preparation", "Being prepared", "Cooking", "Ready", "Served"};


    public Order(int tableNum){
        this.orderNumber = ++count;
        this.orderStatus = statuses[0];
        this.tableNum = tableNum;
        // I'm assuming we're leaving the first entry in tables as null for convenience
        Restaurant.getTables().get(tableNum).setCurrentOrder(this);
        Restaurant.getRestaurantOrders().put(this.orderNumber, this);
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public ArrayList<FoodItem> getOrder() {
        return items;
    }

    public void addItemToOrder(FoodItem item) {
        this.items.add(item);
    }

    public void removeItemFromOrder(FoodItem item) {
        this.items.remove(item);
    }
}
*/