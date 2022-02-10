import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
// On ieng6
// javac -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:. MarkdownParseTest.java
// java -cp lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore MarkdownParseTest
// On windows
// javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java 
// java -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
// change test
public class MarkdownParseTest {
    @Test
    public void tester() throws IOException {
        List<String> expected = List.of("[]","[]","[]","[https://something.com]");
        List<String> list = List.of("empty-file.md", "empty-link.md", "image-file.md", "noperiod-file.md");
        for (int i=0; i<list.size(); i++) {
            Path fileName = Path.of(list.get(i));
            String contents = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(expected.get(i), links.toString());
        }
    }

}