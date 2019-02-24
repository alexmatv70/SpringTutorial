package hellospringboot.Lesson003JMSActiveMQProducer;

import java.util.Date;

public class DemoDTO {
    private String text;
    private Date date;

    public DemoDTO(String text) {
        this.text = text;
        this.date = new Date();
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "DemoDTO{" +
                "text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
