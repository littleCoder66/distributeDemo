/**
 * Runnable测试
 *
 * @author-liudongxu
 * @created 2018-11-13 11:26
 */
public class RunnableTest {
    public static void main(String[] args){
        System.out.println("主程序开始执行");
        (new Runnable(){
            @Override
            public void run() {
                System.out.println("线程开始执行");
            }
        }).run();
    }

}
