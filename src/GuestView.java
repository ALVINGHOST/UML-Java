import java.lang.*;
import java.util.*;

public class GuestView {
    public static void viewChoice(){
        boolean using = true;
        while (using) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Press 1 to see all messages, press 2 to Sign in or to sign up or press 0 to exit");
            int choice = inp.nextInt();

            switch (choice) {
                case 1:
                    Controller.enterChoice(3, null, null);
                    break;
                case 2:
                    using = false;
                    StartView.showOptions();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public static void displayMessages(ArrayList<Message> messages){
        for(Message m:messages){
            System.out.println(m.getContent());
            System.out.println("Author:"+m.getDisplay() +"        Date: "+m.getDate());
            System.out.println(" ");
        }
    }
}
