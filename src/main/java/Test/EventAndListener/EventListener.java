package Test.EventAndListener;

import javafx.application.Application;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/*事件监听器 需要继承ApplicationListener*/
public class EventListener  implements ApplicationListener<ApplicationEvent> {


    @Override
    public void onApplicationEvent(ApplicationEvent event) {

       if(event.getClass().equals(MailSentEvent.class)){

               MailSentEvent mailSentEvent=(MailSentEvent)event;
               System.out.println("监听器监听到邮件发送"+"地址："+mailSentEvent.getAddtress()+" 收件人:"+mailSentEvent.getReceiver());
       }
    }


}
