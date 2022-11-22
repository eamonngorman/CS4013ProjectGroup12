import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserScene {

    private Scanner in;
    private Person user;
    private Restaurant restaurant;

    public UserScene() {
        in = new Scanner(System.in);
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
            System.out.println("A)Login  B)Register  Q)uit");
            String command = in.nextLine().toUpperCase();

            if (command.equals("A")) {
                System.out.println("Username:");
                String userName = in.nextLine();
                System.out.println("Password:");
                String password = in.nextLine();
                this.user = user.getIdNum();
                login(userName);
            } else if (command.equals("B")) {
                register();
            } else if (command.equals("Q")) {
                more = false;
            }
        }
    }

    public void login(String userName){

        String command = in.nextLine().toUpperCase();

        if (user.getAccessLevel() == 0){ //Customer Menu
            System.out.println("A)Make Reservation  B)Cancel Reservation  Q)uit");
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
            System.out.println("A)Edit Tables  B)Edit Menus C)Edit Staff  Q)uit");
            if(command.equals("A")){
                editTables();
            }
            if(command.equals("B")){
                editMenus();
            }
            if(command.equals("C")){
                editStaff();
            }
            if(command.equals("Q")){
                runStart();
            }
        }

        if (user.getAccessLevel() == 5){
            System.out.println("A)Edit Resturants  Q)uit");
            if(command.equals("A")){
                editResturants();
            }
            if(command.equals("Q")){
                runStart();
            }
        }
    }


    private <T> T getChoice(ArrayList<T> choices) { //getChoice can now work for all arrayList types
        if (choices.size() == 0)
            return null;
        while (true) {
            char c = 'A';
            for (T choice : choices) {
                System.out.println("\n" + c + ") \n" + choice.toString() + "\n");
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
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

    public void deleteReservationCustomer(){
        System.out.println("What reservation would you like to remove");
        getChoice(re)
    }
}
