package workshop;

public class LessThanMatcher implements CharacterMatcher{

    @Override
    public boolean matches(char newCharacter) {
        return newCharacter == '<';
    }

    @Override
    public String addNewCharacter() {
        return "&lt;";
    }
}
