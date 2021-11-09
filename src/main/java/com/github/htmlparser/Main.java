package com.github.htmlparser;


import com.github.htmlparser.parser.WordsCounter;

public class Main {
    private final static String URL = "http://www.timbrack.de/index.html#sharenow_campaign";

    public static void main(String[] args) {
        String url = args.length == 0 ? URL : args[1];
        WordsCounter ws = new WordsCounter();
        ws.countWords(url).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
