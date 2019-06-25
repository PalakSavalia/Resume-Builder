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
import android.widget.Toast;

public class Achievements extends AppCompatActivity {

    SQLiteDatabase db;
    EditText achievements,awards;
    Button insertAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        achievements = (EditText) findViewById(R.id.et1);
        awards= (EditText) findViewById(R.id.et2);

        insertAA = (Button) findViewById(R.id.b1);

        insertAA.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            //Course VARCHAR,Institute VARCHAR,Score VARCHAR,Yop VARCHAR
            public void onClick(View view) {

                //Toast.makeText(Achievements.this,PersonalInfo.Username.getText().toString(), Toast.LENGTH_LONG).show();
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET Achievement ='"+ achievements.getText()+"', Award='"+ awards.getText()+"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                    Toast.makeText(Achievements.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Achievements.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
