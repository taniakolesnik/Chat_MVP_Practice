package com.example.chat_mvp_practice.presenter;

import android.provider.MediaStore;
import android.util.Log;

import com.example.chat_mvp_practice.Model.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter {

    private static final String TAG = "debugging";

    private List<Message> messageList;

    public MainActivityPresenter() {
        messageList = new ArrayList<>();
    }

    public void onBindRowViewAtPosition(int position, MessageRowView view){
        Message message = messageList.get(position);
        view.setText(message.getText());
        view.setTime(message.getTime());
}

    public int getRowsCount() {
        return messageList.size();
    }

    public void addMessage(String text, String time){
        Message message = new Message();
        message.setText(text);
        message.setTime(time);
        messageList.add(message);
    }

    public void refreshRepositoriesList(MessagesRecyclerViewAdater adapter){
        adapter.notifyDataSetChanged();
    }

    public interface MessageRowView {

        void setText(String text);

        void setTime(String time);

    }

}
