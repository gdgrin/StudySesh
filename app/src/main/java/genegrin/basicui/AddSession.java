package genegrin.basicui;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class AddSession extends AppCompatActivity {

    String id;
    EditText assignment, date, startTime, endTime, location, notes;
    Button create;

    boolean flag1,flag2,flag3,flag4,flag5,flag6;

    List<Session> Sessions = new ArrayList<Session>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);

        assignment = (EditText) findViewById(R.id.assignmentText);
        date = (EditText) findViewById(R.id.dateText);
        startTime = (EditText) findViewById(R.id.startTimeText);
        endTime = (EditText) findViewById(R.id.endTimeText);
        location = (EditText) findViewById(R.id.locationText);
        notes = (EditText) findViewById(R.id.notesText);
        create = (Button) findViewById(R.id.createButton);

        create.setEnabled(false);

        flag1 = false;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag5 = false;
        flag6 = false;

        assignment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                flag1 = true;
                if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
                    create.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        date.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                flag2 = true;
                if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
                    create.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        startTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                flag3 = true;
                if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
                    create.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        endTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                flag4 = true;
                if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
                    create.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        location.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                flag5 = true;
                if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
                    create.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        notes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                flag6 = true;
                if(flag1&&flag2&&flag3&&flag4&&flag5&&flag6)
                    create.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Session test1 = new Session(id,assignment.getText().toString(),
                                            Date.valueOf(date.getText().toString()),
                                            Time.valueOf(startTime.getText().toString()),
                                            Time.valueOf(endTime.getText().toString()),
                                            location.getText().toString(),
                                            notes.getText().toString());

                Sessions.add(test1);

                Intent intent = new Intent(AddSession.this, ClassView.class);
                startActivity(intent);

            }

           // Toast.makeText(getApplicationContext(), "Session Created", Toast.LENGTH_SHORT).show();

        });
    }

}
