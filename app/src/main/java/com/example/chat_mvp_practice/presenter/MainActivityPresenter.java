package com.example.chat_mvp_practice.presenter;

import android.util.Log;

import com.example.chat_mvp_practice.Model.Message;

public class MainActivityPresenter {

    private static final String TAG = "debugging";

    private Message message;
    private View view;


    public MainActivityPresenter(View view) {
        message = new Message();
        this.view = view;
    }

    public void updateMessage(String text, String time){
        message.setText(text);
        message.setTime(time);
        view.updateMessagesList(message);
        Log.i(TAG, "updateMessage: " + text + ";time:" + time);
    }

    public interface View{

        void updateMessagesList(Message message);
    }
}
