import java.util.concurrent.atomic.AtomicInteger;

public class Person {
    
    private String name;
    private int accessLevel;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int idNum;

    Person(String name, int accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
        this.idNum = count.incrementAndGet();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public int getIdNum() {
        return idNum;
    }

    @Override
    public String toString() {
        return name;
    }
}
