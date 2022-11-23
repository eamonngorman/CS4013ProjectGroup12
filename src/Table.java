import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    private int tableNum;
    private int canSeat;
    private boolean isAvailable;
    private Order currentOrder;


    Table(int tableNum, int canSeat){
        this.tableNum = tableNum;
        this.canSeat = canSeat;
        this.currentOrder = new Order();
    }

    public void setTableNum(int tableNum){
        this.tableNum = tableNum;
    }

    public int getTableNum(){
        return tableNum;
    }

    public void setCanSeat(int canSeat){
        this.canSeat = canSeat;
    }

    public int getCanSeat(){
        return canSeat;
    }


    public void changeAvailability(){
        if(isAvailable){
            this.isAvailable = false;
        } else {
            this.isAvailable = true;
        }
    }

    public boolean getAvailability(){
        return isAvailable;
    }

    public Order getOrder(){
        return currentOrder;
    }


}
