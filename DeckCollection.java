package rookCore;

import java.util.*;

/**
 * Created by ashton on 12/29/14.
 */
public class DeckCollection implements CardHolderInterface{

    Map<String,Card> d;

    public DeckCollection(GameConfig gameConfig) {
        //d=new (Card)ArrayList();
        this.buildDeck(gameConfig);
    }






    private void buildDeck(GameConfig gameConfig){
        if(gameConfig.isIncludeBlueRaven()){
            d.put("RR", new Card(Card.CARD_COLOR.ROOK, Card.CARD_FACE.ROOK, gameConfig.getBlueRavenRank()));
        }
        if(gameConfig.isIncludeOnes()){
            if(gameConfig.isHighTrumpOne()){
                d.put("H1",new Card(gameConfig.getHighTrumpOneColor(), Card.CARD_FACE.ONE, Card.CARD_RANK.HIGHONE));
            }
            else{
                d.put("B1",new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                d.put("G1",new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                d.put("Y1",new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
                d.put("R1",new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.ONE, Card.CARD_RANK.ONE));
            }
        }
        if (gameConfig.isIncludeTwosThruFours()){
            d.put("B2",new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.put("G2",new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.put("Y2",new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.put("R2",new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.TWO, Card.CARD_RANK.TWO));
            d.put("B3",new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.put("G3",new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.put("Y3",new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.put("R3",new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.THREE, Card.CARD_RANK.THREE));
            d.put("B4",new Card(Card.CARD_COLOR.BLACK, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            d.put("G4",new Card(Card.CARD_COLOR.GREEN, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            d.put("Y4",new Card(Card.CARD_COLOR.YELLOW, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
            d.put("R4",new Card(Card.CARD_COLOR.RED, Card.CARD_FACE.FOUR, Card.CARD_RANK.FOUR));
        }
        for (Card.CARD_COLOR c: Card.CARD_COLOR.values()) {
            if(c== Card.CARD_COLOR.ROOK) continue;
            d.put(c.getAbbrev()+"5",new Card(c, Card.CARD_FACE.FIVE, Card.CARD_RANK.FIVE));
            d.put(c.getAbbrev()+"6",new Card(c, Card.CARD_FACE.SIX, Card.CARD_RANK.SIX));
            d.put(c.getAbbrev()+"7",new Card(c, Card.CARD_FACE.SEVEN, Card.CARD_RANK.SEVEN));
            d.put(c.getAbbrev()+"8",new Card(c, Card.CARD_FACE.EIGHT, Card.CARD_RANK.EIGHT));
            d.put(c.getAbbrev()+"9",new Card(c, Card.CARD_FACE.NINE, Card.CARD_RANK.NINE));
            d.put(c.getAbbrev()+"10",new Card(c, Card.CARD_FACE.TEN, Card.CARD_RANK.TEN));
            d.put(c.getAbbrev()+"11",new Card(c, Card.CARD_FACE.ELEVEN, Card.CARD_RANK.ELEVEN));
            d.put(c.getAbbrev()+"12",new Card(c, Card.CARD_FACE.TWELVE, Card.CARD_RANK.TWELVE));
            d.put(c.getAbbrev()+"13",new Card(c, Card.CARD_FACE.THIRTEEN, Card.CARD_RANK.THIRTEEN));
            d.put(c.getAbbrev()+"13",new Card(c, Card.CARD_FACE.FOURTEEN, Card.CARD_RANK.FOURTEEN));
        }





        //build the standard cards in ever deck first



    }






    @Override
    public void viewCards() {

    }

    @Override
    public void releaseCardOut(byte CardIndex) {

    }
}
