import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 线程池测试
 *
 * @author-liudongxu
 * @created 2019-04-24 11:16
 */
public class ThreadPoolTest {

    public static void main(String[]args){
        Executor executor = Executors.newFixedThreadPool(10);
        //一个线程对象
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        //一个Runnable类型对象
        class Task implements Runnable{
            @Override
            public void run() {
                System.out.println("当前线程是--》"+Thread.currentThread().getName());
            }
        }
        for(int i=0;i<10;i++){
            Task task = new Task();
            executor.execute(task);
//            thread.start();
        }
//        retry:
//        for(;;){
//            System.out.println("第一层无限循环");
//            for(;;){
//                System.out.println("第二层无限循环");
//                break retry;
////                continue retry;
//            }
//        }
//
//        System.out.println("不再循环啦");
        
    }
}
