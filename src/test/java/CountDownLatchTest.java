import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    public static void main(String args[]){
        CountDownLatch lock = new CountDownLatch(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 15, 60,
                TimeUnit.SECONDS,new BlockingDeque<Runnable>(10) worke)
    }
//    public static void main(String[] args) throws InterruptedException {
//
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
//    }




}
