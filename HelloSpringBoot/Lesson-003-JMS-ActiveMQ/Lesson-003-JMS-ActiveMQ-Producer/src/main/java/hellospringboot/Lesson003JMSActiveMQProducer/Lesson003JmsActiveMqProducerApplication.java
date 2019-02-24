package hellospringboot.Lesson003JMSActiveMQProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class Lesson003JmsActiveMqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson003JmsActiveMqProducerApplication.class, args);
	}

}
