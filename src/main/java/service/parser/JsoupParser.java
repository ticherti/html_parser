package service.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParser implements Parser {

    public String parseAllWords(String url) {
        String text = "";
        try {
            Document doc = Jsoup.connect(url).get();
            text = doc.body().text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
