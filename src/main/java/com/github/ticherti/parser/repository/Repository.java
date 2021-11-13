package com.github.ticherti.parser.repository;

import com.github.ticherti.parser.model.ParsedPage;

import java.util.List;

public interface Repository {
    void create(ParsedPage page);

    ParsedPage read(String url);

    void update(ParsedPage page);

    void delete(String url);

     List<ParsedPage> getAll();
}
