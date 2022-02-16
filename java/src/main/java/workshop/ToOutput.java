package workshop;

import java.util.ArrayList;
import java.util.List;

public class ToOutput {
    public static List<String> addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
        return convertedLine;
    }

    public static List<String> pushACharacterToTheOutput(List<String> convertedLine, String characterToConvert) {
        convertedLine.add(characterToConvert);
        return convertedLine;
    }


    public static String addBreakLineToOutput(  List<String> result ) {
        String finalResult = String.join("<br />", result);
        return finalResult;
    }


}
