package Test;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import java.io.IOException;
import java.io.InputStream;


/*通过资源加载器配合资源地址表达式 加载资源文件Resource*/
public class PatternResolverTest {

    public static void main(String[] args) throws IOException {
        String locationPattern="classpath:conf/*.text";
        Resource resources[]=getResourceArrPatternResolver( locationPattern);
        for(Resource source: resources){
            //获取资源后建议采用流的方式读取文件,如果打成jar包,直接读取file文件会报错
            InputStream inputStream=source.getInputStream();
            System.out.println(FileSourceExample.getContentByInputStream(inputStream));
        }
    }

    /*使用spring的资源加载器 根据资源地址(支持Ant风格)加载资源列表*/
    public  static Resource[] getResourceArrPatternResolver(String locationPattern) throws IOException {
        /*ResourcePatternResolver支持Ant风格的资源地址,PathMatchingResourcePatternResolver是Spring 提供的标准实现类*/
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        return  resolver.getResources(locationPattern);
    }
}
