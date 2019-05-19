package design_pattern.factory.abstr;

import design_pattern.factory.Car;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 18:00
 * @Version 1.0
 **/
public class DefaultFactory extends AbstractFactory {
    private AudiFactory defaultFactory = new AudiFactory();
    @Override
    protected Car getCar() {
        return defaultFactory.getCar();
    }
}
