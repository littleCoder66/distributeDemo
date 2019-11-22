/**
 * Runnable测试
 *
 * @author-liudongxu
 * @created 2018-11-13 11:26
 */
public class RunnableTest {
    static Object ob = new Object();
    public static void main(String[] args){
        System.out.println("主程序开始执行");
        (new Runnable(){
            @Override
            public void run() {
                try {
                    for(int i=0;i<2;i++){
                        System.out.println(Thread.currentThread().getName());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).run();

        (new Runnable(){
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }).run();
//        ThreadInstance thread1 = new ThreadInstance("线程11111111111111");
//        Thread t1 = new Thread(thread1);
//        ThreadInstance thread2 = new ThreadInstance("线程22222222222222");
//        Thread t2 = new Thread(thread2);
//        t1.start();t2.start();
}
public static class ThreadInstance implements Runnable{
        int str;

    public  ThreadInstance(int str){
    this.str = str;
    };
    @Override
    public void run() {
        while(str<10){
            System.out.println("线程运行中");
        }
    }
}
}
