package design_pattern.proxy.jdk;

import design_pattern.proxy.jdk.model.Person;

public class Xiaoxingxing implements Person {

    private String sex="女";

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void findLove() {
        System.out.println("高富帅！");
        System.out.println("真善美！");
    }
}
