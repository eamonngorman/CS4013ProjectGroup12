import java.util.ArrayList;
import java.util.Scanner;

public class UserScene {

    private Scanner in;
    private Person user;

    public UserScene() {
        in = new Scanner(System.in);
    }

    public void run(){
        boolean more = true;

        while (more) {
            System.out.println("A)Login  B)Register  Q)uit");
            String command = in.nextLine().toUpperCase();

            if(command.equals("A")){
                System.out.println("Username:");
                String userName = in.nextLine();
                System.out.println("Password:");
                String password = in.nextLine();
                this.user = user.getIdNum();
                login(userName);
            } else if(command.equals("B")){
                register();
            } else if(command.equals("Q")){
                more = false;
            }
        }
    }

    public void login(String userName){
        if
    }



    private Object getChoice(ArrayList<Object> choices) {
        if (choices.size() == 0)
            return null;
        while (true) {
            char c = 'A';
            for (Object choice : choices) {
                System.out.println("\n" + c + ") \n" + choice.toString() + "\n");
                c++;
            }
            String input = in.nextLine();
            int n = input.toUpperCase().charAt(0) - 'A';
            if (0 <= n && n < choices.size())
                return choices.get(n);
        }
    }
}
