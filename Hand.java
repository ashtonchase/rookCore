package rookCore;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ashton on 12/31/14.
 */
public class Hand implements CardHolderInterface{
    ArrayList<Card> d;

    @Override
    public ArrayList<Card> viewCards() {
        return d;
    }

    @Override
    public void releaseCardOut(byte CardIndex) {

    }
}
