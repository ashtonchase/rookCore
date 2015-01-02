package rookCore;

import java.util.*;

/**
 * Created by ashton on 12/29/14.
 */
public class DeckCollection implements CardHolderInterface {
    ArrayList<Card> d;


    public DeckCollection(GameConfig gameConfig) {
        d=new ArrayList<Card>(20);
        this.buildDeck(gameConfig);
        shuffleDeck();

    }


    protected void shuffleDeck() {
        Collections.shuffle(d);
    }


    private void buildDeck(GameConfig gameConfig) {
        if (gameConfig.isIncludeBlueRaven()) {
            d.add(new Card(Card.CARD_COLOR.ROOK, Card.CARD_FACE.ROOK, gameConfig.getBlueRavenRank()));
        }
        if (gameConfig.isIncludeOnes()) {
            if (gameConfig.isHighTrumpOne()) {
                d.add(new Card(gameConfig.getHighTrumpOneColor(), Card.CARD_FACE.ONE, Card.CARD_RANK.HIGHONE));
            } else {
                d.add(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                d.add(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                d.add(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                d.add(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
            }
        }
        if (gameConfig.isIncludeTwosThruFours()) {
            d.add(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.add(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.add(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.add(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.add(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.add(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.add(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.add(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.add(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            d.add(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            d.add(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            d.add(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
        }
        for (Card.CARD_COLOR c : Card.CARD_COLOR.values()) {
            if (c == Card.CARD_COLOR.ROOK) continue;
            d.add(new Card(c, Card.CARD_FACE.FIVE, Card.CARD_RANK.FIVE));
            d.add(new Card(c, Card.CARD_FACE.SIX, Card.CARD_RANK.SIX));
            d.add(new Card(c, Card.CARD_FACE.SEVEN, Card.CARD_RANK.SEVEN));
            d.add(new Card(c, Card.CARD_FACE.EIGHT, Card.CARD_RANK.EIGHT));
            d.add(new Card(c, Card.CARD_FACE.NINE, Card.CARD_RANK.NINE));
            d.add(new Card(c, Card.CARD_FACE.TEN, Card.CARD_RANK.TEN));
            d.add(new Card(c, Card.CARD_FACE.TWELVE, Card.CARD_RANK.TWELVE));
            d.add(new Card(c, Card.CARD_FACE.THIRTEEN, Card.CARD_RANK.THIRTEEN));
            d.add(new Card(c, Card.CARD_FACE.FOURTEEN, Card.CARD_RANK.FOURTEEN));
        }
        System.out.println("Created Card");


        //build the standard cards in ever deck first


    }


    @Override
    public void viewCards() {
        //do not run anything here, you can't look at the deck.
    }

    @Override
    public void releaseCardOut(byte CardIndex) {

    }

    @Override
    public String toString() {
        return (d.toString());
    }
}
