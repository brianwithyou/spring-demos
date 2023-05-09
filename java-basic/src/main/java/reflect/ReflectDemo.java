package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author brian
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        Class<?> robotClass = (Class<?>) Class.forName("reflect.Robot");
        // deprecated
//        Object o = robotClass.newInstance();
        Robot robot = (Robot) robotClass.getDeclaredConstructor().newInstance();
        // returnHello 是一个私有方法
//        String hellWord = robot.returnHello();
//        robot.sayHi("hi, I am a robot.");

        // 可以获取private方法，但不能获取继承的方法
        Method getHello = robotClass.getDeclaredMethod("returnHello", String.class);
        // 私有方法需要设置这个才能调动
        getHello.setAccessible(true);
        Object bob = getHello.invoke(robot, "Bob");
        System.out.println(bob.toString());

        // getMethod只能获取public方法，而且可以获取继承的方法
        Method sayHi = robotClass.getMethod("sayHi", String.class);
        sayHi.invoke(robot, "welcome  ");
        // 获取私有属性
        Field name = robotClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot, "Alice");
        sayHi.invoke(robot, "welcome ");

    }

}
