import java.io.*;
import java.lang .*;
import java.util .*;

public class User {
    private String name;
    private String username;
    private String password;
    private int userID;


public User(int UID,String dpName,String user,String pass){

    //setters
    setName(dpName);
    setPassword(pass);
    setUsername(user);
    setUserID(UID);




    }


    public static void FindUser(String Username, String Password) {
        {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("UserDB.txt"));
                String line;
                User readuser = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println("");
                    String[] lineData = line.split(",");
                    int fid = Integer.parseInt(lineData[0]);
                    String fusername = lineData[1];
                    String fname = lineData[2];
                    String fpassword = lineData[3];

                    if (Username.equals(fusername) && Password.equals(fpassword)) {
                        readuser = new User(fid, fname, fusername, fpassword);
                        UserView.viewChoice(readuser);
                        break;
                    }
                }
                if (readuser == null)
                    System.out.println("--USER NOT FOUND!--");
            } catch (IOException e) {
                System.out.println("Fel vid läsning i Controller: " + e);
            }
        }
    }
    public static void signUp(String uName,String pWord, String displayname ){
        int id = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("UserDB.txt"))){
            String line;
            while((line = reader.readLine()) != null) {
                id++;

            }
        }catch(IOException e) {
            System.out.println("ERROR READING FILE IN USER " + e);
        }
        User u1 = new User(id,displayname,uName.toLowerCase(),pWord);
        System.out.println(u1);
        try(FileWriter writer = new FileWriter("UserDB.txt", true)){
            writer.write(u1.toString()+ "\n");
            System.out.println("CREATION SUCCESFULL!");
        }catch(IOException e) {
            e.printStackTrace();
        }
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

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    @Override
    public String toString() {
        return userID+","+username+","+name+","+password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() && Objects.equals(getName(), user.getName()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword());
    }
}