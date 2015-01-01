package rookCore;


/**
 * Created by ashton on 12/29/14.
 * <p/>
 * Cards contain the following fields:
 * Color (4 plus the Rook)
 * FaceValue (which is assigned according to the game)
 * Points(which are assigned according to the game settings)
 * <p/>
 * which cards that are used are not fixed, but there is a maximum.that is in a Rook deck, but this will be stored in the Deck Collection)
 */
public class Card {
    CARD_COLOR cardColor;
    CARD_FACE cardFace;
    CARD_RANK cardRank;

    public Card(CARD_COLOR cardColor, CARD_FACE cardFace, CARD_RANK cardRank) {
        if (cardColor == null || cardFace == null) throw new IllegalArgumentException("Parameters can't be null");
        if (cardFace == CARD_FACE.ROOK) {
            this.cardColor = CARD_COLOR.ROOK;
            this.cardRank = cardRank;
            return;
        }

        this.cardColor = cardColor;
        this.cardFace = cardFace;
        this.cardRank = cardRank;
    }


    public CARD_COLOR getCardColor() {
        return cardColor;
    }

    public void setCardColor(CARD_COLOR cardColor) {
        this.cardColor = cardColor;
    }

    public CARD_FACE getCardFace() {
        return cardFace;
    }

    public void setCardFace(CARD_FACE cardFace) {
        this.cardFace = cardFace;
    }

    public CARD_RANK getCardRank() {
        return cardRank;
    }

    public void setCardRank(CARD_RANK cardRank) {
        this.cardRank = cardRank;
    }


    public enum CARD_COLOR {ROOK("O"), BLACK("B"), GREEN("G"), RED("R"), YELLOW("Y");
        private final String abbrev;

        String getAbbrev() {
            return this.abbrev;
        }

        CARD_COLOR(String abb){

            this.abbrev=abb;
        }


    }

    ;

    public enum CARD_FACE {
        ROOK(20),
        ONE(15),
        TWO(0),
        THREE(0),
        FOUR(0),
        FIVE(5),
        SIX(0),
        SEVEN(0),
        EIGHT(0),
        NINE(0),
        TEN(10),
        ELEVEN(0),
        TWELVE(0),
        THIRTEEN(0),
        FOURTEEN(0);

        private final int points;


        CARD_FACE(int points) {
            this.points = points;

        }


        public int points() {
            return this.points;
        }


    }

    public enum CARD_RANK{
        LOWROOK(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        MIDROOK(11),
        ELEVEN(12),
        TWELVE(13),
        THIRTEEN(14),
        FOURTEEN(15),
        ONE(16),
        HIGHROOK(17),
        HIGHONE(18);

        private final int rank;

                CARD_RANK(int rank){
                    this.rank=rank;
                }
    }

}
