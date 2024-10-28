import java.lang.*;
import java.util.*;
import java.io.*;

public class Controller {

    public void viewAllMessages(boolean signedIn){
        /* Read file
        * Display N posts
        * prompt scroll N more posts
        *
        * if logged in show option to post/remove own posts
        *
        * */
    }

    public static void verifyLogin(String username,String password){
    User.FindUser(username,password);
    }

    public static void createUser(String username,String password,String displayname){
        User.signUp(username,password,displayname);
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
                    GuestView.displayMessages(messages);
                }

                break;
            case 4:
                messages = Message.viewOwnMessages(user);
                UserView.displayMessages(messages);
                break;
            case 5:

                break;
        }

    }

    public static void deleteMessage(int MessageID){
    Message.deleteMessage(MessageID);


    }


}
