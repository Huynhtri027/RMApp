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
 * Created by kagan on 16.12.2015.
 */
public class LDADebts extends ArrayAdapter {

    List list = new ArrayList();

    public LDADebts(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView DEBTTO,DEBTVALUE,DEBTDATE,DEBTDESC;
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
            row = layoutInflater.inflate(R.layout.debts_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.DEBTTO =(TextView) row.findViewById(R.id.text_debtto);
            layoutHandler.DEBTVALUE =(TextView) row.findViewById(R.id.text_debtvalue);
            layoutHandler.DEBTDATE =(TextView) row.findViewById(R.id.text_debtdate);
            layoutHandler.DEBTDESC =(TextView) row.findViewById(R.id.text_debtdesc);

            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DPDebt dataProvider = (DPDebt)this.getItem(position);
        layoutHandler.DEBTTO.setText(dataProvider.getDebtto());
        layoutHandler.DEBTVALUE.setText(dataProvider.getDebtvalue());
        layoutHandler.DEBTDATE.setText(dataProvider.getDebtdate());
        layoutHandler.DEBTDESC.setText(dataProvider.getDebtdesc());

        return row;
    }
}
