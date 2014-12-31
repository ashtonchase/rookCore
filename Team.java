package rookCore;

/**
 * Created by ashton on 12/31/14.
 */
public class Team {
    private int score;
    Player playerOne, playerTwo;


    public Team(Player playerOne, Player playerTwo) {
        this.playerOne=playerOne;
        this.playerTwo=playerTwo;
        score=0;

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
