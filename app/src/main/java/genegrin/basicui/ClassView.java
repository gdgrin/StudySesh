package genegrin.basicui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassView extends AppCompatActivity {

    List<Session> SessionsList = new ArrayList<Session>(); //fetch from db
    ListView sessionListView;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_view);

        refresh = (Button) findViewById(R.id.tempRefresh);
        sessionListView = (ListView) findViewById(R.id.listView);

        refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Date date = new Date();
                Time time1 = new Time(1);
                Time time2 = new Time(1);


                Session test2 = new Session("id", "PA4", date, time1, time2, "Ingalls", "idk");
                SessionsList.add(test2);

                populateList();

            }
        });

    }

    private void populateList() {
        ArrayAdapter<Session> adapter = new SessionsListAdapter();
        sessionListView.setAdapter(adapter);
    }

    private class SessionsListAdapter extends ArrayAdapter<Session>{
        public SessionsListAdapter(){
            super(ClassView.this, R.layout.listview_item, SessionsList);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            if (view == null){
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);
            }

            Session currentSession = SessionsList.get(position);

            TextView assignment = (TextView) view.findViewById(R.id.assignmentName);
            assignment.setText(currentSession.get_assignment());
            TextView location = (TextView) view.findViewById(R.id.locationName);
            location.setText(currentSession.get_location());
            TextView date = (TextView) view.findViewById(R.id.dateName);
            date.setText(currentSession.get_date().toString());
            TextView startTime = (TextView) view.findViewById(R.id.startTimeName);
            startTime.setText(currentSession.get_startTime().toString());
            TextView endTime = (TextView) view.findViewById(R.id.endTimeName);
            endTime.setText(currentSession.get_endTime().toString());

            return view;

        }
    }



}
