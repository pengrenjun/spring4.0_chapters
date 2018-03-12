package Test;

import com.smart.reflect.PrivateCar;
import org.springframework.core.io.Resource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*通过java反射 获取对象并调用其中的类方法及私有成员变量,绕开访问权限的设置*/
public class PrivateCarReflect {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        privateCarReflect();
    }


    private static void privateCarReflect() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class cls=Class.forName("com.smart.reflect.PrivateCar");
        //创建类实体对象
        PrivateCar privateCar=(PrivateCar) cls.newInstance();

        //获取类成员反射类
        /*Class Test.PrivateCarReflect can not access a member of class com.smart.reflect.PrivateCar with modifiers "private"*/
        Field colorField=cls.getDeclaredField("color");
        //取消java语言访问检查以访问private成员变量
        colorField.setAccessible(Boolean.TRUE);

        //通过类成员反射类设置属性
        colorField.set(privateCar,"red");

        System.out.println(privateCar.getColor());

        //获取方法反射类
        Method drive=cls.getDeclaredMethod("drive",new Class[]{String.class});
        //取消java语言访问检查以访问protected成员变量
        drive.setAccessible(Boolean.TRUE);
        //通过方法反射类调用方法
        drive.invoke(privateCar,"red");



    }
}
