package com.example.springlogbacktraceid.util;

import com.example.springlogbacktraceid.decorator.MdcDecorator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author brian
 */
@Slf4j
public class ThreadPoolUtil {

    /**
     * 核心线程数
     */
    private static int corePoolSize = 1000;

    /**
     * 最大线程数
     */
    private static int maximumPoolSize = corePoolSize * 4;

    /**
     * 空闲等待时间
     */
    private static long keepAliveTime = 60;

    /**
     * 等待队列大小
     */
    private static int queueSize = 2;

    /**
     * 如果poolSize < coreSize,线程优先加入corePool中;
     * 如果poolSize >= coreSize,线程加入到queue中;
     * 如果queue满了, 就创建新线程, 直到maxPool大小;
     * 如果poolSize > coreSize, 大于部分的线程会在keepAliveTime没有接到工作任务后销毁。
     **/
    private static final ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();

    static {
        pool.setCorePoolSize(corePoolSize);
        pool.setMaxPoolSize(maximumPoolSize);
        pool.setKeepAliveSeconds((int)keepAliveTime);
        pool.setQueueCapacity(queueSize);
        pool.setThreadFactory(Executors.defaultThreadFactory());
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        pool.setTaskDecorator(new MdcDecorator());
        pool.initialize();
    }

    static {
        // 每分钟打印出线程池的状态
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Thread() {
            @Override
            public void run() {
                printStatus();
            }
        }, 60, 60, TimeUnit.SECONDS);
    }

    /**
     * 执行task
     */
    public static void execute(Runnable task) {
        pool.execute(task);
    }

    public static <T> Future<T> submit(Callable<T> task) {
        return pool.submit(task);
    }

    /**
     * 线程池状态
     */
    public static void printStatus() {
        ThreadPoolExecutor threadPoolExecutor = pool.getThreadPoolExecutor();
        int active = pool.getActiveCount();
        int queue = pool.getQueueSize();
        long complete = threadPoolExecutor.getCompletedTaskCount();
        long task = threadPoolExecutor.getTaskCount();
        if (active > 0 || queue > 0) {
            log.info("[busy] ThreadPool active:" + active + ",queue:" + queue + ",complete:" + complete + ",task:" + task);
        } else {
            log.info("[free] ThreadPool is empty. active:" + active + ",queue:" + queue + ",complete:" + complete + ",task:" + task);
        }
    }
}
