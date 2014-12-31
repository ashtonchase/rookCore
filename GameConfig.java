package rookCore;

/**
 * Created by ashton on 12/31/14.
 *
 * @TODO: Implement the checking of the error handling bits.
 * @TODO: Need to implement the upperBidLimit();
 *
 * Created by ashton on 12/31/14.
 *
 * This class will store all the game settings;
 *<p/>
 *  */
public class GameConfig {


    int GameConfigError;
    private boolean includeOnes;
    private boolean includeTwosThruFours;
    private boolean highTrumpOne;
    private Card.CARD_COLOR highTrumpColor;
    private boolean includeBlueRaven;
    private boolean playBlueRavenAnytime;
    private BLUE_RAVEN_RANK blueRavenRank;
    private short minimumBid;
    private String nestName;
    private boolean revealNestAfterBidding;
    private boolean winningBidderLeads;
    private boolean forceTrumpCantFollowSuit;
    private boolean lastTrickWinnerTakesNest;
    private short bonusAllPoints, bonusAllTricks, bonusMostTricks;
    private short winningScore;

    public GameConfig(){
        includeOnes = true;
        includeTwosThruFours = false;
        highTrumpOne = false;
        highTrumpColor = Card.CARD_COLOR.GREEN;
        includeBlueRaven = true;
        playBlueRavenAnytime = true;
        blueRavenRank = GameConfig.BLUE_RAVEN_RANK.HIGH;
        minimumBid = 100;
        nestName = "Widow";
        revealNestAfterBidding = false;
        winningBidderLeads = true;
        forceTrumpCantFollowSuit = false;
        lastTrickWinnerTakesNest = true;
        bonusAllPoints = 0;
        bonusAllTricks = 0;
        bonusMostTricks = 0;
        winningScore = 300;


    }





    public GameConfig(boolean includeOnes, boolean includeTwosThruFours, boolean highTrumpOne, Card.CARD_COLOR highTrumpColor, boolean includeBlueRaven, boolean playBlueRavenAnytime, BLUE_RAVEN_RANK blueRavenRank, short minimumBid, String nestName, boolean revealNestAfterBidding, boolean winningBidderLeads, boolean forceTrumpCantFollowSuit, boolean lastTrickWinnerTakesNest, short bonusAllPoints, short bonusAllTricks, short bonusMostTricks, short winningScore) {
        this.GameConfigError = GAME_CONFIG_ERROR_BITS.NO_ERROR.bit;
        this.includeOnes = includeOnes;
        this.includeTwosThruFours = includeTwosThruFours;
        if (this.includeOnes) {
            if (highTrumpOne) {
                this.highTrumpOne = highTrumpOne;
                this.highTrumpColor = highTrumpColor;
            }
        }
        this.includeBlueRaven = includeBlueRaven;
        if (this.includeBlueRaven) {
            this.playBlueRavenAnytime = playBlueRavenAnytime;
            this.blueRavenRank = blueRavenRank;
        }
        this.nestName = nestName;
        this.revealNestAfterBidding = revealNestAfterBidding;
        this.winningBidderLeads = winningBidderLeads;
        this.forceTrumpCantFollowSuit = forceTrumpCantFollowSuit;
        this.lastTrickWinnerTakesNest = lastTrickWinnerTakesNest;
        this.bonusAllPoints = bonusAllPoints;
        this.bonusAllTricks = bonusAllTricks;
        this.bonusMostTricks = bonusMostTricks;
        this.setWinningScore(winningScore);
        this.setMinimumBid(minimumBid);

    }

    public boolean isIncludeOnes() {
        return includeOnes;
    }

    public boolean isIncludeTwosThruFours() {
        return includeTwosThruFours;
    }

    public boolean isHighTrumpOne() {
        return highTrumpOne;
    }

    public Card.CARD_COLOR getHighTrumpColor() {
        return highTrumpColor;
    }

    public boolean isIncludeBlueRaven() {
        return includeBlueRaven;
    }

    public boolean isPlayBlueRavenAnytime() {
        return playBlueRavenAnytime;
    }

    public short getMinimumBid() {
        return minimumBid;
    }

    private void setMinimumBid(short minimumBid) {
        short requiredMinBid = 0;

        if (requiredMinBid > minimumBid) {
            this.GameConfigError += GAME_CONFIG_ERROR_BITS.MIN_BID_ERROR.bit;
            this.minimumBid = requiredMinBid;
            return;
        }
        this.minimumBid = minimumBid;

    }

    public String getNestName() {
        return nestName;
    }

    public boolean isRevealNestAfterBidding() {
        return revealNestAfterBidding;
    }

    public boolean isWinningBidderLeads() {
        return winningBidderLeads;
    }

    public boolean isForceTrumpCantFollowSuit() {
        return forceTrumpCantFollowSuit;
    }

    public boolean isLastTrickWinnerTakesNest() {
        return lastTrickWinnerTakesNest;
    }

    public short getBonusAllPoints() {
        return bonusAllPoints;
    }

    public short getBonusAllTricks() {
        return bonusAllTricks;
    }

    public short getBonusMostTricks() {
        return bonusMostTricks;
    }

    public int getWinningScore() {
        return winningScore;
    }

    private void setWinningScore(short winningScore) {
        if (winningScore < 0 || winningScore > 10000) {
            this.GameConfigError += GAME_CONFIG_ERROR_BITS.WIN_SCORE_ERROR.bit;
            this.winningScore = 300;
            return;
        }
        this.winningScore = winningScore;
    }

  public enum BLUE_RAVEN_RANK {
        LOW(0.0),
        MID(10.5),
        HIGH(20.0);
        private final double rank;

        BLUE_RAVEN_RANK(double rank) {
            this.rank = rank;
        }

    }

    public enum GAME_CONFIG_ERROR_BITS {
        NO_ERROR(0),
        MIN_BID_ERROR(1),
        WIN_SCORE_ERROR(2);

        private final int bit;

        GAME_CONFIG_ERROR_BITS(int bit) {
            this.bit = bit;
        }

    }
}
