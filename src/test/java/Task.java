import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author-liudongxu
 * @created 2019-08-05 20:13
 */
public class Task implements Runnable{
    CountDownLatch lock = null;
    AtomicInteger count=new AtomicInteger();

    public Task(CountDownLatch lock, AtomicInteger count) {
        this.lock = lock;
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            lock.countDown();
            count.addAndGet(1);
            System.out.println("当前task线程是-->>"+Thread.currentThread().getName()+"count-->>"+count);
            try {
                lock.await();
                System.out.println("wait task线程是-->>"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
