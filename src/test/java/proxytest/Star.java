package proxytest;

/**
 * 被代理类
 *
 * @author-liudongxu
 * @created 2018-09-27 20:12
 */
public class Star implements StarInterface {
    @Override
    public void say() {
        System.out.println("i am superStar!");
    }
}
