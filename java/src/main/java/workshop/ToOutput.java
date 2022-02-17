package workshop;

import java.util.ArrayList;
import java.util.List;

public class ToOutput {
    public static void addANewLine(List<String> result, List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
    }

    public static String addBreakLineToOutput(  List<String> result ) {
        String finalResult = String.join("<br />", result);
        return finalResult;
    }


}
