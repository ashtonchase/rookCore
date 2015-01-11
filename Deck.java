package rookCore;

import java.util.*;

/**
 * Created by ashton on 12/29/14.
 */
public class Deck implements CardHolderInterface {
    private ArrayList<Card> d;
    private short deckSize;

    public Deck(GameConfig gameConfig) {
        d = new ArrayList<Card>(20);
        this.buildDeck(gameConfig);
        shuffleDeck();

    }

    public short getDeckSize() {
        return deckSize;
    }

    public int length() {
        return d.size();

    }

    public boolean isEmpty() {
        return d.isEmpty();
    }

    protected void shuffleDeck() {
        Collections.shuffle(d);
    }


    private void buildDeck(GameConfig gameConfig) {
        if (gameConfig.isIncludeBlueRaven()) {
            addCard(new Card(Card.CARD_COLOR.ROOK, Card.CARD_FACE.ROOK, gameConfig.getBlueRavenRank()));
        }
        if (gameConfig.isIncludeOnes()) {
            if (gameConfig.isHighTrumpOne()) {
                addCard(new Card(gameConfig.getHighTrumpOneColor(), Card.CARD_FACE.ONE, Card.CARD_RANK.HIGHONE));
            } else {
                addCard(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                addCard(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                addCard(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                addCard(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
            }
        }
        if (gameConfig.isIncludeTwosThruFours()) {
            addCard(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            addCard(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            addCard(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            addCard(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            addCard(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            addCard(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            addCard(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            addCard(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            addCard(new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            addCard(new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            addCard(new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            addCard(new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
        }
        for (Card.CARD_COLOR c : Card.CARD_COLOR.values()) {
            if (c == Card.CARD_COLOR.ROOK) continue;
            addCard(new Card(c, Card.CARD_FACE.FIVE, Card.CARD_RANK.FIVE));
            addCard(new Card(c, Card.CARD_FACE.SIX, Card.CARD_RANK.SIX));
            addCard(new Card(c, Card.CARD_FACE.SEVEN, Card.CARD_RANK.SEVEN));
            addCard(new Card(c, Card.CARD_FACE.EIGHT, Card.CARD_RANK.EIGHT));
            addCard(new Card(c, Card.CARD_FACE.NINE, Card.CARD_RANK.NINE));
            addCard(new Card(c, Card.CARD_FACE.TEN, Card.CARD_RANK.TEN));
            addCard(new Card(c, Card.CARD_FACE.TWELVE, Card.CARD_RANK.TWELVE));
            addCard(new Card(c, Card.CARD_FACE.THIRTEEN, Card.CARD_RANK.THIRTEEN));
            addCard(new Card(c, Card.CARD_FACE.FOURTEEN, Card.CARD_RANK.FOURTEEN));
        }
        System.out.println("Deck Created");
        deckSize = (short) d.size();

        //build the standard cards in ever deck first


    }


    @Override
    public void viewCards() {
        //do not run anything here, you can't look at the deck.
    }

    @Override
    public Card releaseCardOut(int CardIndex) {
        return d.remove(CardIndex);
    }

    @Override
    public void addCard(Card card) {
        d.add(card);
    }

    @Override
    public String toString() {
        return (d.toString());
    }
}
