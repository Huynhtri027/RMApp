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
 * Created by kagan on 22.12.2015.
 */
public class LDAToDoList extends ArrayAdapter {

    List list = new ArrayList();

    public LDAToDoList(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {

        TextView SUBJECT,DATE,DESC;
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
            row = layoutInflater.inflate(R.layout.todolist_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.SUBJECT =(TextView) row.findViewById(R.id.text_subject);
            layoutHandler.DATE =(TextView) row.findViewById(R.id.text_listdate);
            layoutHandler.DESC =(TextView) row.findViewById(R.id.text_listdesc);

            row.setTag(layoutHandler);
        }
        else
        {
            layoutHandler = (LayoutHandler) row.getTag();

        }
        DPToDoList dataProvider = (DPToDoList)this.getItem(position);
        layoutHandler.SUBJECT.setText(dataProvider.getSubject());
        layoutHandler.DATE.setText(dataProvider.getDate());
        layoutHandler.DESC.setText(dataProvider.getDesc());


        return row;
    }
}
