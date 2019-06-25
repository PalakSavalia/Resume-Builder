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

public class Interests extends AppCompatActivity {

    SQLiteDatabase db;
    EditText int1,int2;
    Button insertInt;
    String interest = "";
    String interest1 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);
        Intent intent = getIntent();
        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        int1 = (EditText) findViewById(R.id.et1);
        int2 = (EditText) findViewById(R.id.et2);

        insertInt = (Button) findViewById(R.id.b1);

        insertInt.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            //Course VARCHAR,Institute VARCHAR,Score VARCHAR,Yop VARCHAR
            public void onClick(View view) {

                //Toast.makeText(Interests.this, int1.getText()+" ,"+int2.getText(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(Interests.this,PersonalInfo.Username.getText().toString(), Toast.LENGTH_LONG).show();
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET Interests ='"+ int1.getText()+" , "+int2.getText() +"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                    Toast.makeText(Interests.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Interests.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
