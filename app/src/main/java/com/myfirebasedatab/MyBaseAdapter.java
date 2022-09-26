package com.myfirebasedatab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Bean>beanArrayList;
    public MyBaseAdapter(Context context, ArrayList<Bean> beanArrayList) {

            this.context=context;
            this.beanArrayList=beanArrayList;

    }

    @Override
    public int getCount() {
        return beanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return beanArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.raw_list,null);

        TextView tvFn = view.findViewById(R.id.tv_fn);
        TextView tvLn = view.findViewById(R.id.tv_ln);

        tvFn.setText(beanArrayList.get(i).firstName);
        tvLn.setText(beanArrayList.get(i).lastName);
        return view;





    }
}
