package example.kagan.helloworld;

/**
 * Created by kagan on 22.12.2015.
 */
public class DPToDoList {
    private String subject;
    private String date;
    private String desc;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DPToDoList(String subject, String date, String desc)
    {
        this.subject = subject;
        this.date = date;
        this.desc = desc;
    }
}
