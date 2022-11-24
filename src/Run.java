import java.io.IOException;

public class Run
{ 
   public static void main(String[] args)
         throws IOException
   { 

      SystemBoot systemBoot = new SystemBoot();
      //RestaurantChain yum = new RestaurantChain("Yum", systemBoot.giveRest);

      RestaurantChain yum = systemBoot.boot();
      UserScene use = new UserScene(yum);
      use.runStart();
  }

}