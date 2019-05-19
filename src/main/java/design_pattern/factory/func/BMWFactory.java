package design_pattern.factory.func;

import design_pattern.factory.BMW;
import design_pattern.factory.Car;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 17:50
 * @Version 1.0
 **/
public class BMWFactory implements Factory{
    @Override
    public Car getCar() {
        return new BMW();
    }
}
