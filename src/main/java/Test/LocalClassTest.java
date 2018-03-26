package Test;


import java.text.*;
import java.util.Date;
import java.util.Locale;

/*国际化信息的使用*/
public class LocalClassTest {

    public static void main(String[] args) throws  Exception {

        /*获取当前系统默认的本地信息(语言,地区)*/
        Locale locale=Locale.getDefault();

        /*指定语言和地区的本地信息*/
        Locale cnLocale=new Locale("zh","CN");


        /*NumberFormat的使用方法 NumberFormat 表示数字的格式化类， 即：可以按照本地的风格习惯进行数字的显示。
        MessageFormat 、DateFormat 、NumberFormat 是 Format 三个常用的子类，如果要想进一步完成一个好的国际化程序，则肯定需要同时使用这样三个类完成*/
        //按本地化格式对金额进行格式化
        NumberFormat currencyFormat=NumberFormat.getCurrencyInstance(Locale.getDefault());
        double amt=123.2898;
        String amtStr= currencyFormat.format(amt);
        System.out.println(amtStr);
        /*getNumberInstance方法和getIntegerInstance方法也有format方法和parse方法，
        format方法将一个基本类型的数字转换为字符串，而parse方法将一个字符串转换为Number类型(Number类型是所有基本类型包装类的父类)。
        这两个方法其实都可以使用String.valueOf或者各个基本类型包装类中的静态方法(如Integer.parseInt)替代*/
        NumberFormat nf = null ;    // 声明一个NumberFormat对象
        nf = NumberFormat.getInstance() ;  // 得到默认的数字格式化显示
        System.out.println("格式化之后的数字：" + nf.format(10000000)) ;
        System.out.println("格式化之后的数字：" + nf.format(1000.345)) ;

        //将货币格式的字符串转换为基本类型数字
        NumberFormat nfB = NumberFormat.getCurrencyInstance(Locale.CHINA);
        Number number = nfB.parse(amtStr);
        double price = number.doubleValue();
        System.out.println(price);

        //以百分比格式将基本类型数字转换为字符串
        double percent = 0.51345;
        NumberFormat nfC = NumberFormat.getPercentInstance();
        String percentFormat = nfC.format(percent);
        System.out.println(percentFormat);


        /*DecimalFormat 是NumberFormat 类的子类，主要的作用是用来格式化数字使用，当然，在格式化数字的时候要比直接使用NumberFormat 更加方便，
        因为可以直接指定按用户自定义方式进行格式化操作，要使用DecimalFormat对象，必须提供给它提供一个格式化的模式(pattern) */

        //小数点后保留两位的例子
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("输出的数字："+df.format(12.3456));


        FormatDemo demo = new FormatDemo() ;  // 格式化对象的类
        demo.format1("###,###.###",111222.34567) ;
        demo.format1("000,000.000",11222.34567) ;
        demo.format1("###,###.###￥",111222.34567) ;
        demo.format1("000,000.000￥",11222.34567) ;
        demo.format1("##.###%",0.345678) ;
        demo.format1("00.###%",0.0345678) ;
        demo.format1("###.###\u2030",0.345678) ;


     /*   DateFormat类可以将一个日期/时间类（例如Date类）的对象格式化表示为某地区或语言环境的日期/时间字符串，当然也能从字符串转换为日期/时间类。*/
     /*我们看看DateFormat能获取实例对象的方法：

        ① getDateInstance方法，只获取日期的实例对象

        ② getTimeInstance方法，只获取时间的实例对象

        ③ getDateTimeInstance方法，获取日期和时间的实例对象

        对上面的每个方法，有无参的(长度模式和Locale都采用默认值)，有单独参数的(指定长度模式)，有两个参数的(指定长度模式和Locale对象)共九种方法。*/
        Date date = new Date();
        DateFormat dfA = DateFormat.getDateInstance(DateFormat.MEDIUM); //省略了Locale对象，默认中文环境
        String dateStr = dfA.format(date);
        System.out.println(dateStr);

        Date date1 = new Date();
        DateFormat dfB = DateFormat.getDateInstance(DateFormat.FULL);
        String dateStr1 = dfB.format(date1);
        System.out.println(dateStr1);

        Date date2 = new Date();
        DateFormat dfc = DateFormat.getTimeInstance(DateFormat.FULL);
        String dateStr2 = dfc.format(date2);
        System.out.println(dateStr2);

        String DateStr = "2016-8-1 16:39:27";
        DateFormat dfSTR = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        Date dateq = dfSTR.parse(DateStr);
        System.out.println(dateq);


        Date dateD = new Date();
        SimpleDateFormat dfd = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateStrd = dfd.format(dateD);
        System.out.println(dateStrd);


        /*MessageFormat 提供了以与语言无关方式生成连接消息的方式。
        使用此方法构造向终端用户显示的消息MessageFormat 获取一组对象，格式化这些对象，然后将格式化后的字符串插入到模式中的适当位置*/

        int planet = 7;
        String event = "messagement apply";

        String result = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
                planet, new Date(), event);
        System.out.println(result);

        System.out.println (MessageFormat.format("Today is {0}",new Date()));






    }


   static class FormatDemo{
        public void format1(String pattern,double value){  // 此方法专门用于完成数字的格式化显示
            DecimalFormat df = null ;      // 声明一个DecimalFormat类的对象
            df = new DecimalFormat(pattern) ;  // 实例化对象，传入模板
            String str = df.format(value) ;   // 格式化数字
            System.out.println("使用" + pattern
                    + "格式化数字" + value + "：" + str) ;
        }
    };
}
