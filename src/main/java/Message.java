/**
 * Created by a.danishevskiy on 16.05.2017.
 *
 * The class is describes the "Message" entity
 */
public class Message {

    /**
     * The variable that contains the message text
     */
    private String message;

    private static Message instance;

    public static synchronized Message getInstance() {
        if (instance == null) {
            instance = new Message();
        }
        return instance;
    }

    private Message(){
        this.message = "";
    }

    public String getMassage() {
        return message;
    }

    public synchronized void sentMassage(String text, int count) throws InterruptedException {
        message += text;
        Thread.sleep(1000);
    }
}
