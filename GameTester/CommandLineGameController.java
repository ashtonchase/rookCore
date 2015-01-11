package rookCore.GameTester;

import rookCore.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ashton on 1/1/15.
 */
public class CommandLineGameController extends GameController implements PlayerCommChannelInterface {
    BufferedReader is;
    String[] s;
    //String s = null;


    public CommandLineGameController() {

        super();
        is = new BufferedReader(new InputStreamReader(System.in));
    }

    public void startGame() {

        super.gameControllerDefault();
    }

    @Override
    protected void reloadWidow(Player p) {
        System.out.println(p.getName() + ", please select 5 cards to place back into the Widow:");
        for (int i = 0; i < 4; i++) {
            Card c = cardPuller(p);
            System.out.println("You picked: " + c.toString());
            super.widow.addCard(c);
            if (i < 3) System.out.println("Please choose another card.");
        }


    }

    @Override
    protected void requestTrump(Player p, Card.CARD_COLOR trumpColor) {
        listCards(p);
        System.out.println(p.getName() + " please choose trumps: (B)lack (G)reen (R)ed (Y)ellow");

        char trump = 'X';
        try {
            trump = is.readLine().charAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (trump) {
            case 'B':
                trumpColor = Card.CARD_COLOR.BLACK;
                System.out.println("Trumps is: " + trumpColor.toString());
                break;
            case 'G':
                trumpColor = Card.CARD_COLOR.GREEN;
                System.out.println("Trumps is: " + trumpColor.toString());
                break;
            case 'R':
                trumpColor = Card.CARD_COLOR.RED;
                System.out.println("Trumps is: " + trumpColor.toString());
                break;
            case 'Y':
                trumpColor = Card.CARD_COLOR.YELLOW;
                System.out.println("Trumps is: " + trumpColor.toString());
                break;
            default:
                System.out.println("ERROR: Please enter one of the designated letters. Try again");
                requestTrump(p, trumpColor);
                break;
        }
    }


    @Override
    protected void postBidUpdate() {

    }

    @Override
    protected void notifyGameExit() {
        System.out.println("------GAME OVER-------");
    }

    @Override
    protected void assignTeams() {


        int playerOne = 0;
        int playerTwo = 0;
        ArrayList<Player> playerPicker = new ArrayList<Player>(4);

        for (int i = 0; i < super.players.size(); i++) {
            playerPicker.add(super.players.get(i));
        }

        System.out.print("Pick two players of the same team (Eg. 1 <enter> 4):" +
                "  1)" + super.players.get(0).name +
                "  2)" + super.players.get(1).name +
                "  3)" + super.players.get(2).name +
                "  4)" + super.players.get(3).name);
        System.out.println();
        try {
            playerOne = Integer.parseInt(is.readLine()) - 1;
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        System.out.println("You chose:" + super.players.get(playerOne).name + ".");
        System.out.print("Please choose the other player:");
        try {
            playerTwo = Integer.parseInt(is.readLine()) - 1;
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }
        System.out.println("You chose:" + super.players.get(playerTwo).name);
        team[0] = new Team(playerPicker.get(playerOne), playerPicker.get(playerTwo));
        ArrayList<Player> playersPicked = new ArrayList<Player>(2);
        playersPicked.add(super.players.get(playerOne));
        playersPicked.add(super.players.get(playerTwo));
        playerPicker.removeAll(playersPicked);
        team[1] = new Team(playerPicker.remove(0), playerPicker.remove(0));

        System.out.println("Team One: " + team[0].getPlayerNames());
        System.out.println("Team Two: " + team[1].getPlayerNames());
        Collections.swap(super.players, playerTwo, 2);

    }

    @Override
    protected void setGameConfig() {

    }

    @Override
    protected void storeGameState() {

    }

    @Override
    protected void storeGameConfig() {

    }

    @Override
    protected boolean createPlayerConnection(Player p) {
        return false;
    }

    @Override
    protected void getPlayerNames() {
        if (true) {
            System.out.print("Player Name (Your Name):");
            try {
                super.players.get(0).setName(is.readLine().toString());
            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }
            for (int i = 1; i < super.players.size(); i++) {
                System.out.print("Next Player's Name:");
                try {
                    super.players.get(i).setName(is.readLine().toString());
                } catch (IOException ioe) {
                    System.out.println("IO error trying to read your name!");
                    System.exit(1);
                }
            }
        } else return;
    }

    @Override
    protected void playTrick() {
        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(gameState.getLeadNextTrick());
        Iterator iterator = super.players.iterator();
        int j = super.players.indexOf(gameState.getLeadNextTrick()) + 1;
        for (int i = 0; i < 3; i++, j++) {
            if (j > 3)
                j = 0;
            playerList.add(super.players.get(j));

        }

        Card.CARD_COLOR playedColor;
        ArrayList<Card> cardsOfTrick = new ArrayList<Card>(4);
        for (Player p : playerList) {
            System.out.flush();
            cardsOfTrick.add(requestCardPlay(p));

            if (p.equals(playerList.get(0))) {
            }
            postCard(p, cardsOfTrick.get(cardsOfTrick.size() - 1));
            //TODO:determine winner and post points;
        }

    }

    @Override
    protected void postCard(Player p, Card c) {
        //update display of played card.
        System.out.println(p.getName() + " played " + c.toString());
    }

    @Override
    public void SetPlayerNames(String[] names) {
        this.s = names;


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void SendUpdatedGameState(Player p, GameState currentState) {

    }

    @Override
    public void AttachInterface() {

    }

    @Override
    public int requestBid(Player p) {


        System.out.print(p.getName() + " Bid (" + super.tempBid + ") or higher. (C)heck or (P)ass  :");
        String input = null;
        try {
            input = is.readLine();
        } catch (IOException ioe) {
            System.out.println("IO Error trying to read card");
            System.exit(1);
        }

        if (input.equalsIgnoreCase("P")) {
            p.setPassBid(true);

            return 0;
        } else if (input.equalsIgnoreCase("C")) {
            p.setCheck(true);
            return 0;

        } else if (Integer.parseInt(input) < super.tempBid) {
            System.out.println("ERROR: You must bit at least " + super.tempBid + " or higher. Bid again.");
            requestBid(p);
        }
        tempBid = Integer.parseInt(input);
        return Integer.parseInt(input);

    }

    @Override
    public boolean playerSignalledPass(Player p) {
        return false;
    }

    @Override
    public boolean playedSignalledCheck(Player p) {
        return false;
    }

    @Override
    public Card requestCardPlay(Player p) {
        System.out.println("Play Card For: " + p.getName());
        return cardPuller(p);
    }

    public Card cardPuller(Player p) {
        ArrayList<Card> c = p.getHand();
        int i = 0;
        for (Card card : c) {
            System.out.println(i + ") " + card.toString());
            i++;
        }


        int pickedCardIndex = 0;
        try {
            pickedCardIndex = Integer.parseInt(is.readLine());
        } catch (IOException ioe) {
            System.out.println("IO Error trying to read card");
            System.exit(1);
        }


        return c.remove(pickedCardIndex);
    }

    @Override
    public void run() {

    }

    public void listCards(Player p) {
        ArrayList<Card> c = p.getHand();
        int i = 0;
        for (Card card : c) {
            System.out.println(i + ") " + card.toString());
            i++;
        }

    }
}
