package rookCore;


/**
 * Created by ashton on 12/29/14.
 *
 * Cards contain the following fields:
 * Color (4 plus the Rook)
 * FaceValue (which is assigned according to the game)
 * Points(which are assigned according to the game settings)
 *
 * which cards that are used are not fixed, but there is a maximum.that is in a Rook deck, but this will be stored in the Deck Collection)
 */
public class Card {

    byte CardIndex;

    public enum CARD_COLOR {BLUE, BLACK, GREEN, RED, YELLOW};
    public enum CARD_FACE {
        ROOK(0, 20),
        ONE(1, 15),
        FIVE(11, 5),
        SIX(10, 0),
        SEVEN(9, 0),
        EIGHT(8, 0),
        NINE(7, 0),
        TEN(6, 10),
        ELEVEN(5, 0),
        TWELVE(4, 0),
        THIRTEEN(3, 0),
        FOURTEEN(2, 0);

        private final int points;
        private final int rank;

    CARD_FACE(int rank , int points){
        this.rank=rank;
        this.points=points;

    }


        public int points() {return this.points;}
        public int rank() {return this.rank;}



    };


}
