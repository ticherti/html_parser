package com.github.ticherti.parser.repository;

import com.github.ticherti.parser.exception.StorageException;
import com.github.ticherti.parser.model.ParsedPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapRepository implements Repository {
    private final Map<String, ParsedPage> storage = new HashMap<>();

    public void create(ParsedPage page) {
        if (page == null) {
            throw new StorageException("Parsed page is null");
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
