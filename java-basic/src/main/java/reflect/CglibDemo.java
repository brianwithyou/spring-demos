package reflect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author brian
 */
public class CglibDemo {

    public void cglibProxyDemo() {

        CglibUser cglibUser = new CglibUser("Stark");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cglibUser.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            // 当你调用目标方法时，实质上是调用该方法
            // proxy:代理对象
            // method:目标方法
            // args：目标方法的形参
            // methodProxy:代理方法
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib代理对象打印日志。。。");
                Object invoke = method.invoke(cglibUser, args);
                return invoke;
            }
        });
        // 空构造方法
//        CglibUser userProxy = (CglibUser) enhancer.create();
        CglibUser userProxy = (CglibUser) enhancer.create(new Class[]{String.class}, new Object[]{cglibUser.getName()});
        userProxy.sayHello();

    }

    public static void main(String[] args) {
        CglibDemo cglibDemo = new CglibDemo();
        cglibDemo.cglibProxyDemo();
    }

}
