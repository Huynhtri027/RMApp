package example.kagan.helloworld;

/**
 * Created by kagan on 14.12.2015.
 */
public class DPPayment {
    private String payto;
    private String payvalue;
    private String paydate;
    private String paytype;

    public String getPayto() {
        return payto;
    }

    public void setPayto(String payto) {
        this.payto = payto;
    }

    public String getPayvalue() {
        return payvalue;
    }

    public void setPayvalue(String payvalue) {
        this.payvalue = payvalue;
    }

    public String getPaydate() {
        return paydate;
    }

    public void setPaydate(String paydate) {
        this.paydate = paydate;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public DPPayment(String payto, String payvalue, String paydate, String paytype)
    {
        this.payto = payto;
        this.payvalue = payvalue;
        this.paydate = paydate;
        this.paytype = paytype;
    }
}
