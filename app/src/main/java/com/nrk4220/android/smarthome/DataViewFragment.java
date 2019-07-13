package com.nrk4220.android.smarthome;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DataViewFragment extends Fragment {

    private ArrayList<JSONDataHolder> JSONArrayDataHolder = new ArrayList<JSONDataHolder>();
    private ListView listData;
    private DataViewAdapter dataViewAdapter;
    private View rootView;
    private String url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_data_view, container, false);
        //ChatLuongNuoc mainDisplayClass = new ChatLuongNuoc();
        String string = ChatLuongNuoc.getSwitchString();
        Log.e(string,string);
        if(string.equalsIgnoreCase("ChatLuongNuoc")) {
            url = "https://api.thingspeak.com/channels/820017/fields/1.json?api_key=4FAWSN2R3CA5NQD3&results=10";
        } else {
            url = "https://api.thingspeak.com/channels/821958/fields/1.json?api_key=NB1G7SBA8CSPMXH3&results=10";
        }
        /*Thread refreshThread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(180000);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        refreshThread.start();*/
        new JSONParser(getActivity()).execute();
        return rootView;
    }

    private class JSONParser extends AsyncTask{

        public JSONParser (Activity context) {

        }

        @Override
        protected Object doInBackground(Object[] objects) {
            ServiceCallHandler serviceCallHandler = new ServiceCallHandler();
            String JSONstring = serviceCallHandler.htmlCallForData(url); //"{\"channel\":{\"id\":820017,\"name\":\"DO CHAT LUONG NUOC\",\"description\":\"Do tong chat ran hoa tan, TDS\",\"latitude\":\"0.0\",\"longitude\":\"0.0\",\"field1\":\"Do TDS cho nuoc\",\"field2\":\"Dien ap cam bien\",\"created_at\":\"2019-07-10T09:29:05Z\",\"updated_at\":\"2019-07-13T05:44:32Z\",\"last_entry_id\":18},\"feeds\":[{\"created_at\":\"2019-07-13T03:17:01Z\",\"entry_id\":9,\"field1\":\"\"},{\"created_at\":\"2019-07-13T03:17:34Z\",\"entry_id\":10,\"field1\":\"\"},{\"created_at\":\"2019-07-13T03:17:55Z\",\"entry_id\":11,\"field1\":\"\"},{\"created_at\":\"2019-07-13T03:21:36Z\",\"entry_id\":12,\"field1\":\"\"},{\"created_at\":\"2019-07-13T03:22:08Z\",\"entry_id\":13,\"field1\":\"17\"},{\"created_at\":\"2019-07-13T03:22:26Z\",\"entry_id\":14,\"field1\":\"176\"},{\"created_at\":\"2019-07-13T03:22:42Z\",\"entry_id\":15,\"field1\":\"184\"},{\"created_at\":\"2019-07-13T03:22:59Z\",\"entry_id\":16,\"field1\":\"143\"},{\"created_at\":\"2019-07-13T03:23:16Z\",\"entry_id\":17,\"field1\":\"137\"},{\"created_at\":\"2019-07-13T03:23:33Z\",\"entry_id\":18,\"field1\":\"142\"}]}";
            if (JSONstring != null) {
                try {
                    JSONObject jsonObj = new JSONObject(JSONstring);
                    // Getting JSON Array node
                    JSONArray feeds = jsonObj.getJSONArray("feeds");

                    // looping through All Contacts
                    for (int i = 0; i < feeds.length(); i++) {
                        JSONObject c = feeds.getJSONObject(i);
                        String position = c.getString("entry_id");
                        String entryData = c.getString("field1");
                        String timeStamp = c.getString("created_at");
                        String[] seperation = timeStamp.split("T");
                        JSONArrayDataHolder.add(new JSONDataHolder(seperation[0],entryData,position));
                    }
                } catch (final JSONException e) {
                    Log.e("Error","Json Parsing Error");
                }

            } else {
                Log.e("Error","Couldn't Connect to server");
            }
            return JSONArrayDataHolder;
        }

        @Override
        protected void onPostExecute(Object o) {
            listData = (ListView) rootView.findViewById(R.id.list);
            dataViewAdapter = new DataViewAdapter(getActivity(), JSONArrayDataHolder);
            listData.setAdapter(dataViewAdapter);
            super.onPostExecute(o);
        }
    }
}
