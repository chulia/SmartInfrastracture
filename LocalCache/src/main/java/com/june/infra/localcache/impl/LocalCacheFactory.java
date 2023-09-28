package com.june.infra.localcache.impl;

import com.google.common.collect.Sets;
import com.june.infra.localcache.LocalCache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存工厂类
 * <p>提供缓存注册和缓存对象获取方法
 */
public class LocalCacheFactory {

    private Map<String, LocalCache<?>> localCacheMap = new ConcurrentHashMap<>();

    private Set<String> autoRefreshCaches = Sets.newConcurrentHashSet();

    /**
     *  缓存对象注册到缓存工厂
     */
    public void register(String localCacheName, LocalCache<?> localCache) {
        localCacheMap.put(localCacheName, localCache);
    }

    /**
     * 根据缓存名称获取缓存对象
     * @param localCacheName 缓存名称
     * @return               缓存对象
     */
    public LocalCache<?> getLocalCache(String localCacheName) {
        return localCacheMap.get(localCacheName);
    }

    public Map<String, LocalCache<?>> getLocalCacheMap() {
        return localCacheMap;
    }

    public Set<String> getAutoRefreshCaches() {
        return autoRefreshCaches;
    }
}
