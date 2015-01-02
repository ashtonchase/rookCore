package rookCore;

import java.util.ArrayList;

/**
 * Created by ashton on 1/1/15.
 */
public class Widow implements CardHolderInterface{
ArrayList<Card> cards;

    public Widow() {
        cards=new ArrayList<Card>(5);
    }

    @Override
    public void viewCards() {

    }
    public void addCard(Card c){
        cards.add(c);

    }
    @Override
    public Card releaseCardOut(int CardIndex) {
    return cards.remove(CardIndex);
    }
}
