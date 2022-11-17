public class WaitingPerson extends Staff{

    // made this return the order number for tracking purposes. Maybe printing it to the screen would be sufficient?
    public int createOrder(int tableNum){
        Order newOrder = new Order(tableNum);
        Restaurant.getRestaurantOrders().add(newOrder);
        return newOrder.getOrderNumber();

    }
    public void addItemToOrder(int orderNumber, FoodItem foodItem){
        // Waiting to turn restaurantOrders into a map for ease of locating specific Orders to add FoodItems to

    }
    public void deleteItemFromOrder(int orderNumber, FoodItem foodItem){
        for (Order order: Restaurant.getRestaurantOrders()){
            if (order.getOrderNumber() == orderNumber){
                for (FoodItem item : order.getOrder()){
                    if (item == foodItem){
                        order.getOrder().remove(item);
                    }
                }
            }
        }
    }
}
