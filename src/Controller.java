import java.lang.*;
import java.util.*;

public class Controller {

    public static void verifyLogin(String username,String password){
    if(!User.FindUser(username,password)){
        StartView.showOptions();
    }
    }

    public static void createUser(String username,String password,String displayname){
        User.saveUser(username,password,displayname);
    }
    public static void startUserView(User user) {
        UserView.viewChoice(user);
    }
    public static void enterChoice(int opt,User user,String content){
        ArrayList<Message> messages = null;
        switch (opt){
            case 1:
                Message.createMessage(user,content);
                UserView.viewChoice(user);
                break;
            case 2:
                messages = Message.viewOwnMessages(user);
                UserView.deleteMessages(messages);
                break;
            case 3:
                messages = Message.viewAllMessages();
                if (user != null){
                    UserView.displayMessages(messages);
                } else {
                    GuestView.displayMessagesGuest(messages);
                }

                break;
            case 4:
                messages = Message.viewOwnMessages(user);
                UserView.displayMessages(messages);
                break;
        }

    }

    public static void deleteMessage(int MessageID){
    Message.deleteMessageFromFile(MessageID);
    }

    public static int getNumberInput(Scanner scanner, int min, int max) {
        int input = -1;

        while (input < 0) {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException nfe) {
                input = -1;
            }
            if (input < min || input > max) {
                System.out.println("Please pick a number between " + min + " and " + max + "." );
                input = -1;
            }
        }
        return input;
    }
}
