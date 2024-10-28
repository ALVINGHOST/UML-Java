import java.util.*;
import java.io.*;
public class StartView {
    static Scanner inp = new Scanner(System.in);
    public static void showOptions() {
        int choice = 0;
        System.out.println("Welcome to GENERIC MESSAGE PLATFORM!\n Please enter 1 to sign in,press 2 to sign up or enter 0 to continue as guest.");
        choice = inp.nextInt();
        if (choice == 1){
            signIn();
        } else if (choice == 0) {
            GuestView.viewChoice();
        } else if (choice == 2) {
            signUp();

        } else{
            System.out.println("Please pick between 1 and 0");
            StartView.showOptions();
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
        String uName;
        String pWord;
        String displayname;
        System.out.println("Please enter username: ");
        uName = inp.next();
        System.out.println(uName);
        System.out.println("Please enter displayname: ");
        displayname = inp.next();
        System.out.println(displayname);
        System.out.println("Please enter password: ");
        pWord = inp.next();
        System.out.println(pWord);
        Controller.createUser(uName.toLowerCase(),pWord,displayname);
    }
}
