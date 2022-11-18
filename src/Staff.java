public class Staff extends Person{
    private int staffId;
    private int count = 1;

    Staff(String name, String phoneNumber) {
        super(name, phoneNumber);
        this.staffId = count;
        count++;
        Restaurant.getStaff().add(this);
    }
}
