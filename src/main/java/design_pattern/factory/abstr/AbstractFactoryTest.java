package design_pattern.factory.abstr;

/**
 * @Description TODO
 * @Author ruzhen
 * @Date 2019/5/18 18:01
 * @Version 1.0
 **/
public class AbstractFactoryTest {
    public static void main(String[] args) {
        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar("BMW").getName());
    }
}
