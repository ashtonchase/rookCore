package rookCore.GameTester;


/**
 * Created by ashton on 1/1/15.
 */
public class Main {


    protected boolean nameSet;
    String[] names;
    CommandLineGameController game;


    public Main() {
        this.game = new CommandLineGameController();
        names = new String[4];
        this.nameSet = false;

    }


    public static void main(String args[]) {
        Main m = new Main();
        //m.game.SetPlayerNames(m.getNames());
        m.game.startGame();

    }


}




