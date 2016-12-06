package genegrin.basicui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button c1,c2,c3,c4,c5,c6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //int numClasses = AddClasses.getTotalClasses();
        int numClasses = getIntent().getIntExtra("TotalClasses",1);
        //System.out.println(numClasses);
        c1 = (Button) findViewById(R.id.class1);
        c2 = (Button) findViewById(R.id.class2);
        c3 = (Button) findViewById(R.id.class3);
        c4 = (Button) findViewById(R.id.class4);
        c5 = (Button) findViewById(R.id.class5);
        c6 = (Button) findViewById(R.id.class6);


        Button[] btnList = {c1,c2,c3,c4,c5,c6};

        String tv1 = getIntent().getStringExtra("TextValue1");
        String tv2 = getIntent().getStringExtra("TextValue2");
        String tv3 = getIntent().getStringExtra("TextValue3");
        String tv4 = getIntent().getStringExtra("TextValue4");
        String tv5 = getIntent().getStringExtra("TextValue5");
        String tv6 = getIntent().getStringExtra("TextValue6");

        for (int i=numClasses; i<6; i++){
            btnList[i].setEnabled(false);
            btnList[i].setVisibility(Button.INVISIBLE);
        }

        if(!tv1.trim().isEmpty()) {
            c1.setText(tv1);
        }

        if(!tv2.trim().isEmpty()) {
            c2.setText(tv2);
        }

        if(!tv3.trim().isEmpty()) {
            c3.setText(tv3);
        }

        if(!tv4.trim().isEmpty()) {
            c4.setText(tv4);
        }

        if(!tv5.trim().isEmpty()) {
            c5.setText(tv5);
        }

        if(!tv6.trim().isEmpty()) {
            c6.setText(tv6);
        }


        c1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ClassView.class);
               // intent.putExtra("className", tv1);
                startActivity(intent);
            }
        });
    }
}
