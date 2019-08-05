import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(15));
        AtomicInteger count = new AtomicInteger(0);
        Task task = new Task(lock,count);
        for(int m=0;m<10;m++){
            pool.execute(task);
        }
        lock.await();
        System.out.println("main 线程");

//        final CountDownLatch countDownLatch = new CountDownLatch(1) {
//            @Override
//            public void await() throws InterruptedException {
//                super.await();
//                System.out.println(Thread.currentThread().getName() + " count down is ok");
//            }
//        };
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //do something
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " is done");
//                countDownLatch.countDown();
//            }
//        }, "thread1");
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //do something
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName() + " is done");
//                countDownLatch.countDown();
//            }
//        }, "thread2");
//
//
//        thread1.start();
//        thread2.start();
//
//        countDownLatch.await();
    }
}
