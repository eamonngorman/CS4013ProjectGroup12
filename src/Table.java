public class Table {
    private int tableNo;
    private int tableCounter = 1;

    //private boolean isReserved;
    private boolean isAvailable;
    private int canSeatXCustomers;

    Table(int tableNum, int canSeatXCustomers){
        
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

    public String toString(){
        
        String print = "Table: " + getTableNo() + "\n" +
        "Can seat: " + getNumSeats() + "\n";

        return print;
    }
}
