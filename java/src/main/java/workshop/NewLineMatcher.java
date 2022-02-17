package workshop;

import java.util.List;

public class NewLineMatcher implements CharacterMatcher{
    @Override
    public boolean matches(char newCharacter) {
        return newCharacter == '\n';
    }

    @Override
    public void addNewCharacter(List<String> convertedLine, String characterToConvert) {
        convertedLine.add("<br />");
        convertedLine.clear();
    }
}
