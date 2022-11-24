import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurant {

    private String name;
    private int restaurantId;
    private ArrayList<Menu> menus;
    private ArrayList<Table> tables;
    private ArrayList<Reservation> reservations;
    private ArrayList<Order> orders;
    private HashMap<String, Person> people;

    Restaurant(){
    }

    Restaurant(String name) {
        this.name = name;
        this.menus = new ArrayList<Menu>();
        this.tables = new ArrayList<Table>();
        this.reservations = new ArrayList<Reservation>();
        this.orders = new ArrayList<Order>();
        this.people = new HashMap<String, Person>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }


    public HashMap<String, Person> getPeople(){
        return people;
    }

    public Person getPerson(String userName){
        return people.get(userName);
    }

    //not nessacary, created a general object.toArray instead
    // public Table[] getTablesArr() {
    //     ArrayList<Table> temp = this.tables;
    //     Table[] tablesArr = new Table[temp.size()];
    //     for(Table t: temp){
    //         tablesArr[temp.indexOf(t)] = t;
    //     }

    //     return tablesArr;
    // }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Reservation> getReservationByCustomers(Customer cust) {
        ArrayList<Reservation> resByCust = new ArrayList<Reservation>();
        for(Reservation r: reservations){
            if(r.getCustomer() == cust){
                resByCust.add(r);
            }
        }
        return resByCust;
    }

    public ArrayList<Reservation> getReservationByDay(LocalDate day) {
        ArrayList<Reservation> resByDay = new ArrayList<Reservation>();
        for(Reservation r: reservations){
            if(r.getStartTime()..gday){
                resByDay.add(r);
            }
        }
        return resByDay;
    }    

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addMenu(Menu m) {
        menus.add(m);
    }

    public void removeMenu(Menu m) {
        menus.remove(m);
    }

    public void addTable(Table t) {
        tables.add(t);
    }
    public void addPeople(Person p, String s){
        people.put(s,p);
    }

    public void removeTable(Table t) {
        tables.remove(t);
    }

    public void removeOrder(Order o) { 
        orders.remove(o);
    
    }
    public void removePeople(Person p){
        people.remove(p);
    }


    public void addReservation(Reservation r) {

        //make boolean return so that it can throw an error
        int flag = 0;

        for (Reservation reservation : reservations) {
            if (!reservation.isAvailable(r)) {
                flag = 1;
            }
        }

        if (flag == 0) {
            reservations.add(r);
        }
    }

    public void removeReservation(Reservation r) {
        reservations.remove(r);
    }

    public ArrayList<Table> getBookedTables(LocalDateTime start, LocalDateTime finish) {
        ArrayList<Table> bookedTable = new ArrayList<Table>();

        for (Reservation r : reservations) {
            if (r.getStartTime().compareTo(start) >= 0 &&
            r.getStartTime().compareTo(finish) <= 0) {
                bookedTable.add(r.getTable());
            }
        }

        return bookedTable;

    }

    public ArrayList<Table> getFreeTables(int partySize, LocalDateTime start, LocalDateTime finish) {
        ArrayList<Table> inUse = getBookedTables(start, finish);
        ArrayList<Table> temp = tables;
        temp.removeAll(inUse);
        ArrayList<Table> freeTables = new ArrayList<Table>();

        for (Table t : temp) {
            if (t.getCanSeat() >= partySize) {
                freeTables.add(t);
            }
        }

        return freeTables;
    }

    public ArrayList<Table> getFreeTables(int partySize, LocalDateTime start) {

        ArrayList<Table> inUse = getBookedTables(start, start.plusMinutes(Reservation.getReservationMinutes()));
        ArrayList<Table> temp = tables;
        temp.removeAll(inUse);
        ArrayList<Table> freeTables = new ArrayList<Table>();

        for (Table t : temp) {
            if (t.getCanSeat() >= partySize) {
                freeTables.add(t);
            }
        }

        return freeTables;
    }

    @Override
    public String toString() {
        return name;
    }
}
