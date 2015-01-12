package rookCore;

import java.util.ArrayList;

/**
 * Created by ashton on 12/29/14.
 */
public class Player {
    public static Position position;
    public String name;
    protected Hand hand;
    boolean passBid;
    boolean check;
    private boolean checkable;
    private int currentBid;

    public Player(String name) {
        this.name = name;
        this.passBid = false;
        this.checkable = false;
    }

    public Player() {
        this.name = "dummy";
        this.hand = new Hand();
    }

    public boolean isCheckable() {
        return checkable;
    }

    public void setCheckable(boolean b) {
        this.checkable = b;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean b) {
        this.check = b;
    }

    public boolean isPassBid() {
        return passBid;
    }

    public void setPassBid(boolean passBid) {
        this.passBid = passBid;
    }

    public ArrayList<Card> getHand() {
        return hand.getCards();
    }

    protected void setHand(Hand hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand(Card.CARD_COLOR color) {
        return hand.getCardsOfColor(color);
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    public void addCard(Card c) {
        this.hand.addCard(c);
    }

    public void addWidow(ArrayList<Card> widow) {
        this.hand.addCards(widow);
    }

    public enum Position {
        ONE,
        TWO,
        THREE,
        FOUR;
    }

}
