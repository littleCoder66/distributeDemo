import static java.lang.Thread.sleep;

/**
 * 对象中有多个synchronize修饰的方法或代碼塊时，如果有一个synchronize修饰的方法正在被访问；其他被synchronize
 * 修饰的方法不能被访问，因为java对象只有一个锁，锁标记java对象的监视器monitor
 * synchronize修飾的方法或代碼都需要獲取到Java對象的monitor之後才能執行；
 *
 * new Thread 對象中synchronize（this）獲取到的是thread的monitor
 *
 */
public class LockTest {
    public static void main(String[]args){
        final LockTest  test = new LockTest();
        new Thread(){
            public void run(){
                test.lock1();
            }
        }.start();
        new Thread() {
            public void run() {
                test.lock2();
                }
        }.start();
    }



    public synchronized  void lock2(){
        for(int i=0;i<1000000;i++)
        System.out.println("synchronize 方法lock2");
    }
    public   void lock1(){
        synchronized (this){
            for(int i=0;i<1000000;i++)
                System.out.println("synchronize 代码块lock1");
        }
    }

}
