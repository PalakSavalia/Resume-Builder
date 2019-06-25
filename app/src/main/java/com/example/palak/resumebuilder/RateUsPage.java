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
import android.widget.RatingBar;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class RateUsPage extends AppCompatActivity {


    Button b1,b2;
    RatingBar ratingBar;
    Float dispRating;
    SQLiteDatabase db;

    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us_page);
        Intent intent = getIntent();

        db=openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS UserReview(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserName VARCHAR,EmailId VARCHAR,Reviews VARCHAR, Stars VARCHAR);");

       final EditText et1 = (EditText)findViewById(R.id.et1);
       et1.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view,boolean b)
            {
                    //Toast.makeText(RateUsPage.this,"Enter your full name (OnFocusListener)",Toast.LENGTH_LONG).show();
                    et1.setBackgroundResource(R.color.holo_red_light);
                    //et1.setShowSoftInputOnFocus(false);
            }
        });

        final EditText et2 = (EditText) findViewById(R.id.et2);
        et2.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view,boolean b)
            {
                //Toast.makeText(RateUsPage.this,"Enter your full name (OnFocusListener)",Toast.LENGTH_LONG).show();
                et2.setBackgroundResource(R.color.holo_red_light);
                //et1.setShowSoftInputOnFocus(false);
            }
        });


        final EditText et3 = (EditText) findViewById(R.id.et3);
        et3.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view,boolean b)
            {
                //Toast.makeText(RateUsPage.this,"Enter your full name (OnFocusListener)",Toast.LENGTH_LONG).show();
                et3.setBackgroundResource(R.color.holo_red_light);
                //et1.setShowSoftInputOnFocus(false);
            }
        });

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
              ratingBar = (RatingBar) findViewById(R.id.rb1);
              dispRating = ratingBar.getRating();
                //Toast.makeText(RateUsPage.this, dispRating.toString(), Toast.LENGTH_SHORT).show();

                //Toast.makeText(RateUsPage.this,name.toString(), Toast.LENGTH_LONG).show();
                if (et1.getText().toString().trim().length() == 0 || et2.getText().toString().trim().length() == 0 || et3.getText().toString().trim().length() == 0) {
                    Toast.makeText(RateUsPage.this, "Please fill in all the details", Toast.LENGTH_LONG).show();
                    return;
                }
                db.execSQL("INSERT INTO UserReview(UserName,EmailId,Reviews,Stars)VALUES('" + et1.getText() + "','" + et2.getText() + "','" + et3.getText() + "','" + dispRating.toString() + "');");
                Toast.makeText(RateUsPage.this, "Thanks "+et1.getText()+" for grading us "+dispRating.toString()+"/5 !!", Toast.LENGTH_LONG).show();

                String Email = et2.getText().toString().trim();
                String emailSubject = "Resume Builder";
                String emailBody = "Dear "+et1.getText().toString().trim()+",\n\n"+"             Thank you for using our app 'Resume Builder' and giving us your valuable feedback! Hope you enjoyed using our app and it was helpful for you to build your resume & prepare for your interviews!!\n\nGood Luck for your future endeavours:)\n\n\nRegards,\nTeam Resume Builder";
                SendMail sm = new SendMail(RateUsPage.this,Email,emailSubject,emailBody);
                sm.execute();

                /*Cursor c1=db.rawQuery("SELECT * FROM UserReview", null);
                if(c1.getCount()==0)
                {
                    Toast.makeText(RateUsPage.this, "No records", Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(c1.moveToNext())
                {
                    buffer.append(c1.getString(1)+"\n"+c1.getString(2)+"\n"+c1.getString(3)+"\n"+c1.getString(4)+"\n\n");
                    //String fromEmail = c1.getString(1);

                }
                Toast.makeText(RateUsPage.this,buffer.toString(), Toast.LENGTH_LONG).show();*/

            }
        });
    }
}

