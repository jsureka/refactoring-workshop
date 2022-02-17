package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
        ToOutput toOutput = new ToOutput();
        List<CharacterMatcher> characterMatchers = new ArrayList<CharacterMatcher>(Arrays.asList(new NewLineMatcher(), new GreaterThanMatcher(), new LessThanMatcher(), new AndMatcher(), new defaultMatcher()));
        for (char characterToConvert : source.toCharArray()) {
            for (CharacterMatcher matcher: characterMatchers
                 ) {
                if(matcher.matches(characterToConvert)){
                     matcher.addNewCharacter(convertedLine, Character.toString(characterToConvert));
                }

            }
        }
//            ToOutput.addANewLine(result, convertedLine);
//            convertedLine.clear();
//

        toOutput.addANewLine(result,convertedLine);
        convertedLine.clear();
        return toOutput.addBreakLineToOutput(result);
    }

}
