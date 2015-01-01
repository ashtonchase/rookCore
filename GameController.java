package rookCore;

import java.util.Collection;

/**
 * Created by ashton on 12/31/14.
 */
public abstract class GameController {

    public GameConfig gameConfig;
    public GameState gameState;
    public DeckCollection deckCollection;
    public Player one,two,three, four;
    public Team    teamOne,teamTwo;


    protected void GameControllerDefault() {
        this.gameConfig=new GameConfig();
        this.gameState=new GameState();
        this.deckCollection=new DeckCollection(gameConfig);
        //TODO: Create game players.

    }


    protected abstract void setGameConfig();

    protected abstract void storeGameState();

    protected abstract void storeGameConfig();

    protected abstract void assignPlayersToTeam();

    protected abstract boolean createPlayerConnection();



}
