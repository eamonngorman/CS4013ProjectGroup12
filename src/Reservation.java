import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {

    private Customer customer;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int reservationId;
    private Table table;
    private int numOfPeople; // not needed?
    private LocalDateTime startTime;
    private static int reservationMinutes = 90;
    private LocalDateTime finishTime;
    private String phoneNumber;

    Reservation(Customer customer, Table table, int numOfPeople, LocalDateTime startTime, String phoneNumber){
        this.reservationId = count.incrementAndGet();
        this.customer = customer;
        this.table = table;
        this.numOfPeople = numOfPeople;
        this.startTime = startTime;
        this.finishTime = startTime.plusMinutes(reservationMinutes);
        this.phoneNumber = phoneNumber;
    }

    Reservation(Table table) {
        this.reservationId = count.incrementAndGet();
        this.table = table;
        this.startTime = LocalDateTime.now();
        this.finishTime = startTime.plusMinutes(reservationMinutes);
        Customer walkIn = new Customer("Walkin");
        this.customer = walkIn;
    }

    
    /**  
     * <h1>getCustomer()</h1>
     * returns Customer
     * @return Customer
     */
    public Customer getCustomer() {
        return customer;
    }
    

    
    /** 
     * @return Table
     */
    public Table getTable() {
        return table;
    }

    
    /** 
     * @return int
     */
    public int getNumOfPeople() {
        return numOfPeople;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getStartTime() {
        return startTime;
    }

    
    /** 
     * @return LocalDateTime
     */
    public LocalDateTime getFinishTime() {
        return finishTime;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }


    public static int getReservationMinutes() {
        return reservationMinutes;
    }

    
    /** 
     * @return int
     */
    public int getReservationId() {
        return reservationId;
    }

    
    /** 
     * 
     * @param minutes
     */
    public void setReservationMinutes(int minutes) {
        reservationMinutes = minutes;
    }

    
    /** 
     * <h1>isAvailable()</h1>
     * returns true if a reservation can be created
     * take time and table into account
     * @param r
     * @return boolean
     */
    // true = is available
    // false = not available
    public boolean isAvailable(Reservation r) {

        if (r.startTime.compareTo(this.startTime) >= 0 &&
                r.startTime.compareTo(this.finishTime) <= 0) {
            if (this.table.equals(r.table)) {
                return false;
            } 
        }
        return true;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        String s = "Day: " + getStartTime().toLocalDate();
        s += "\nTime: " + getStartTime().toLocalTime();
        s += "\nParty size: " + getNumOfPeople();
        return s;        
    }

    
}