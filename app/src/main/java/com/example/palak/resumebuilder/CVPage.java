package com.example.palak.resumebuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CVPage extends AppCompatActivity {

    EditText name,add1,add2,add3;
    TextView letter;
    Button cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvpage);
        Intent intent = getIntent();

        name = (EditText) findViewById(R.id.et1);
        add1 = (EditText) findViewById(R.id.et1);
        add2 = (EditText) findViewById(R.id.et2);
        add3 = (EditText) findViewById(R.id.et3);
        cv = (Button) findViewById(R.id.b1);
        letter = (TextView) findViewById(R.id.tv6);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(CVPage.this, name.getText().toString()+add1.getText().toString()+add2.getText().toString()+add3.getText().toString(), Toast.LENGTH_SHORT).show();

                letter.setText("\n"+add1.getText().toString()+",\n"+add2.getText().toString()+",\n"+add3.getText().toString()+",\n"+"8169434245,\nme09@gmail.com.\n\nSUBJECT : Applying for Junior Engineer post.\n\n"+
                "Dear Sir/Madam,\n            I am writing this letter to you to apply for the position of (desired position) in your company (company name). I came across the position via (mention job portal source) and wanted to apply for the same.\n" +
                "            I have learned that I enjoy working in this field and that I can prove to be a valuable asset with my present skill set. I enjoy working with like-minded people, and I am a team player. The challenges that the (desired position) offers is big, and I am sure that with an expert team I can take these challenges head-on.\n" +
                "            Thank you for your time and for considering me as a candidate. I have mentioned my contact number and email id in my resume and will send a follow-up email next week if further information is required.\n\n" +
                "Yours sincerely,\n"+name.getText().toString()+"\n");


            }
        });
    }
}
