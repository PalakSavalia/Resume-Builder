package com.example.palak.resumebuilder;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class GenerateResumePage extends AppCompatActivity {

    SQLiteDatabase db;

    TextView fullName, add, email, phone, dob ;
    String strfullName, stradd, stremail, strphone, strdob ;

    TextView course, institute, score, yop ;
    String strcourse, strinstitute, strscore, stryop ;

    TextView obj,skills;
    String strobj, strskills;

    TextView prjctName, prjctDes;
    String strprjctName, strprjctDes;

    TextView achi, awards;
    String strachi, strawards;

    TextView ints;
    String strints;

    TextView refName, refOrg, refCont;
    String strrefName, strrefOrg, strrefCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_resume_page);
        Intent intent = getIntent();

        db=openOrCreateDatabase("ResumeDB", Context.MODE_PRIVATE, null);

        fullName = (TextView) findViewById(R.id.fullName);
        add = (TextView) findViewById(R.id.add);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        dob = (TextView) findViewById(R.id.dob);

        course = (TextView) findViewById(R.id.course);
        institute = (TextView) findViewById(R.id.institute);
        score = (TextView) findViewById(R.id.score);
        yop = (TextView) findViewById(R.id.yop);

        obj = (TextView) findViewById(R.id.obj);
        skills = (TextView) findViewById(R.id.skills);

        prjctName = (TextView) findViewById(R.id.prjctName);
        prjctDes = (TextView) findViewById(R.id.prjctDescp);

        achi = (TextView) findViewById(R.id.achi);
        awards = (TextView) findViewById(R.id.awards);

        ints = (TextView) findViewById(R.id.ints);

        refName = (TextView) findViewById(R.id.refName);
        refOrg = (TextView) findViewById(R.id.refOrg);
        refCont = (TextView) findViewById(R.id.refCont);

        Cursor c1=db.rawQuery("SELECT * FROM PersonalDet7", null);
        if(c1.getCount()==0)
        {
            Toast.makeText(GenerateResumePage.this, "No records", Toast.LENGTH_LONG).show();
            return;
        }
        StringBuffer buffer=new StringBuffer();
        while(c1.moveToNext())
        {
            //buffer.append(c1.getString(1)+"\n"+c1.getString(2)+"\n"+c1.getString(3)+"\n"+c1.getString(4)+"\n"+c1.getString(5)+"\n"+c1.getString(6)+"\n"+c1.getString(7)+"\n"+c1.getString(8)+"\n"+c1.getString(9)+"\n"+c1.getString(10)+"\n"+c1.getString(11)+"\n"+c1.getString(12)+"\n"+c1.getString(13)+"\n"+c1.getString(14)+"\n"+c1.getString(15)+"\n"+c1.getString(16)+"\n"+c1.getString(17)+"\n"+c1.getString(18)+"\n"+c1.getString(19)+"\n\n");
            strfullName = c1.getString(1);
            stradd = c1.getString(2);
            stremail = c1.getString(3);
            strphone = c1.getString(4);
            strdob = c1.getString(5);
            strobj = c1.getString(6);
            strskills = c1.getString(7);
            strcourse = c1.getString(8);
            strinstitute = c1.getString(9);
            strscore = c1.getString(10);
            stryop = c1.getString(11);
            strints = c1.getString(12);
            strprjctName = c1.getString(13);
            strprjctDes = c1.getString(14);
            strachi = c1.getString(15);
            strawards = c1.getString(16);
            strrefName = c1.getString(17);
            strrefOrg = c1.getString(18);
            strrefCont = c1.getString(19);
        }
        //Toast.makeText(Objective.this,buffer.toString(), Toast.LENGTH_LONG).show();
        fullName.setText(fullName.getText().toString()+" "+strfullName);
        add.setText(add.getText().toString()+" "+stradd);
        email.setText(email.getText().toString()+" "+stremail);
        phone.setText(phone.getText().toString()+" "+strphone);
        dob.setText(dob.getText().toString()+" "+strdob);

        course.setText(course.getText().toString()+" "+strcourse);
        institute.setText(institute.getText().toString()+" "+strinstitute);
        score.setText(score.getText().toString()+" "+strscore);
        yop.setText(yop.getText().toString()+" "+stryop);

        obj.setText(obj.getText().toString()+" "+strobj);
        skills.setText(skills.getText().toString()+" "+strskills);

        prjctName.setText(prjctName.getText().toString()+" "+strprjctDes);
        prjctDes.setText(prjctDes.getText().toString()+" "+strprjctDes);

        achi.setText(achi.getText().toString()+" "+strachi);
        awards.setText(awards.getText().toString()+" "+strawards);

        ints.setText(ints.getText().toString()+" "+strints);

        refName.setText(refName.getText().toString()+" "+strrefName);
        refOrg.setText(refOrg.getText().toString()+" "+strrefOrg);
        refCont.setText(refCont.getText().toString()+" "+strrefCont);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                //Toast.makeText(this, "You have selected SaveAsPDF Option", Toast.LENGTH_SHORT).show();
                savePdf();
                return true;
            case R.id.print:
                //Toast.makeText(this, "You have selected Print Option", Toast.LENGTH_SHORT).show();

                File file = new File(Environment.getExternalStorageDirectory()+ "/" + strfullName+ "_Resume_RB.pdf");
                if (file.exists()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    Uri uri = FileProvider.getUriForFile(GenerateResumePage.this, GenerateResumePage.this.getPackageName() + ".provider", file);
                    intent.setDataAndType(uri, "application/pdf");
                    intent.putExtra(Intent.EXTRA_STREAM, uri);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    //Toast.makeText(GenerateResumePage.this, "Intent starting", Toast.LENGTH_LONG).show();
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(GenerateResumePage.this, "Save the resume as PDF first, then try sharing the file!", Toast.LENGTH_LONG).show();
                    }

                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void savePdf() {
        Document document = new Document();
        //String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
        String filePath = Environment.getExternalStorageDirectory() + "/" + strfullName+ "_Resume_RB.pdf";
        try {
            PdfWriter.getInstance(document,new FileOutputStream((filePath)));
            document.open();
            String text = "********************************* RESUME FOR JOB APPLICATION *********************************\n\n----- PERSONAL DETAILS -----\nName : "+strfullName + "\nResidential Address : "+stradd+ "\nEmailID : "+stremail+"\nContact No. : "+strphone+"\nDate Of Birth : "+strdob
                    + "\n\n----- EDUCATION -----\nCourse : "+strcourse+"\nInstitute : "+strinstitute+"\nCGPA/SGP/% : "+strscore+"\nYear Of Passing : "+stryop
                    + "\n\n----- OBJECTIVE -----\n" + strobj
                    + "\n\n----- TECHNICAL SKILLS -----\n "+strskills
                    + "\n\n----- INTERESTS -----\n"+strints
                    + "\n\n----- PROJECTS -----\nTitle : "+strprjctName+"\nDescription : "+strprjctDes
                    +"\n\n----- ACHIEVEMENTS -----\nAchievements : "+strachi+"\nAwards : "+strawards
                    + "\n\n----- REFERENCE -----\nName/Designation : "+strrefName+"\nOrganization Name : "+strrefOrg+"\nContact No. : "+strrefCont
                    + "\n\n\n*********************************************************************************************************";
            document.addAuthor("Palak Savlia");
            document.add(new Paragraph(text));
            document.close();
            Toast.makeText(this,"Saved pdf at "+filePath,Toast.LENGTH_LONG).show();
        }
        catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }
}
