package rookCore;

import java.util.Collection;

/**
 * Created by ashton on 12/31/14.
 */
public abstract class GameController {

    public GameConfig gameConfig;
    public GameState gameState;
    public DeckCollection deckCollection;
    public Player[] players;
    public Team[]    team;


    protected void gameControllerDefault() {
        this.gameConfig=new GameConfig();
        this.gameState=new GameState();
        this.deckCollection=new DeckCollection(gameConfig);
        this.players=new Player[4];
        this.team=new Team[2];

        startGame();
        //TODO: Create game players.

    }

    private void startGame() {
        for (int i = 0; i < players.length; i++) {

            createPlayerConnection(players[i]);
        }
        getPlayerNames();
        assignTeams();


        notifyGameExit();
    }

    protected abstract void notifyGameExit();

    protected abstract void assignTeams();

    protected abstract void setGameConfig();

    protected abstract void storeGameState();

    protected abstract void storeGameConfig();

    protected abstract boolean createPlayerConnection(Player p);

    protected abstract void getPlayerNames();


}
