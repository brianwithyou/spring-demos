package concurrent;

/**
 * @author brian
 */
public class BlockTaskRunnable implements Runnable{

    @Override
    public void run() {
        synchronized (BlockTaskRunnable.class) {
            try {
                // 阻塞1000s  16.667分钟，依然可以执行完成
                Thread.sleep(1000000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
