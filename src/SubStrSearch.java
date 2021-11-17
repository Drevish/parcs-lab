import parcs.AM;
import parcs.AMInfo;
import parcs.channel;
import parcs.point;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStrSearch implements AM {
    @Override
    public void run(AMInfo info) {
        Input n = (Input)info.parent.readObject();
        System.out.println("[" + n.getId() + "] line search started.");


        Pattern pattern = Pattern.compile(n.getWord(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(n.getLine());
        int wordOccurrences = 0;
        while (matcher.find()) {
            wordOccurrences++;
        }
        System.out.println("[" + n.getId() + "] line " + wordOccurrences + " occurrences found.");


        if (n.getId() == 0) {
            List<point> points = new ArrayList<>();
            List<channel> chans = new ArrayList<>();
            Input cur = n;
            while (true) {
                point p = info.createPoint();
                channel c = p.createChannel();
                p.execute("SubStrSearch");
                c.write(cur);
                points.add(p);
                chans.add(c);
                cur = cur.getNext();
                if (cur == null) break;
            }

            for (channel c: chans) {
                wordOccurrences += c.readInt();
            }
        }


        System.out.println("[" + n.getId() + "] line search finished.");
        info.parent.write(wordOccurrences);
    }
}
