package workshop;

import java.util.ArrayList;
import java.util.List;

public class TriviaGame {
    List<Player> players = new ArrayList<>();
    Questions questions = new Questions();


    int currentPlayer = 0;

    public TriviaGame() {

    }

    public void add(String playerName) {

        players.add(new Player(playerName));
        announce(playerName + " was added");
        announce("They are player number " + players.size());
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public void roll(int roll) {
        announce(getCurrentPlayer() + " is the current player");
        announce("They have rolled a " + roll);

        if (getCurrentPlayer().isInPenaltyBox()) {
            if (roll % 2 != 0) {

                getCurrentPlayer().setGettingOutOfPenaltyBox(true);
                announce(getCurrentPlayer() + " is getting out of the penalty box");
                getCurrentPlayer().move(roll);
                announce(getCurrentPlayer() + "'s new location is " + getCurrentPlayer().getPlace());
                announce("The category is " + questions.currentQuestionCategory(getCurrentPlayer().getPlace()));
                askQuestion();
               getCurrentPlayer().setGettingOutOfPenaltyBox(false);

            } else {
                announce(getCurrentPlayer() + " is not getting out of the penalty box");
            }

        } else {
            getCurrentPlayer().move(roll);
            announce(getCurrentPlayer() + "'s new location is " + getCurrentPlayer().getPlace());
            announce("The category is " + questions.currentQuestionCategory(getCurrentPlayer().getPlace()));
            askQuestion();
        }

    }

    public void askQuestion() {
        announce(questions.nextQuestion(getCurrentPlayer().getPlace()));
    }


    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().isInPenaltyBox()) {
            if (getCurrentPlayer().isGettingOutOfPenaltyBox()) {
                announce("Answer was correct!!!!");
                getCurrentPlayer().addToPurse(getCurrentPlayer().getPurses() + 1);
                announce(getCurrentPlayer() + " now has " + getCurrentPlayer().getPurses() + " Gold Coins.");
                boolean winner = getCurrentPlayer().didPlayerWin();
                getNextPlayer();
                return winner;
            } else {
                getNextPlayer();
                return true;
            }
        } else {
            announce("Answer was correct!!!!");
            getCurrentPlayer().addToPurse(getCurrentPlayer().getPurses() + 1);
            announce(getCurrentPlayer() + " now has " + getCurrentPlayer().getPurses() + " Gold Coins.");
            boolean winner = getCurrentPlayer().didPlayerWin();
            getNextPlayer();
            return winner;
        }
    }

    private void getNextPlayer() {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    public boolean wrongAnswer() {
        announce("Question was incorrectly answered");
        announce(getCurrentPlayer() + " was sent to the penalty box");
        getCurrentPlayer().setInPenaltyBox(true);
        getNextPlayer();
        return true;
    }

    protected void announce(Object message) {
        System.out.println(message);
    }
}