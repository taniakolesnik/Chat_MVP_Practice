package com.example.chat_mvp_practice.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chat_mvp_practice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageViewHolder extends RecyclerView.ViewHolder implements MainActivityPresenter.MessageRowView {

    @BindView(R.id.message_item_textView)
    TextView textTextView;

    @BindView(R.id.message_item_time_textView)
    TextView timeTextView;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void setText(String text) {
        textTextView.setText(text);
    }

    @Override
    public void setTime(String time) {
        timeTextView.setText(time);
    }


}
