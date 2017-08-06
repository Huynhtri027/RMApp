package example.kagan.helloworld;

/**
 * Created by kagan on 19.12.2015.
 */
public class DPStock {

    private String stockname;
    private String stocknumber;


    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public String getStocknumber() {
        return stocknumber;
    }

    public void setStocknumber(String stocknumber) {
        this.stocknumber = stocknumber;
    }

    public DPStock(String stockname, String stocknumber)
    {
        this.stockname = stockname;
        this.stocknumber = stocknumber;
    }
}
