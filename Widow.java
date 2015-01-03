package rookCore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by ashton on 1/1/15.
 */
public class Widow implements CardHolderInterface{
ArrayList<Card> cards;

    public Widow() {
        cards=new ArrayList<Card>(5);
    }

    public void clearWidow(){
        cards.clear();

    }


    public ArrayList<Card> releaseWidow(){
        return cards;

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
