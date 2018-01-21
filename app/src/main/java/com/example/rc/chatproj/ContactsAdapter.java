package com.example.rc.chatproj;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rc on 2018-01-06.
 */

class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    ArrayList<String> users;

    public ContactsAdapter(ArrayList<String> users) {
        this.users = users;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_contacts_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
        holder.name.setText(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvContactsName);

        }
    }
}
