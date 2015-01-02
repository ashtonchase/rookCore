package rookCore;

/**
 * Created by ashton on 12/31/14.
 */
public abstract class GameController {

    public GameConfig gameConfig;
    public GameState gameState;
    public Deck deck;
    public Player[] players;
    public Team[]    team;
    public Widow widow;


    protected void gameControllerDefault() {
        this.gameConfig=new GameConfig();
        this.gameState=new GameState();
        this.deck =new Deck(gameConfig);
        this.players=new Player[4];
        for (int i = 0; i < players.length ; i++) {
            this.players[i]=new Player();
        }
        this.team=new Team[2];
        this.widow=new Widow();

        startGame();
        //TODO: Create game players.

    }

    private void startGame() {
        for (int i = 0; i < players.length; i++) {

            createPlayerConnection(players[i]);
        }
        getPlayerNames();
        assignTeams();

        do{//play hands until either team has enough points to win.
        dealCards();
        }while ((team[0].getScore()<=gameConfig.getWinningScore())&&(team[1].getScore()<=gameConfig.getWinningScore()));
        if(team[0].getScore()>team[1].getScore())
            gameState.setWinningTeam(team[0]);
        else gameState.setWinningTeam(team[1]);


        notifyGameExit();
    }

    private void dealCards() {
        for (int i = 1; i <=5; i++) {
        widow.addCard(deck.releaseCardOut(0));
        }
        for (int i = 0; i < deck.length()/4 ; i++) {
            for (int j = 0; j <players.length ; j++) {

            this.players[j].addCard(deck.releaseCardOut(0));
        }
        }


    }

    protected abstract void notifyGameExit();

    protected abstract void assignTeams();

    protected abstract void setGameConfig();

    protected abstract void storeGameState();

    protected abstract void storeGameConfig();

    protected abstract boolean createPlayerConnection(Player p);

    protected abstract void getPlayerNames();


}
