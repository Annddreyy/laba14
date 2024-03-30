import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "::1 128.134.145.145 1.22.256.48 ::: -1.88";
        Pattern pattern1 = Pattern.compile("" +
                "(((\\d|[a-z]){4}:){7}((\\d|[a-z]){4}))" + "|" +
                "((([1-9]|[a-z]){1,4}:){7}([1-9]|[a-z]){1,4})" + "|" +
                "::(([1-9]|[a-z]){1,4}:){1,6}(([1-9]|[a-z]){1,4})?" + "|" +
                "::(([1-9]|[a-z]){1,4})" + "|" +
                "((([1-9]|[a-z]){1,4}:):((([1-9]|[a-z]){1,4}:){0,5})(([1-9]|[a-z]){1,4})?)" + "|" +
                "((([1-9]|[a-z]){1,4}:){2}:((([1-9]|[a-z]){1,4}:){0,4})(([1-9]|[a-z]){1,4})?)" + "|" +
                "((([1-9]|[a-z]){1,4}:){3}:((([1-9]|[a-z]){1,4}:){0,3})(([1-9]|[a-z]){1,4})?)" + "|" +
                "((([1-9]|[a-z]){1,4}:){4}:((([1-9]|[a-z]){1,4}:){0,2})(([1-9]|[a-z]){1,4})?)" + "|" +
                "((([1-9]|[a-z]){1,4}:){5}:((([1-9]|[a-z]){1,4}:)?)(([1-9]|[a-z]){1,4})?)"
        );
        Pattern pattern2 = Pattern.compile("((\\d|[1-9]\\d|1\\d{2}|2[0-4][0-9]|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d{2}||2[0-4][0-9]|25[0-5])");
        String[] numbers = text.split(" ");
        for (String digit : numbers){
            Matcher matcher = pattern1.matcher(digit);
            if (matcher.find())
                System.out.println(digit + " - " + "корректный ip v6");
            else{
                matcher = pattern2.matcher(digit);
                if (matcher.find())
                    System.out.println(digit + " - " + "корректный ip v4");
                else
                    System.out.println(digit + " - " + "некорректный ip адрес");
            }
        }
    }
}
