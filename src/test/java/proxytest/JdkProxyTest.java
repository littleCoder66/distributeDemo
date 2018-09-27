package proxytest;

import sun.management.resources.agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试
 *
 * @author-liudongxu
 * @created 2018-09-27 19:46
 */
public class JdkProxyTest {

    public static void main(String[] args){
        Star ycy = new Star();
        InvocationHandler  agentHandler = new ProxyAgent(ycy);
        StarInterface starAgent = (StarInterface) Proxy.newProxyInstance(StarInterface.class.getClassLoader(),new Class[]{StarInterface.class},agentHandler);
        starAgent.say();
    }
}
