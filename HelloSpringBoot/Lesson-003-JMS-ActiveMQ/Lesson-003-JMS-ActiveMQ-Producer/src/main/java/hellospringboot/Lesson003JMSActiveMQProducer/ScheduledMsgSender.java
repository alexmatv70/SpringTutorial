package hellospringboot.Lesson003JMSActiveMQProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledMsgSender {
    @Autowired
    private DemoMsgProducer producer;

    @Scheduled(initialDelay = 2000, fixedRate = 5000)
    void sendMsg() {
        producer.sendMsg("Hello " + new Date());
    }

    @Scheduled(initialDelay = 2000, fixedRate = 5000)
    void run() {
        producer.sendDto(new DemoDTO("Hello DTO"));
    }
}
