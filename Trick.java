package rookCore;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashton on 1/1/15.
 */
public class Trick {
    Card[] cardArray;
    Player[] players;
    byte arrayIndex;

    public Trick(Player[] players) {
        cardArray = new Card[4];
        arrayIndex = 0;

    }

    public void PlaceCardOnTable(Card card, Player playingPlayer) {
        for (int i = 0; i < cardArray.length; i++) {
            if (playingPlayer == players[i]) {
                cardArray[i] = card;
            }

        }

    }


}
