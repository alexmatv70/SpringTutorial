package hellospringboot.Lesson003JMSActiveMQ;

import java.util.Date;

public class DemoDTO {
    private String text;
    private Date date;

    protected DemoDTO() {
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
