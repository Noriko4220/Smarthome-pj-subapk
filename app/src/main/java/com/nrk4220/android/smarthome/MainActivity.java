package com.nrk4220.android.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button chatLuongNuocButton = (Button) findViewById(R.id.chatLuongNuocButton);
        chatLuongNuocButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatLuongNuoc.class);
                intent.putExtra("keyData", "ChatLuongNuoc");
                startActivity(intent);
            }
        });

        Button matDoBuiButton = (Button) findViewById(R.id.matDoBuiButton);
        matDoBuiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatLuongNuoc.class);
                intent.putExtra("keyData", "MatDoBui");
                startActivity(intent);
            }
        });
    }
}
