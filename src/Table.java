public class Table {
    private int tableNo;
    private int tableCounter = 1;

    //private boolean isReserved;
    private boolean isAvailable;
    private int canSeatXCustomers;

    // Should this be set to null after the bill is paid?
    private Order currentOrder;

    Table(int canSeatXCustomers){
        
        this.canSeatXCustomers = canSeatXCustomers;
        this.tableNo = tableCounter;
        tableCounter++;
    }

    public int getTableNo(){
        return tableNo;
    }

    public int getNumSeats(){
        return canSeatXCustomers;
    }

    public void isAvailable(){
        this.isAvailable = true;
    }

    public void isReserved(){
        this.isAvailable = false;
    }

    public boolean checkAvailability(){
        return isAvailable;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    
    public String toString(){
        
        String print = "Table: " + getTableNo() + "\n" +
        "Can seat: " + getNumSeats() + "\n";

        return print;
    }
}
