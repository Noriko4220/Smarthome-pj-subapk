package com.nrk4220.android.smarthome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataViewAdapter extends ArrayAdapter<JSONDataHolder> {

    public DataViewAdapter(Context context, ArrayList<JSONDataHolder> JSONDataHolder){
        super(context,0,JSONDataHolder);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View parentView = convertView;
        if(parentView == null){
            parentView = LayoutInflater.from(getContext()).inflate(R.layout.activity_data_view_adapter, parent, false);
        }

        JSONDataHolder jsonDataHolder = getItem(position);

        TextView timeStamp = (TextView) parentView.findViewById(R.id.dataHolderTimestsamp);
        TextView data = (TextView) parentView.findViewById(R.id.dataHolderData);
        TextView dataPosition = (TextView) parentView.findViewById(R.id.dataHolderNamespace);

        timeStamp.setText(jsonDataHolder.getJSONTimeStamp());
        data.setText(jsonDataHolder.getJSONDataString());
        dataPosition.setText(jsonDataHolder.getJSONDataPosition());
        return parentView;
    }
}
