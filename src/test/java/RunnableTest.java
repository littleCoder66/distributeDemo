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
                synchronized (ob){
                    try {
                        ob.wait();
//                        ob.notify();
                        System.out.println("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("释放ob");
                }
                System.out.println("线程开始执行");
            }
        }).run();

//        (new Runnable(){
//            @Override
//            public void run() {
//                synchronized (ob){
//                    ob.notify();
//                    System.out.println("notify 完成");
//                }
//            }
//        }).run();
    }

}
