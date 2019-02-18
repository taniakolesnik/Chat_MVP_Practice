package com.example.chat_mvp_practice.presenter;

import com.example.chat_mvp_practice.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter {

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

    public void refreshRepositoriesList(MessagesRecyclerViewAdapter adapter){
        adapter.notifyDataSetChanged();
    }

    public interface MessageRowView {

        void setText(String text);

        void setTime(String time);

    }

}
