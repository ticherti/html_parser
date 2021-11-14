package com.github.ticherti.parser.repository;

import com.github.ticherti.parser.exception.StorageException;
import com.github.ticherti.parser.model.ParsedPage;
import com.github.ticherti.parser.service.parser.JsoupParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRepository implements Repository {
    private static final String NULL_PAGE = "Parsed page is null";
    Logger log = LogManager.getLogger(JsoupParser.class.getName());
    private final Map<String, ParsedPage> storage = new HashMap<>();

    public void create(ParsedPage page) {
        if (page == null) {
            log.info(NULL_PAGE);
            throw new StorageException(NULL_PAGE);
        }
        storage.put(page.getUrl(), page);
    }

    @Override
    public ParsedPage read(String url) {
        return storage.get(url);
    }

    @Override
    public void update(ParsedPage page) {
        storage.put(page.getUrl(), page);
    }

    @Override
    public void delete(String url) {
        storage.remove(url);
    }

    @Override
    public List<ParsedPage> getAll() {
        return new ArrayList<>(storage.values());
    }
}
