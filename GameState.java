package rookCore;

/**
 * Created by ashton on 12/31/14.
 */
public class GameState {
    private Team winningTeam;

    public GameState() {

    }

    enum Situation{NOT_STARTED,BIDDING,WIDOW_WORKING,PLAYING,HAND_OVER,ROUND_OVER,GAME_OVER};

    protected void setWinningTeam(Team t){
        this.winningTeam=t;

    }

    protected Team getWinningTeam(){
        return winningTeam;
    }

}
