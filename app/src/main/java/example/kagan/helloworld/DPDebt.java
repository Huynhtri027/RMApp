package example.kagan.helloworld;

/**
 * Created by kagan on 16.12.2015.
 */
public class DPDebt {

    private String debtto;
    private String debtvalue;
    private String debtdate;
    private String debtdesc;

    public String getDebtto() {
        return debtto;
    }

    public void setDebtto(String debtto) {
        this.debtto = debtto;
    }

    public String getDebtvalue() {
        return debtvalue;
    }

    public void setDebtvalue(String debtvalue) {
        this.debtvalue = debtvalue;
    }

    public String getDebtdate() {
        return debtdate;
    }

    public void setDebtdate(String debtdate) {
        this.debtdate = debtdate;
    }

    public String getDebtdesc() {
        return debtdesc;
    }

    public void setDebtdesc(String debtdesc) {
        this.debtdesc = debtdesc;
    }

    public DPDebt(String debtto, String debtvalue, String debtdate, String debtdesc)
    {
        this.debtto = debtto;
        this.debtvalue = debtvalue;
        this.debtdate = debtdate;
        this.debtdesc = debtdesc;
    }
}
