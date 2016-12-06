package genegrin.basicui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class AddClasses extends AppCompatActivity {

    int totalClasses=0;
    final int autoCompleteThreshold = 5;
    AutoCompleteTextView textView1, textView2,textView3, textView4, textView5, textView6;


    private static final String[] CLASSES = new String[] { //change this to method that gets classes
            "ENG EC 401", "ENG EK 210", "ENG EK 301", "ENG EC 311"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_classes);

        totalClasses = 1;

        textView1 = (AutoCompleteTextView) findViewById(R.id.classNameAdder);
        textView2 = (AutoCompleteTextView) findViewById(R.id.classNameAdder2);
        textView3 = (AutoCompleteTextView) findViewById(R.id.classNameAdder3);
        textView4 = (AutoCompleteTextView) findViewById(R.id.classNameAdder4);
        textView5 = (AutoCompleteTextView) findViewById(R.id.classNameAdder5);
        textView6 = (AutoCompleteTextView) findViewById(R.id.classNameAdder6);

        final Button doneButton = (Button) findViewById(R.id.doneButton);

        AutoCompleteTextView[] allTextViews ={textView1, textView2,textView3, textView4, textView5, textView6};

        for (AutoCompleteTextView item : allTextViews){
            item.setThreshold(autoCompleteThreshold);
        }

        for (int i=1; i<allTextViews.length; i++){ //all except first
            allTextViews[i].setEnabled(false);
            allTextViews[i].setVisibility(AutoCompleteTextView.GONE);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, CLASSES);

        textView1.setAdapter(adapter);
        textView1.setThreshold(5);

        textView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!textView1.getText().toString().trim().isEmpty()){
                    textView2.setEnabled(true);
                    textView2.setVisibility(AutoCompleteTextView.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        textView2.setAdapter(adapter);

        textView2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!textView2.getText().toString().trim().isEmpty()){
                    textView3.setEnabled(true);
                    textView3.setVisibility(AutoCompleteTextView.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
               // totalClasses++;
            }
        });


        textView3.setAdapter(adapter);


        textView3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!textView3.getText().toString().trim().isEmpty()){
                    textView4.setEnabled(true);
                    textView4.setVisibility(AutoCompleteTextView.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
               // totalClasses++;
            }
        });


        textView4.setAdapter(adapter);

        textView4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!textView4.getText().toString().trim().isEmpty()){
                    textView5.setEnabled(true);
                    textView5.setVisibility(AutoCompleteTextView.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
               // totalClasses++;
            }
        });


        textView5.setAdapter(adapter);

        textView5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!textView5.getText().toString().trim().isEmpty()){
                    textView6.setEnabled(true);
                    textView6.setVisibility(AutoCompleteTextView.VISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
               // totalClasses++;
            }
        });


        textView6.setAdapter(adapter);

        textView2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               // if(!textView6.getText().toString().trim().isEmpty()) {
               //     totalClasses++;
               // }
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddClasses.this, MainActivity.class);
                if(!textView1.getText().toString().trim().isEmpty()) {
                    intent.putExtra("TextValue1", textView1.getText().toString());

                }
                else{
                    intent.putExtra("TextValue1", "");
                }
                if(!textView2.getText().toString().trim().isEmpty()) {
                    intent.putExtra("TextValue2", textView2.getText().toString());
                    totalClasses++;
                }
                else{
                    intent.putExtra("TextValue2", "");
                }
                if(!textView3.getText().toString().trim().isEmpty()) {
                    intent.putExtra("TextValue3", textView3.getText().toString());
                    totalClasses++;
                }
                else{
                    intent.putExtra("TextValue3", "");
                }
                if(!textView4.getText().toString().trim().isEmpty()) {
                    intent.putExtra("TextValue4", textView4.getText().toString());
                    totalClasses++;
                }
                else{
                    intent.putExtra("TextValue4", "");
                }
                if(!textView5.getText().toString().trim().isEmpty()) {
                    intent.putExtra("TextValue5", textView5.getText().toString());
                    totalClasses++;
                }
                else{
                    intent.putExtra("TextValue5", "");
                }
                if(!textView6.getText().toString().trim().isEmpty()) {
                    intent.putExtra("TextValue6", textView6.getText().toString());
                    totalClasses++;
                }
                else{
                    intent.putExtra("TextValue6", "");
                }
                intent.putExtra("TotalClasses", totalClasses);
                startActivity(intent);
            }

        });

    }

    //public int getTotalClasses(){
   //     return totalClasses;
   // }

}
