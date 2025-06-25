package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {
    public static void main(String[] args) {

        Class<BasicData> basicData = BasicData.class;
        System.out.println("==== method ====");
        Method[] methods = basicData.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("==== declared Method ====");
        Method[] declaredMethods = basicData.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }
}
