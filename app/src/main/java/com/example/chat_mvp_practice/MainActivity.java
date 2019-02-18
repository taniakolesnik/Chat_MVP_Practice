package com.example.chat_mvp_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chat_mvp_practice.Model.Message;
import com.example.chat_mvp_practice.presenter.MainActivityPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    private static final String TAG = "debugging";

    @BindView(R.id.messages_recycler_view)
    TextView recyclerView;

    @BindView(R.id.message_edit_text)
    EditText editText;

    @BindView(R.id.send_button)
    Button button;

    private MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainActivityPresenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                Log.i(TAG, "onClick: text is " + text);
                presenter.updateMessage(text, String.valueOf(System.currentTimeMillis()));
            }
        });
    }

    @Override
    public void updateMessagesList(Message message) {
        recyclerView.setText(message.getText() + message.getTime());
        Log.i(TAG, "updateMessagesList: " + message.getText() + message.getTime());
    }
}
