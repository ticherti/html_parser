package com.github.ticherti.parser;

import com.github.ticherti.parser.repository.MapRepository;
import com.github.ticherti.parser.repository.Repository;
import com.github.ticherti.parser.service.ParsedPageGenerator;

public class Main {
    private final static String URL = "http://www.timbrack.de/index.html#sharenow_campaign";

    public static void main(String[] args) {
        String url = args.length == 0 ? URL : args[1];
        Repository repo = new MapRepository();
        ParsedPageGenerator pg = new ParsedPageGenerator();
        repo.create(pg.generateParsedPage(url));

        repo.getAll().forEach(System.out::println);
    }
}
