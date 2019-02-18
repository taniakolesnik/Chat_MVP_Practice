package com.example.chat_mvp_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chat_mvp_practice.Model.Message;
import com.example.chat_mvp_practice.presenter.MainActivityPresenter;
import com.example.chat_mvp_practice.presenter.MessagesRecyclerViewAdater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "debugging";


    @BindView(R.id.messages_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.message_edit_text)
    EditText editText;

    @BindView(R.id.send_button)
    Button button;

    private MainActivityPresenter presenter;
    private MessagesRecyclerViewAdater adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainActivityPresenter();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                presenter.addMessage(text, String.valueOf(System.currentTimeMillis()));
                presenter.refreshRepositoriesList(adapter);

            }
        });

        adapter = new MessagesRecyclerViewAdater(presenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}
