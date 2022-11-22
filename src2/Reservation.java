import java.time.LocalDateTime;

public class Reservation {

    private Customer customer;
    private Table table;
    private int numOfPeople; // not needed?
    private LocalDateTime startTime;
    private static int reservationMinutes = 90;
    private LocalDateTime finishTime;

    Reservation(Customer customer, Table table, int numOfPeople, LocalDateTime startTime) {
        this.customer = customer;
        this.table = table;
        this.numOfPeople = numOfPeople;
        this.startTime = startTime;
        this.finishTime = startTime.plusMinutes(reservationMinutes);
    }

    Reservation(Table table, LocalDateTime startTime) {
        this.table = table;
        this.startTime = startTime;
        this.finishTime = startTime.plusMinutes(reservationMinutes);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Table getTable() {
        return table;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public static int getReservationMinutes() {
        return reservationMinutes;
    }

    public void setReservationMinutes(int minutes) {
        this.reservationMinutes = minutes;
    }

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

    
}