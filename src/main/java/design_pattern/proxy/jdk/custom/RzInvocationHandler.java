package design_pattern.proxy.jdk.custom;

import java.lang.reflect.Method;

public interface RzInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
