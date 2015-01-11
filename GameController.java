package rookCore;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ashton on 12/31/14.
 */
public abstract class GameController implements Runnable {

    public GameConfig gameConfig;
    public GameState gameState;
    public Deck deck;
    public ArrayList<Player> players;
    public Team[] team;
    public Widow widow;
    protected int tempBid;

    protected void gameControllerDefault() {
        this.gameConfig = new GameConfig();
        this.gameState = new GameState();
        this.deck = new Deck(gameConfig);
        players = new ArrayList<Player>(4);
        for (int i = 0; i < 4; i++) {
            players.add(new Player());
        }
        this.team = new Team[2];
        this.widow = new Widow();
        gameConfig.setNumberOfRounds((short) deck.getDeckSize());
        startGame();
        //TODO: Create game players.


    }

    private void startGame() {
        // ThreadPooledServer server = new ThreadPooledServer(5066);
        //new Thread(server).start();


        for (int i = 0; i < players.size(); i++) {

            createPlayerConnection(players.get(i));
        }
        gameState.setStartingBidder(players.get(0));
        getPlayerNames();
        System.out.flush();
        assignTeams();
        System.out.flush();
        dealCards();
        do {//play hands until either team has enough points to win.

            initiateBidding();
            System.out.flush();
            for (short i = 0; i < gameConfig.getNumberOfRounds(); i++) {
                playTrick();
            }


        }
        while ((team[0].getScore() <= gameConfig.getWinningScore()) && (team[1].getScore() <= gameConfig.getWinningScore()));
        if (team[0].getScore() > team[1].getScore())
            gameState.setWinningTeam(team[0]);
        else gameState.setWinningTeam(team[1]);

        System.out.println("Stopping Server");
        // server.stop();
        notifyGameExit();
    }

    private void initiateBidding() {
        int index = players.indexOf(gameState.startingBidder);
        ArrayList<Player> tempBidders = new ArrayList<Player>(4);
        tempBidders.addAll(players);
        gameState.currentHighBid = 0;
        Player winningBidder;

        tempBid = gameConfig.getMinimumBid();
        do {
            tempBidders.get(0).setCheckable(true);
            pollBids(tempBidders);
            if (tempBidders.size() == 1) {
                gameState.setWinningBidder(tempBidders.remove(0));
                tempBidders.clear();
                break;
            }
        } while (true);

        gameState.getWinningBidder().addWidow(widow.releaseWidow());
        widow.clearWidow();
        System.out.println(gameState.getWinningBidder().getName() + " Won the bid!");
        requestTrump(gameState.getWinningBidder(), gameState.trumps);
        reloadWidow(gameState.getWinningBidder());


    }

    protected abstract void reloadWidow(Player p);

    protected abstract void requestTrump(Player p, Card.CARD_COLOR trumpColor);

    //protected abstract void pollBids(ArrayList<Player> tempBidders);
    //@Override
    protected void pollBids(ArrayList<Player> tempBidders) {
        for (int i = 0; i < tempBidders.size(); i++) {
            if (tempBidders.size() == 1) break;
            tempBidders.get(i).setCurrentBid(requestBid(tempBidders.get(i)));
            postBidUpdate();
            if (tempBidders.get(i).isPassBid()) {
                //    tempBidders.get(i+1).setCheckable(true);
                tempBidders.remove(i);
                i--;

            } else if (tempBidders.get(i).isCheck()) {
                //    tempBidders.get(i+1).setCheckable(false);
            } else if (tempBidders.get(i).getCurrentBid() >= tempBid)
                tempBid = tempBidders.get(i).getCurrentBid() + 5;


        }
    }

    protected abstract void postBidUpdate();

    public abstract int requestBid(Player p);

    private void dealCards() {
        for (int i = 1; i <= 5; i++) {
            widow.addCard(deck.releaseCardOut(0));
        }

        while (!deck.isEmpty()) {
            players.get(0).addCard(deck.releaseCardOut(0));
            players.get(1).addCard(deck.releaseCardOut(0));
            players.get(2).addCard(deck.releaseCardOut(0));
            players.get(3).addCard(deck.releaseCardOut(0));
        }


    }

    protected abstract void notifyGameExit();

    protected abstract void assignTeams();

    protected abstract void setGameConfig();

    protected abstract void storeGameState();

    protected abstract void storeGameConfig();

    protected abstract boolean createPlayerConnection(Player p);

    protected abstract void getPlayerNames();

    protected abstract void playTrick();

    protected abstract void postCard(Player p, Card c);

    public abstract void SetPlayerNames(String[] names);
}
