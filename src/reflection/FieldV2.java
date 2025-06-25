package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        User user = new User("id1", "userA", 20);
        System.out.println("original name " + user.getName());


        Class<? extends User> userClass = user.getClass();

        Field nameField = userClass.getDeclaredField("name");

        nameField.setAccessible(true);
        nameField.set(user, "userB");

        System.out.println("updated name = " + user.getName());
    }
}
