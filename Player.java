package rookCore;

/**
 * Created by ashton on 12/29/14.
 */
public class Player {
    public static Position position;
    private Hand hand;


    public Player() {

    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    protected void setHand(Hand hand) {
        this.hand = hand;
    }

    public enum Position {
        ONE,
        TWO,
        THREE,
        FOUR;
    }

}
