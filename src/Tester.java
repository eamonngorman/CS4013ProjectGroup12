import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Tester {

    private Scanner in;
    private Person user;
    private Restaurant restaurant;
    private RestaurantChain yum = new RestaurantChain();

    public Tester(RestaurantChain yum) {
        in = new Scanner(System.in);
        this.yum = yum;
    }

    /*
     * for users
     * we can use a hashmap with String userName as the key
     * and Person person as the value
     * this will require storing people in resturant
     */
    public void runStart() {
        boolean more = true;

        while (more) {
            if(restaurant == null) {
                restaurant = getChoice(yum.getRestaurants());
            }
            System.out.println("A)Login  B)Register  Q)uit");
            String command = in.nextLine().toUpperCase();
            CSVReader csvReader = new CSVReader();
            if (command.equals("A")) {
                System.out.println("Username:");
                String userName = in.nextLine();
                System.out.println("Password:");
                String password = in.nextLine();
                if (csvReader.signIn(userName, password)){
                    this.user = restaurant.getPerson(userName);
                    login();
                } else {
                    System.out.println("Username and password were not in the database");
                }
            } else if (command.equals("B")) {
                register();
            } else if (command.equals("Q")) {
                more = false;
            }
        }
    }

    CSVWriter w = new CSVWriter();
    CSVReader csvReader = new CSVReader();

    private void register() {
        String[] details = new String[3];
        System.out.println("Name: ");
        String name = in.nextLine();
        details[0] = name;
        Customer newCustomer = new Customer(name);
        /*System.out.println("Which restaurant do you want to register with?: A) Ardee B) Athleague C) Cavan D) Westport Q) Quit");
        String command = in.nextLine().toUpperCase();
        if(command.equals("A")){
            ;
        }
        if(command.equals("B")){
            ;
        }
        if(command.equals("C")){
            ;
        }
        if(command.equals("D")){
            ;
        }
        if(command.equals("Q")){
            runStart();
        }*/

        System.out.println("Username: ");
        String username = in.nextLine();

        boolean isTaken = csvReader.isUsernameTaken(username);
        if (isTaken){
            System.out.println("Username already in database");
        } else {
            details[1] = username;
            System.out.println("Password: ");
            String password = in.nextLine();
            details[2] = password;
            w.writeNewCustomerToCSV(details, restaurant);

            Person newUser = new Customer(details[0]);
            restaurant.addPeople(newUser, username);
            System.out.println("You have been registered with the username and password above.");

        }

    }

    public void login(){

        String command;

        if (user.getAccessLevel() == 0){ //Customer Menu
            System.out.println("A)Make Reservation  B)Cancel Reservation  Q)uit");
            command = in.nextLine().toUpperCase();

            if(command.equals("A")){
                makeReservation();
            }
            if(command.equals("B")){
                deleteReservationCustomer();
            }
            if(command.equals("Q")){
                runStart();
            }
        }

        if (user.getAccessLevel() == 1){
            System.out.println("A)Make Reservation  B)Cancel Reservation  Q)uit");
            command = in.nextLine().toUpperCase();

            if(command.equals("A")){
                makeReservation();
            }
            if(command.equals("B")){
                deleteReservationStaff();
            }
            if(command.equals("Q")){
                runStart();
            }
        }

        if (user.getAccessLevel() == 2){
            System.out.println("A)Add to Order  B)Remove from Order C)Cancel Order D)Finish Order  Q)uit");
            command = in.nextLine().toUpperCase();
            if(command.equals("A")){
                addItemToOrder();
            }
            if(command.equals("B")){
                removeItemFromOrder();
            }
            if(command.equals("C")){
                deleteOrder();
            }
            if(command.equals("D")){
                finishOrder();
            }
            if(command.equals("Q")){
                runStart();
            }
        }

        if (user.getAccessLevel() == 3){
            System.out.println("A)Update Order  B)See Current Orders  Q)uit");
            command = in.nextLine().toUpperCase();
            if(command.equals("A")){
                updateOrderStatus();
            }
            if(command.equals("A")){
                seeOrders();
            }
            if(command.equals("Q")){
                runStart();
            }
        }

        if (user.getAccessLevel() == 4){
            System.out.println("A)Edit Tables  B)Edit Menus C)Edit Staff D)Calculate Restaurant Income  Q)uit");
            command = in.nextLine().toUpperCase();
            if(command.equals("A")){
                editTables();
            }
            if(command.equals("B")){
                editMenus();
            }
            if(command.equals("C")){
                editStaff();
            }
            if(command.equals("D")){
                calculateRestaurantIncome();
            }
            if(command.equals("Q")){
                runStart();
            }
        }

        if (user.getAccessLevel() == 5){
            System.out.println("A)Edit Restaurants B)Set Name C)Find Restaurant D)Get name Q)uit");
            command = in.nextLine().toUpperCase();
            if(command.equals("A")){
                editRestaurants();
            }
            if(command.equals("Q")){
                runStart();
            }
        }
    }

    private void calculateRestaurantIncome() {

        System.out.println("A)Calculate income from each restaurant  B)Remove from Order C)Cancel Order D)Finish Order  Q)uit");
        String command = in.nextLine().toUpperCase();

        if(command.equals("A")){
            addItemToOrder();
        }
        if(command.equals("B")){
            removeItemFromOrder();
        }
        if(command.equals("C")){
            deleteOrder();
        }
        if(command.equals("D")){
            finishOrder();
        }
        if(command.equals("Q")){
            runStart();
        }
    }


    private void editStaff() {
        System.out.println("A)dd Staff Member  E)dit Staff Member  R)emove Staff member Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("A")){
            System.out.println("Enter Name");
            String name = in.nextLine();
            System.out.println("Enter Username");
            String username = in.nextLine();
            System.out.println("Enter Access Level");
            int accessLevel = in.nextInt();
            Person person = new Person(name, accessLevel);
            restaurant.addPeople(person, username);
        }
        if (command.equals("E")){
            System.out.println("Select a Staff Member to edit");
            Person person = getChoice(restaurant.getPeople());
            editMember(person);
        }
        if (command.equals("R")){
            System.out.println("Select a Staff Member to Remove");
            Person person = getChoice(restaurant.getPeople());
            restaurant.removePeople(person);
        }
        if (command.equals("Q")){
            runStart();
        }
    }
    private void editMember(Person person){
        System.out.println("Edit N)ame A)ccess Level Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("N")){
            System.out.println("Enter Name");
            String name = in.nextLine();
            person.setName(name);
        }
        if (command.equals("A")){
            System.out.println("Enter Access Level");
            int accessLevel = in.nextInt();
            person.setAccessLevel(accessLevel);
        }
        if (command.equals("Q")){
            runStart();
        }

    }

    private void editRestaurants() {
        System.out.println("A)Add Restaurant  B)Edit Restaurant  Q)uit");
        String command = in.nextLine().toUpperCase();
        if(command.equals("A")){
            addRestaurant(); ;
        }
        if(command.equals("B")){
            System.out.print("Set Name");
        }
        if(command.equals("C")) {
            System.out.print("Find Restaurant");
            ArrayList<String> restaurant = new ArrayList<String>();
        }
        if(command.equals("D")){
            System.out.println("Get Name");
        }
        if(command.equals("Q")){
            runStart();
        }



        }


    private void editTables() {
        System.out.println("A)dd R)emove Q)uit");
        String command = in.nextLine().toUpperCase();
        if(command.equals("A")){
            System.out.println("Enter number of seats");
            int numSeats = in.nextInt();
            System.out.println("Enter table number");
            int tabNum = in.nextInt();
            Table table = new Table(tabNum, numSeats);
            restaurant.addTable(table);
        }
        if(command.equals("R")){
            System.out.println("Select a table to remove");
            Table table = getChoice(restaurant.getTables());
            restaurant.removeTable(table);
        }
        if (command.equals("Q")){
            runStart();
        }
    }

    private void editMenus() {
        System.out.println("E)dit menu R)emove menu Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals ("E")){
            System.out.println("Select a menu to edit");
            Menu menus = getChoice(restaurant.getMenus());
            editMenu(menus);
        }
        if (command.equals ("R")){
            System.out.println("Select a menu to remove");
            Menu menus = getChoice(restaurant.getMenus());
            restaurant.removeMenu(menus);
        }
        if (command.equals("Q")){
            runStart();
        }
    }

    private void editMenu(Menu menus){
        ArrayList<MenuCategory> menuCategories = menus.getCategories();
        System.out.println("E)dit category A)dd category R)emove category Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("E")){
            System.out.println("Select a category to edit");
            MenuCategory menuCat = getChoice(menuCategories);
            editCats(menuCat);
        }
        if (command.equals("A")){
            System.out.println("Enter Category Name");
            String cat = in.nextLine();
            MenuCategory menuCat = new MenuCategory(cat);
            menus.addCategory(menuCat);
        }
        if (command.equals("R")){
            System.out.println("Select a category to remove");
            MenuCategory menuCat = getChoice(menuCategories);
            menus.removeCategory(menuCat);
        }
        if (command.equals("Q")){
            runStart();
        }
    }

    private void editCats(MenuCategory menuCat){
        ArrayList<MenuItem> menuItems = menuCat.getMenuItems();
        System.out.println("E)dit Item A)dd Item R)emove Item Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("E")){
            System.out.println("Select an item to edit");
            MenuItem menuItem = getChoice(menuItems);
            editItems(menuItem);
        }
        if (command.equals("A")){
            System.out.println("Enter Item Name");
            String item = in.nextLine();
            System.out.println("Enter Item Price");
            Double price = in.nextDouble();
            MenuItem menuItem = new MenuItem(item, price);
            menuCat.addMenuItem(menuItem);
        }
        if (command.equals("R")){
            System.out.println("Select an item to remove");
            MenuItem menuItem = getChoice(menuItems);
            menuCat.removeMenuItem(menuItem);
        }
        if (command.equals("Q")){
            runStart();
        }
    }

    private void editItems(MenuItem menuItem){
        System.out.println("Change N)ame P)rice Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("N")){
            System.out.println("Enter New Name");
            String name = in.nextLine();
            menuItem.setItemName(name);
        }
        if (command.equals("P")){
            System.out.println("Enter New Price");
            Double price = in.nextDouble();
            menuItem.setItemCost(price);
        }
        if (command.equals("Q")){
            runStart();
        }
    }


    private <T> T getChoice(ArrayList<T> choices) { //getChoice can now work for all arrayList types
        if (choices == null){
            return null;
        }

        if (choices.size() == 0)
            return null;
        while (true) {
            char c = 'A';
            for (T choice : choices) {
                System.out.println(c + ")" + choice.toString());
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }

    private Person getChoice(HashMap<String, Person> hashMap) { //getChoice can now work for all arrayList types
        if (hashMap.size() == 0)
            return null;
        while (true) {
            char c = 'A';
            for (String s : hashMap.keySet()) {
                System.out.println("\n" + c + ") \n" + hashMap.entrySet().toString() + "\n");
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < hashMap.size())
                return hashMap.get(n);
        }
    }

    // ask Eamonn before commenting this out. This is needed for String Arrays
    private String getChoice(String[] choices) {
        if (choices.length == 0)
             return null;
         while (true) {
             char c = 'A';
             for (String choice : choices) {
                 System.out.println("\n" + c + ") \n" + choice.toString() + "\n");
                 c++;
             }
             String input = in.nextLine();
             int n = input.toUpperCase().charAt(0) - 'A';
             if (0 <= n && n < choices.length)
                return choices[n];
    }
    }

    public void makeReservation() {

        String date = in.nextLine();
        System.out.println("What day would you like a reservation? (dd/mm/yyyy)");
        String time = in.nextLine();
        System.out.println("What time would you like your reservation? (hh:mm)");
        String format = date + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime formattedDate = LocalDateTime.parse(format, formatter);

        int people = Integer.parseInt(in.nextLine());
        System.out.println("How many people are coming?");
        Table table =  getChoice(restaurant.getFreeTables(people, formattedDate));

        Reservation r = new Reservation((Customer) user, table, people, formattedDate);
        restaurant.addReservation(r);

    }

    public void addItemToOrder(){
        MenuItem item = selectItem();
        Order selectedOrder = selectOrderFromTable();

        for (Order order : restaurant.getOrders()){
            if (order == selectedOrder){
                order.addToOrder(item);
            }
        }
    }

    public void addRestaurant(){



        System.out.println("What is the name of the new restaurant?: ");
        String name = in.nextLine();
        Restaurant newRestaurant = new Restaurant(name);

        yum.getRestaurants().add(newRestaurant);
    }

    public void removeItemFromOrder(){
        MenuItem item = selectItem();
        Order selectedOrder = selectOrderFromTable();

        for (Order order : restaurant.getOrders()){
            if (order == selectedOrder){
                order.removeFromOrder(item);
            }
        }
    }

    public MenuItem selectItem(){
        ArrayList<Menu> menus = restaurant.getMenus();
        System.out.println("Select menu to add item from: ");
        Menu selectedMenu = getChoice(menus);

        ArrayList<MenuCategory> menuCategories = selectedMenu.getCategories();
        System.out.println(("Select category to add item from: "));
        MenuCategory selectedCategory = getChoice(menuCategories);

        ArrayList<MenuItem> menuItems = selectedCategory.getMenuItems();
        System.out.println(("Select item to add to order: "));
        MenuItem item = getChoice(menuItems);
        return item;
    }

    public Order selectOrderFromTable(){
        ArrayList<Table> tables = restaurant.getTables();
        System.out.println("Select table to add item to it's order: ");
        Table table = getChoice(tables);

        return table.getOrder();
    }

    public void deleteOrder(){
        System.out.println("Enter order number: ");
        int orderNumber = in.nextInt();
        ArrayList<Order> orders = restaurant.getOrders();
        for (Order order: orders){
            if (order.getOrderId() == orderNumber){
                order = null;
                return;
            }
        }
    }

    public void updateOrderStatus(){
        Order selectedOrder = selectOrderFromTable();
        String status = getChoice(selectedOrder.getStatuses());
        selectedOrder.setOrderStatus(status);
    }

    public void seeOrders(){
        ArrayList<Order> orders = restaurant.getOrders();
        if (orders.size() == 0) {
            return;
        }
        char c = 'A';
        for (Object order : orders) {
            System.out.println("\n" + c + ") \n" + orders.toString() + "\n");
            c++;
        }
    }

    public void deleteReservationCustomer(){
        System.out.println("What reservation would you like to remove?");
        Reservation r = getChoice(restaurant.getReservationByCustomers((Customer)user));
        restaurant.removeReservation(r);
        System.out.println("Reservation Removed");
    }

    public void deleteReservationStaff(){
        String date = in.nextLine();
        System.out.println("What day is the reservation? (dd/mm/yyyy)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formattedDate = LocalDate.parse(date, formatter);

        Reservation r = getChoice(restaurant.getReservationByDay(formattedDate));
        restaurant.removeReservation(r);
    }

    public void finishOrder(){
        
        System.out.println("Which table's order would you like to complete?:");
        Table t = getChoice(restaurant.getTables());
        Order o = t.getOrder();
        o.printBill();
        System.out.println("Would you like to add a tip? Y)es N)o");
        String command = in.nextLine().toUpperCase();
        if (command.equals("Y")){
            System.out.println("How much would you like to tip?");
            double tip = in.nextDouble();
            o.setGratuity(tip);
        }
        if (command.equals("N")){
            o.setGratuity(0);
        }
        printBill(o);
        CSVWriter csvWriter = new CSVWriter();
        csvWriter.writeOrderToCSV(o, restaurant);
        restaurant.removeOrder(o);
        t.changeAvailability();
        
    }

    public void printBill(Order o){
        System.out.println("Would you like to pay by C)ash or D)ebit Card");
        String command = in.nextLine().toUpperCase();
        if (command.equals("C")){
            o.setPaymentMethod('C');
        }
        if(command.equals("D")){
            o.setPaymentMethod('D');
        }
        o.setPaid(true);
        o.printBill();
    }

    public RestaurantChain getYum() {
        return yum;
    }
}
