public class Person {
    
    private String name;
    private int accessLevel;
    private int idNum;

    Person(String name, int accessLevel) {
        this.name = name;
        this.accessLevel = accessLevel;
        //need a way to create a unique ID number for every created person
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
}
