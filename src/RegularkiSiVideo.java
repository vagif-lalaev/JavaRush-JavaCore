import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularkiSiVideo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\d+");
        for (String value : new String [] {"1234", "sdfssfs", "!@#$%^&*"}) {
            Matcher m = pattern.matcher(value);
            System.out.println(value);
            boolean result = m.matches();
            System.out.println("matcher: " + result);
            if (result) {
                System.out.printf("Matches %d until %d => %s\n", m.start(), m.end(), m.group());
            }
            m.reset();
            while(m.find()) {
                System.out.printf("From %d until %d => %s\n", m.start(), m.end(), m.group());
            }
            System.out.println();
        }

    }
}
