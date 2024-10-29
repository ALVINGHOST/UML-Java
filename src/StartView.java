import java.util.*;
import java.io.*;
public class StartView {
    static Scanner inp = new Scanner(System.in);
    public static void showOptions() {
        int choice = 0;
        System.out.println("Welcome to GENERIC MESSAGE PLATFORM!\n Please enter 1 to sign in,press 2 to sign up or enter 0 to continue as guest.");
        choice = Controller.getNumberInput(inp,0,2);
        if (choice == 1){
            signIn();
        } else if (choice == 0) {
            GuestView.viewChoice();
        } else if (choice == 2) {
            signUp();

        }
        inp.close();
    }
    private static void signIn(){
        String uName;
        String pWord;
        System.out.println("Please enter username: ");
        uName = inp.next();
        System.out.println(uName);
        System.out.println("Please enter password: ");
        pWord = inp.next();
        System.out.println(pWord);
        Controller.verifyLogin(uName.toLowerCase(),pWord);
    }

    private static void signUp(){
        String uName = null;
        String pWord = null;
        String displayname = null;
        System.out.println("username must be at least 3 characters");
        System.out.println("Please enter username: ");
        uName = inp.next();
        while(uName.length()<3) {
            System.out.println("Username is too short. Please enter username: ");
            uName = inp.next();
        }
        System.out.println("displayname must be at least 3 characters");
        System.out.println("Please enter displayname: ");
        displayname = inp.next();
        while(displayname.length()<3) {
            System.out.println("Displayname is too short. Please enter displayname: ");
            displayname = inp.next();
        }
        System.out.println("password must be at least 6 characters");
        System.out.println("Please enter password: ");
        pWord = inp.next();
        while(pWord.length()<6) {
            System.out.println("Password is too short. Please enter password: ");
            pWord = inp.next();
        }
        System.out.println(pWord);
        System.out.println("Please repeat your password:");
        if (pWord.equals(inp.next())){
            Controller.createUser(uName.toLowerCase(),pWord,displayname);
        }else{
            System.out.println("Passwords do not match");
            showOptions();
        }


    }
}
