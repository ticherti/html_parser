package service.parser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsCounter {
    private final Parser parser = new JsoupParser();

    public Map<String, Long> countWords(String url) {
        return getWords(url).stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    private List<String> getWords(String url) {
        //        regex:  pick one of {' ', ',', '.', '! ', '?','"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'}
        return List.of(parser.parseAllWords(url).split("[ ,.!?\";:\\[\\]()\\n\\r\\t]+"));
    }


}
