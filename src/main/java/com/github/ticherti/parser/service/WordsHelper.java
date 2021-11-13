package com.github.ticherti.parser.service;

import com.github.ticherti.parser.exception.ParserException;
import com.github.ticherti.parser.service.parser.JsoupParser;
import com.github.ticherti.parser.service.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsHelper {
    Logger log = LogManager.getLogger(WordsHelper.class.getName());

    private final Parser parser = new JsoupParser();

    public List<String> getWords(String url) {
        if (url == null) {
            log.info("Url is null.");
            throw new ParserException("The url's wrong. Url = " + url);
        }
        //regex:  pick one of {' ', ',', '.', '! ', '?','"', ';', ':', '[', ']', '(', ')', '{', '}','\n', '\r', '\t'}
        return List.of(parser.parseAllWords(url).split("[ ,.!?\";:\\[\\](){}\\n\\r\\t]+"));
    }

    public Map<String, Integer> countWords(String url) {
        return getWords(url).stream().collect(Collectors.groupingBy(e -> e.toUpperCase(Locale.ROOT), Collectors.reducing(0, e -> 1, Integer::sum)));
    }
}
