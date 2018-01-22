package com.example.rc.chatproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserWindow extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_window);
        textView = (TextView)findViewById(R.id.tvUserWindowName);
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            textView.setText(bundle.getString("UserName"));
        }
    }
}
