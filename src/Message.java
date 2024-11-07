import java.io.*;
import java.lang.*;
import java.util.*;

public class Message {

    private String content;
    private String date;
    private String author;
    private String display;
    private int messageID;

    public Message(String auth,String display,String content,String date,int mID){
        setAuthor(auth);
        setContent(content);
        setDisplay(display);
        setDate(date);
        setMessageID(mID);
    }

    public static void createMessage(User user,String content){
        String date = String.format(String.valueOf(new Date()));
        String file = "MessageDB.csv";
        Scanner input = null;
        int mID = 0;
        try{
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                 mID = Integer.parseInt(toks[0].trim());
            }

        }catch(IOException e) {
            System.out.println("ERROR READING FILE IN MESSAGE " + e);
        }
        mID++;
        Message m1 = new Message (user.getUsername(),user.getName(),content,date, mID);
        System.out.println(m1);
        try(FileWriter writer = new FileWriter("MessageDB.csv", true)){
            writer.write(m1.toString()+ "\n");
            System.out.println("MESSAGE CREATED!");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Message> viewAllMessages(){
        String file = "MessageDB.csv";
        Scanner input = null;
        ArrayList<Message> messages = new ArrayList<>();
        try {
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                int mID = Integer.parseInt(toks[0].trim());
                String auth = toks[1].trim();
                String display = toks[2].trim();
                String cont = toks[3].trim();
                String date = toks[4].trim();

                Message ac = new Message(auth,display,cont,date, mID);
                messages.add(ac);
            }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public static ArrayList<Message> viewOwnMessages(User user){
        String file = "MessageDB.csv";
        Scanner input = null;
        ArrayList<Message> messages = new ArrayList<>();
        try {
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                int mID = Integer.parseInt(toks[0].trim());
                String auth = toks[1].trim();
                String display = toks[2].trim();
                String cont = toks[3].trim();
                String date = toks[4].trim();
                if (user.getUsername().equals(auth)){
                Message ac = new Message(auth,display,cont,date, mID);
                messages.add(ac);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public static void deleteMessageFromFile(int messageID){
        String file = "MessageDB.csv";
        Scanner input = null;
        boolean messageDeleted = false;
        ArrayList<Message> messages = new ArrayList<>();
        try {
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                int mID = Integer.parseInt(toks[0].trim());
                String auth = toks[1].trim();
                String display = toks[2].trim();
                String cont = toks[3].trim();
                String date = toks[4].trim();
                if (messageID != mID){
                    Message ac = new Message(auth,display,cont,date, mID);
                    messages.add(ac);
                }else{
                    messageDeleted = true;
                    System.out.println("MESSAGE DELETED!");
                }

            }
            if (!messageDeleted){
                System.out.println("Message could not be found, please enter valid message id");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

            try(FileWriter writer = new FileWriter("MessageDB.csv", false)){
                for(Message m:messages){
                    writer.write(m.toString()+ "\n");
                }
            }catch(IOException e) {
                e.printStackTrace();
            }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setDisplay(String display){
        this.display = display;
    }
    public String  getDisplay(){
        return display;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    @Override
    public String toString() {
        return messageID +"\t"+ author +"\t"+display+"\t"+content+"\t"+date;
    }
}
