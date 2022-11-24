import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    private static final AtomicInteger count = new AtomicInteger(0);
    private int orderId;
    private ArrayList<MenuItem> itemsInOrder;
    private double totalCost;
    private double gratuity;
    private boolean isPaid;
    private String orderStatus;
    private final String[] statuses = {"Waiting for preparation", "Being prepared", "Cooking", "Ready", "Served"};
    private LocalDate date;
    private char paymentMethod;

    Order(){
        this.orderId = count.incrementAndGet();
        this.orderStatus = statuses[0];
        this.itemsInOrder = new ArrayList<MenuItem>();
        this.totalCost = 0;
        this.date = LocalDate.now();

    }
    public void setPaymentMethod(char method){
        paymentMethod = method;
    }

    public void setGratuity(double gratuity){
        this.gratuity = gratuity;
    }
    public void setPaid(boolean paid){
        isPaid = paid;
    }

    public char getPaymentMethod(){
        return paymentMethod;
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

    /*public void addOrderToCSv() throws IOException {
        StringBuilder line = new StringBuilder();
        String listString = "";
        for (MenuItem m : itemsInOrder){
            listString += m + "; ";
        }
        line.append(orderId + ",");
        line.append(listString + ",");
        line.append(totalCost);
        line.append("\n");
        fileWriter.write(line.toString());
    }*/

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getDate() {
        return date;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public double getGratuity() {
        return gratuity;
    }

    public void printBill(){  //method to print the bill. will only show tip after the bill has been paid
        double beforeTip = totalCost;
        totalCost += gratuity;
        System.out.println("Yum Restaurant");
        System.out.println(itemsInOrder);
        System.out.println("Total: " + beforeTip);
        if (isPaid == true){
            if (gratuity > 0){
                System.out.println("Tip: " + gratuity);
                System.out.println("Grand Total: " + totalCost);
            }
            System.out.println("Bill paid. Thank you for dining at Yum");
        }
    }

    @Override
    public String toString(){
        String str = "";
        for (MenuItem item : itemsInOrder){
            str += (item.toString() + ", ");
        }
        str += ("Total cost: " + totalCost);
        return str;
    }
}
