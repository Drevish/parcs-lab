import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalApp {
    private final static String FILENAME = "out/inp";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(FILENAME));
        String word = sc.next();
        String text = Files.readString(Path.of(FILENAME));
        text = text.substring(text.indexOf("\n"));
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        int wordOccurrences = 0;
        while (matcher.find()) {
            wordOccurrences++;
        }

        System.out.println("Result: " + wordOccurrences + " occurrences found.");
    }
}
