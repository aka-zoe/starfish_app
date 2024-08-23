package com.zoe.starfish_server.utils.thread_pool;

import java.util.concurrent.ThreadFactory;

/**
 * 创建线程池的工厂对象
 */
public class MyThreadFactory implements ThreadFactory {

    /**
     * 该方法用来创建线程
     *
     * @param r
     * @return
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        return newThread;
    }
}
