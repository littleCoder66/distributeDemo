package designPattern.decoratorTest;

/**
 * 具体构件
 *
 * @author-liudongxu
 * @created 2019-04-18 21:14
 */
public class ConcreteComponent implements Component{
    @Override
    public void decorator() {
        System.out.println("具体构件");
    }
}
