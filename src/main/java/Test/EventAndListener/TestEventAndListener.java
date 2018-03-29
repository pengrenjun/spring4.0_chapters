package Test.EventAndListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*测试邮件发送监听*/
public class TestEventAndListener {

    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        EventSender eventSender=ctx.getBean("eventSender",EventSender.class);
        MailSentEvent mail=new MailSentEvent(ctx,"沈阳市","xiaoli");
        eventSender.sendMail(mail);
    }
}
