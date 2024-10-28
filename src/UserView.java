import java.lang.*;
import java.util.*;

public class UserView {

    public static void viewChoice(User user){
        while (user != null) {
            Scanner inp = new Scanner(System.in);
            System.out.println("Press 1 to create a message, press 2 to delete one of your messages,");
            System.out.println("press 3 to see all messages, press 4 to see your messages, 0 to sign out and exit");
            int choice = inp.nextInt();

            switch (choice) {
                case 1:
                    String content = null;
                    System.out.println("Write your message. Press Enter to post: ");
                    Scanner cInp = new Scanner(System.in);
                    content = cInp.nextLine();
                    Controller.enterChoice(choice, user, content);
                    break;
                case 2:
                    Controller.enterChoice(choice, user, null);
                    break;
                case 3:
                    Controller.enterChoice(choice, user, null);
                    break;
                case 4:
                    Controller.enterChoice(choice, user, null);
                    break;
                case 0:
                    Controller.enterChoice(choice, user, null);
                    user = null;
                    System.exit(0);
                    break;

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
    public static void deleteMessages(ArrayList<Message> messages){
        Scanner inp = new Scanner(System.in);
        for(Message m:messages){
            System.out.println(m.getContent());
            System.out.println("Author:"+m.getDisplay() +"        Date: "+m.getDate()+"     Message ID:"+m.getMessageID());
            System.out.println(" ");
        }
        System.out.println("Write the ID of the message you want to delete :");
        int choice = inp.nextInt();
        Controller.deleteMessage(choice);
    }

}
