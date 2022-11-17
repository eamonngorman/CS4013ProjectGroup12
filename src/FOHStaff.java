import java.util.ArrayList;

public class FOHStaff extends Staff{

    public void seatCustomers(Table table){
        table.setCurrentlyAvailable(false);
    }

    private void showAvailableTables() {
        ArrayList<Table> availableTables = new ArrayList<Table>();
        for (Table table : Restaurant.getTables()) {
            if (table.isCurrentlyAvailable()){
                availableTables.add(table);
            }
        }
        System.out.println(availableTables);

    }
}
