package com.june.infra.localcache;

/**
 * 缓存监听器，如果有对象基于某个缓存数据构建二级缓存，需要注册
 */
public interface CacheListener {
    void refresh();
}
