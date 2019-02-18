package com.example.chat_mvp_practice.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chat_mvp_practice.R;

public class MessagesRecyclerViewAdater extends RecyclerView.Adapter<MessageViewHolder>{

    private MainActivityPresenter presenter;

    public MessagesRecyclerViewAdater(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.messages_list_item, viewGroup, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {
        presenter.onBindRowViewAtPosition(i, messageViewHolder);

    }

    @Override
    public int getItemCount() {
        return presenter.getRowsCount();
    }
}
