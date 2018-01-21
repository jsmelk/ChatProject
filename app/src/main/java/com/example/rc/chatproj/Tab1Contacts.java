package com.example.rc.chatproj;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by rc on 2018-01-06.
 */

public class Tab1Contacts extends Fragment {

    ArrayList<String> users;
    public Tab1Contacts(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_tab1contacts_main, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.contactsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add("User #" + i);
        }

        ContactsAdapter adapter = new ContactsAdapter(users);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
        }
}
