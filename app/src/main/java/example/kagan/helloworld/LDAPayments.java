package example.kagan.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kagan on 14.12.2015.
 */
public class LDAPayments extends ArrayAdapter {
    List list = new ArrayList();

    public LDAPayments(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView PAYTO,PAYVALUE,PAYDATE,PAYTYPE;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null)
        {
            LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.payment_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.PAYTO =(TextView) row.findViewById(R.id.text_payto);
            layoutHandler.PAYVALUE =(TextView) row.findViewById(R.id.text_payvalue);
            layoutHandler.PAYDATE =(TextView) row.findViewById(R.id.text_paydate);
            layoutHandler.PAYTYPE =(TextView) row.findViewById(R.id.text_paytype);

            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DPPayment dataProvider = (DPPayment)this.getItem(position);
        layoutHandler.PAYTO.setText(dataProvider.getPayto());
        layoutHandler.PAYVALUE.setText(dataProvider.getPayvalue());
        layoutHandler.PAYDATE.setText(dataProvider.getPaydate());
        layoutHandler.PAYTYPE.setText(dataProvider.getPaytype());


        return row;
    }
}
