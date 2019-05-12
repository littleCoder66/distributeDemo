import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 *
 * @author-liudongxu
 * @created 2019-04-24 11:16
 */
public class ThreadPoolTest {

    public static void main(String[]args){
        class Task implements Runnable{
            List list;
            String string;

            public Task(List list, String str){
                this.list = list;
                this.string = str;
            }

            @Override
            public void run() {
                if(list.size()>0)
                System.out.println(list.get(0));
                System.out.println(string+"-------");
            }
        }
        Executor threadPool = Executors.newScheduledThreadPool(5);
        for(int i=0;i<5;i++){
            List list = new ArrayList();
            list.add(i);
//            ((ScheduledExecutorService) threadPool).scheduleAtFixedRate(new Task(list,"第"+i+"个线程"),0,1, TimeUnit.SECONDS);//延迟0s后每隔1s执行一次
            ((ScheduledExecutorService) threadPool).schedule(new Task(list,"第"+i+"个线程"),1,TimeUnit.SECONDS);//延迟1s后执行
            threadPool.execute(new Task(list,"第"+i+"个线程"));//直接执行
        }
//        Executor executor = Executors.newFixedThreadPool(10);
//        //一个线程对象
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//        //一个Runnable类型对象
//        class Task implements Runnable{
//            @Override
//            public void run() {
//                System.out.println("当前线程是--》"+Thread.currentThread().getName());
//            }
//        }
//        for(int i=0;i<10;i++){
//            Task task = new Task();
//            executor.execute(task);
//            thread.start();
//        }
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
