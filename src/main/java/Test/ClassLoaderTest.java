package Test;

import Utils.ClassLocationUtils;
import com.smart.reflect.PrivateCar;

public class ClassLoaderTest {

    public static void main(String[] args) {

        //默认使用AppClassLoader装载应用程序类
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        System.out.println("current classLoader"+classLoader);

        //AppClassLoader的父类ExtClassLoader
        System.out.println("parent classLoader"+classLoader.getParent());

        //跟加载器是通过c++编写的,在java中是访问不到的
        System.out.println("grandparent classLoader"+classLoader.getParent().getParent());

        //通过工具类,来获取类是来自哪个类包中的
        String sourceCls= ClassLocationUtils.where(Thread.class);
        System.out.println(sourceCls);




    }
}
