package hellospringboot.Lesson003JMSActiveMQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.Session;
import java.io.IOException;

@Component
class DemoMsgListener {
    private final Logger log = LoggerFactory.getLogger(DemoMsgListener.class);

    @Autowired
    private ObjectMapper mapper;

    @JmsListener(destination = "demo.queue")
    @SendTo("demo.queue.result")
    public String receiveMessage(
            @Payload String body,
            @Headers MessageHeaders headers,
            Message message,
            Session session
    ) {
        log.info("Received: " + body);
        return body+" (result)";
    }

    @JmsListener(destination = "dto.queue")
    @SendTo("dto.queue.result")
    public String receiveDto(
            @Payload String body,
            @Headers MessageHeaders headers,
            Message message,
            Session session
    ) {
        log.info("Received DTO: " + body);
        try {
            DemoDTO dto = mapper.readValue(body, DemoDTO.class);
            return "DTO OK";
        } catch (IOException e) {
            log.error("Failed to parse DemoDTO: "+body, e);
            return "DTO Error";
        }
    }
}
