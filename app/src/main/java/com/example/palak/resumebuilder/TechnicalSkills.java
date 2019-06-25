package com.example.palak.resumebuilder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class TechnicalSkills extends AppCompatActivity {

    SQLiteDatabase db;
    TextView tv3, tv4, tv5, tv6, tv7, tv8, tv9,tv10;
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    String techSkills = "";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical_skills);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv3 = (TextView) findViewById(R.id.tv3);
                techSkills = techSkills + "Programming Languages, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv4 = (TextView) findViewById(R.id.tv4);
                techSkills = techSkills + "Software Proficiency, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv5 = (TextView) findViewById(R.id.tv5);
                techSkills = techSkills + "Common OS, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b4 = (Button) findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv6 = (TextView) findViewById(R.id.tv6);
                techSkills = techSkills + "Data Analysis, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b5 = (Button) findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv7 = (TextView) findViewById(R.id.tv7);
                techSkills = techSkills + "Analytical Skills, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b6 = (Button) findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv8 = (TextView) findViewById(R.id.tv8);
                techSkills = techSkills + "Project Management, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();

            }
        });

        b7 = (Button) findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv9 = (TextView) findViewById(R.id.tv9);
                techSkills = techSkills + "Technical Writing, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

        b8 = (Button) findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                tv10 = (TextView) findViewById(R.id.tv10);
                techSkills = techSkills + "Social Media Experience, ";
                Toast.makeText(TechnicalSkills.this,"Selected skill added succesfully!",Toast.LENGTH_SHORT).show();
                count++;
                insertSkills();
            }
        });

    }

    public void insertSkills() {

        if(count == 4) {
            Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE PersonalDet7 SET TechSkills ='"+ techSkills +"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                Toast.makeText(TechnicalSkills.this, "Your skill set is saved successfully!", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(TechnicalSkills.this, "You can add only 4 skills! Please try again incase you want to change your skill set!", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(TechnicalSkills.this, "Selected skill added succesfully!", Toast.LENGTH_LONG).show();
        }

        if(count > 4) {
            Toast.makeText(TechnicalSkills.this, "You can add only 4 skills! Please try again incase you want to change your skill set!", Toast.LENGTH_LONG).show();
        }

    }
}
