import java.util.ArrayList;
import java.util.Scanner;

public class CustomerScene {
   private Scanner in;

   /**
      Constructs an ReservationMenu object.
   */
   public CustomerScene() {
      in = new Scanner(System.in);
   }

   /**
      Runs the system.
   */
   public void run() {
      boolean more = true;
      ReservationCalendar calendar = new ReservationCalendar();

      while (more) {
         System.out.println("A)Make Reservation B)Cancel Reservation C)See Tables D)Exit");
         String command = in.nextLine().toUpperCase();

         if (command.equals("A")) {
            try {
               System.out.println("How many people?");
               String line = in.nextLine();
               Table t = new Table(Integer.parseInt(line));
               calendar.add(t);
            } catch (ReservationException ex) {
               System.out.println(ex.getMessage());
            }
         } else if (command.equals("C")) {
            System.out.println("Enter Reservation Date");
            String line = in.nextLine();
            ReservationDate day = new ReservationDate(line);
            Reservation a = getChoice(calendar.getReservationsForDay(day));
            if (a != null)
               calendar.cancel(a);
         } else if (command.equals("S")) {
            System.out.println("Date");
            String line = in.nextLine();
            ReservationDate day = new ReservationDate(line);
            for (Reservation appt : calendar.getReservationsForDay(day))
               System.out.println(appt.format());
         } else if (command.equals("Q")) {
            more = false;
         }
      }
   }

   private Reservation getChoice(ArrayList<Reservation> choices) {
      if (choices.size() == 0)
         return null;
      while (true) {
         char c = 'A';
         for (Reservation choice : choices) {
            System.out.println(c + ") " + choice.format());
            c++;
         }
         String input = in.nextLine();
         int n = input.toUpperCase().charAt(0) - 'A';
         if (0 <= n && n < choices.size())
            return choices.get(n);
      }
   }
}
