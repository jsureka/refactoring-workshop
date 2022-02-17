package workshop;

public class BuzzPatternMatcher implements PatternMatcher{

    @Override
    public boolean matches(int number) {
        // TODO Auto-generated method stub
        return number %5 == 0;
    }

    public String generateResponse(){
        return "Buzz";

    }
}
