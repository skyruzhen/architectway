package design_pattern.factory.func;

import design_pattern.factory.Car;
import design_pattern.factory.VW;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 17:50
 * @Version 1.0
 **/
public class VMFactory implements Factory{
    @Override
    public Car getCar() {
        return new VW();
    }
}
