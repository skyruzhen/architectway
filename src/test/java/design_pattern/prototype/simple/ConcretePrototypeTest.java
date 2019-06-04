package design_pattern.prototype.simple;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author lizhen
 * @CreateAt 2019/5/20 002014:54
 */
public class ConcretePrototypeTest {

    @Test
    public void getAge() {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);

        ConcretePrototype cpClone = (ConcretePrototype) cp.clone();
        System.out.println(cpClone.getAge());
    }
}