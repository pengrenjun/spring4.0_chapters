package Test.EventAndListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/*邮件发送事件(事件对象) 需要继承ApplicationContextEvent*/
public class MailSentEvent extends ApplicationContextEvent {

    //接收地址
    private String addtress;
    //接收人
    private String receiver;


    /**
     * Create a new ContextStartedEvent.
     *  事件对象的构造器 引入事件源source
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MailSentEvent(ApplicationContext source,String addtress,String receiver) {
        super(source);
        this.addtress=addtress;
        this.receiver=receiver;
    }

    public String getAddtress() {
        return addtress;
    }

    public void setAddtress(String addtress) {
        this.addtress = addtress;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
