import java.util.ArrayList;

public class Order {
    private static int count = 0;
    private int orderNumber;
    private ArrayList<FoodItem> order;
    private String orderStatus;
    private final String[] statuses = {"Waiting for preparation", "Being prepared", "Cooking", "Ready", "Served"};


    public Order(){
        this.setOrderNumber(++count);
        this.orderStatus = statuses[0];

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
        return order;
    }
}
