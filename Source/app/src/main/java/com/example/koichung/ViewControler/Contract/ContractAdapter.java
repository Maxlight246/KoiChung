package com.example.koichung.ViewControler.Contract;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.koichung.Model.Contract;
import com.example.koichung.R;

import java.util.ArrayList;

public class ContractAdapter extends BaseAdapter {

    Context context;
    ArrayList<Contract> arrData;

    public ContractAdapter(Context context, ArrayList<Contract> arrData) {
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
          Contract contract = arrData.get(position);

          if (convertView == null){
              convertView = LayoutInflater.from(context).inflate(R.layout.item_contract_layout,parent,false);
              viewHolder = new ViewHolder(convertView);
              convertView.setTag(viewHolder);
          }else {
              viewHolder = (ViewHolder) convertView.getTag();
          }
           viewHolder.setupView(contract);
        return convertView;
    }

    class ViewHolder{
        TextView tvContractId,tvAgencyName,tvStatus,tvLastCount,tvPercentComit,tvFunds,tvDateFunds,tvDateComit,tvCreateDate;

        public ViewHolder (View view){
            tvContractId = view.findViewById(R.id.tv_contract_id);
            tvAgencyName = view.findViewById(R.id.tv_agency_name);
            tvStatus = view.findViewById(R.id.tv_status);
            tvLastCount = view.findViewById(R.id.tv_contract_last_count);
            tvPercentComit = view.findViewById(R.id.tv_pecent_commit);
            tvFunds = view.findViewById(R.id.tv_funds);
            tvDateFunds = view.findViewById(R.id.tv_date_funds);
            tvDateComit = view.findViewById(R.id.tv_date_comit);
            tvCreateDate = view.findViewById(R.id.tv_contract_create_date);
        }

        public void setupView(Contract contract){
            tvContractId.setText(contract.getCode());
            tvAgencyName.setText(contract.getAgencyName());
            tvLastCount.setText(contract.getQty()+"");
            tvPercentComit.setText(contract.getPecentcommit()+"% theo vốn lợi nhuận");
            tvFunds.setText(contract.getFunds()+" đ");
            tvDateFunds.setText(contract.getDateFunds());
            tvDateComit.setText(contract.getDateCommit());
            tvCreateDate.setText(contract.getCreateDate());
            tvPercentComit.setText(contract.getPecentcommit());
            switch (contract.getStatus()){
                case 0:
                    tvStatus.setText("Chờ duyệt");
                    break;
                case 1:
                    tvStatus.setText("Đang thực hiện");
                    break;
                case 2:
                    tvStatus.setText("Hoàn thành");
                    break;
                case 3:
                    tvStatus.setText("Quá hạn");
                    break;
            }
        }
    }
}
