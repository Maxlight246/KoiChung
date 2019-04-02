package com.example.koichung.ViewControler.Agency;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.koichung.Model.Agency;
import com.example.koichung.R;

import java.util.ArrayList;

public class AgencyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Agency> arrData;

    public AgencyAdapter(Context context, ArrayList<Agency> arrData) {
        this.context = context;
        this.arrData = arrData;
    }

    @Override
    public int getCount() {
        return arrData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Agency agency = arrData.get(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_agency_layout,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setupView(agency);
        return convertView;
    }

    class ViewHolder{
        TextView tvName,tvUserName,tvAddress;
        public ViewHolder (View view){
            tvName = view.findViewById(R.id.tv_agency_name);
            tvUserName = view.findViewById(R.id.tv_agency_user_name);
            tvAddress = view.findViewById(R.id.tv_agency_address);
        }

        public void setupView(Agency agency){
            tvName.setText(agency.getName());
            tvUserName.setText("("+agency.getUserName()+")");
            tvAddress.setText(agency.getAddress());
        }
    }
}
