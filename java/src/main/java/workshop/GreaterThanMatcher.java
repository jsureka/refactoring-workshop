package workshop;

public class GreaterThanMatcher implements CharacterMatcher{

    @Override
    public boolean matches(char newCharacter) {
        return newCharacter == '>';
    }

    @Override
    public String addNewCharacter() {
        return "&gt;";
    }
}
