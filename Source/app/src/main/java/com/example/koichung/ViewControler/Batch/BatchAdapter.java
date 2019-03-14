package com.example.koichung.ViewControler.Batch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.koichung.Model.Batch;
import com.example.koichung.R;

import java.util.ArrayList;

public class BatchAdapter extends BaseAdapter {

    Context context;
    ArrayList<Batch> arrData;

    @Override
    public int getCount() {
        return arrData.size();
    }

    public BatchAdapter(Context context, ArrayList<Batch> arrData) {
        this.context = context;
        this.arrData = arrData;
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
         Batch batch = arrData.get(position);

         if (convertView == null){
             convertView = LayoutInflater.from(context).inflate(R.layout.item_batch_layout,parent,false);
             viewHolder = new ViewHolder(convertView);
             convertView.setTag(viewHolder);
         }else {
             viewHolder = (ViewHolder) convertView.getTag();
         }
         viewHolder.setUpView(batch);
        return convertView;
    }

    class ViewHolder{
        TextView tvBatchId,tvCount,tvLastCount,tvRoot,tvDealer,tvBuyer,tvNote,tvPrivateNote,tvCreateDay;

        public ViewHolder(View view){
            tvBatchId = view.findViewById(R.id.tv_batch_id);
            tvCount = view.findViewById(R.id.tv_batch_count);
            tvLastCount = view.findViewById(R.id.tv_batch_last_count);
            tvRoot = view.findViewById(R.id.tv_batch_root);
            tvDealer = view.findViewById(R.id.tv_batch_dealer);
            tvBuyer = view.findViewById(R.id.tv_batch_buyer);
            tvNote = view.findViewById(R.id.tv_batch_note);
            tvPrivateNote = view.findViewById(R.id.tv_batch_private_note);
            tvCreateDay = view.findViewById(R.id.tv_batch_create_date);
        }

        public void setUpView(Batch batch){
            tvBatchId.setText(batch.getCode());
            tvCount.setText(batch.getCount()+"");
            tvLastCount.setText(batch.getLastCount()+"");
            tvRoot.setText(batch.getRoot());
            tvDealer.setText(batch.getDealer());
            tvBuyer.setText(batch.getBuyer());
            tvNote.setText(batch.getNote());
            tvPrivateNote.setText(batch.getPrivateNote());
            tvCreateDay.setText(batch.getCreateDate());
        }
    }
}
