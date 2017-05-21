package com.example.tag.mydialog01;

import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private FragmentManager fragmentManager;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();

        textView = (TextView)findViewById(R.id.textView);
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.show(fragmentManager,"test");
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textView.setText(hourOfDay+":"+minute);
    }
}
