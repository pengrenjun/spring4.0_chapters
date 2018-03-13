
package Test;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.IOException;

/*通过spring的Resource抽象接口的实现类访问文件资源*/
public class FileSourceExample {



    public static void main(String[] args) throws IOException {


        //使用系统绝对路径的方式访问资源
        String filePath="E:\\下载的资料\\精通spring4.x工程源码\\chapter2\\src\\main\\java\\com\\smart\\domain\\XhContractExecution.java".replace("\\","/");
        WritableResource writableResource= getPathResource(filePath);
        System.out.println(writableResource.isWritable());

        //使用类路径加载文件
        String classResoucePath="resources/smart-contect.xml";
        Resource classResource=getClassResouce(classResoucePath);
        System.out.println();

    }

    private static Resource getClassResouce(String str) {
        return  new ClassPathResource(str);
    }

    private  static WritableResource getPathResource(String str){
        return new PathResource(str);
    }
}