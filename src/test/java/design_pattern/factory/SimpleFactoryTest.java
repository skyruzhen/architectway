package design_pattern.factory;

import design_pattern.factory.simple.SimpleFactory;
import org.junit.Test;

public class SimpleFactoryTest {
    @Test
    public void testGetCar() {
        Car car = new SimpleFactory().getCar("BMW");
        System.out.println(car.getName());
    }
}