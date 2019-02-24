package hellospringboot.Lesson003JMSActiveMQProducer;

import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Session;

@Component
public class DemoMsgResultListener {
    private Logger log = LoggerFactory.getLogger(DemoMsgResultListener.class);

    @JmsListener(destination = "demo.queue.result")
    public void receiveResult(
            @Payload String body,
            @Headers MessageHeaders headers,
            Message message,
            Session session
    ) {
        log.info("received result <" + body + ">");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("######          Message Details           #####");
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("headers: " + headers);
        log.info("message: " + message);
        log.info("session: " + session);
        log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
    }


}
