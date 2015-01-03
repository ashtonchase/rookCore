package rookCore;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ashton on 12/31/14.
 */
public class Hand implements CardHolderInterface{
    ArrayList<Card> d;

    public Hand() {
        this.d=new ArrayList<Card>(8);
    }

    @Override
    public void viewCards() {

    }
    public ArrayList<Card> getCards(){
        return d;
    }

    @Override
    public void addCard(Card c){
        this.d.add(c);

    }
    @Override
    public Card releaseCardOut(int CardIndex) {
    return this.d.remove(CardIndex);
    }

    public void addCards(ArrayList<Card> cards) {
        d.addAll(cards);

    }
}
