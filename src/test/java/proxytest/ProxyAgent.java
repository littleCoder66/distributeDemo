package proxytest;

import org.aopalliance.intercept.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 *
 * @author-liudongxu
 * @created 2018-09-27 20:13
 */
public class ProxyAgent implements InvocationHandler {
    private Object star = null;
    public ProxyAgent(Object star){
        this.star = star;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("i am agent");
        Object ret = method.invoke(star,args);
        return ret;
    }
}
