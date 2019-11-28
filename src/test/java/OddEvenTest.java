/**
 * 奇数偶数交替输出
 *
 * @author-liudongxu
 * @created 2019-11-28 16:06
 */
public class OddEvenTest {
    private static final Object lock = new Object();
    static int count = 0;
    public static void print(){
        while (count<100){
            synchronized (lock){
                System.out.println("当前count值-->>"+count);
                count++;
                lock.notifyAll();
                if(count<100){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class number implements Runnable{
        @Override
        public void run() {
            print();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new number());
        Thread t2 = new Thread(new number());
        t1.start();
        Thread.sleep(1);
        t2.start();
    }
}
