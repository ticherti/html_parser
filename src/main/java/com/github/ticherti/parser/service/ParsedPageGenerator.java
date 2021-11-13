package com.github.ticherti.parser.service;

import com.github.ticherti.parser.model.ParsedPage;

public class ParsedPageGenerator {
    public ParsedPage generateParsedPage(String url) {
        WordsHelper wc = new WordsHelper();
        return new ParsedPage(url, wc.countWords(url));
    }
}
