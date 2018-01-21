package com.example.rc.chatproj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;


public class MessageWindow extends AppCompatActivity {

    private EditText editMsg;
    private RecyclerView MessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_window);

        editMsg = (EditText) findViewById(R.id.etMessageWindow);


    }

}
