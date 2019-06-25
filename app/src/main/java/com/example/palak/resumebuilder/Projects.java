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

public class Projects extends AppCompatActivity {

    SQLiteDatabase db;
    EditText title,desc;
    Button insertProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Intent intent = getIntent();

        db = openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        title = (EditText) findViewById(R.id.et1);
        desc= (EditText) findViewById(R.id.et2);

        insertProject = (Button) findViewById(R.id.b1);

        insertProject.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            //Course VARCHAR,Institute VARCHAR,Score VARCHAR,Yop VARCHAR
            public void onClick(View view) {

                //Toast.makeText(Projects.this,PersonalInfo.Username.getText().toString(), Toast.LENGTH_LONG).show();
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET PrjctTitle ='"+ title.getText()+"', PrjctDes='"+ desc.getText()+"' WHERE Name ='"+PersonalInfo.Username.getText().toString()+"'");
                    Toast.makeText(Projects.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Projects.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
