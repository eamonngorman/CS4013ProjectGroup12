import java.time.LocalDateTime;
import java.util.ArrayList;

public class Customer extends Person{

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<Table> searchForAvailableTable(LocalDateTime time, int partySize){

        ArrayList<Table> placeholder = new ArrayList<Table>();
        return placeholder;
    }

    public void reserveTable(LocalDateTime date, int numPeople, int tableNum){
        String name = Customer.super.getName();
        String phoneNumber = Customer.super.getPhoneNumber();
        new Reservation(name, date, phoneNumber, numPeople, tableNum);
        // Set table's isReserved to true
    }

    public void cancelReservation(int reservationId){
        //delete Reservation object and free table
    }
}
