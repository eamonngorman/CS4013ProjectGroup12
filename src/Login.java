public class Login {    //may have to replace boolean with int
                        //I couldnt figure that out right now but will look into it

    public String name;
    public String userName;
    public int password;
    private boolean isStaff;

    public Login(String Name, String UserName, int passwordHashed) {
        name = Name;
        userName = UserName;
        password = passwordHashed;
    }

    public Login(String Name, String UserName, String passwordNotHashed) {
        this(Name, UserName, passwordNotHashed.hashCode());
    }

    public Login(String Name, String UserName, int passwordHashed, boolean IsStaff) {
        this(Name, UserName, passwordHashed);
        if (IsStaff) isStaff = true;
    }

    public boolean getIsStaff() {
        return isStaff;
    }

    public boolean attemptLogin(String UserName, String attemptPassword) {
        if (userName.equals(UserName) && password == attemptPassword.hashCode()) 
            return true;
        else 
            return false;
    }
}


