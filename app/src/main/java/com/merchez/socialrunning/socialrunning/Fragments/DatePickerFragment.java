package com.merchez.socialrunning.socialrunning.Fragments;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.merchez.socialrunning.socialrunning.CreateGroupActivity;
import com.merchez.socialrunning.socialrunning.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends AppCompatDialogFragment implements OnDateSelectedListener  {
    private TextView textView;
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    private MaterialCalendarView widget;

    private List<CalendarDay> dates;
    private ArrayList<String> datesListStr = new ArrayList<String>();

    public DatePickerFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //inflate custom layout and get views
        //pass null as parent view because will be in dialog layout
        View view = inflater.inflate(R.layout.fragment_date_picker, null);

        textView = (TextView) view.findViewById(R.id.textView);

        widget = (MaterialCalendarView) view.findViewById(R.id.calendarView);

        widget.setOnDateChangedListener(this);
        widget.setSelectionMode(MaterialCalendarView.SELECTION_MODE_MULTIPLE);

        final CreateGroupActivity act= (CreateGroupActivity) this.getActivity();

        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.title_activity_dialogs)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dates = widget.getSelectedDates();

                        act.setDates(dates);
                        /*String dateString = "";
                        for (CalendarDay day : dates) {

                            if(day.getDay() <10) dateString+="0";
                            dateString+=day.getDay()+"/";

                            if(day.getMonth() <10) dateString+="0";
                            dateString+=day.getMonth()+"/";

                            dateString+=day.getYear();

                            dateString+= "  \n";
                            datesListStr.add(dateString);
                        }*/

                        //TextView txt = (TextView) act.findViewById(R.id.dateList);

                        //txt.setText(dateString);

                        //Log.i("debug", act.toString());

                        //act.setContentView(R.layout.activity_create_group);
                        //StableArrayAdapter dateAdapter = new StableArrayAdapter(act, R.id.groupe_textview, datesListStr );

                        //final ListView dateList = (ListView) act.findViewById(R.id.dateList);
                        //dateList.setAdapter(dateAdapter);
                        //act.setContentView(dateList);

                    }
                })
                .create();
    }



    public List<CalendarDay> getDates() {
        return dates;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        textView.setText(FORMATTER.format(date.getDate()));
    }

}
