package com.github.ticherti.parser.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupParser implements Parser {
    Logger log = LogManager.getLogger(JsoupParser.class.getName());

    public String parseAllWords(String url) {

        String text = "";
        try {;
            Document doc = Jsoup.connect(url).get();
            text = doc.body().text();
        } catch (IOException | IllegalArgumentException e) {
            log.info("Incorrect url " + url + " " + e.getMessage());
            e.printStackTrace();
        }
        return text;
    }
}
