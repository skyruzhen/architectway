package design_pattern.proxy.jdk;

import design_pattern.proxy.jdk.model.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("媒婆：你的性别是：");
        System.out.println("开始海选。。。。");
        return null;
    }
}
