package com.nrk4220.android.smarthome;

import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ChatLuongNuoc extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    /*static {
        System.loadLibrary("native-lib");
    }*/
    private Bundle bundle;
    private static String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_display_screen);
        CustomFragmentPagerAdapter customFragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(), this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(customFragmentPagerAdapter);
        bundle = getIntent().getExtras();
        string = bundle.getString("keyData");
        /*Bundle bundle = new Bundle();
        bundle.putString("edttext", getIntent().getExtras(););
        DataViewFragment dataFragObj = new DataViewFragment();
        dataFragObj.setArguments(bundle);
        WebViewFragment webFragObj = new WebViewFragment();
        webFragObj.setArguments(bundle);*/
    }

    public static String getSwitchString (){
        return string;
    }
}
