package workshop;

import java.util.List;

public class defaultMatcher implements CharacterMatcher{

    @Override
    public boolean matches(char newCharacter) {
        return (newCharacter != '<' && newCharacter != '>' && newCharacter != '&' && newCharacter != '\n');
    }

    @Override
    public void addNewCharacter(List<String> convertedLine, String characterToConvert) {
        convertedLine.add(characterToConvert);
    }
}
