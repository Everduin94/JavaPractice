/*
package App;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {

    public static void main(String[] args) throws IOException {
        // write your code here
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        Element body = doc.body();
        System.out.println(body);

        //Document.body() is equivalent to
        doc.getElementsByTag("body");

        */
/*You need to fetch and parse a HTML document from the web
        * and find data within it (screen scrapping)*//*

        doc = Jsoup.connect("https://jsoup.org/cookbook/input/load-document-from-url").get();
        String title = doc.title();
        System.out.println(title);

        */
/**
         * The connect(String url) method creates a new Connection
         * and @code{get()} fetches and parses a HTML file.
         * If an error occurs while fetching the URL,
         * it will thrown an IOException, which you should handle
         * appropriately
         *//*


        */
/**
         * The Connection interface is designed for method chaining
         * to build specific requests
         *//*

        doc = Jsoup.connect("https://jsoup.org/cookbook/input/load-document-from-url")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();
        */
/*This method only supports web URLs (http and https protocols)
        * if you need to load from a file, use
        * parse(File in, String charsetName) method instead*//*

        File input = new File("filewithhtml");
        doc = Jsoup.parse(input, "UTF-8", "");


    }

    */
/**
     * Temp place for general notes
     *
     * @return empty string
     *//*

    public static String notes() {

        */
/*Documents consist of Elements and TextNodes
        * (and a couple of other misc nodes)
        * The inheritance chain :
        * Document extends Element extends Node.
        * TextNode extends Node*//*


        */
/*An element contains a list of children Nodes
        * and has one parent Element*//*


        */
/*The parse(File in, String charsetName, String baseUri) method loads and parses a HTML file.
        If an error occurs whilst loading the file, it will throw an IOException, which you should handle appropriately.
        The baseUri parameter is used by the parser to resolve relative URLs
        in the document before a <base href> element is found.
        If that's not a concern for you, you can pass an empty string instead.
        There is a sister method parse(File in, String charsetName)
        which uses the file's location as the baseUri.
        This is useful if you are working on a filesystem-local site
         and the relative links it points to are also on the filesystem.*//*

        return "";
    }

    */
/**
     * @return Empty String
     * @throws IOException
     * @see <a href="https://jsoup.org/cookbook/extracting-data/dom-navigation"> DOM </a>
     *//*

    private final static String useDOMtoNavigateDocument() throws IOException {

        String METHOD_NAME = "navigateDocument()";

        File input = new File("/tmp/input.html"); //HTML file you want data from
        try {
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            Element content = doc.getElementById("content");
            Elements links = content.getElementsByTag("a");

            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text();
            }
        } catch (IOException e) {
            e.printStackTrace(); //TODO: Replace later
        }

        return "";
    } //TODO: Convience methods and overloading for optional parameters

    */
/**
     * @return Empty String
     * @throws IOException
     * @see <a href="https://jsoup.org/cookbook/extracting-data/selector-syntax"> Selector </a>
     *//*

    private final static String useSelectorToNavigate() throws IOException {
        Document doc = getExampleDoc();
        File input = getExampleFile();

        Elements links = doc.select("a[href]"); // a with href
        Elements pngs = doc.select("img[src$=.png]"); //img with src enging .png

        Element masthead = doc.select("div.masthead").first();
        //div with class=masthead

        Elements resultLinks = doc.select("h3.r > a");
        //direct a after h3


        return "";
    }

    private final static File getExampleFile() {
        return new File("/tmp/input.html");
    }

    private final static Document getExampleDoc() throws IOException {
        return Jsoup.parse(getExampleFile(), "UTF-8", "http://example.com/");
    }
}
*/
