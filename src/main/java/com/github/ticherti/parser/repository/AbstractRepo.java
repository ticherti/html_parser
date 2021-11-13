package com.github.ticherti.parser.repository;

import java.util.List;

public abstract class AbstractRepo {

    public abstract <T> T create();

    public abstract <T> T read();

    public abstract <T> T update();

    public abstract int delete();

    public abstract <T> List<T> readAll();

}
