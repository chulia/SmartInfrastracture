package com.june.infra.localcache.impl;

import com.google.common.collect.Sets;
import com.june.infra.localcache.CacheListener;
import com.june.infra.localcache.LocalCache;
import com.june.util.constants.Constants;
import com.june.util.exception.InternalSystemException;
import com.june.util.log.LogUtils;
import com.june.util.log.Loggers;
import org.springframework.beans.factory.InitializingBean;

import java.util.Set;

/**
 * 本地缓存抽象类。
 * <p>本地缓存具体实现继承此抽象类，该类自动通过afterPropertiesSet方法初始化缓存，在spring启动完成后通过ApplicationRunner回调启动线程
 * 定时刷新缓存
 * @param <T>
 */
public abstract class AbstractLocalCache<T> implements LocalCache<T>, InitializingBean {

    /** 行分隔符 **/
    protected static final String SEPARATOR = "--------------------";

    /** 数据加载标志 **/
    private volatile boolean dataLoaded;

    /** 缓存数据 **/
    private volatile T cacheData;

    /** 缓存工厂 **/
    private LocalCacheFactory localCacheFactory;

    private Set<CacheListener> cacheListeners = Sets.newLinkedHashSet();

    @Override
    public void load() {
        if (dataLoaded) {
            return;
        }

        // 如果未来系统加载的缓存太多，需要控制加载上限，防止出现启动CPU尖刺

        try {
            // 加载数据
            cacheData = doLoad();
            dataLoaded = true;

            // 缓存注册
            registerLocalCache();

            // 刷新在此缓存上注册监听器的二级缓存
            refreshByListener();

            // 打印缓存内容
            dump();

            LogUtils.info(Loggers.LOCAL_CACHE, "load local cache, cacheName={0}", getLocalCacheName());
        } catch (Exception e) {
            LogUtils.error(Loggers.LOCAL_CACHE, e, "初始化加载缓存失败", "");
            dataLoaded = false;
            throw new InternalSystemException("初始化加载缓存失败", e);
        }
    }

    public abstract T doLoad();

    public void registerLocalCache() {
        localCacheFactory.register(getLocalCacheName(), this);
    }

    protected void refreshByListener() {
        for (CacheListener listener : cacheListeners) {
            listener.refresh();
        }
    }

    protected void addCacheListener(CacheListener cacheListener) {
        this.cacheListeners.add(cacheListener);
    }

    @Override
    public void refresh() {
        try {
            // 覆盖缓存数据
            cacheData = doLoad();

            // 刷新在此缓存上注册监听器的二级缓存
            refreshByListener();

            // 打印缓存内容
            dump();

            LogUtils.info(Loggers.LOCAL_CACHE, "refresh local cache, cacheName={0}", getLocalCacheName());
        } catch (Exception e) {
            LogUtils.error(Loggers.LOCAL_CACHE, e,"刷新缓存失败");
            throw new InternalSystemException("初始化加载缓存失败", e);
        }
    }

    @Override
    public T getData() {
        if (!dataLoaded) {
            load();
        }

        if (null == cacheData) {
            throw new InternalSystemException(getLocalCacheName() + "缓存数据为空，请进行检查！");
        } else {
            return cacheData;
        }
    }

    @Override
    public void dump() {
        if (Loggers.LOCAL_CACHE.isInfoEnabled()) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(SEPARATOR).append("开始输出缓存[").append(getLocalCacheName()).append("]信息").append(SEPARATOR);
            buffer.append(Constants.ENTER).append("缓存内容：");

            this.constructCacheDigest(buffer);

            buffer.append(Constants.ENTER).append(SEPARATOR).append("结束输出缓存[").append(getLocalCacheName()).append("]信息").append(SEPARATOR);
            Loggers.LOCAL_CACHE.info(buffer.toString());
        }
    }

    /**
     * 构建缓存摘要信息
     * @param buffer 缓存摘要输出buffer
     */
    public abstract void constructCacheDigest(StringBuilder buffer);

    @Override
    public void afterPropertiesSet() throws Exception {
        load();
    }



    public LocalCacheFactory getLocalCacheFactory() {
        return localCacheFactory;
    }

    public void setLocalCacheFactory(LocalCacheFactory localCacheFactory) {
        this.localCacheFactory = localCacheFactory;
    }
}
