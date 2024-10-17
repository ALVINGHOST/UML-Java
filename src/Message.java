import java.lang.*;
import java.util.*;

public class Message {

    private String content;
    private Date date;
    private String Author;
    private int MessageID;

    public Message(String Auth,String Content){
        this.Author = Auth;
        this.content = Content;
        date = new Date();
        //check for total posts in postDB
        //messageID = total in DB + 1
        //this.messageID = tot+1;
    }
}
