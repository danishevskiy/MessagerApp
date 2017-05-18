import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by a.danishevskiy on 16.05.2017.
 *
 * The class in which starts a games thread and create the players
 */
public class Game implements Runnable {

    /**
     * The thread of the first player
     */
    Thread thread1;

    /**
     * The thread of the second player
     */
    Thread thread2;

    /**
     * The method creates a main games thread
     */
    @Override
    public void run() {
        Player player1 = new Player();   // Player 1
        System.out.println("Player 1, are you ready? (Y/N)");
        try {BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String p1State = br.readLine();
            if (p1State.equals("Y"))
                player1.setState(StateEnum.READY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Player player2 = new Player(); //Player 2
        System.out.println("Player 2, are you ready? (Y/N)");
        try {BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String p2State = br.readLine();
            if (p2State.equals("Y"))
                player2.setState(StateEnum.READY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (player1.isReady() && player2.isReady()){
            thread1 = new Thread(player1,"Player 1");
            thread2 = new Thread(player2,"Player 2");
            thread1.start();
            thread2.start();
            System.out.println("Please, entering the message and press \"Enter\"" );

            while (true){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!player1.isReady() || !player2.isReady()){ // Conditions for the end of the game
                    System.out.println("Game over!");
                    if (player1.getStatePlayer() == StateEnum.NOT_READY){
                        System.out.println("Player 1 win!");
                    }
                    if (player2.getStatePlayer() == StateEnum.NOT_READY){
                        System.out.println("Player 2 win!");
                    }
                    player1.interrupt();
                    player2.interrupt();
                    break;
                }
            }
        }
        System.out.println("[RESULT MESSAGE]: " + Message.getInstance().getMassage().toString());
        System.out.println("Press any key");
    }
}
