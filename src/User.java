import java.lang .*;
import java.util .*;

public class User {
    private String name;
    private String username;
    private String password;
    private int userID;


public User(String dpName,String user,String pass){

    //check for total users in userDB
    //userID = total in DB + 1
    //this.userID = tot+1;

    if (true){// Check for duplicates in userDB
        this.username = user;
    }else {
        System.err.println("Username Already exists");
    }
    if(true){ // password security check
        this.password = pass;
    }else {
        System.err.println("Password too weak");
    }
    //if kanske?
    this.name = dpName;
}

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() && Objects.equals(getName(), user.getName()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword());
    }
}
