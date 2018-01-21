package com.example.rc.chatproj;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rc on 2018-01-10.
 */

class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder>{
    ArrayList<String> chats;
    ArrayList<String> chatsMsg;

    public ChatsAdapter(ArrayList<String> chats, ArrayList<String> chatsMsg) {
        this.chats = chats;
        this.chatsMsg = chatsMsg;
    }


    @Override
    public ChatsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab2_chats_content, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ChatsAdapter.ViewHolder holder, int position) {
        holder.chatUsername.setText(chats.get(position));
        holder.chatContent.setText(chatsMsg.get(position));
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView chatUsername;
        public TextView chatContent;
        public ViewHolder(View itemView) {
            super(itemView);
            chatUsername= itemView.findViewById(R.id.tvMessageContactsName);
            chatContent= itemView.findViewById(R.id.tvMessageContent);
        }
    }
}


