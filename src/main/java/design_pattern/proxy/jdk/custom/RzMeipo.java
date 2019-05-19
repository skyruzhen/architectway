package design_pattern.proxy.jdk.custom;

import design_pattern.proxy.jdk.model.Person;

import java.lang.reflect.Method;

public class RzMeipo implements RzInvocationHandler{
    private Person target;
    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return RzProxy.newProxyInstance(new RzClassLoader(), clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆：你的性别是：");
        System.out.println("开始海选。。。。");
        method.invoke(this.target, args);
        return null;
    }
}
