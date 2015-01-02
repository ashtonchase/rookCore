package rookCore;

/**
 * Created by ashton on 12/29/14.
 */
public class Player {
    public static Position position;
    private Hand hand;
    public String name;


    public Player(String name) {

        this.name = name;

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
