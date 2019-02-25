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
                        for(int i=0;i<1000000;i++){
                            System.out.println("线程11111111111");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    System.out.println("释放ob");
            }
//                System.out.println("线程开始执行");
        }).run();

        (new Runnable(){
        @Override
        public void run() {
            for(int i=0;i<1000000;i++){
                System.out.println("线程222222222222");
            }
        }
    }).run();
//        ThreadInstance thread1 = new ThreadInstance("线程11111111111111");
//        Thread t1 = new Thread(thread1);
//        ThreadInstance thread2 = new ThreadInstance("线程22222222222222");
//        Thread t2 = new Thread(thread2);
//        t1.start();t2.start();
}
public static class ThreadInstance implements Runnable{
        String str;

    public  ThreadInstance(String str){
    this.str = str;
    };
    @Override
    public void run() {
        for(int i=0;i<10000000;i++){
            System.out.println(str);
        }
    }
}
}
