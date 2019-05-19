package design_pattern.factory.abstr;

import design_pattern.factory.Audi;
import design_pattern.factory.Car;
import design_pattern.factory.func.Factory;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 17:49
 * @Version 1.0
 **/
public class AudiFactory extends AbstractFactory{
    @Override
    public Car getCar() {
        return new Audi();
    }
}
