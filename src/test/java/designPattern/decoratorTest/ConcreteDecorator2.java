package designPattern.decoratorTest;

/**
 * 具体装饰角色2
 *
 * @author-liudongxu
 * @created 2019-04-18 21:28
 */
public class ConcreteDecorator2 extends Decorator{
    public ConcreteDecorator2(Component cc) {
        super(cc);
    }

    @Override
    public void decorator(){
        super.decorator();
        System.out.println("具体装饰角色2");
    }
}
