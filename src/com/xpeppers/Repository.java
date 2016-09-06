package com.xpeppers;

public interface Repository<T> {
    void store(T t);
    T load();
    void delete();
}
