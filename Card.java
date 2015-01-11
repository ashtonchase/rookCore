package rookCore;


import java.util.Comparator;

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
public class Card implements Comparator<Card>, Comparable<Card> {
    CARD_COLOR cardColor;
    CARD_FACE cardFace;
    CARD_RANK cardRank;

    public Card(CARD_COLOR cardColor, CARD_FACE cardFace, CARD_RANK cardRank) {
        if (cardColor == null || cardFace == null) throw new IllegalArgumentException("Parameters can't be null");
        if (cardFace == CARD_FACE.ROOK) {
            this.cardFace = CARD_FACE.ROOK;
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

    @Override
    public String toString() {
        return cardColor.toString() + " " + cardFace.toString();
    }

    @Override
    public int compare(Card c1, Card c2) {
        if (c1.cardColor.value > c2.cardColor.value) {
            return 1;
        } else if (c1.cardColor == c2.cardColor) {
            if (c1.cardRank.rank > c2.cardRank.rank) {
                return 1;
            } else if (c1.cardRank.rank == c2.cardRank.rank)
                return 0;
        }
        return -1;
    }

    @Override
    public int compareTo(Card card) {
        return compare(this, card);
    }


    public enum CARD_COLOR {
        ROOK("O", 0), BLACK("B", 1), GREEN("G", 2), RED("R", 3), YELLOW("Y", 4);
        private final String abbrev;
        private final int value;

        CARD_COLOR(String abb, int value) {
            this.value = value;
            this.abbrev = abb;
        }

        String getAbbrev() {
            return this.abbrev;
        }

    }



    public enum CARD_FACE {
        ROOK(20, 0),
        ONE(15, 15),
        TWO(0, 2),
        THREE(0, 3),
        FOUR(0, 4),
        FIVE(5, 5),
        SIX(0, 6),
        SEVEN(0, 7),
        EIGHT(0, 8),
        NINE(0, 9),
        TEN(10, 10),
        ELEVEN(0, 11),
        TWELVE(0, 12),
        THIRTEEN(0, 13),
        FOURTEEN(0, 14);

        private final int points;
        private final int value;


        CARD_FACE(int points, int value) {
            this.points = points;
            this.value = value;

        }

        public int points() {
            return this.points;
        }
    }

    public enum CARD_RANK {
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

        CARD_RANK(int rank) {
            this.rank = rank;
        }
    }

}
