package com.github.ticherti.parser.model;

import java.util.Map;
import java.util.Objects;

public class ParsedPage {
    private final String url;
    private final Map<String, Integer> words;

    public ParsedPage(String url, Map<String, Integer> words) {
        Objects.requireNonNull(url);
        Objects.requireNonNull(words);
        this.url = url;
        this.words = words;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Page url is ")
                .append(url)
                .append("\n Words are:");
        words.forEach((k, v) ->sb.append(String.format("%s - %d\n", k, v)));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParsedPage)) return false;
        ParsedPage that = (ParsedPage) o;
        return url.equals(that.url) && words.equals(that.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, words);
    }
}
