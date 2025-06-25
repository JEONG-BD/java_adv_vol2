package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Field;

public class FieldV1 {
    public static void main(String[] args) {

        Class<BasicData> basicDataClass = BasicData.class;

        System.out.println("==== field() ====");
        Field[] fields = basicDataClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        System.out.println("=== declared Fields() ====");
        Field[] declaredFields = basicDataClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
}
