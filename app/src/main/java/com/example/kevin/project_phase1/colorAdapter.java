package com.example.kevin.project_phase1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class colorAdapter<T> extends ArrayAdapter<T> {
    private final Context context;
    private final ArrayList<T> data;

    public colorAdapter(Context context, ArrayList<T> list) {
        super(context, 0, list);
        this.context=context;
        this.data=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        ViewHolder holder;
        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.itemlistrow, parent, false);
            holder = new ViewHolder();
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder) convertView.getTag();
        }
        TextView tv = (TextView) view.findViewById(R.id.row);
        //here set your color as per position

//        if (position == 0) {
//            tv.setBackgroundColor(Color.BLUE);
//        } else if (position == 1) {
//            tv.setBackgroundColor(Color.RED);
//        }

        //Test here to set color to gradients depending on size of input array
        float hue, hueNext;

        hue=(360/ (float) data.size())*position;
        hueNext=(360/(float)data.size())*(position+1);

        float[] hsv1={hue, 1, 1};
        float[] hsv2={hueNext,1,1};
        tv.setBackground(new colorGradient(hsv1, hsv2,"gradi"+position).getLRGradient());

        return view;
    }
}