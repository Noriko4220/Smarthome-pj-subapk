package com.nrk4220.android.smarthome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebViewFragment extends Fragment {

    final String iFrame = "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/820017/charts/1?bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&api_key=4FAWSN2R3CA5NQD3&title=%C4%90o+Ch%E1%BA%A5t+L%C6%B0%E1%BB%A3ng+N%C6%B0%E1%BB%9Bc&type=line\"></iframe>";
    final String iFrame2 = "<iframe width=\"450\" height=\"260\" style=\"border: 1px solid #cccccc;\" src=\"https://thingspeak.com/channels/820017/widgets/86458\"></iframe>";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_web_view, container, false);
        WebView webView = (WebView) rootView.findViewById(R.id.webView);
        WebView webView2 = (WebView) rootView.findViewById(R.id.webView2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(iFrame,"text/html",null);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadData(iFrame2,"text/html",null);
        return rootView;
    }
}
