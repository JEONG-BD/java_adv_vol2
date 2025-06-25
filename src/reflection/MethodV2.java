package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 정적 메서드 호출
        BasicData basicDataInstance = new BasicData();
        basicDataInstance.call();

        //동적 메서드 사용
        Class<? extends BasicData> basicDataClass = basicDataInstance.getClass();
        String methodName = "hello";

        //
        Method method1 = basicDataClass.getDeclaredMethod(methodName, String.class);
        System.out.println("method1 = " + method1);
        Object result = method1.invoke(basicDataInstance, "hi");
        System.out.println(result);

    }
}
