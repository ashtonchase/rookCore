package rookCore;

import java.util.*;

/**
 * Created by ashton on 12/29/14.
 */
public class DeckCollection implements CardHolderInterface{

    DeckCollection(GameConfig G) {
    }

    public List<CardClass> getDeck() {
        return Deck;
    }



    private List<CardClass> Deck = new ArrayList<CardClass>();


    @Override
    public void viewCards() {

    }

    @Override
    public void releaseCardOut(byte CardIndex) {

    }
}
