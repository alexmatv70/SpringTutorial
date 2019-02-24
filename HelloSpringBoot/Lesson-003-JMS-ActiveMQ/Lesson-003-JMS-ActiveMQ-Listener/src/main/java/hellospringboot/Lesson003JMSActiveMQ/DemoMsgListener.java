package hellospringboot.Lesson003JMSActiveMQ;

import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.Session;

@Component
class DemoMsgListener {
    private final Logger log = LoggerFactory.getLogger(DemoMsgListener.class);

    @JmsListener(destination = "demo.queue")
    @SendTo("demo.queue.result")
    public String receiveMessage(@Payload String body,
                               @Headers MessageHeaders headers,
                               Message message, Session session) {
        log.info("Received: " + body);
        return body+" (result)";
    }
}
