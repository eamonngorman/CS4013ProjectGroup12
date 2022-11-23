import java.io.IOException;

/**
   This program simulates a vending machine.
*/
public class Run
{ 
   public static void main(String[] args)
         throws IOException
   { 
      RestaurantChain yum = new RestaurantChain("Yum");
      
      SystemBoot systemBoot = new SystemBoot();
      systemBoot.systemBoot();
      UserScene use = new UserScene();
      use.runStart();
  }

}