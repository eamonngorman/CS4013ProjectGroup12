import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Table {
    private int tableNum;
    private int canSeat;
    private boolean isAvailable;
    private Order currentOrder;

    File tablesCSV = new File("Tables.csv");
    FileWriter fileWriter = new FileWriter(tablesCSV);

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

    public void addTableToCsv() throws IOException{
        StringBuilder line = new StringBuilder();
        line.append(tableNum + ",");
        line.append(canSeat);
        line.append("\n");
        fileWriter.write(line.toString());
    }

    public void changeAvailablity(){
        if(isAvailable){
            this.isAvailable = false;
        } else {
            this.isAvailable = true;
        }
    }

    public boolean getAvailablity(){
        return isAvailable;
    }

    public Order getOrder(){
        return currentOrder;
    }


}
