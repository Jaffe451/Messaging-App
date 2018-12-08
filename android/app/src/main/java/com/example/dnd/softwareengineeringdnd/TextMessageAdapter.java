package com.example.dnd.softwareengineeringdnd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TextMessageAdapter extends RecyclerView.Adapter<TextMessageAdapter.TextMessageViewHolder> {



    class TextMessageViewHolder extends RecyclerView.ViewHolder {
        private final TextView TextMessageItemView;

        private TextMessageViewHolder(View itemView) {
            super(itemView);
            TextMessageItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<TextMessage> mTextMessage; // Cached copy of words

    TextMessageAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public TextMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new TextMessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TextMessageViewHolder holder, int position) {
        if (mTextMessage != null) {
            TextMessage current = mTextMessage.get(position);
            holder.TextMessageItemView.setText(current.getData());
        } else {
            // Covers the case of data not being ready yet.
            holder.TextMessageItemView.setText("No Word");
        }
    }

    void setWords(List<TextMessage> messages){
        mTextMessage = messages;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mTextMessage != null)
            return mTextMessage.size();
        else return 0;
    }

}
