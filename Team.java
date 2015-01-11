package rookCore;

/**
 * Created by ashton on 12/31/14.
 */
public class Team {
    Player playerOne, playerTwo;
    private short score;


    public Team(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        score = 0;

    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public String getPlayerNames() {
        String s = playerOne.name + " & " + playerTwo.name;
        return s;
    }

    public Player getPartner(Player p) {
        if (p.equals(this.playerOne)) {
            return this.playerTwo;
        } else if (p.equals(this.playerTwo)) {
            return this.playerOne;
        }
        throw new IllegalArgumentException("Player is not in this team");

    }

    public boolean contains(Player p) {
        if (p.equals(this.playerOne) || p.equals(this.playerTwo)) {
            return true;
        }
        return false;

    }
}
