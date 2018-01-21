package com.example.rc.chatproj;

/**
 * Created by rc on 2018-01-03.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Tab2Chats extends Fragment {

    ArrayList<String> chats;
    ArrayList<String> chatsMsg;
    public Tab2Chats(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab2chats_main, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.chatsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       /* LinearLayout msgLayout = (LinearLayout) rootView.findViewById(R.id.receivedMessageLayout);
        msgLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent msgIntent = new Intent (getActivity(), MessageWindow.class);
                startActivity(msgIntent);
            }
        });*/

        chats = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            chats.add("User #" + i);
        }

        chatsMsg = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            chatsMsg.add("Wiadomość przykładowa o numerze " + i);
        }

        ChatsAdapter adapter = new ChatsAdapter(chats, chatsMsg);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }


}