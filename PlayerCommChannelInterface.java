package rookCore;

/**
 * Created by ashton on 1/2/15.
 */
public interface PlayerCommChannelInterface {

    public void SendUpdatedGameState(Player p, GameState currentState);

    public void AttachInterface();

    public int requestBid(Player p);

    public boolean playerSignalledPass(Player p);

    public boolean playedSignalledCheck(Player p);

    public Card requestCardPlay(Player p);




}
