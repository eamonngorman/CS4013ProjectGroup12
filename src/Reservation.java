import java.time.LocalDateTime;

public class Reservation {
    private static int count = 0; //what is this for

    private int reservationId;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private Table table;
    private Customer customer;
    private int numPeople;

    public Reservation(Table table, Customer customer) {
        this.table = table;
        this.customer = customer;
    }

    public Reservation(LocalDateTime startTime, Customer customer, int numPeople, Table table) {
        this.startTime = startTime;
        this.finishTime = startTime.plusHours(2);
        this.customer = customer;
        this.table = table;
        //this.phoneNumber = phoneNumber;
        this.numPeople = numPeople;
        //this.tableNum = tableNum;
        // The following code might be error prone, we may have to protect against errors like reservations having the same id
        this.reservationId = ++count;
    }

    public LocalDateTime getTimeStart() {
        return startTime;
    }

    public LocalDateTime getTimeFinish() {
        return finishTime;
    }

    public void sendReminderToCustomer() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getstartTime() {
        return startTime;
    }

    public int getReservationId() {
        return reservationId;
    }

    public boolean isAvailable(Reservation reservationToCheck){
        if(table.equals(reservationToCheck.table)){
            return false;
        } else if (reservationToCheck.startTime.compareTo(startTime) == 0 ||
                    reservationToCheck.startTime.compareTo(startTime) == -1){
            return false;
        } else if (reservationToCheck.finishTime.compareTo(finishTime) == 0 ||
        reservationToCheck.finishTime.compareTo(finishTime) == 1){
            return false;
        } else {
            return true;
        }
    }

    public void changeTableStatus() {
        // 1 hour(or more suitable time interval) before table is due to have a
        // reservation turn it's isAvailable variable from true to false
    }
}
