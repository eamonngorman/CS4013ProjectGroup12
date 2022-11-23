import java.io.IOException;

/**
   This program simulates a vending machine.
*/
public class Run
{ 
   public static void main(String[] args)
         throws IOException
   { 

      SystemBoot systemBoot = new SystemBoot();
      //RestaurantChain yum = new RestaurantChain("Yum", systemBoot.giveRest);

      systemBoot.boot();
      UserScene use = new UserScene();
      use.runStart();
  }

}