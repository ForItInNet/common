package com.foryouinnet.common.util;

import lombok.NonNull;
import org.springframework.aop.framework.AopProxyUtils;

import java.lang.reflect.Method;

public final class TestingUtil {

    final static String METHOD_WAS_NOT_FOUND_ERROR_MESSAGE = "Method was not found";
    final static String METHOD_WAS_FOUND_WITH_DIFFERENT_SIGNATURE_ERROR_MESSAGE = "Method was fount but with different signature";

    public static Object invokeMethod(@NonNull Object object, @NonNull String methodName, Object... args) {

        Object targetObject = AopProxyUtils.getSingletonTarget(object);
        Class<?> objectClass = targetObject != null ? targetObject.getClass() : object.getClass();

        boolean isMethodWithSameNameFount = false;

        for(Method method: objectClass.getDeclaredMethods()) {

            if(method.getName().equals(methodName)) {

                isMethodWithSameNameFount = true;

                if(method.getParameterCount() == args.length) {

                    try {
                        method.setAccessible(true);
                        return method.invoke(object, args);
                    } catch(Exception exception) {
                        throw new RuntimeException(exception);
                    }
                }
            }
        }

        throw new RuntimeException(isMethodWithSameNameFount ? METHOD_WAS_FOUND_WITH_DIFFERENT_SIGNATURE_ERROR_MESSAGE : METHOD_WAS_NOT_FOUND_ERROR_MESSAGE);
    }
}
