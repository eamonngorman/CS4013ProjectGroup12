import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemBoot {
    

    public void createMenuItems(){
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        ArrayList<MenuCategory> cats = new ArrayList<MenuCategory>();
        ArrayList<Menu> menus = new ArrayList<Menu>();
        File fileItems = new File("items.csv");
        File fileCats = new File("cats.csv");
        File fileMenus = new File("menus.csv");
        
        try { //create list of all menus
            Scanner in = new Scanner(fileMenus);
            if (in.hasNextLine()){
                in.nextLine();
            }
            while(in.hasNextLine()){
                String[] dataFields = in.nextLine().split(",");
                String menuName = dataFields[0];
                Menu m = new Menu(menuName);
                menus.add(m);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner in = new Scanner(fileCats);
            if (in.hasNextLine()){
                in.nextLine();
            }
            while(in.hasNextLine()){
                String[] dataFields = in.nextLine().split(",");
                String catName = dataFields[0];
                String menuName = dataFields[1];
                MenuCategory c = new MenuCategory(catName);
                cats.add(c);
                for(Menu m: menus){
                    if(menuName.equals(m.getMenuName())){
                        m.addCategory(c);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Scanner in = new Scanner(fileItems);
            if (in.hasNextLine()){
                in.nextLine();
            }
            while(in.hasNextLine()){
                String[] dataFields = in.nextLine().split(",");
                String itemName = dataFields[0];
                double cost = Double.parseDouble(dataFields[1]);
                MenuItem item = new MenuItem(itemName, cost);
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

    }

    
    public void createMenus(){
        
    }
    public void createTables(){
        
    }
    public void createPeople(){
        
    }
    public void createReservation(){
        
    }
    public void createResturant(){
        
    }
}
