package hellospringboot.Lesson003JMSActiveMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Lesson003JmsActiveMqListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson003JmsActiveMqListenerApplication.class, args);
	}

}
