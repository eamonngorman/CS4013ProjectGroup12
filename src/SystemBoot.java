import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SystemBoot {

    private ArrayList<Restaurant> restaurants = new ArrayList<>();
    private HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();
    private HashMap<Integer, Table> tableMap = new HashMap<Integer, Table>(); 

    public void systemBoot(){
        RestaurantChain yum = new RestaurantChain("Yum");
        createRestaurant();
        createTables();
        createPeople();
        createReservation();
        createMenuItems();
        for(Restaurant r: restaurants){
            yum.addRestaurant(r);
        }


    }
    

    public void createMenuItems() {
        //this should have been split into seperate methods, my bad
        HashMap<String, MenuItem> items = new HashMap<String, MenuItem>();
        HashMap<String, MenuCategory> cats = new HashMap<String, MenuCategory>();
        HashMap<String, Menu> menus = new HashMap<String, Menu>();
        File fileItems = new File("src/MenuItems.csv");
        File fileCats = new File("src/MenuCategories.csv");
        File fileMenus = new File("src/Menus.csv");

        try { // create list of all menus
            Scanner in = new Scanner(fileMenus);
            if (in.hasNextLine()) {
                in.nextLine();
            }
            int i = 0;
            while (in.hasNextLine()) {
                String[] dataFields = in.nextLine().split(",");
                String menuName = dataFields[0];
                String restaurantName = dataFields[1] + i;
                Menu m = new Menu(menuName);
                menus.put(restaurantName, m);
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try { // create categories
            Scanner in = new Scanner(fileCats);
            if (in.hasNextLine()) {
                in.nextLine();
            }
            int i = 0;
            while (in.hasNextLine()) {
                String[] dataFields = in.nextLine().split(",");
                String catName = dataFields[0];
                String menuName = dataFields[1] + i;
                MenuCategory c = new MenuCategory(catName);
                cats.put(menuName, c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try { // create items
            Scanner in = new Scanner(fileItems);
            if (in.hasNextLine()) {
                in.nextLine();
            }
            int i = 0;
            while (in.hasNextLine()) {
                String[] dataFields = in.nextLine().split(",");
                String itemName = dataFields[0];
                double cost = Double.parseDouble(dataFields[1]);
                String catName = dataFields[2] + i;
                MenuItem item = new MenuItem(itemName, cost);
                items.put(catName, item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, MenuCategory> cat : cats.entrySet()) {
            String catName = cat.getValue().getCategoryName();
            for (Map.Entry<String, MenuItem> item : items.entrySet()) {
                String keyCatName = item.getKey();
                keyCatName = keyCatName.substring(0, keyCatName.length() - 1);
                if (catName.equals(keyCatName)) {
                    cat.getValue().addMenuItem(item.getValue());
                }
            }
        }

        for (Map.Entry<String, Menu> m : menus.entrySet()) {
            String menuName = m.getValue().getMenuName();
            for (Map.Entry<String, MenuCategory> cat : cats.entrySet()) {
                String keyMenuName = cat.getKey();
                keyMenuName = keyMenuName.substring(0, keyMenuName.length() - 1);
                if (menuName.equals(keyMenuName)) {
                    m.getValue().addCategory(cat.getValue());
                }
            }
        }

        for (Restaurant r : restaurants) {
            String restName = r.getName();
            for (Map.Entry<String, Menu> m : menus.entrySet()) {
                String keyRestName = m.getKey();
                keyRestName = keyRestName.substring(0, keyRestName.length() - 1);
                if (restName.equals(keyRestName)) {
                    r.addMenu(m.getValue());
                }
            }
        }
    }

    public void createTables() {
        try {
            File file = new File("src/Tables.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");
                int restaurantId = Integer.parseInt(dataFields[0]);
                int tableNum = Integer.parseInt(dataFields[1]);
                int tableCapacity = Integer.parseInt(dataFields[2]);
                Table table = new Table(tableNum, tableCapacity);
                tableMap.put(table.getTableNum(), table);
                // Have to add these tables to their restaurants!!!!!!!!!!!!!!!!!!!!
                for (Restaurant restaurant: restaurants){
                    if (restaurant.getRestaurantId() == restaurantId){
                        restaurant.getTables().add(table);
                    }
                }
            }
            } catch (IOException e){
                e.printStackTrace();
            }

        }


    public void createPeople() {
        try {
            File file = new File("src/PersonDetails.csv");
            Scanner input = new Scanner(file);
            if (input.hasNextLine()){
                input.nextLine();
            }
            while (input.hasNext()) {
                String[] dataFields = input.nextLine().split(",");

                String name = dataFields[0];
                String username = dataFields[2];
                int accessLevel = Integer.parseInt(dataFields[1]);
                String restaurantName = dataFields[4];
                // Add these to the specific restaurant!!!!!!!!!!!!!!!!!!!!!!
                Person person;
                if (accessLevel == 0) {
                    Customer customer = new Customer(name);
                    person = (Person) customer;
                } else if (accessLevel == 1) {
                    FOHStaff fohStaff = new FOHStaff(name);
                    person = (Person) fohStaff;
                } else if (accessLevel == 2) {
                    Waiter waiter = new Waiter(name);
                    person = (Person) waiter;
                } else if (accessLevel == 3) {
                    Chef chef = new Chef(name);
                    person = (Person) chef;
                } else {
                    Manager manager = new Manager(name);
                    person = (Person) manager;
                }
                for (Restaurant r : restaurants) {
                    if (r.getName() == restaurantName) {
                        r.getPeople().put(username, person);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public void createReservation() {

        File fileReservation = new File("src/Reservations.csv");

        try { // create list of all menus
            Scanner in = new Scanner(fileReservation);
            if (in.hasNextLine()) {
                in.nextLine();
            }
            while (in.hasNextLine()) {
                String[] dataFields = in.nextLine().split(",");
                int custId = Integer.parseInt(dataFields[5]);
                Customer c = customerMap.get(custId);
                int tableNum = Integer.parseInt(dataFields[4]);
                Table t = tableMap.get(tableNum);

                this.restaurants.add();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createRestaurant() {

        File fileRestaurant = new File("src/Restaurants.csv");

        try {
            Scanner in = new Scanner(fileRestaurant);
            if (in.hasNextLine()) {
                in.nextLine();
            }
            while (in.hasNextLine()) {
                String[] dataFields = in.nextLine().split(",");
                String restuarantName = dataFields[0];
                Restaurant r = new Restaurant(restuarantName);
                this.restaurants.add(r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LocalDateTime stringToDate(String date){
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime formattedDate = LocalDateTime.parse(date, formatter);

        return formattedDate;
    }
}
