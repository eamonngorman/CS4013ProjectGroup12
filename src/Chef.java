public class Chef extends Staff{

/* Need to set the potential statuses the chef can change to, so
they can't change the status to "Served" as that should only
 be done by the WaitingPerson */

    public void changeOrderStatus(Order order, int statusCode){
        order.setOrderStatus(order.getStatuses()[statusCode]);
    }
}
