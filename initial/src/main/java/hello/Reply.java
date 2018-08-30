package hello;
public class Reply extends UserMessage{
    UserMessage userMessage;

    public Reply(String name, String message, UserMessage userMessage){
        super(name, message);
        this.userMessage = userMessage;
    }
    @Override
    public String toString(){
        return userMessage + "\n" + super.toString();
    }

}