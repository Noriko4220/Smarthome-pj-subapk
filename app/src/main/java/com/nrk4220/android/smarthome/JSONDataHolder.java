package com.nrk4220.android.smarthome;

public class JSONDataHolder {

    private String data;
    private String timeStamp;
    private String position;

    public JSONDataHolder(){}

    public JSONDataHolder(String timestamp, String datastring, String positionstring){
        timeStamp = timestamp;
        data = datastring;
        position = positionstring;
    }

    public String getJSONDataString(){
        return data;
    }

    public String getJSONTimeStamp(){
        return timeStamp;
    }

    public String getJSONDataPosition(){
        return position;
    }
}
