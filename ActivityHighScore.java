package com.example.user.depressiontest.Test.eng;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.depressiontest.R;
import com.example.user.depressiontest.forgotPassword;
import com.example.user.depressiontest.login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ActivityHighScore extends AppCompatActivity {

    private TextView toSend;

//    private EditText passwordEmail;
//    private Button rPassword;
TextView txtScore = (TextView) findViewById(R.id.textScore);
    TextView txtV = (TextView) findViewById(R.id.textView);
    TextView txt = (TextView) findViewById(R.id.textView2);

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highest_activity_eng);

        toSend = findViewById(R.id.email);


        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        if (score <= 5) {
            txtScore.setText("SCORE: " + score);
            txtV.setText("NORMAL");
            txt.setText("Your result indicate that you have none or very few symptoms of depression.If you notice that your" +
                    " symptoms aren't improving,you may want to bring them up with mental health professional or someone who is supporting you.");
        } else if (score <= 7) {
            txtScore.setText("SCORE: " + score);
            txtV.setText("MILD");
            txt.setText("Your result indicate that you may be experiencing some symptoms of mild depression.While your symptoms" +
                    " are not likely having a major impact on your life,it is important to monitor them.These result does not mean " +
                    " that you have depression,but it may be time to start a conversation with mental health professional");
        } else if (score <= 10) {
            txtScore.setText("SCORE: " + score);
            txtV.setText("MODERATE");
            txt.setText("Your result indicate that you may be experiencing moderate depression.Based on your answers,living with these" +
                    " symptoms could be causing difficulty managing emotion and even the task of everyday life.These result do not mean" +
                    " that you have depression,but it may be time to start a conversation with mental health professional");
        } else if (score <= 14) {
            txtScore.setText("SCORE: " + score);
            txtV.setText("SEVERE");
            txt.setText("Your result indicate that you may be experiencing moderate severe depression.Based on your answers,living with these" +
                    " symptoms could be causing difficulty managing emotion and even the task of everyday life" +
                    " This result does not mean you have depression,but we have really recomended " +
                    " you to start a conversation with a mental health professional");
        } else if (score >= 15) {
            txtScore.setText("SCORE: " + score);
            txtV.setText("EXTREMELY SEVERE");
            txt.setText("Your results indicate that you may be experiencing symptoms of extremely severe depression.Based on your answer,these symptoms" +
                    " seems to be greatly interfering with your emotion and tasks of everyday life.These results do not mean that you have depression," +
                    " but we really recomended you to start a conversation with mental health professional");

//            Intent i = new Intent(ActivityHighScore.this, MusicActivity.class);
//            startActivity(i);
        }

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);

        Button buttonSend = findViewById(R.id.button);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }

    private void sendMail() {

        Intent i = new Intent(ActivityHighScore.this, email.class);

        String subject = txtScore.getText().toString();
        String message = txtV.getText().toString();
        String message2 = txt.getText().toString();

        String recipientList = toSend.getText().toString();
        String[] recipients = recipientList.split(",");

        i.putExtra("Subject:", subject);
        i.putExtra("Depression Condition:", message);
        i.putExtra("Description:", message2);

//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
//        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//        intent.putExtra(Intent.EXTRA_TEXT, message);
//        intent.putExtra(Intent.EXTRA_TEXT, message2);

//        intent.setType("message/rfc822");
//        intent.setType("message2/rfc822");
//        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }
}

//rPassword.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String email = passwordEmail.getText().toString().trim();
//
//                    if(email.equals("")){
//                        Toast.makeText(ActivityHighScore.this, "Please enter your email ", Toast.LENGTH_SHORT).show();
//                    }else{
//                        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if(task.isSuccessful()){
//                                    Toast.makeText(ActivityHighScore.this, "email sent!", Toast.LENGTH_SHORT).show();
//                                    finish();
//                                    startActivity(new Intent(ActivityHighScore.this, login.class));
//                                }else{
//                                    Toast.makeText(ActivityHighScore.this, "Error in sending email", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                    }
//                }
//            });

//        }



