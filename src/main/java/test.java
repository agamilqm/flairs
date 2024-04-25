import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args)
    {
//        String regEx = "\\(\\s*(\\d+)\\s*\\)";
//        String recordsFoundString = "(8) Records Found";
//        Pattern pattern = Pattern.compile(regEx);
//        Matcher matcher = pattern.matcher(recordsFoundString);
////        Integer recordValueInt = Integer.parseInt();
//
//        System.out.println(recordsFoundString);
//        System.out.println(matcher.group());

        String input = "(8) Records Found"; // Make sure this matches your actual input scenario
        String regex = "\\(\\s*(\\d+)\\s*\\)"; // Regex to match digits within parentheses, ignoring spaces

        System.out.println("Input: " + input);
        System.out.println("Regex: " + regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String number = matcher.group(1);
            System.out.println("The number inside the parentheses is: " + number);
        }
    }
}
