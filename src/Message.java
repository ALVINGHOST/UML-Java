import java.io.*;
import java.lang.*;
import java.util.*;
import java.time.*;

public class Message {

    private String content;
    private String date;
    private String Author;
    private String Display;
    private int MessageID;

    public Message(String Auth,String Display,String Content,String date,int MID){
        setAuthor(Auth);
        setContent(Content);
        setDisplay(Display);
        setDate(date);
        setMessageID(MID);
    }

    public static void createMessage(User user,String content){
        String date = String.format(String.valueOf(new Date()));
        String file = "MessageDB.txt";
        Scanner input = null;
        int MID = 0;
        try{
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                 MID = Integer.parseInt(toks[0].trim());
            }

        }catch(IOException e) {
            System.out.println("ERROR READING FILE IN MESSAGE " + e);
        }
        MID++;
        Message m1 = new Message (user.getUsername(),user.getName(),content,date,MID);
        System.out.println(m1);
        try(FileWriter writer = new FileWriter("MessageDB.txt", true)){
            writer.write(m1.toString()+ "\n");
            System.out.println("MESSAGE CREATED!");
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Message> viewAllMessages(){
        String file = "MessageDB.txt";
        Scanner input = null;
        ArrayList<Message> messages = new ArrayList<>();
        try {
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                int MID = Integer.parseInt(toks[0].trim());
                String auth = toks[1].trim();
                String display = toks[2].trim();
                String cont = toks[3].trim();
                String date = toks[4].trim();

                Message ac = new Message(auth,display,cont,date,MID);
                messages.add(ac);
            }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public static ArrayList<Message> viewOwnMessages(User user){
        String file = "MessageDB.txt";
        Scanner input = null;
        ArrayList<Message> messages = new ArrayList<>();
        try {
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                int MID = Integer.parseInt(toks[0].trim());
                String auth = toks[1].trim();
                String display = toks[2].trim();
                String cont = toks[3].trim();
                String date = toks[4].trim();
                if (user.getUsername().equals(auth)){
                Message ac = new Message(auth,display,cont,date,MID);
                messages.add(ac);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public static void deleteMessage(int MessageID){
        String file = "MessageDB.txt";
        Scanner input = null;
        ArrayList<Message> messages = new ArrayList<>();
        try {
            input = new Scanner(new File(file));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] toks = line.split("\t");
                int MID = Integer.parseInt(toks[0].trim());
                String auth = toks[1].trim();
                String display = toks[2].trim();
                String cont = toks[3].trim();
                String date = toks[4].trim();
                if (MessageID != MID){
                    System.out.println(MessageID + MID);
                    Message ac = new Message(auth,display,cont,date,MID);
                    messages.add(ac);
                }else{
                    System.out.println(MessageID + MID);
                    System.out.println("MESSAGE DELETED!");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

            try(FileWriter writer = new FileWriter("MessageDB.txt", false)){
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
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
    public void setDisplay(String display){
        Display = display;
    }
    public String  getDisplay(){
        return Display;
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int messageID) {
        MessageID = messageID;
    }

    @Override
    public String toString() {
        return MessageID+"\t"+Author+"\t"+Display+"\t"+content+"\t"+date;
    }
}
