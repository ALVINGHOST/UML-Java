import java.lang.*;
import java.util.*;

public class GuestView {
    public static void viewChoice(){
        boolean using = true;
        while (using) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Press 1 to see all messages, press 2 to Sign in or to sign up or press 0 to exit");
            int choice = Controller.getNumberInput(inp,0,2);

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

    public static void displayMessagesGuest(ArrayList<Message> messages){
        int count = 0;
        Scanner inp = new Scanner(System.in);
        for(Message m:messages){
            String opt;
            if (count % 3 == 0 && count != 0){
                System.out.println("press any key to load more messages or press q to quit");
                opt = inp.nextLine().toLowerCase();
                if(opt.equals("q")){
                    break;
                }
            }
            System.out.println(m.getContent());
            System.out.println("Author:"+m.getDisplay() +"        Date: "+m.getDate());
            System.out.println(" ");
            count++;
        }
    }
}
