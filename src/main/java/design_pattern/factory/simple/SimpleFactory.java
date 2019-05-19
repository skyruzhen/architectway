package design_pattern.factory.simple;

import design_pattern.factory.BMW;
import design_pattern.factory.Car;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 11:53
 * @Version 1.0
 **/
public class SimpleFactory {
    //工厂模式实现统一管理,专业化管理
    public Car getCar(String name){
        System.out.println("德国品质,值得信赖!");
        if("BMW".equalsIgnoreCase(name)){
            return new BMW();
        }
        return null;
    }
}
