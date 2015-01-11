package rookCore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.List;

import static java.util.Collections.*;

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


}
