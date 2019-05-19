package design_pattern.factory.abstr;

import design_pattern.factory.BMW;
import design_pattern.factory.Car;

/**
 * @Description 抽象工厂模式, 自带逻辑
 * @Author ruzhen
 * @Date 2019/5/18 17:55
 * @Version 1.0
 **/
public abstract class AbstractFactory {
   protected abstract Car getCar();

    public Car getCar(String name){
        System.out.println("德国品质,值得信赖!");
        if("BMW".equalsIgnoreCase(name)){
            return new BMWFactory().getCar();
        }else if("Audi".equalsIgnoreCase(name)){
            return new AudiFactory().getCar();
        }
        return null;
    }
}
