package com.smart.EventAndListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*事件发布器 实现ApplicationContextAware接口 用来注入启动的容器实例 */
public class EventSender implements ApplicationContextAware {

    //注入启动的容器实例
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //邮件发送发布器
    public void sendMail(MailSentEvent mailSentEvent) {

        System.out.println("邮件开始发送");
        //发布邮件发布事件
        applicationContext.publishEvent(mailSentEvent);
    }


}
