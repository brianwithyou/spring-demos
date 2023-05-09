package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author brian
 */
public class JavaProxyDemo {

    // Spring 通过代理实现 AOP功能，当被代理的对象实现了接口，则通过Java Proxy实现代理
    // 如果被代理的对象(target)没有实现接口，则通过Cglib实现代理
    //    AOP应用场景
    //    场景一： 记录日志
    //    场景二： 监控方法运行时间 （监控性能）
    //    场景三： 权限控制
    //    场景四： 缓存优化 （第一次调用查询数据库，将查询结果放入内存对象， 第二次调用， 直接从内存对象返回，不需要查询数据库 ）
    //    场景五： 事务管理 （调用方法前开启事务， 调用方法后提交关闭事务 ）
    public void proxyUser() {

        User user = new User("John");
        // 注意，使用JavaProxy，必须强制转换为接口类;
        // newProxyInstance的三个参数解释：
        // 参数1：代理类的类加载器，同目标类的类加载器
        // 参数2：代理类要实现的接口列表，同目标类实现的接口列表
        // 参数3：回调，是一个InvocationHandler接口的实现对象，当调用代理对象的方法时，执行的是回调中的invoke方法
        //proxy为代理对象
        UserInterface proxy = (UserInterface) Proxy.newProxyInstance(user.getClass().getClassLoader()
                , user.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    // 参数proxy:被代理的对象
                    // 参数method:执行的方法，代理对象执行哪个方法，method就是哪个方法
                    // 参数args:执行方法的参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理对象打印日志...");
                        Object invoke = method.invoke(user, args);
                        return invoke;
                    }
                });
        proxy.sayHello();
    }

    public static void main(String[] args) {
        JavaProxyDemo javaProxyDemo = new JavaProxyDemo();
        javaProxyDemo.proxyUser();
    }

}
