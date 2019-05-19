package design_pattern.factory.abstr;

import design_pattern.factory.BMW;
import design_pattern.factory.Car;
import design_pattern.factory.func.Factory;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 17:50
 * @Version 1.0
 **/
public class BMWFactory extends AbstractFactory{
    @Override
    public Car getCar() {
        return new BMW();
    }
}
