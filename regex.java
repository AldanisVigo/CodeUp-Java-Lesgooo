import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class regex {
    public static void main(String[] args){
        //RegEx - Regular Expressions
        /*
            A sequence of characters that defines a search pattern
            
            can be used for any text search or text replace operation

            Java Regex is a Java implementation of Regular Expressions

            Matcher Class - Used to match a character sequence
            ---------------------------------------------------
            boolean matches() -> Tests wether the regular expression matches or not.
            boolean find() -> Used to find the next expression that matches the pattern.
            boolean find(int start) -> Searches the next expression starting from the start index
            String group() -> Used to return the matched sequence.
            int start() -> Returns the starting index.
            int end() -> Returns ending index of the regular expression


            Pattern Class - Used to define the pattern for a regex engine
            -------------------------------------------------------------
            Static Pattern compile(String regex) -> Compiles the given regex expression and returns the instance of a pattern.
            Matcher matcher(charSequence input) -> Used to create a matcher that matches the given input with a pattern.
            Static boolean matches(String regex) -> It works as a combination of the compile and matcher methods.
            String split[] -> Used to split the given String around matches of a given pattern
            String pattern() -> Helps to return the regex pattern
            Int end() -> Returns the ending index.

            Regex Metacharacters
            --------------------
            . -> It can be any character.
            d -> Represents any digits
            D -> Represents any non digit
            s -> Represents any white space
            S -> Non white space character
            w -> It can be a word character ()
            W -> It can be a word character
            b -> Represents a word boundary
         */

        //Example: Matching a phone number pattern
        String phoneExpression = "(254)394-9926";
        String phoneNumberPtrn = "\\(\\d{3}\\)\\d{3}-\\d{4}"; //Match phone number pattern (ddd)ddd-dddd
        Pattern phoneNumberPattern = Pattern.compile(phoneNumberPtrn);
        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneExpression);
        Boolean phoneMatches = phoneNumberMatcher.matches();
        System.out.printf("Does the expression %s match the pattern %s ? %b\n",phoneExpression,phoneNumberMatcher.pattern(),phoneMatches);

        //Example: Matching an email pattern
        String emailExpression = "aldanisvigo@gmail.com";
        String emailPtrn = "\\w{0,30}@\\w{0,30}\\.\\w{3}"; //Match email xxxxx@xxxxxx.xxx
        Pattern emailPattern = Pattern.compile(emailPtrn);
        Matcher emailMatcher = emailPattern.matcher(emailExpression);
        Boolean emailMatches = emailMatcher.matches();
        System.out.printf("Does the expression %s match the pattern %s ? %b\n",emailExpression,emailMatcher.pattern(),emailMatches);
    }
}
