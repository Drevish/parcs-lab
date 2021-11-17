import parcs.AMInfo;
import parcs.channel;
import parcs.point;
import parcs.task;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws Exception {
        task curtask = new task();
        curtask.addJarFile("SubStrSearch.jar");
        Input n = fromFile(curtask.findFile("inp"));

        AMInfo info = new AMInfo(curtask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("SubStrSearch");
        c.write(n);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readLong());
        curtask.end();
    }

    public static Input fromFile(String filename) throws Exception {
        Scanner sc = new Scanner(new File(filename));
        String word = sc.next();
        String text = Files.readString(Path.of(filename));
        text = text.substring(text.indexOf("\n"));
        int wordSize = word.length();
        int lineSize = (100 - wordSize);

        Input cur = null;
        Input root = null;

        int counter = 0;
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < text.length() / lineSize; i++) {
            String line = text.substring(counter + 1, counter + 100);
            counter += lineSize;
            if (i == 0) {
                cur = new Input(i, word, line);
                root = cur;
            } else {
                cur.setNext(new Input(i, word, line));
                cur = cur.getNext();
            }
        }

        return root;
    }
}
