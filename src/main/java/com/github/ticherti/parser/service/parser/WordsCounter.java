package com.github.ticherti.parser.service.parser;

import com.github.ticherti.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsCounter {
    Logger log = LogManager.getLogger(WordsCounter.class.getName());

    private final Parser parser = new JsoupParser();

    public Map<String, Long> countWords(String url) {
        return getWords(url).stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    private List<String> getWords(String url) {
        if (url == null) {
            log.info("Url is null.");
            throw new ParserException("The url's wrong. Url = " + url);
        }
        //        regex:  pick one of {' ', ',', '.', '! ', '?','"', ';', ':', '[', ']', '(', ')', '\n', '\r', '\t'}
        return List.of(parser.parseAllWords(url).split("[ ,.!?\";:\\[\\]()\\n\\r\\t]+"));
    }
}
