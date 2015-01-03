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
        assignTeams();
        dealCards();
        do {//play hands until either team has enough points to win.

            initiateBidding();
            playTrick();

        }
        while ((team[0].getScore() <= gameConfig.getWinningScore()) && (team[1].getScore() <= gameConfig.getWinningScore()));
        if (team[0].getScore() > team[1].getScore())
            gameState.setWinningTeam(team[0]);
        else gameState.setWinningTeam(team[1]);






/*
        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/


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
            pollBids(tempBidders);
            if (tempBidders.size()==1){
                gameState.setWinningBidder(tempBidders.remove(0));
                tempBidders.clear();
                break;
            }else tempBid+=5;


        } while (true);
        gameState.getWinningBidder().addWidow(widow.releaseWidow());
        widow.clearWidow();

    }

    protected abstract void pollBids(ArrayList<Player> tempBidders);

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
