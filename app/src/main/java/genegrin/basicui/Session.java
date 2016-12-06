package genegrin.basicui;

import java.sql.Time;
import java.util.Date;

/**
 * Created by genegrinberg on 12/5/16.
 */

public class Session {

    private String _id, _assignment, _location, _notes;
    private Date _date;
    private Time _startTime, _endTime;

    public Session(String id, String assignment, Date date, Time startTime, Time endTime, String location, String notes){
        _id = id;
        _assignment = assignment;
        _location = location;
        _notes = notes;
        _date = date;
        _startTime = startTime;
        _endTime = endTime;
    }

    public String get_id() {
        return _id;
    }

    public String get_assignment() {
        return _assignment;
    }

    public String get_location() {
        return _location;
    }

    public String get_notes() {
        return _notes;
    }

    public Date get_date() {
        return _date;
    }

    public Time get_startTime() {
        return _startTime;
    }

    public Time get_endTime() {
        return _endTime;
    }
}
