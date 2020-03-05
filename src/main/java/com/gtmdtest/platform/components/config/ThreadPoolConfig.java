package com.gtmdtest.platform.components.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: platform
 * @description: 谷歌线程池
 * @author:
 * @create: 2019-11-28 13:11
 **/
public class ThreadPoolConfig {
    /**
     * 线程池
     */
    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(
            10, 20,
            5L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(200),
            new ThreadFactoryBuilder().setNameFormat("自建线程池-%d").build());

    /**
     * 获取线程池
     *
     * @return
     */
    public static ExecutorService getExecutor() {
        return EXECUTOR;
    }

}
