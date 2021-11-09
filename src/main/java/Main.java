import service.parser.WordsCounter;

public class Main {

    public static void main(String[] args) {
        String url = "http://www.timbrack.de/index.html#sharenow_campaign";
        WordsCounter ws = new WordsCounter();
        ws.countWords(url).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
