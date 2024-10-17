import java.util.*;
import java.io.*;
public class StartView {
    static Scanner inp = new Scanner(System.in);
    public static void main() {
        int choice = 0;
        System.out.println("Welcome to GENERIC MESSAGE PLATFORM!\n Please enter 1 to sign in or enter 0 to continue as guest.");
        choice = inp.nextInt();
        if (choice == 1){
            //run loginView
            System.out.println("loginview init");
        } else if (choice == 0) {
            //run guestView
            System.out.println("guestview init");
        } else{
            System.out.println("Please pick between 1 and 0");
            StartView.main();
        }

    }
}
