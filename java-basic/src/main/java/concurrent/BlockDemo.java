package concurrent;

/**
 * @author brian
 */
public class BlockDemo {


    public static void main(String[] args) {
        // 阻塞1000s(16.667min)之后释放锁，第二个线程依然可以执行，
        new Thread(new BlockTaskRunnable()).start();
        new Thread(new BlockTaskRunnable()).start();
    }

}
