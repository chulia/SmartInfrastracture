package com.june.infra.localcache;

public interface LocalCache<T> {
    void load();

    void refresh();

    T getData();

    String getLocalCacheName();

    void dump();
}
