package com.foryouinnet.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestingUtilTest {

    private ClassForTest classForTest = new ClassForTest();

    @Test
    void getPrivateMethod_callPrivateMethod() {

        Assertions.assertEquals(1, TestingUtil.invokeMethod(classForTest, "callPrivateMethod"));
    }

    @Test
    void getPrivateMethod_callDefaultMethod() {

        Assertions.assertEquals(2, TestingUtil.invokeMethod(classForTest, "callDefaultMethod"));
    }

    @Test
    void getPrivateMethod_callProtectedMethod() {

        Assertions.assertEquals(3, TestingUtil.invokeMethod(classForTest, "callProtectedMethod"));
    }

    @Test
    void getPrivateMethod_callPublicMethod() {

        Assertions.assertEquals(4, TestingUtil.invokeMethod(classForTest, "getPublicMethod"));
    }

    @Test
    void getPrivateMethod_callMethodWithParameters() {

        Assertions.assertEquals(5, TestingUtil.invokeMethod(classForTest, "callMethodWithParameters", 4, 1));
    }

    @Test
    void getPrivateMethod_callUnknownMethod() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> TestingUtil.invokeMethod(classForTest, "callUnknownMethod"));
        Assertions.assertEquals(TestingUtil.METHOD_WAS_NOT_FOUND_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void getPrivateMethod_callMethodWithWrongSignature() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> TestingUtil.invokeMethod(classForTest, "callPrivateMethod", 1, 2));
        Assertions.assertEquals(TestingUtil.METHOD_WAS_FOUND_WITH_DIFFERENT_SIGNATURE_ERROR_MESSAGE, exception.getMessage());
    }

    private class ClassForTest {


        private int callPrivateMethod() {

            return 1;
        }

        int callDefaultMethod() {

            return 2;
        }

        protected int callProtectedMethod() {

            return 3;
        }

        public int getPublicMethod() {

            return 4;
        }

        private int callMethodWithParameters(int firstParam, int secondParam) {

            return firstParam + secondParam;
        }
    }
}