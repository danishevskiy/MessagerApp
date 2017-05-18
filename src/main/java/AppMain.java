/**
 * Created by a.danishevskiy on 16.05.2017.
 *
 * Main application class
 */
public class AppMain {

    /**
     * Main application thread
     *
     * @param args
     */
    public static void main(String[] args) {

        new Thread(new Game()).start();

    }
}
