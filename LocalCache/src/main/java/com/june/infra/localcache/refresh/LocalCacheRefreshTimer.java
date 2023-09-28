package com.june.infra.localcache.refresh;

import com.june.infra.localcache.impl.LocalCacheFactory;
import com.june.util.log.LogUtils;
import com.june.util.log.Loggers;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class LocalCacheRefreshTimer implements ApplicationRunner {

    /** 本地缓存工厂 **/
    private LocalCacheFactory localCacheFactory;

    public void startTimer(final long period) {
        // 定时刷缓存的线程池
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("cmd-monitor-%d").daemon(true).build());

        // 机器维度平滑，未来10s内开始执行
        long initDelay = new Random().nextInt() % 100 * 100;

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long currentMilliseconds = System.currentTimeMillis();
                for (String localCacheName : localCacheFactory.getAutoRefreshCaches()) {
                    refresh(localCacheName, currentMilliseconds);
                }
            }
        }, initDelay, period * 1000, TimeUnit.MILLISECONDS);
    }

    private void refresh(String localCacheName, final long currentMilliseconds) {
        try {
            // 可以配置缓存刷新周期时间，默认一分钟刷新一次
            int cachePeriod = 60;
            if ((currentMilliseconds / 1000 / 20) * 20 % cachePeriod != 0) {
                LogUtils.info(Loggers.LOCAL_CACHE, "未到缓存刷新周期时间，缓存不需要刷新，cashName：{0}", localCacheName);
                return;
            }

            localCacheFactory.getLocalCache(localCacheName).refresh();
        } catch (Exception e) {
          try {
              LogUtils.error(Loggers.LOCAL_CACHE, "刷新缓存失败，缓存名称：{0}", localCacheName);
          } catch (Throwable t) {
              return;
          }
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        startTimer(20L);
    }
}
