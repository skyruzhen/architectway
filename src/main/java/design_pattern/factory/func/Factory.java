package design_pattern.factory.func;

import design_pattern.factory.Car;

/**
 * @Description 工厂接口,定义来所有工厂的执行标准
 * @Author ruzhen
 * @Date 2019/5/18 17:48
 * @Version 1.0
 **/
public interface Factory {

    //符合汽车上路标准
    Car getCar();
}
