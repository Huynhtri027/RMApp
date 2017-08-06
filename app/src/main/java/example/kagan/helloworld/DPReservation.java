package example.kagan.helloworld;

/**
 * Created by kagan on 13.12.2015.
 */
public class DPReservation {
    private String name;
    private String people;
    private String phone;
    private String date;
    private String hour;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public DPReservation(String name, String people, String phone, String date, String hour)
    {
        this.name = name;
        this.people = people;
        this.phone = phone;
        this.date = date;
        this.hour = hour;
    }
}
