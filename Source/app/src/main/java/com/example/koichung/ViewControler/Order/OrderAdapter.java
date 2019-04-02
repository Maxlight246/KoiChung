package com.example.koichung.ViewControler.Order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.koichung.Model.Order;
import com.example.koichung.R;

import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {

    Context context;
    ArrayList<Order> arrData;

    public OrderAdapter(Context context, ArrayList<Order> arrData) {
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
        Order order = arrData.get(position);

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_order_layout,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setupView(order);
        return convertView;
    }

    class ViewHolder{
        TextView tvOrderID,tvOrderName,tvPhone,tvCount,tvPrice,tvDate;

        public ViewHolder(View view){
            tvOrderID = view.findViewById(R.id.tv_order_id);
            tvOrderName = view.findViewById(R.id.tv_order_name);
            tvPhone = view.findViewById(R.id.tv_order_phone);
            tvCount = view.findViewById(R.id.tv_order_count);
            tvPrice = view.findViewById(R.id.tv_order_price);
            tvDate = view.findViewById(R.id.tv_order_date);
        }

        public void setupView(Order order){
            tvOrderID.setText(order.getCode());
            tvOrderName.setText(order.getCustomerName());
            tvPhone.setText(order.getPhone());
            tvCount.setText(order.getQty()+" con");
            tvPrice.setText(order.getTotalPrice()+" đ");
            tvDate.setText(order.getCreateDateString());
        }
    }
}
