package rookCore;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ashton on 12/31/14.
 */
public class Hand implements CardHolderInterface {
    ArrayList<Card> d;

    public Hand() {
        this.d = new ArrayList<Card>(8);
    }

    @Override
    public void viewCards() {

    }

    public ArrayList<Card> getCards() {
        return d;
    }

    @Override
    public void addCard(Card c) {
        this.d.add(c);
        Collections.sort(d);

    }

    @Override
    public Card releaseCardOut(int CardIndex) {
        Card outCard = this.d.remove(CardIndex);
        ;
        Collections.sort(d);
        return outCard;

    }

    public void addCards(ArrayList<Card> cards) {
        d.addAll(cards);
        Collections.sort(d);

    }

    public ArrayList<Card> getCardsOfColor(Card.CARD_COLOR color) {
        ArrayList<Card> returningCards = new ArrayList<Card>(1);
        int fromIndex = -1, toIndex = -1;
        for (int i = 0; i < d.size(); i++) {
            if (d.get(i).cardColor == Card.CARD_COLOR.ROOK) {
                returningCards.add(d.get(i));
            }

            if (d.get(i).cardColor == color) {
                fromIndex = i;
                break;
            }

        }
        if (fromIndex == -1) {
            return d;
        }
        toIndex = fromIndex;
        for (int i = fromIndex; i < d.size(); i++) {
            if (d.get(i).cardColor != color) {
                toIndex = i - 1;
                break;
            }
            toIndex = i;
        }

        returningCards.addAll(d.subList(fromIndex, toIndex + 1));
        return returningCards;
    }


}
