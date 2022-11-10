
import java.util.Scanner;
import java.util.ArrayList;

public class CustomerMenu {
   private Scanner in;

   /**
      Constructs an AppointmentMenu object.
   */
   public CustomerMenu()
   {
       in = new Scanner(System.in);
   }
   
   /**
      Runs the system.
   */
   public void run()
   {         
      boolean more = true;
      ReservationCalendar calendar = new ReservationCalendar();
  
      while (more)
      {  
         System.out.println("A)Make Reservation B)Cancel Reservation C)See Tables D)Exit");
         String command = in.nextLine().toUpperCase();

         if (command.equals("A"))
         {  
            try{
            System.out.println("How many people?");
            String line = in.nextLine();
            Table t = new Table(Integer.parseInt(line));
            calendar.add(t);
            }
            catch (AppointmentException ex)
            {
               System.out.println(ex.getMessage());
            }
         }
         else if (command.equals("C"))
         { 
            System.out.println("Enter Appointment Date");
            String line = in.nextLine();
            AppointmentDate day = new AppointmentDate(line);
            Appointment a = getChoice(calendar.getAppointmentsForDay(day));
            if (a != null)
               calendar.cancel(a);
         }
         else if (command.equals("S"))
         { 
            System.out.println("Date");
            String line = in.nextLine();
            AppointmentDate day = new AppointmentDate(line);
            for (Appointment appt : calendar.getAppointmentsForDay(day))
               System.out.println(appt.format());
         }
         else if (command.equals("Q"))
         { 
            more = false;
         }
      }      
   }

   private Appointment getChoice(ArrayList<Appointment> choices)
   {
      if (choices.size() == 0) return null;
      while (true)
      {
         char c = 'A';
         for (Appointment choice : choices)
         {
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
