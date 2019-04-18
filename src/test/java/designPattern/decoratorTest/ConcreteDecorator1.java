package designPattern.decoratorTest;

/**
 * 具体装饰角色
 * @author-liudongxu
 * @created 2019-04-18 21:23
 */
public class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component cc) {
        super(cc);
    }
    @Override
    public void decorator(){
        super.decorator();
        System.out.println("具体装饰角色1");
    }
}