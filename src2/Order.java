import java.util.ArrayList;

public class Order {

    private int orderId;
    private ArrayList<MenuItem> itemsInOrder;
    private double totalCost;
    private double tip;
    private boolean isPaid;

    Order() {
        this.orderId = 123; //need way to create unique id....  could do random number. add it to arraylist and whenever creating new order id check if its in the arraylist. would create unneccery clog though
        this.itemsInOrder = new ArrayList<MenuItem>();
        this.totalCost = 0;
    }

    public void setTip(double tip){
        this.tip = tip;
    }
    public void setPaid(boolean paid){
        isPaid = paid;
    }

    public int getOrderId() {
        return orderId;
    }

    public ArrayList<MenuItem> getItems() {
        return itemsInOrder;
    }

    public double getTotal() {
        return totalCost;
    }

    public void addToOrder(MenuItem item) {
        itemsInOrder.add(item);
        totalCost += item.getItemCost();
    }

    public void removeFromOrder(MenuItem item) {
        itemsInOrder.remove(item);
        totalCost -= item.getItemCost();
    }

    public void printBill (){  //method to print the bill. will only show tip after the bill has been paid
        double beforeTip = totalCost;
        totalCost += tip;
        System.out.println("Yum Restaurant");
        System.out.println(itemsInOrder);
        System.out.println("Total: " + beforeTip);
        if (isPaid == true){
            System.out.println("Tip: " + tip);
            System.out.println("Grand Total: " + totalCost);
        }
    }
}
