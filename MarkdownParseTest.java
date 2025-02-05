import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
//     @Test
//     public void addition() {
//         assertEquals(2, 1 + 1);
//     }

//     @Test
//     public void originalFile() throws IOException{
//         Path fileName = Path.of("test-file.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> links = MarkdownParse.getLinks(contents);
//         assertEquals(List.of("https://something.com","some-page.html"),links);
//     }

//     @Test
//     public void secondFile() throws IOException{
//         Path fileName = Path.of("image.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> links = MarkdownParse.getLinks(contents);
//         assertEquals(List.of("google.com"),links);
//     }

//     @Test
//     public void ThirdFile() throws IOException{
//         Path fileName = Path.of("incorrect.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> links = MarkdownParse.getLinks(contents);
//         assertEquals(List.of(),links);
//     }
// //------------------------------------------------------------------
// //------------------------------------------------------------------
//     @Test
//     public void getLinks() throws IOException{
//         Path fileName = Path.of("Test-file2.md");
// 	    String contents = Files.readString(fileName);
//         ArrayList<String> links = MarkdownParse.getLinks(contents);
//         assertEquals(links.size(),0);
//     }

//     @Test
//     public void getLinks2() throws IOException{
//         Path fileName = Path.of("Test-file3.md");
// 	    String contents = Files.readString(fileName);
//         try {
//             MarkdownParse.getLinks(contents);
//             fail();
//         }
//         catch(IndexOutOfBoundsException e) {
//             //test case throws exception
//             //test case passed successfully
//         }
//     }

//     @Test
//     public void getLinks3() throws IOException{
//         Path fileName = Path.of("Test-file4.md");
// 	    String contents = Files.readString(fileName);
//         try {
//             MarkdownParse.getLinks(contents);
//             fail();
//         }
//         catch(IndexOutOfBoundsException e) {
//             //test case throws exception
//             //test case passed successfully
//         }
//     }

//     @Test
//     public void additionMistake() {
//         assertEquals(2, 1 + 1);
//     }

//     @Test
//     public void testSpaceAfterParen() {
//         String contents = "[title]( space-in-url.com)";
//         List<String> expect = List.of("space-in-url.com");
//         assertEquals(expect, MarkdownParse.getLinks(contents));
//     }

    @Test
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"),links);
    }

    @Test
    public void testSnippet2() throws IOException{
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("a.com", "a.com((", "example.com"),links);
    }

    @Test
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/"),links);
    }
}