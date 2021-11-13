package com.github.ticherti.parser.service;

import com.github.ticherti.parser.model.ParsedPage;

public class ParsedPageGenerator {
    public ParsedPage generateParsedPage(String url) {
        WordsCounter wc = new WordsCounter();
        return new ParsedPage(url, wc.countWords(url));
    }
}
