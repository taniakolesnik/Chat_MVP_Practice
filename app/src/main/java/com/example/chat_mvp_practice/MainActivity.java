package com.example.chat_mvp_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chat_mvp_practice.presenter.MainActivityPresenter;
import com.example.chat_mvp_practice.presenter.MessagesRecyclerViewAdapter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
    private MessagesRecyclerViewAdapter adapter;

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
                if (text.isEmpty()){
                    editText.setError(getString(R.string.edit_text_error));
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:MM:SS", Locale.UK);
                    LocalDateTime now = LocalDateTime.now();
                    String time = formatter.format(now);

                    presenter.addMessage(text, time);
                    presenter.refreshRepositoriesList(adapter);
                    editText.getText().clear();
                }

            }
        });

        adapter = new MessagesRecyclerViewAdapter(presenter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

}
