package com.example.palak.resumebuilder;

import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Objective extends AppCompatActivity implements View.OnClickListener{

    SQLiteDatabase db;
    EditText name,add,mail,phone,dob;
    Button insert,view;
    TextView tv3 ;
    TextView tv4 ;
    TextView tv5;
    TextView tv6;
    CharSequence myObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objective);
        Intent intent = getIntent();

        db=openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);

        insert = (Button) findViewById(R.id.b1);
       //view = (Button) findViewById(R.id.b2);

        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        insert.setOnClickListener(this);
        //view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.tv3:
                tv3.setVisibility(View.GONE);
                tv4.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.GONE);
                tv6.setVisibility(View.GONE);
                myObj = tv4.getText();
                break;

            case R.id.tv4:
                tv5.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.GONE);
                tv3.setVisibility(View.GONE);
                tv6.setVisibility(View.GONE);
                myObj = tv5.getText();
                break;

            case R.id.tv5:
                tv6.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
                tv5.setVisibility(View.GONE);
                myObj = tv6.getText();
                break;

            case R.id.tv6:
                tv3.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.GONE);
                tv4.setVisibility(View.GONE);
                tv6.setVisibility(View.GONE);
                myObj = tv3.getText();
                break;

            case R.id.b1:
                //Toast.makeText(Objective.this,PersonalInfo.Username.getText().toString(), Toast.LENGTH_LONG).show();
                Cursor c=db.rawQuery("SELECT * FROM PersonalDet7 WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE PersonalDet7 SET Obj ='"+ myObj.toString()+"' WHERE Name ='"+ PersonalInfo.Username.getText().toString() +"'");
                    Toast.makeText(Objective.this, "Data saved sucessfully!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Objective.this, "Data not saved!", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.b2:
                //VIEW ALL
                /*Cursor c1=db.rawQuery("SELECT * FROM PersonalDet7", null);
                if(c1.getCount()==0)
                {
                    Toast.makeText(Objective.this, "No data found!", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(c1.moveToNext())
                {
                    buffer.append(c1.getString(1)+"\n"+c1.getString(2)+"\n"+c1.getString(3)+"\n"+c1.getString(4)+"\n"+c1.getString(5)+"\n"+c1.getString(6)+"\n"+c1.getString(7)+"\n"+c1.getString(8)+"\n"+c1.getString(9)+"\n"+c1.getString(10)+"\n"+c1.getString(11)+"\n"+c1.getString(12)+"\n"+c1.getString(13)+"\n"+c1.getString(14)+"\n"+c1.getString(15)+"\n"+c1.getString(16)+"\n"+c1.getString(17)+"\n"+c1.getString(18)+"\n"+c1.getString(19)+"\n\n");

                }
                Toast.makeText(Objective.this,buffer.toString(), Toast.LENGTH_LONG).show();*/

                //DELETE ALL
                /*Cursor c1=db.rawQuery("SELECT * FROM PersonalDet7 ", null);
                if(c1.moveToFirst())
                {
                    db.execSQL("DELETE FROM PersonalDet7");
                    Toast.makeText(Objective.this,"Deleted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Objective.this,"Nai hoga bantai", Toast.LENGTH_LONG).show();
                }*/

                break;
        }
    }

}





