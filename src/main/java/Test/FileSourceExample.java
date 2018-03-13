
package Test;

import com.deloitte.si.core.utils.FileUtils;
import com.smart.domain.XhContractExecution;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.*;

/*通过spring的Resource抽象接口的实现类访问文件资源*/
public class FileSourceExample {



    public static void main(String[] args) throws IOException {


        //使用系统绝对路径的方式访问资源
        String filePath="E:\\下载的资料\\精通spring4.x工程源码\\chapter2\\src\\main\\java\\com\\smart\\domain\\XhContractExecution.java".replace("\\","/");
        WritableResource writableResource= (WritableResource) getPathResource(filePath);
        System.out.println(writableResource.isWritable());

        //使用类路径加载文件
        String classResoucePath="main/resources/smart-context.xml";
        Resource classResource=getClassResouce(classResoucePath);

        File file= getFileByResoure(classResource);
        System.out.println("文件的系统绝对路径： "+file.getAbsolutePath());

        System.out.println(getFileRootPath(XhContractExecution.class));

        String path="E:\\下载的资料\\精通spring4.x工程源码\\chapter2\\src\\conf\\asd.text".replace("\\","/");
        WritableResourceTest(path);
        System.out.println("读取的文件内容："+ReadResourceTest(path));


        /*通过EmcodeResource对资源文件进行编码处理*/
        Resource resourceToEncode=getPathResource(path);

        String content= getFileContent(resourceToEncode,"UTF-8");
        System.out.println("读取的文件内容utf-8: "+content);

    }

    /*获取特殊编码风格的文件内容信息(通过EncodeResource对Resource进行资源编码处理)*/
    public static String getFileContent(Resource resourceToEncode,String codeStyle) throws IOException {
       return  FileCopyUtils.copyToString(getEncodeResource(resourceToEncode,codeStyle).getReader());
    }

    /*通过Resource获取特殊编码的EncodeResource*/
    public static EncodedResource getEncodeResource(Resource resourceToEncode,String codeStyle) {
        return  new EncodedResource(resourceToEncode,codeStyle);
    }

    /*通过resource获取File对象*/
    public static File getFileByResoure(Resource resource) throws IOException {
        return resource.getFile();
    }

    /*通过Resource接口读取文件资源*/
    public static String ReadResourceTest(String path) throws IOException {
        Resource resource=getPathResource(path);
        InputStream inputStream=resource.getInputStream();
       return getContentByInputStream(inputStream);


    }

    /*根据输入流读取文件信息内容*/
    public static String  getContentByInputStream(InputStream inputStream) throws IOException {
        //ByteArrayOutputStream他的作用就是把字节流转成字符
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        int i;
        while ((i=inputStream.read())!=-1){
            byteArrayOutputStream.write(i);
        }
        inputStream.close();
        byteArrayOutputStream.close();

        return byteArrayOutputStream.toString();
    }



    //使用WritableResource接口向系统所在文件中写资源(filePath为系统绝对路径)
    public static void WritableResourceTest(String filePath) throws IOException {
        WritableResource writableResource=(WritableResource)getPathResource(filePath);

         OutputStream outputStream=  getOutputStream(writableResource);
         //这个写法回覆盖之前文件中的内容
         outputStream.write("资源文件写入测试".getBytes());
         outputStream.flush();
    }


    /*通过WritableResource获取相应的输出流FileOutputStream*/
    public static OutputStream getOutputStream(WritableResource writableResource) throws IOException {
        //writableResource完成写资源操作,实际调用的是jdk的outputStream
        return  writableResource.getOutputStream();
    }

    public static Resource getClassResouce(String str) {
        return  new ClassPathResource(str);
    }

    public  static Resource getPathResource(String str){
        return new PathResource(str);
    }
    //获取类加载的根路径(系统跟路径)
    public static String getFileRootPath(Class<?> cls){
        return  cls.getClass().getResource("/").getPath();
    }


}