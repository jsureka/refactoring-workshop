package workshop;

public class AndMatcher implements CharacterMatcher{

    @Override
    public boolean matches(char newCharacter) {
        return newCharacter == '&';
    }

    @Override
    public String addNewCharacter() {
        return "&amp;";
    }
}
