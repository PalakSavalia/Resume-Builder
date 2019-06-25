package com.example.palak.resumebuilder;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CreateResumePage extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_resume_page);
        Intent intent = getIntent();

        Button button1 = (Button) findViewById(R.id.b1);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), PersonalInfo.class);
                startActivity(intent);


            }
        });

        Button button2 = (Button) findViewById(R.id.b2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), Education.class);
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.b3);

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), TechnicalSkills.class);
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.b4);

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), Interests.class);
                startActivity(intent);
            }
        });

        Button button5 = (Button) findViewById(R.id.b5);

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), Projects.class);
                startActivity(intent);
            }
        });

        Button button6 = (Button) findViewById(R.id.b6);

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), Achievements.class);
                startActivity(intent);
            }
        });

        Button button7 = (Button) findViewById(R.id.b7);

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), Objective.class);
                startActivity(intent);
            }
        });


        Button button8 = (Button) findViewById(R.id.b8);

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), References.class);
                startActivity(intent);
            }
        });

        Button button9 = (Button) findViewById(R.id.b9);

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                //Create the intent to start another activity
                Intent intent = new Intent(view.getContext(), GenerateResumePage.class);
                startActivity(intent);
            }
        });


    }


}
