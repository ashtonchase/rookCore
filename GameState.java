package rookCore;

/**
 * Created by ashton on 12/31/14.
 */
public class GameState {
    int startingBidder;
    int currentHighBid;
    Player WinningBidder;
    Player StartingBidder;
    Player leadNextTrick;
    private Card.CARD_COLOR trumps;
    private Team winningTeam;
    public GameState() {
        startingBidder = 0;

    }

    public Player getLeadNextTrick() {
        return leadNextTrick;
    }

    public void setLeadNextTrick(Player leadNextTrick) {
        this.leadNextTrick = leadNextTrick;
    }

    public Card.CARD_COLOR getTrumps() {
        return trumps;
    }

    public void setTrumps(Card.CARD_COLOR trumps) {
        this.trumps = trumps;
    }

    public Player getStartingBidder() {

        return StartingBidder;
    }

    public void setStartingBidder(Player startingBidder) {
        StartingBidder = startingBidder;
    }

    public Player getWinningBidder() {
        return WinningBidder;
    }

    public void setWinningBidder(Player winningBidder) {
        WinningBidder = winningBidder;
        leadNextTrick=winningBidder;
    }

    protected Team getWinningTeam() {
        return winningTeam;
    }

    ;

    protected void setWinningTeam(Team t) {
        this.winningTeam = t;

    }

    enum Situation {NOT_STARTED, BIDDING, WIDOW_WORKING, PLAYING, HAND_OVER, ROUND_OVER, GAME_OVER}

}
