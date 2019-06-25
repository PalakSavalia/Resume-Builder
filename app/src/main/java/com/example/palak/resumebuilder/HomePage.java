package com.example.palak.resumebuilder;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private float x = 0;
    private float y = 0;
    private Button button5 = null;
    private TextView tv1 = null;

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RelativeLayout r1 = findViewById(R.id.r1);
        tv1 = findViewById(R.id.tv1);
        button5 = (Button) findViewById(R.id.b5);


        Button button1 = (Button) findViewById(R.id.b1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), CreateResumePage.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.b2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), CVPage.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.b3);

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), DownloadPage.class);
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.b4);

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), InterviewPage.class);
                startActivity(intent);
            }
        });



        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), RateUsPage.class);
                startActivity(intent);
            }
        });

        Button button6 = (Button) findViewById(R.id.b6);

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/plain");
               String sharebody = "Hey, I have used this ResumeBuilder App! It has 50+ resume templates, divided sections to fill in your details.. You can build your resume in just 5 mins!!\n\n https://app/resumebuilder";
               String sharesub = "Share ResumeBuilder";
               intent.putExtra(Intent.EXTRA_SUBJECT,sharesub);
               intent.putExtra(Intent.EXTRA_TEXT,sharebody);
               startActivity(Intent.createChooser(intent,"Share Using.."));

            }
        });

        r1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                x = event.getX();
                y = event.getY();

                if(event.getAction()== MotionEvent.ACTION_MOVE) {
                    tv1.setX(x);
                    tv1.setY(y);
                }
                //Toast.makeText(RateUsPage.this,"Enter your full name (OnFocusListener)",Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    }

    /*public void openInterviewPage(View view) {
        // Do something in response to button
        Intent intent;
        intent = new Intent(this, InterviewPage.class);
        startActivity(intent);
    }*/


}
