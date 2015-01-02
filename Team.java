package rookCore;

/**
 * Created by ashton on 12/31/14.
 */
public class Team {
    private short score;
    Player playerOne, playerTwo;


    public Team(Player playerOne, Player playerTwo) {
        this.playerOne=playerOne;
        this.playerTwo=playerTwo;
        score=0;

    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public String getPlayerNames (){
        String s=playerOne.name+" & "+playerTwo.name;
        return s;
    }
}
