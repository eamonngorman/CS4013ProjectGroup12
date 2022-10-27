import java.time.LocalDateTime;

public class Customer extends Person{

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void searchForAvailableTable(LocalDateTime time){


    }

    public void reserveTable(LocalDateTime date, int numPeople, int tableNum){
        String name = Customer.super.getName();
        String phoneNumber = Customer.super.getPhoneNumber();
        new Reservation(name, date, phoneNumber, numPeople, tableNum);
        // Set table's isReserved to true
    }

    public void cancelReservation(){
        //delete Reservation object and free table
    }
}
