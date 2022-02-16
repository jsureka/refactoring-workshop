package workshop;

public class NewLineMatcher implements CharacterMatcher{
    @Override
    public boolean matches(char newCharacter) {
        return newCharacter == '\n';
    }

    @Override
    public String addNewCharacter() {
        return "\n";
    }
}
