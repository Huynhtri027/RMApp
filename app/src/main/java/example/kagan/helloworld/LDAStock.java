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
 * Created by kagan on 19.12.2015.
 */
public class LDAStock extends ArrayAdapter {

    List list = new ArrayList();

    public LDAStock(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView NAME,NUMBER;
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
            row = layoutInflater.inflate(R.layout.stock_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME =(TextView) row.findViewById(R.id.text_itemname);
            layoutHandler.NUMBER =(TextView) row.findViewById(R.id.text_itemnumber);

            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DPStock dataProvider = (DPStock)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getStockname());
        layoutHandler.NUMBER.setText(dataProvider.getStocknumber());


        return row;
    }
}
