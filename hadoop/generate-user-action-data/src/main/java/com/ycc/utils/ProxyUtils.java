package com.ycc.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Uni
 * @create 2021/11/14 15:34
 */
public class ProxyUtils {
    public static <T> T getProxy(T obj){
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTime = System.currentTimeMillis();
                        Object result = method.invoke(obj, args);
                        long endTime = System.currentTimeMillis();
                        //System.out.println(method.getName() + " () 执行耗时: " + (endTime - startTime) / 1000.0 + " s");
                        return result;
                    }
                });
    }
}
