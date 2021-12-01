package com.ycc.Main;
import com.ycc.DataCenter;
import com.ycc.thread.PageRunnableImpl;
import com.ycc.thread.StartRunnableImpl;
import java.util.concurrent.*;

/**
 * @author Ycc
 * @create 2021/11/15 10:52
 */
public class app {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2,
                2,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        DataCenter.readConfig();

        // 双线程
        pool.execute(new PageRunnableImpl());
        pool.execute(new StartRunnableImpl());
    }
}
