package designPattern.decoratorTest;

/**
 * 装饰角色
 *
 * @author-liudongxu
 * @created 2019-04-18 21:17
 */
public class Decorator implements Component{
    Component concreteComponent;
    public Decorator(Component cc){
        this.concreteComponent = cc;
    }
    @Override
    public void decorator() {
        concreteComponent.decorator();
    }
}
