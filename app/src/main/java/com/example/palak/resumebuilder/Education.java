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

public class Education extends AppCompatActivity {

    SQLiteDatabase db;
    EditText nameDegree,institute,score,yop;
    Button insertEdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        nameDegree = (EditText) findViewById(R.id.et1);
        institute = (EditText) findViewById(R.id.et2);
        score = (EditText) findViewById(R.id.et3);
        yop = (EditText) findViewById(R.id.et4);

        insertEdu = (Button) findViewById(R.id.b1);

        insertEdu.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            //Course VARCHAR,Institute VARCHAR,Score VARCHAR,Yop VARCHAR
            public void onClick(View view) {
                //Toast.makeText(Education.this,PersonalInfo.Username.getText().toString(), Toast.LENGTH_LONG).show();
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET Course ='"+ nameDegree.getText()+"', Institute='"+ institute.getText()+"', Score='"+ score.getText()+"',Yop='"+ yop.getText()+"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                    Toast.makeText(Education.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Education.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
