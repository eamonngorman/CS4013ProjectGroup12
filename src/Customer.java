import java.time.LocalDateTime;
import java.util.ArrayList;

public class Customer extends Person{

    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<Table> searchForAvailableTable(LocalDateTime time, int partySize){
        // This function only checks current availability,
        // we have to figure out a way to have tables availability dependent on timeslots

        ArrayList<Table> availableSuitableTables = new ArrayList<Table>();
        for (Table table : Restaurant.getTables()){

            //Possible issue with parties selecting a table that is way too big for
            // their party size maybe we should implement something to prevent this?

            if (table.isAvailable() && table.getNumSeats() >= partySize){
                availableSuitableTables.add(table);
            }
        }
        return availableSuitableTables;
    }

    public void reserveTable(LocalDateTime date, int numPeople, int tableNum){
        String name = Customer.super.getName();
        String phoneNumber = Customer.super.getPhoneNumber();
        new Reservation(name, date, phoneNumber, numPeople, tableNum);
        // Set table's isReserved to true
    }

    public void cancelReservation(int reservationId){
        //deletes Reservation object
        for (Reservation reservation : Restaurant.getReservations()){
            if (reservation.getReservationId() == reservationId){
                Restaurant.getReservations().remove(reservation);
                reservation = null;
            }
        }

        //Still have to free up the table. We need to link the Table and Reservation class together somehow.
    }

    public void payBill(Bill bill, boolean cashOrCredit, boolean isPaid){
        if (isPaid){
            bill.setPaid(true);
            bill.setCashOrCredit(cashOrCredit);
        }
    }

    public void addGratuity(Bill bill, double gratuity){
        bill.setGratuity(gratuity);
        bill.setBillTotal(bill.getBillTotal() + gratuity);
    }
}
