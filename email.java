package com.example.user.depressiontest.Test.eng;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.depressiontest.MainActivity;
import com.example.user.depressiontest.R;

public class email extends AppCompatActivity {
    private TextView TextTo;
    private TextView TextSubject;
    private TextView TextMessage;
    private TextView TextMessage2;
    private Bundle savedInstanceState;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail);

        TextTo = findViewById(R.id.edit_text);
        TextSubject = findViewById(R.id.edit_subject);
        TextMessage = findViewById(R.id.edit_message);
        TextMessage2 = findViewById(R.id.edit_message2);

        Button buttonSend = findViewById(R.id.send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMail();
            }
        });
    }

    private void getMail() {
        String recipientList = TextTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = TextSubject.getText().toString();
        String message = TextMessage.getText().toString();
        String message2 =TextMessage2.toString();

        Intent intent = new Intent(Intent.ACTION_SEND);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                subject= null;
                message=null;
                message2=null;
            } else {
                subject= extras.getString("Score is needed");
                message= extras.getString("Description is needed");
                message2= extras.getString("Description needed");
            }
        } else {
            subject= (String) savedInstanceState.getSerializable("Score is needed");
            message= (String) savedInstanceState.getSerializable("Description is needed");
            message2= (String) savedInstanceState.getSerializable("Description needed");
        }

//        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intent.putExtra(Intent.EXTRA_TEXT, message);

//        intent.setType("message/rfc822");
//        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}
