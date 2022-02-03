import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void originalFile() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com","some-page.html"),links);
    }

    @Test
    public void secondFile() throws IOException{
        Path fileName = Path.of("image.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("google.com"),links);
    }

    @Test
    public void ThirdFile() throws IOException{
        Path fileName = Path.of("incorrect.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of(),links);
    }
//------------------------------------------------------------------
//------------------------------------------------------------------
    @Test
    public void getLinks() throws IOException{
        Path fileName = Path.of("Test-file2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(links.size(),0);
    }

    @Test
    public void getLinks2() throws IOException{
        Path fileName = Path.of("Test-file3.md");
	    String contents = Files.readString(fileName);
        try {
            MarkdownParse.getLinks(contents);
            fail();
        }
        catch(IndexOutOfBoundsException e) {
            //test case throws exception
            //test case passed successfully
        }
    }

    @Test
    public void getLinks3() throws IOException{
        Path fileName = Path.of("Test-file4.md");
	    String contents = Files.readString(fileName);
        try {
            MarkdownParse.getLinks(contents);
            fail();
        }
        catch(IndexOutOfBoundsException e) {
            //test case throws exception
            //test case passed successfully
        }
    }

    @Test
    public void additionMistake() {
        assertEquals(10, 1 + 1);
    }
}