import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Input implements Serializable {
    private Integer id;
    private String word;
    private String line;
    private Input next;

    public Input(Integer id, String word, String line) {
        this.id = id;
        this.word = word;
        this.line = line;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Input getNext() {
        return next;
    }

    public void setNext(Input next) {
        this.next = next;
    }
}
