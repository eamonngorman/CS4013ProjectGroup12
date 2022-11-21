import java.time.LocalDateTime;
import java.util.ArrayList;

public class Resturant {

    private String name;
    private ArrayList<Menu> menus;
    private ArrayList<Table> tables;
    private ArrayList<Reservation> reservations;
    private ArrayList<Order> orders;
    private ArrayList<Person> people;

    Resturant(String name) {
        this.name = name;
        this.menus = new ArrayList<Menu>();
        this.tables = new ArrayList<Table>();
        this.reservations = new ArrayList<Reservation>();
        this.orders = new ArrayList<Order>();
        this.people = new ArrayList<Person>();
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

    public ArrayList<Table> getTables() {
        return tables;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
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

    public void removeTable(Table t) {
        tables.remove(t);
    }

    public void addReservation(Reservation r) {

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
            if (r.getStartTime().isAfter(start) && r.getStartTime().isBefore(finish)) {
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
}
