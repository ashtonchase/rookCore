package rookCore;

import java.util.Collection;

/**
 * Created by ashton on 12/31/14.
 */
public abstract class GameController {
    GameConfig gameConfig;
    GameState gameState;
    DeckCollection deckCollection;
    Collection<Player> gamePlayers;


    public void GameControllerDefault() {
        gameConfig=new GameConfig();
        gameState=new GameState();
        deckCollection=new DeckCollection(this.gameConfig);
        //TODO: Create game players.
    }
}
