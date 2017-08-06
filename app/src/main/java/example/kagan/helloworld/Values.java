package example.kagan.helloworld;

/**
 * Created by kagan on 12.12.2015.
 */
public class Values {
    public static abstract class RegisterInfo
    {
        public static final String TBREGISTER = "register_TB";
        public static final String REGID ="reg_id";
        public static final String REGCOMPANYNAME = "reg_cname";
        public static final String REGEMAİL = "reg_email";
        public static final String REGPASSWORD = "reg_password";
    }

    public static abstract class ReservationInfo
    {
        public static final String TBRESERVATION = "reservation_TB";
        public static final String RESID = "res_id";
        public static final String RESNAME = "res_name";
        public static final String RESPEOPLE = "res_people";
        public static final String RESPHONE = "res_phone";
        public static final String RESDATE = "res_date";
        public static final String RESHOUR = "res_hour";
        public static final String RESDESC = "res_description";
    }

    public static abstract class PaymentInfo
    {
        public static final String TBPAYMENT = "payment_TB";
        public static final String PAYID = "pay_id";
        public static final String PAYTO = "pay_to";
        public static final String PAYVALUE = "pay_value";
        public static final String PAYDATE = "pay_date";
        public static final String PAYTYPE = "pay_type";
        public static final String PAYDESC = "pay_description";
    }

    public static abstract  class StockInfo
    {
        public static final String TBSTOCK = "stock_TB";
        public static final String STOCKNAME = "stock_name";
        public static final String STOCKNUMBER = "stock_number";
    }

    public static abstract  class ToDoListInfo
    {
        public static final String TBTODOLIST = "todolist_TB";
        public static final String TODOID = "todo_id";
        public static final String TODOSUBJECT = "todo_subject";
        public static final String TODODATE = "todo_date";
        public static final String TODODESC = "todo_description";
    }

    public static abstract  class DebtInfo
    {
        public static final String TBDEBT = "debt_TB";
        public static final String DEBTID = "debt_id";
        public static final String DEBTNAME = "debt_name";
        public static final String DEBTVALUE = "debt_value";
        public static final String DEBTDATE = "debt_date";
        public static final String DEBTDESC = "debt_desc";
    }

}
