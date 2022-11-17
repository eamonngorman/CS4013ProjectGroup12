import java.time.LocalDateTime;

public class Reservation {
    private String reservationName;
    private static int count = 0;

    private int reservationId;
    private LocalDateTime reservationDate;
    private Table table;
    private Customer customer;
    //private String phoneNumber; //this should be Customer object, all relevent info will then be from Customer
    private int numPeople;
    //private int tableNum; //this should be Table object, selected from list. Table object will have this info

    public Reservation(int reservationId, Table t1, Customer c1){
        
    }

    public Reservation(String reservationName, LocalDateTime reservationDate, Customer customer, int numPeople, Table table){
        this.reservationName = reservationName;
        this.reservationDate = reservationDate;
        this.customer = customer;
        this.table = table;
        //this.phoneNumber = phoneNumber;
        this.numPeople = numPeople;
        //this.tableNum = tableNum;
        // The following code might be error prone, we may have to protect against errors like reservations having the same id
        this.reservationId = ++count;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationName() {
        return reservationName;
    }

    public LocalDateTime getTime(){
        return reservationDate;
    }

    public void sendReminderToCustomer(){

    }

    public int getReservationId() {
        return reservationId;
    }

    public void changeTableStatus(){
        // 1 hour(or more suitable time interval) before table is due to have a
        // reservation turn it's isAvailable variable from true to false
    }
}
