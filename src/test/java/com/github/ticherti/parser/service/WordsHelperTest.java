package com.github.ticherti.parser.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordsHelperTest {
    private WordsHelper wc;
    private final List<String> EXPECTED_LIST = List.of("Java", "class", "HelloWorld", "public", "static", "void", "main", "String", "args", "for", "System", "out", "print", "Hello", "World", "submitted", "by", "dan@engr", "latech", "edu", "Danny", "Schales");

    public WordsHelperTest() {
        this.wc = new WordsHelper();
    }

    @Test
    void parseListOfAllWordsFromURL() {
        List<String> actual = wc.getWords("http://www2.latech.edu/~acm/helloworld/java.html");
        assertEquals(EXPECTED_LIST, actual);
    }
}