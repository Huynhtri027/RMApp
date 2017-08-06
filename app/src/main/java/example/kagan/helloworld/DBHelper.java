package example.kagan.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kagan on 12.12.2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "RMADB";
    private static final int DBVERSION='1';

    private static final String CREATE_REGISTERTB=
            "CREATE TABLE " + Values.RegisterInfo.TBREGISTER+"("+ Values.RegisterInfo.REGID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Values.RegisterInfo.REGCOMPANYNAME+" TEXT,"+ Values.RegisterInfo.REGEMAİL+" TEXT NOT NULL,"+
                    Values.RegisterInfo.REGPASSWORD+" TEXT NOT NULL);";

    private static final String CREATE_RESERVATIONTB=
            "CREATE TABLE " + Values.ReservationInfo.TBRESERVATION+"("+ Values.ReservationInfo.RESID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Values.ReservationInfo.RESNAME+" TEXT NOT NULL,"+ Values.ReservationInfo.RESPEOPLE+" TEXT NOT NULL,"+
                    Values.ReservationInfo.RESPHONE+" TEXT NOT NULL,"+ Values.ReservationInfo.RESDATE+" TEXT NOT NULL,"+
                    Values.ReservationInfo.RESHOUR+" TEXT,"+ Values.ReservationInfo.RESDESC+" TEXT);";

    private static final String CREATE_PAYMENTTB=
            "CREATE TABLE " + Values.PaymentInfo.TBPAYMENT+"("+ Values.PaymentInfo.PAYID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Values.PaymentInfo.PAYTO+" TEXT NOT NULL,"+ Values.PaymentInfo.PAYVALUE+" TEXT,"+
                    Values.PaymentInfo.PAYDATE+" TEXT,"+ Values.PaymentInfo.PAYTYPE+" TEXT,"+
                    Values.PaymentInfo.PAYDESC+" TEXT);";

    private static final String CREATE_STOCKTB=
            "CREATE TABLE " + Values.StockInfo.TBSTOCK+"("+ Values.StockInfo.STOCKNAME+" TEXT PRIMARY KEY, "+
                    Values.StockInfo.STOCKNUMBER+" TEXT);";

    private static final String CREATE_TODOLISTTB=
            "CREATE TABLE " + Values.ToDoListInfo.TBTODOLIST+"("+ Values.ToDoListInfo.TODOID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Values.ToDoListInfo.TODOSUBJECT+" TEXT,"+ Values.ToDoListInfo.TODODATE+" TEXT,"+
                    Values.ToDoListInfo.TODODESC+" TEXT NOT NULL);";

    private static  final String CREATE_DEBTTB=
            "CREATE TABLE " + Values.DebtInfo.TBDEBT+" ("+ Values.DebtInfo.DEBTID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    Values.DebtInfo.DEBTNAME+" TEXT,"+ Values.DebtInfo.DEBTVALUE+" TEXT,"+
                    Values.DebtInfo.DEBTDATE+" TEXT,"+ Values.DebtInfo.DEBTDESC+" TEXT);";


    public DBHelper (Context context){

        super(context, DBNAME, null, DBVERSION);
        Log.e("DATABASE OPERATIONS", "Database created / opened...");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_REGISTERTB);
        db.execSQL(CREATE_RESERVATIONTB);
        db.execSQL(CREATE_PAYMENTTB);
        db.execSQL(CREATE_STOCKTB);
        db.execSQL(CREATE_TODOLISTTB);
        db.execSQL(CREATE_DEBTTB);
        Log.e("DATABASE OPERATIONS","Tables created");

    }

    public void addregister(String cname,String email, String password,SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.RegisterInfo.REGCOMPANYNAME, cname);
        cv.put(Values.RegisterInfo.REGEMAİL, email);
        cv.put(Values.RegisterInfo.REGPASSWORD, password);
        db.insert(Values.RegisterInfo.TBREGISTER, null, cv);
        Log.e("DATABASE OPERATIONS", "Register row inserted");

    }

    public void addReservation(String resname,String respeople, String resphone,String resdate,String reshour,String resdesc,SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.ReservationInfo.RESNAME, resname);
        cv.put(Values.ReservationInfo.RESPEOPLE, respeople);
        cv.put(Values.ReservationInfo.RESPHONE, resphone);
        cv.put(Values.ReservationInfo.RESDATE, resdate);
        cv.put(Values.ReservationInfo.RESHOUR, reshour);
        cv.put(Values.ReservationInfo.RESDESC, resdesc);
        db.insert(Values.ReservationInfo.TBRESERVATION, null, cv);
        Log.e("DATABASE OPERATIONS", "Reservation row inserted");

    }

    public Cursor getReservationInfo (SQLiteDatabase db)
    {
        Cursor cursor;
        String[] reservation = {Values.ReservationInfo.RESNAME, Values.ReservationInfo.RESPEOPLE, Values.ReservationInfo.RESPHONE,Values.ReservationInfo.RESDATE, Values.ReservationInfo.RESHOUR, Values.ReservationInfo.RESDESC};
        cursor = db.query(Values.ReservationInfo.TBRESERVATION, reservation,null,null,null,null,null);
        return cursor;

    }

    public Cursor searchReservation (String search_name, SQLiteDatabase sqLiteDatabase)
    {
        String[] searchreservation = {Values.ReservationInfo.RESID,Values.ReservationInfo.RESNAME, Values.ReservationInfo.RESPEOPLE, Values.ReservationInfo.RESPHONE,Values.ReservationInfo.RESDATE, Values.ReservationInfo.RESHOUR, Values.ReservationInfo.RESDESC};
        String searchselectionres = Values.ReservationInfo.RESNAME+" LIKE ?";
        String[] searchselectionres_args = {search_name};
        Cursor cursor = sqLiteDatabase.query(Values.ReservationInfo.TBRESERVATION,searchreservation,searchselectionres,searchselectionres_args,null,null,null);
        return cursor;
    }

    public void deleteReservation (String search_id, SQLiteDatabase sqLiteDatabase)
    {
        String deleteres = Values.ReservationInfo.RESID+" LIKE ?";
        String[] deleteres_args = {search_id};
        sqLiteDatabase.delete(Values.ReservationInfo.TBRESERVATION,deleteres,deleteres_args);
    }

    public int updateupReservation (String old_name, String new_name, String new_people, String new_phone, String new_date, String new_hour, String new_desc, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Values.ReservationInfo.RESNAME,new_name);
        contentValues.put(Values.ReservationInfo.RESPEOPLE,new_people);
        contentValues.put(Values.ReservationInfo.RESPHONE,new_phone);
        contentValues.put(Values.ReservationInfo.RESDATE,new_date);
        contentValues.put(Values.ReservationInfo.RESHOUR,new_hour);
        contentValues.put(Values.ReservationInfo.RESDESC,new_desc);

        String selection = Values.ReservationInfo.RESNAME + " LIKE ?";
        String[] selection_args = {old_name};
        int count = sqLiteDatabase.update(Values.ReservationInfo.TBRESERVATION,contentValues,selection,selection_args);
        return count;

    }

    public void addPayment(String payto,String payvalue, String paydate,String paytype,String paydesc,SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.PaymentInfo.PAYTO, payto);
        cv.put(Values.PaymentInfo.PAYVALUE, payvalue);
        cv.put(Values.PaymentInfo.PAYDATE, paydate);
        cv.put(Values.PaymentInfo.PAYTYPE, paytype);
        cv.put(Values.PaymentInfo.PAYDESC, paydesc);
        db.insert(Values.PaymentInfo.TBPAYMENT, null, cv);
        Log.e("DATABASE OPERATIONS", "Payment row inserted");

    }

    public Cursor getPaymentInfo (SQLiteDatabase db)
    {
        Cursor cursor;
        String[] payment = {Values.PaymentInfo.PAYTO, Values.PaymentInfo.PAYVALUE, Values.PaymentInfo.PAYDATE,Values.PaymentInfo.PAYTYPE, Values.PaymentInfo.PAYDESC};
        cursor = db.query(Values.PaymentInfo.TBPAYMENT, payment,null,null,null,null,null);
        return cursor;
    }

    public Cursor searchPayment (String search_payto, SQLiteDatabase sqLiteDatabase)
    {
        String[] searchpayment = {Values.PaymentInfo.PAYID,Values.PaymentInfo.PAYTO, Values.PaymentInfo.PAYVALUE, Values.PaymentInfo.PAYDATE,Values.PaymentInfo.PAYTYPE, Values.PaymentInfo.PAYDESC};
        String searchselectionpay = Values.PaymentInfo.PAYTO+" LIKE ?";
        String[] searchselectionpay_args = {search_payto};
        Cursor cursor = sqLiteDatabase.query(Values.PaymentInfo.TBPAYMENT,searchpayment,searchselectionpay,searchselectionpay_args,null,null,null);
        return cursor;
    }

    public void deletePayment (String search_id, SQLiteDatabase sqLiteDatabase)
    {
        String deletepay = Values.PaymentInfo.PAYID+" LIKE ?";
        String[] deletepay_args = {search_id};
        sqLiteDatabase.delete(Values.PaymentInfo.TBPAYMENT,deletepay,deletepay_args);
    }

    public int updateupPayment (String old_cname, String new_cname, String new_value, String new_date, String new_type, String new_updesc, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Values.PaymentInfo.PAYTO,new_cname);
        contentValues.put(Values.PaymentInfo.PAYVALUE,new_value);
        contentValues.put(Values.PaymentInfo.PAYDATE,new_date);
        contentValues.put(Values.PaymentInfo.PAYTYPE,new_type);
        contentValues.put(Values.PaymentInfo.PAYDESC,new_updesc);

        String selection = Values.PaymentInfo.PAYTO + " LIKE ?";
        String[] selection_args = {old_cname};
        int count = sqLiteDatabase.update(Values.PaymentInfo.TBPAYMENT,contentValues,selection,selection_args);
        return count;

    }

    public void addStock(String stockname,String stocknumber,SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.StockInfo.STOCKNAME, stockname);
        cv.put(Values.StockInfo.STOCKNUMBER, stocknumber);
        db.insert(Values.StockInfo.TBSTOCK, null, cv);
        Log.e("DATABASE OPERATIONS", "Stock row inserted");

    }

    public Cursor getStockInfo (SQLiteDatabase db)
    {
        Cursor cursor;
        String[] stock = {Values.StockInfo.STOCKNAME, Values.StockInfo.STOCKNUMBER};
        cursor = db.query(Values.StockInfo.TBSTOCK, stock,null,null,null,null,null);
        return cursor;

    }

    public Cursor searchStock (String search_stock, SQLiteDatabase sqLiteDatabase)
    {
        String[] searchstock = {Values.StockInfo.STOCKNAME,Values.StockInfo.STOCKNUMBER};
        String searchselectionstock = Values.StockInfo.STOCKNAME+" LIKE ?";
        String[] searchselectionstock_args = {search_stock};
        Cursor cursor = sqLiteDatabase.query(Values.StockInfo.TBSTOCK,searchstock,searchselectionstock,searchselectionstock_args,null,null,null);
        return cursor;
    }

    public int updateupStock(String old_cname, String new_cname, String new_number, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Values.StockInfo.STOCKNAME,new_cname);
        contentValues.put(Values.StockInfo.STOCKNUMBER,new_number);


        String selection = Values.StockInfo.STOCKNAME + " LIKE ?";
        String[] selection_args = {old_cname};
        int count = sqLiteDatabase.update(Values.StockInfo.TBSTOCK, contentValues, selection, selection_args);
        return count;

    }

    public void deleteStock (String search_id, SQLiteDatabase sqLiteDatabase)
    {
        String deletestock = Values.StockInfo.STOCKNAME+" LIKE ?";
        String[] deletestock_args = {search_id};
        sqLiteDatabase.delete(Values.StockInfo.TBSTOCK,deletestock,deletestock_args);
    }

    public void addTodolist(String todosubject,String tododate,String tododesc, SQLiteDatabase db)
    {

        ContentValues cv= new ContentValues();
        cv.put(Values.ToDoListInfo.TODOSUBJECT, todosubject);
        cv.put(Values.ToDoListInfo.TODODATE, tododate);
        cv.put(Values.ToDoListInfo.TODODESC, tododesc);
        db.insert(Values.ToDoListInfo.TBTODOLIST, null, cv);
        Log.e("DATABASE OPERATIONS", "Todolist row inserted");

    }

    public Cursor getToDoListInfo (SQLiteDatabase db)
    {
        Cursor cursor;
        String[] todolist = {Values.ToDoListInfo.TODOSUBJECT, Values.ToDoListInfo.TODODATE, Values.ToDoListInfo.TODODESC};
        cursor = db.query(Values.ToDoListInfo.TBTODOLIST, todolist,null,null,null,null,null);
        return cursor;

    }

    public Cursor searchToDoList (String search_todo, SQLiteDatabase sqLiteDatabase)
    {
        String[] searchtodo = {Values.ToDoListInfo.TODOSUBJECT,Values.ToDoListInfo.TODODATE,Values.ToDoListInfo.TODODESC};
        String searchselectiontodo = Values.ToDoListInfo.TODOSUBJECT+" LIKE ?";
        String[] searchselectiontodo_args = {search_todo};
        Cursor cursor = sqLiteDatabase.query(Values.ToDoListInfo.TBTODOLIST,searchtodo,searchselectiontodo,searchselectiontodo_args,null,null,null);
        return cursor;
    }

    public int updateToDoList(String old_cname, String new_subject, String new_todate,String new_todesc, SQLiteDatabase sqLiteDatabase)
    {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Values.ToDoListInfo.TODOSUBJECT,new_subject);
        contentValues.put(Values.ToDoListInfo.TODODATE,new_todate);
        contentValues.put(Values.ToDoListInfo.TODODESC,new_todesc);


        String selection = Values.ToDoListInfo.TODOSUBJECT + " LIKE ?";
        String[] selection_args = {old_cname};
        int count = sqLiteDatabase.update(Values.ToDoListInfo.TBTODOLIST, contentValues, selection, selection_args);
        return count;

    }

    public void deleteToDoList (String search_id, SQLiteDatabase sqLiteDatabase)
    {
        String deletetodo = Values.ToDoListInfo.TODOSUBJECT+" LIKE ?";
        String[] deletetodo_args = {search_id};
        sqLiteDatabase.delete(Values.ToDoListInfo.TBTODOLIST,deletetodo,deletetodo_args);
    }

    public void addDebt(String debtname, String debtvalue, String debtdate, String debtdesc, SQLiteDatabase db)
    {
        ContentValues cv= new ContentValues();
        cv.put(Values.DebtInfo.DEBTNAME, debtname);
        cv.put(Values.DebtInfo.DEBTVALUE, debtvalue);
        cv.put(Values.DebtInfo.DEBTDATE, debtdate);
        cv.put(Values.DebtInfo.DEBTDESC, debtdesc);
        db.insert(Values.DebtInfo.TBDEBT, null, cv);
        Log.e("DATABASE OPERATIONS", "Debt row inserted");
    }

    public Cursor getDebtInfo (SQLiteDatabase db)
    {
        Cursor cursor;
        String[] debt = {Values.DebtInfo.DEBTNAME, Values.DebtInfo.DEBTVALUE, Values.DebtInfo.DEBTDATE,Values.DebtInfo.DEBTDESC};
        cursor = db.query(Values.DebtInfo.TBDEBT, debt,null,null,null,null,null);
        return cursor;

    }

    public Cursor searchDept (String search_debt, SQLiteDatabase sqLiteDatabase)
    {
        String[] searchdebt = {Values.DebtInfo.DEBTID,Values.DebtInfo.DEBTNAME, Values.DebtInfo.DEBTVALUE, Values.DebtInfo.DEBTDATE,Values.DebtInfo.DEBTDESC};
        String searchselectiondebt = Values.DebtInfo.DEBTNAME+" LIKE ?";
        String[] searchselectiondebt_args = {search_debt};
        Cursor cursor = sqLiteDatabase.query(Values.DebtInfo.TBDEBT,searchdebt,searchselectiondebt,searchselectiondebt_args,null,null,null);
        return cursor;
    }

    public void payDebtInsertToPayment (String payname,String payvalue,String paydate,String paytype, String paydesc, SQLiteDatabase db)
    {
        ContentValues cv= new ContentValues();
        cv.put(Values.PaymentInfo.PAYTO, payname);
        cv.put(Values.PaymentInfo.PAYVALUE, payvalue);
        cv.put(Values.PaymentInfo.PAYDATE, paydate);
        cv.put(Values.PaymentInfo.PAYTYPE, paytype);
        cv.put(Values.PaymentInfo.PAYDESC, paydesc);
        db.insert(Values.PaymentInfo.TBPAYMENT, null, cv);
        Log.e("DATABASE OPERATIONS", "DebtPay row inserted");
    }

    public void deleteDebt (String search_id, SQLiteDatabase sqLiteDatabase)
    {
        String deletedebt = Values.DebtInfo.DEBTID+" LIKE ?";
        String[] deletedebt_args = {search_id};
        sqLiteDatabase.delete(Values.DebtInfo.TBDEBT, deletedebt, deletedebt_args);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
