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
    private final Logger log = LoggerFactory.getLogger(DemoMsgResultListener.class);

    @JmsListener(destination = "demo.queue.result")
    public void receiveDemoResult(
            @Payload String body,
            @Headers MessageHeaders headers,
            Message message,
            Session session
    ) {
        log.info("Received result: " + body);
    }

    @JmsListener(destination = "dto.queue.result")
    public void receiveDtoResult(
            @Payload String body,
            @Headers MessageHeaders headers,
            Message message,
            Session session
    ) {
        log.info("Received DTO result: " + body);
    }

}
