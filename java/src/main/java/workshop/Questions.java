package workshop;

import java.util.LinkedList;

class Questions {
    LinkedList popQuestions = new LinkedList<>();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();
    Questions() {
        for (int index = 0; index < 50; index++) {
            popQuestions.addLast(createPopQuestion(index));
            scienceQuestions.addLast(createScienceQuestion(index));
            sportsQuestions.addLast(createSportsQuestion(index));
            rockQuestions.addLast(createRockQuestion(index));

        }
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }
    public String createScienceQuestion(int index) {
        return "Science Question " + index;
    }
    public String createSportsQuestion(int index) {
        return "Sports Question " + index;
    }
    public String createPopQuestion(int index) {
        return "Pop Question " + index;
    }




    public String nextQuestion(int currentPlace) {
        switch (currentQuestionCategory(currentPlace)) {

            case "Pop":
                return (String) popQuestions.removeFirst();
            case "Science":
                return (String) scienceQuestions.removeFirst();
            case "Sports":
                return (String) sportsQuestions.removeFirst();
            case "Rock":
                return (String) rockQuestions.removeFirst();
            default:
                throw new IllegalStateException("Unexpected value: " + currentQuestionCategory(currentPlace));
        }
    }


    public String currentQuestionCategory(int currentPlace) {
        int PlaceMod4 = currentPlace % 4;
        switch (PlaceMod4) {
            case 0:
                return "Pop";
            case 1:
                return "Science ";
            case 2:
                return "Sports";
            default:
                return "Rock";
        }

    }

}
