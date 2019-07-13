package com.nrk4220.android.smarthome;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ServiceCallHandler {

    public ServiceCallHandler() {
    }

    public String htmlCallForData(String reqUrl) {
        String JSONDataInString = null;

        try {

            URL url = new URL(reqUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            JSONDataInString = bufferedReader(inputStream);

        } catch (MalformedURLException e) {
            Log.e("DEBUG", "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e("DEBUG", "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e("DEBUG", "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e("DEBUG", "Exception: " + e.getMessage());
        }

        return JSONDataInString;
    }

    private String bufferedReader(InputStream is) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }
}
