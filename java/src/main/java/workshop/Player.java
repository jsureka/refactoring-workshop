package workshop;

public class Player {
    private String playerName;
    private int place = 0;
    private boolean inPenaltyBox = false;
    private int purses = 0;
    private boolean isGettingOutOfPenaltyBox;
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void setInPenaltyBox(boolean inPenaltyBox) {
        this.inPenaltyBox = inPenaltyBox;
    }

    public int getPurses() {
        return purses;
    }

    public void addToPurse(int purses) {
        this.purses = purses;
    }


    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }

    void move(int roll) {
        this.place = this.place + roll;
        if (this.place > 11)
            this.place = this.place - 12;
    }

    boolean didPlayerWin() {
        return !(getPurses()== 6);
    }
}
