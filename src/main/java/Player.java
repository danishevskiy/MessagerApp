import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by a.danishevskiy on 16.05.2017.
 *
 *
 */
public class Player extends Thread implements Runnable{

    private String name;
    private Message message;
    private int count;
    private StateEnum state;

    public Player(){
        name = this.getName();
    }

    /*public long getIdPlayer() {
        return id;
    }

    public void setNickname(S) {
        this.id = nickname;
    }*/

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public StateEnum getStatePlayer() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public boolean isReady(){
        return state.equals(StateEnum.READY);
    }

    @Override
    public void run() {

        while (!this.isInterrupted()) {

            System.out.println(name + ":");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String m = br.readLine();
                message = Message.getInstance();
                message.sentMassage(m, count);
                if (count == 9) this.interrupt();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 9) { // Conditions for the end of the game
                state = StateEnum.NOT_READY;
                return;}
            count++;

        }

    }


}
