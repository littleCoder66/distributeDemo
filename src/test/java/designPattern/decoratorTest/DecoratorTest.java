package designPattern.decoratorTest;

/**
 * 装饰者模式
 *
 * @author-liudongxu
 * @created 2019-04-18 18:24
 */
public class DecoratorTest {
    public static  void main(String[]args){
        Component c= new ConcreteComponent();
        Component d= new ConcreteDecorator1(new ConcreteDecorator2(c));
        d.decorator();
    }

}
