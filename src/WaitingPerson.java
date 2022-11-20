public class WaitingPerson extends Staff{

    WaitingPerson(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    // made this return the order number for tracking purposes. Maybe printing it to the screen would be sufficient?
    public int createOrder(int tableNum){
        Order newOrder = new Order(tableNum);
        // Restaurant.getRestaurantOrders().add(newOrder);
        return newOrder.getOrderNumber();

    }
    public void deleteOrder(int orderNumber) {
        Restaurant.getRestaurantOrders().remove(orderNumber);
    }
    public void addItemToOrder(int orderNumber, FoodItem foodItem){
        Restaurant.getRestaurantOrders().get(orderNumber).addItemToOrder(foodItem);

    }
    public void deleteItemFromOrder(int orderNumber, FoodItem foodItem){
        Restaurant.getRestaurantOrders().get(orderNumber).removeItemFromOrder(foodItem);

    }

}
