package rookCore;

/**
 * Created by ashton on 12/29/14.
 */
public abstract class PlayerClass {
    private HandClass hand;
    public static Position position;


    public PlayerClass() {

    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    protected void setHand(HandClass hand) {
        this.hand = hand;
    }
}
