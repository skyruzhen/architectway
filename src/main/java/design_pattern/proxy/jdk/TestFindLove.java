package design_pattern.proxy.jdk;

import design_pattern.proxy.jdk.custom.RzMeipo;
import design_pattern.proxy.jdk.model.Person;

public class TestFindLove {
    public static void main0(String[] args) {
        Person person = (Person)new MeiPo().getInstance(new Xiaoxingxing());
        person.findLove();
    }

    public static void main(String[] args) {
        Person person = (Person)new RzMeipo().getInstance(new Xiaoxingxing());
        person.findLove();
    }
}
