import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserScene {

    private Scanner in;
    private Person user;
    private Restaurant restaurant;
    private RestaurantChain yum = new RestaurantChain();
    private CSVWriter csvWriter = new CSVWriter();
    private CSVReader csvReader = new CSVReader();
     

    public UserScene(RestaurantChain yum) {
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
            System.out.println("Welcome to the Yum restaurant management system");
            if(restaurant == null) {
                System.out.println("What Yum restaurant do you wish to access?");
                restaurant = getChoice(yum.getRestaurants());
            }
            System.out.println("A)Login  B)Register  Q)uit");
            String command = in.next().toUpperCase();
            CSVReader csvReader = new CSVReader();
            if (command.equals("A")) {
                System.out.println("Username:");
                String userName = in.next();
                System.out.println("Password:");
                String password = in.next();
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


    private void register() {
        Person newPerson = new Person("NOname", 0);

        if(user.getAccessLevel() == 0){
            System.out.println("Enter Your Name: ");
            String name = in.nextLine();
            newPerson = new Customer(name);
        } else {
            System.out.println("Enter New Employee Name: ");
            String name = in.nextLine();
            System.out.println("What Kind of Employee is being hired?");
            System.out.println("A)Front of House  B)Waiter  C)Chef  D)Manager  Q)uit");
            
            String command = in.next().toUpperCase();
            if(command.equals("A")){
                newPerson = new FOHStaff(name);

            } else if(command.equals("B")){
                newPerson = new Waiter(name);

            } else if(command.equals("C")){
                newPerson = new Chef(name);

            } else if(command.equals("D")){
                newPerson = new Manager(name);

            } else if(command.equals("Q")){
                login();
            }
        }
        
        System.out.println("Enter Username: ");
        String username = in.nextLine();

        System.out.println("Enter Password:");
        String password = in.nextLine();
        

        boolean isTaken = csvReader.isUsernameTaken(username);
        if (isTaken){
            System.out.println("Username already in database");
        } else {

            csvWriter.writeNewPersonToCSV(username, password, (Person)newPerson, restaurant);;

            restaurant.addPeople(newPerson, username);
            System.out.println("You have been registered with the username and password above.");

        }

    }

    public void login(){

        String command;

        if (user.getAccessLevel() == 0){ //Customer Menu
            System.out.println("Hello " + user.getName() + " :), good to have you back");
            if(hasRes((Customer)user)){
                System.out.println("Here is a list of your current reservations: ");
                printCurrentRes();
            }
            System.out.println("\nA)Make Reservation  B)Cancel Reservation  Q)uit");
            command = in.next().toUpperCase();

            if(command.equals("A")){
                makeReservation();
            }
            if(command.equals("B")){
                if(!hasRes((Customer)user)){
                    System.out.println("You have no reservations currently \n");
                }
                deleteReservationCustomer();
            }
            if(command.equals("Q")){
                runStart();
            }
            login();
        }

        if (user.getAccessLevel() == 1){
            System.out.println("A)Make Reservation  B)Cancel Reservation  Q)uit");
            command = in.next().toUpperCase();

            if(command.equals("A")){
                makeReservation();
            }
            if(command.equals("B")){
                deleteReservationStaff();
            }
            if(command.equals("Q")){
                runStart();
            }
            login();
        }

        if (user.getAccessLevel() == 2){
            System.out.println("A)Add to Order  B)Remove from Order C)Cancel Order D)Finish Order  Q)uit");
            command = in.next().toUpperCase();
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
            login();
        }

        if (user.getAccessLevel() == 3){
            System.out.println("A)Update Order  B)See Current Orders  Q)uit");
            command = in.next().toUpperCase();
            if(command.equals("A")){
                updateOrderStatus();
            }
            if(command.equals("B")){
                seeOrders();
            }
            if(command.equals("Q")){
                runStart();
            }
            login();
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
            login();
        }

        if (user.getAccessLevel() == 5){
            System.out.println(user.getAccessLevel());
            System.out.println("A)Edit Restaurants Q)uit");
            command = in.next().toUpperCase();
            if(command.equals("A")){
                editRestaurants();
            }
            if(command.equals("Q")){
                runStart();
            }
            login();
        }
    }

    private void calculateRestaurantIncome() {

        System.out.println("A)Calculate income from each restaurant  B)Calculate total income between two dates C)Calculate income on a given day of the week  Q)uit");
        String command = in.nextLine().toUpperCase();

        if(command.equals("A")){
            calculateIncomeFromEachRestaurant();
        }
        if(command.equals("B")){
            CalculateTotalIncomeBetWeenTwoDates();
        }
        if(command.equals("C")){
            CalculateIncomeOnDayOfTheWeek();
        }
        if(command.equals("Q")){
            runStart();
        }
    }

    private void CalculateIncomeOnDayOfTheWeek() {
        System.out.println("Day: (ALL CAPITALS) ");
        DayOfWeek day = DayOfWeek.valueOf(in.nextLine());
        CSVReader csvReader = new CSVReader();
        ArrayList<Double> income = csvReader.readPaymentsFromCSV(day);
        Double sum = 0.00;
        for (Double payment : income){
            sum += payment;
        }
        System.out.println("€" + sum);
    }

    private void CalculateTotalIncomeBetWeenTwoDates() {
        System.out.println("Start date: (dd/mm/yyyy)");
        LocalDate startDate = LocalDate.parse(in.nextLine());
        System.out.println(("End date: (dd/mm/yyyy"));
        LocalDate endDate = LocalDate.parse(in.nextLine());

        CSVReader csvReader = new CSVReader();
        ArrayList<Double> income = csvReader.readPaymentsFromCSV(startDate, endDate);
        Double sum = 0.00;
        for (Double payment : income){
            sum += payment;
        }
        System.out.println("€" + sum);

    }

    private void calculateIncomeFromEachRestaurant() {
        CSVReader csvReader = new CSVReader();
        double[] income = csvReader.readPaymentsFromCSV(yum);
        System.out.println("Ardee income:" + income[0]);
        System.out.println("Athleague income:" + income[1]);
        System.out.println("Cavan income:" + income[2]);
        System.out.println("Westport income:" + income[3]);
    }


    private void editStaff() {
        System.out.println("A)dd Staff Member Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("A")){
            System.out.println("Enter Name");
            String name = in.nextLine();
            System.out.println("Enter Username");
            String username = in.nextLine();
            System.out.println("Enter password");
            String password = in.next();
            System.out.println("Enter Access Level");
            int accessLevel = in.nextInt();
            Person person = new Person(name, accessLevel);
            restaurant.addPeople(person, password);
            csvWriter.writeNewPersonToCSV(username, password, person, restaurant);
        }
        if (command.equals("Q")){
            runStart();
        }
        login();
    }

    private void editRestaurants() {
        System.out.println("A)Add Restaurant  B)Edit Restaurant  Q)uit");
        String command = in.nextLine().toUpperCase();
        if(command.equals("A")){
            addRestaurant();
        }
        if(command.equals("Q")){
            runStart();
        }
        login();


        }


    private void editTables() {
        System.out.println("A)dd Q)uit");
        String command = in.nextLine().toUpperCase();
        if(command.equals("A")){
            System.out.println("Enter number of seats");
            int numSeats = in.nextInt();
            System.out.println("Enter table number");
            int tabNum = in.nextInt();
            Table table = new Table(tabNum, numSeats);
            restaurant.addTable(table);
            csvWriter.writeTableToCSV(table, restaurant);
        }
        if (command.equals("Q")){
            runStart();
        }
        login();
    }

    private void editMenus() {
        System.out.println("A)dd new menu E)dit menu Q)uit");
        String command = in.nextLine().toUpperCase();
        if (command.equals("A")){
            System.out.println("Enter Menu Name: ");
            String name = in.next();
            Menu newMenu = new Menu(name);
            restaurant.addMenu(newMenu);
            csvWriter.writeMenusToCSV(newMenu, restaurant);
        }
        if (command.equals ("E")){
            System.out.println("Select a menu to edit");
            Menu menus = getChoice(restaurant.getMenus());
            editMenu(menus);
        }
        if (command.equals("Q")){
            runStart();
        }
        login();
    }

    
    /** 
     * @param menus
     */
    private void editMenu(Menu menus){
        ArrayList<MenuCategory> menuCategories = menus.getCategories();
        System.out.println("E)dit category A)dd category Q)uit");
        String command = in.next().toUpperCase();
        if (command.equals("E")){
            System.out.println("Select a category to edit");
            MenuCategory menuCat = getChoice(menuCategories);
            editCats(menuCat, menus);
        }
        if (command.equals("A")){
            System.out.println("Enter Category Name");
            String cat = in.next();
            MenuCategory menuCat = new MenuCategory(cat);
            menus.addCategory(menuCat);
            csvWriter.writeMenuCategoryToCSV(menuCat, restaurant, menus);
        }
        if (command.equals("Q")){
            runStart();
        }
        login();
    }

    
    /** 
     * @param menuCat
     */
    private void editCats(MenuCategory menuCat, Menu menus){
        ArrayList<MenuItem> menuItems = menuCat.getMenuItems();
        System.out.println("A)dd Item Q)uit");
        String command = in.next().toUpperCase();
        if (command.equals("A")){
            System.out.println("Enter Item Name");
            String item = in.next();
            System.out.println("Enter Item Price");
            Double price = in.nextDouble();
            MenuItem menuItem = new MenuItem(item, price);
            menuCat.addMenuItem(menuItem);
        }
        if (command.equals("Q")){
            runStart();
        }
        login();
    }


    

    private <T> T getChoice(ArrayList<T> choices) { //getChoice can now work for all arrayList types

        if (choices.size() == 0)
            return null;
        while (true) {
            char c = 'A';
            for (T choice : choices) {
                System.out.println(c + ")" + choice.toString());
                c++;
            }
            String input = in.next();
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

    
    /** 
     * @param choices
     * @return String
     */
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
             String input = in.next();
             int n = input.toUpperCase().charAt(0) - 'A';
             if (0 <= n && n < choices.length)
                return choices[n];
    }
    }

    public void makeReservation() {

        Reservation r;

        if(user.getAccessLevel() == 0){

        System.out.println("What day would you like a reservation? (dd/mm/yyyy)");
        String date = in.next();
        //change so 1/12/2910 can be used
        System.out.println("What time would you like your reservation? (hh:mm)");
        String time = in.next();
        String format = date + " " + time;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime formattedDate = LocalDateTime.parse(format, formatter);

        
        System.out.println("How many people are coming?");
        int people = in.nextInt();
        Table table =  getChoice(restaurant.getFreeTables(people, formattedDate));
        System.out.println("Please enter your phone number");
        String phoneNumber = in.next();
        r = new Reservation((Customer) user, table, people, formattedDate, phoneNumber);
        } else {

        System.out.println("How many seats are needed?");
        LocalDateTime time = LocalDateTime.now();
        int people = in.nextInt();
        Table table =  getChoice(restaurant.getFreeTables(people, time));

            r = new Reservation(table);
        }

        restaurant.addReservation(r);
        csvWriter.writeReservationToCSV(r, restaurant, user);
        login();
    }

    public void addItemToOrder(){

        MenuItem item = selectItem();
        Order selectedOrder = selectOrderFromTable();

        for (Order order : restaurant.getOrders()){
            if (order == selectedOrder){
                order.addToOrder(item);
            }
        }
        login();
    }

    public void addRestaurant(){
        System.out.println("What is the name of the new restaurant?: ");
        String name = in.nextLine();
        Restaurant newRestaurant = new Restaurant(name);
        yum.getRestaurants().add(newRestaurant);
        csvWriter.writeRestaurantToCSV(newRestaurant);
        login();
    }

    public void removeItemFromOrder(){
        System.out.println("Select table: ");
        Table table = getChoice(restaurant.getTables());
        Order order = table.getOrder();
        System.out.println("Select item to remove: ");
        MenuItem item = getChoice(order.getItems());
        order.removeFromOrder(item);

        login();
    }

    
    /** 
     * @return MenuItem
     */
    public MenuItem selectItem(){
        ArrayList<Menu> menus = restaurant.getMenus();
        System.out.println("Select menu: ");
        Menu selectedMenu = getChoice(menus);

        ArrayList<MenuCategory> menuCategories = selectedMenu.getCategories();
        System.out.println(("Select category: "));
        MenuCategory selectedCategory = getChoice(menuCategories);

        ArrayList<MenuItem> menuItems = selectedCategory.getMenuItems();
        System.out.println(("Select item: "));
        MenuItem item = getChoice(menuItems);
        return item;
    }

    
    /** 
     * @return Order
     */
    public Order selectOrderFromTable(){
        ArrayList<Table> tables = restaurant.getTables();
        System.out.println("Select table: ");
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
        login();
    }

    public void updateOrderStatus(){
        Order selectedOrder = selectOrderFromTable();
        String status = getChoice(selectedOrder.getStatuses());
        selectedOrder.setOrderStatus(status);
        login();
    }

    public void seeOrders(){
        ArrayList<Order> orders = restaurant.getOrders();
        if (orders.size() == 0) {
            return;
        }
        char c = 'A';
        for (Object order : orders) {
            System.out.println("\n" + c + ") \n" + order.toString() + "\n");
            c++;
        }
        login();
    }

    public void deleteReservationCustomer(){
        if(hasRes((Customer)user)){
        System.out.println("What reservation would you like to remove?");
        Reservation r = getChoice(restaurant.getReservationByCustomers((Customer)user));
        restaurant.removeReservation(r);
        System.out.println("Reservation Removed");
        } 
    }

    public void deleteReservationStaff(){

        System.out.println("What day is the reservation? (dd/mm/yyyy)");
        String date = in.next();
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

    
    /** 
     * @param o
     */
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

    
    /** 
     * @return RestaurantChain
     */
    public RestaurantChain getYum() {
        return yum;
    }

    public boolean hasRes(Customer user){
        if(restaurant.getReservations() == null){
            return false;
        }

        for(Reservation r: restaurant.getReservations()){
            if(r.getCustomer() == user){
                return true;
            }
        }

        return false;
    }

    public void printCurrentRes(){
        
        System.out.println("Reservations are for " + restaurant.getName());
        int i = 1;
        for(Reservation r: restaurant.getReservations()){
            if(r.getCustomer() == user){
                System.out.println("===============================");
                System.out.println("Reservation No." + i);
                System.out.println(r);
                System.out.println("===============================");
                i++;
            }
        }

    }

    
}
