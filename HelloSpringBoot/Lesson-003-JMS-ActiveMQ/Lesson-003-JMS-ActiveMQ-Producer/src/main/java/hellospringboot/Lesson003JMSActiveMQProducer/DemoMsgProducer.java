package hellospringboot.Lesson003JMSActiveMQProducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoMsgProducer {
    private final Logger log = LoggerFactory.getLogger(DemoMsgProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void sendMsg(String msg) {
        log.info("Send MSG: "+msg);
        jmsTemplate.convertAndSend("demo.queue", msg);
    }

    public void sendDto(DemoDTO dto) {
        log.info("Send DTO: "+dto);
        try {
            jmsTemplate.convertAndSend("dto.queue", mapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            log.error("Failed to convert DTO to JSON", e);
        }
    }
}
