package workshop;

import java.util.List;

public interface CharacterMatcher {

    public boolean matches(char newCharacter);
    public void addNewCharacter(List<String> convertedLine, String characterToConvert);

}
