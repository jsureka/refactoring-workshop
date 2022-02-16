package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {

    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String read() throws IOException {
        Path filePath = Paths.get("sample.txt");
        byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        CharacterMatcher matcher = new CharacterMatcher() {
            @Override
            public boolean matches(char newCharacter) {
                return false;
            }

            @Override
            public String addNewCharacter() {
                return null;
            }
        };
        for (char characterToConvert : source.toCharArray()) {
            if(matcher.matches(characterToConvert)){
                matcher.addNewCharacter();
            }
            else
               convertedLine = ToOutput.pushACharacterToTheOutput(convertedLine, String.valueOf(characterToConvert));
        }
        result = ToOutput.addANewLine(result,convertedLine);
        return ToOutput.addBreakLineToOutput(result);
    }

}
