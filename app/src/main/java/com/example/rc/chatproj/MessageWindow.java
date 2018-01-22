package com.example.rc.chatproj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;


public class MessageWindow extends AppCompatActivity {

    private EditText editMsg;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_window);
        editMsg = (EditText) findViewById(R.id.etMessageWindow);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            toolbar.setTitle(bundle.getString("UserName"));
        }
    }
}
