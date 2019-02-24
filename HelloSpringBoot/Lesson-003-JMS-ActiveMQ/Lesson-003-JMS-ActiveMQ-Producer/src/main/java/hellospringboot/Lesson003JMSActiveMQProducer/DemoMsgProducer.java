package hellospringboot.Lesson003JMSActiveMQProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoMsgProducer {
    private final Logger log = LoggerFactory.getLogger(DemoMsgProducer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String msg) {
        log.info("Send: "+msg);
        jmsTemplate.convertAndSend("demo.queue", msg);
    }
}
